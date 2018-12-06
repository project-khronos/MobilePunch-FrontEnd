package edu.cnm.deepdive.mobilepunch.model.dao.abstraction;

import android.content.Context;
import android.os.AsyncTask;
import edu.cnm.deepdive.mobilepunch.controller.MainActivity;
import edu.cnm.deepdive.mobilepunch.model.db.MobilePunchDatabase;
import edu.cnm.deepdive.mobilepunch.model.entities.ClientEntity;
import edu.cnm.deepdive.mobilepunch.model.entities.EquipmentEntity;
import edu.cnm.deepdive.mobilepunch.model.entities.EventEntity;
import edu.cnm.deepdive.mobilepunch.model.entities.EventEquipment;
import edu.cnm.deepdive.mobilepunch.model.entities.ProjectClient;
import edu.cnm.deepdive.mobilepunch.model.entities.ProjectEntity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProjectHelper {

  public static Set<ProjectEntity> getProjects(Context context) {
    List<ProjectEntity> projects = MobilePunchDatabase.getInstance(context).getProjectDao()
        .select();
    for (ProjectEntity project : projects) {
      project.setEvents(MobilePunchDatabase.getEventsFromProject(project));
      if (project.getEvents() != null) {
        for (EventEntity event : project.getEvents()) {
          List<EventEquipment> eventEquipments = MobilePunchDatabase.getInstance(context)
              .getEventEquipmentDao().select(event.getId1(), event.getId2());
          List<EquipmentEntity> equipment = new ArrayList<>();
          for (EventEquipment eventEquipment : eventEquipments) {
            equipment.add(MobilePunchDatabase.getInstance(context).getEquipmentDao()
                .select(eventEquipment.getEquipmentId1(), eventEquipment.getEquipmentId2()));
          }
          event.setEquipmentList(equipment);
        }
      }
      List<ClientEntity> clients = new ArrayList<>();
      for (ProjectClient projectClient : MobilePunchDatabase.getInstance(context)
          .getProjectClientDao().select(project.getId1(), project.getId2())) {
        clients.add(MobilePunchDatabase.getInstance(context).getClientDao()
            .select(projectClient.getClientId1(), projectClient.getClientId2()));
      }
      project.setClients(clients);
    }
    return new HashSet<>(projects);
  }

  public static class ProjectGetterTask extends AsyncTask<Void, Void, Set<ProjectEntity>> {

    @Override
    protected Set<ProjectEntity> doInBackground(Void... voids) {
      Set<ProjectEntity> projects = getProjects(MainActivity.getInstance());
      MainActivity.getInstance().setProjects(projects);
      return projects;
    }
  }


}
