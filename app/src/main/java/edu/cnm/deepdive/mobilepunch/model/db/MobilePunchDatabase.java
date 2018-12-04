package edu.cnm.deepdive.mobilepunch.model.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;
import edu.cnm.deepdive.mobilepunch.model.dao.ClientDao;
import edu.cnm.deepdive.mobilepunch.model.dao.EquipmentDao;
import edu.cnm.deepdive.mobilepunch.model.dao.EventDao;
import edu.cnm.deepdive.mobilepunch.model.dao.ProjectDao;
import edu.cnm.deepdive.mobilepunch.model.entities.ClientEntity;
import edu.cnm.deepdive.mobilepunch.model.entities.EquipmentEntity;
import edu.cnm.deepdive.mobilepunch.model.entities.EventEntity;
import edu.cnm.deepdive.mobilepunch.model.entities.ProjectEntity;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Database(
    entities = {ProjectEntity.class, EventEntity.class, ClientEntity.class, EquipmentEntity.class},
    version = 1,
    exportSchema = true
)
@TypeConverters(MobilePunchDatabase.Converters.class)
public abstract class MobilePunchDatabase extends RoomDatabase {

  private static final String DB_NAME = "mobile_punch_db";
  private static MobilePunchDatabase instance = null;

  public synchronized static MobilePunchDatabase getInstance(Context context) {
    if (instance == null) {
      instance = Room
          .databaseBuilder(context.getApplicationContext(), MobilePunchDatabase.class, DB_NAME)
          .build();
    }
    return instance;
  }

  public synchronized static void forgetInstance() {
    instance = null;
  }

  public abstract ProjectDao getProjectDao();

  public abstract ClientDao getClientDao();

  public abstract EquipmentDao getEquipmentDao();

  public abstract EventDao getEventDao();


  public static void fromUUIDProject(List<ProjectEntity> projects) {
    for (int i = 0; i < projects.size(); i++) {
      ProjectEntity project = projects.get(i);
      fromUUIDProject(project);
    }
  }

  public static void fromUUIDProject(ProjectEntity project) {
    project.setId1(project.getUuid().getMostSignificantBits());
    project.setId2(project.getUuid().getLeastSignificantBits());
    fromUUIDEvent(project.getEvents());
    fromUUIDClient(project.getClients());
  }

  private static void toUUIDProject(List<ProjectEntity> projects) {
    for (int i = 0; i < projects.size(); i++) {
      ProjectEntity project = projects.get(i);
      toUUIDProject(project);
    }
  }

  private static void toUUIDProject(ProjectEntity project) {
    project.setUuid(new UUID(project.getId1(), project.getId2()));
    toUUIDCLient(project.getClients());
    toUUIDEvent(project.getEvents());
  }

  public static void fromUUIDEvent(List<EventEntity> events) {
    for (int j = 0; j < events.size(); j++) {
      EventEntity event = events.get(j);
      fromUUIDEvent(event);
    }
  }

  public static void fromUUIDEvent(EventEntity event) {
    event.setId1(event.getUuid().getMostSignificantBits());
    event.setId2(event.getUuid().getLeastSignificantBits());
    fromUUIDEquipment(event.getEquipmentList());
  }

  public static void toUUIDEvent(EventEntity event) {
    event.setUuid(new UUID(event.getId1(), event.getId2()));
    toUUIDEquipment(event.getEquipmentList());
  }

  public static void toUUIDEvent(List<EventEntity> events) {
    for (int j = 0; j < events.size(); j++) {
      EventEntity event = events.get(j);
      toUUIDEvent(event);
    }
  }

  public static void fromUUIDClient(ClientEntity client) {
    client.setId1(client.getUuid().getMostSignificantBits());
    client.setId2(client.getUuid().getLeastSignificantBits());
    fromUUIDProject(client.getProjects());
  }

  public static void fromUUIDClient(List<ClientEntity> clients) {
    for (int i = 0; i < clients.size(); i++) {
      ClientEntity client = clients.get(i);
      fromUUIDClient(client);
    }
  }

  public static void toUUIDCLient(List<ClientEntity> clients) {
    for (int i = 0; i < clients.size(); i++) {
      ClientEntity client = clients.get(i);
      toUUIDClient(client);
    }
  }

  public static void toUUIDClient(ClientEntity client) {
    client.setUuid(new UUID(client.getId1(), client.getId2()));
    toUUIDProject(client.getProjects());
  }

  public static void fromUUIDEquipment(EquipmentEntity equipment) {
    equipment.setId1(equipment.getUuid().getMostSignificantBits());
    equipment.setId2(equipment.getUuid().getLeastSignificantBits());
  }

  public static void fromUUIDEquipment(List<EquipmentEntity> equipmentList) {
    for (int i = 0; i < equipmentList.size(); i++) {
      EquipmentEntity equipment = equipmentList.get(i);
      fromUUIDEquipment(equipment);
    }
  }

  public static void toUUIDEquipment(EquipmentEntity equipment) {
    equipment.setUuid(new UUID(equipment.getId1(), equipment.getId2()));
  }

  public static void toUUIDEquipment(List<EquipmentEntity> equipmentList) {
    for (int i = 0; i < equipmentList.size(); i++) {
      EquipmentEntity equipment = equipmentList.get(i);
      toUUIDEquipment(equipment);
    }
  }


  public static class Converters {

    @TypeConverter
    public static Date dateFromLong(Long time) {
      return (time != null) ? new Date(time) : null;
    }

    @TypeConverter
    public static long longFromDate(Date date) {
        return (date != null) ? date.getTime() : 0;
    }


  }


}

