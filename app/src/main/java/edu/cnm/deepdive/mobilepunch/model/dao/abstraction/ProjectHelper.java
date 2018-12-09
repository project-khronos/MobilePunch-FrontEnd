package edu.cnm.deepdive.mobilepunch.model.dao.abstraction;

import android.content.Context;
import android.os.AsyncTask;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import edu.cnm.deepdive.mobilepunch.controller.FrontendApplication;
import edu.cnm.deepdive.mobilepunch.controller.MainActivity;
import edu.cnm.deepdive.mobilepunch.model.db.MobilePunchDatabase;
import edu.cnm.deepdive.mobilepunch.model.entities.ClientEntity;
import edu.cnm.deepdive.mobilepunch.model.entities.EquipmentEntity;
import edu.cnm.deepdive.mobilepunch.model.entities.EventEntity;
import edu.cnm.deepdive.mobilepunch.model.entities.ProjectEntity;
import edu.cnm.deepdive.mobilepunch.model.entities.abstraction.UuidSetter;

/**
 * The type Project helper.
 */
public class ProjectHelper {

    /**
     * Gets projects.
     *
     * @param context the context
     * @return the projects
     */

    public static Set<ProjectEntity> getProjects(Context context) {

        List<ProjectEntity> projects = MobilePunchDatabase.getInstance(context).getProjectDao()
                .select();
        for (ProjectEntity project : projects) {
            UuidSetter.setUuidFromIds(project);
            project.setEvents(MobilePunchDatabase.getEventsFromProject(project));
            if (project.getEvents() != null) {
                for (EventEntity event : project.getEvents()) {
                    UuidSetter.setUuidFromIds(event);
                    EquipmentEntity equipment = MobilePunchDatabase.getInstance(context).getEquipmentDao().select(event.getEquipmentId1(), event.getEquipmentId2());
                    event.setEquipment(equipment);
                }
            }
            ClientEntity clients = MobilePunchDatabase.getInstance(context).getClientDao().select(project.getClientId1(), project.getClientId2());
            project.setClients(clients);
        }
        return new HashSet<>(projects);
    }

    /**
     * The type Project getter task.
     */

    public static class ProjectGetterTask extends AsyncTask<Void, Void, Set<ProjectEntity>> {


        @Override
        protected Set<ProjectEntity> doInBackground(Void... voids) {
            Set<ProjectEntity> projects = getProjects(MainActivity.getInstance());
            if (FrontendApplication.getMasterProjectSet() == null) {
                FrontendApplication.setMasterProjectSet(new HashSet<>());
            }
            FrontendApplication.getMasterProjectSet().addAll(projects);
            return projects;
        }
    }


}
