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
import edu.cnm.deepdive.mobilepunch.model.entities.EventEquipment;
import edu.cnm.deepdive.mobilepunch.model.entities.ProjectClient;
import edu.cnm.deepdive.mobilepunch.model.entities.ProjectEntity;
import edu.cnm.deepdive.mobilepunch.model.entities.abstraction.UuidSetter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The type Mobile punch database.
 */
@Database(
    entities = {ProjectEntity.class, EventEntity.class, ClientEntity.class, EquipmentEntity.class,
        EventEquipment.class, ProjectClient.class},
    version = 1,
    exportSchema = true
)
@TypeConverters(MobilePunchDatabase.Converters.class)
public abstract class MobilePunchDatabase extends RoomDatabase {

  private static final String DB_NAME = "mobile_punch_db";
  private static MobilePunchDatabase instance = null;

  /**
   * Gets instance.
   *
   * @param context the context
   * @return the instance
   */
  public synchronized static MobilePunchDatabase getInstance(Context context) {
    if (instance == null) {
      instance = Room
          .databaseBuilder(context.getApplicationContext(), MobilePunchDatabase.class, DB_NAME)
          .build();
    }
    return instance;
  }

  /**
   * Forget instance.
   */
  public synchronized static void forgetInstance() {
    instance = null;
  }

  /**
   * From uuid project.
   *
   * @param projects the projects
   */
  public static void fromUUIDProject(List<ProjectEntity> projects) {
    if (projects != null) {
      for (int i = 0; i < projects.size(); i++) {
        ProjectEntity project = projects.get(i);
        fromUUIDProject(project);
      }
    }
  }

  /**
   * From uuid project.
   *
   * @param project the project
   */
  public static void fromUUIDProject(ProjectEntity project) {
    if (project != null) {
      UuidSetter.setIdsFromUuid(project);
      fromUUIDEvent(project.getEvents());
      fromUUIDClient(project.getClients());
    }
  }

  private static void toUUIDProject(List<ProjectEntity> projects) {
    if (projects != null) {
      for (int i = 0; i < projects.size(); i++) {
        ProjectEntity project = projects.get(i);
        toUUIDProject(project);
      }
    }
  }

  private static void toUUIDProject(ProjectEntity project) {
    if (project != null) {
      UuidSetter.setUuidFromIds(project);
      toUUIDCLient(project.getClients());
      toUUIDEvent(project.getEvents());
    }
  }

  /**
   * From uuid event.
   *
   * @param events the events
   */
  public static void fromUUIDEvent(List<EventEntity> events) {
    if (events != null) {
      for (int j = 0; j < events.size(); j++) {
        EventEntity event = events.get(j);
        fromUUIDEvent(event);
      }
    }
  }

  /**
   * From uuid event.
   *
   * @param event the event
   */
  public static void fromUUIDEvent(EventEntity event) {
    if (event != null) {
      UuidSetter.setIdsFromUuid(event);
      fromUUIDEquipment(event.getEquipmentList());
    }
  }

  /**
   * To uuid event.
   *
   * @param event the event
   */
  public static void toUUIDEvent(EventEntity event) {
    if (event != null) {
      UuidSetter.setUuidFromIds(event);
      toUUIDEquipment(event.getEquipmentList());
    }
  }

  /**
   * To uuid event.
   *
   * @param events the events
   */
  public static void toUUIDEvent(List<EventEntity> events) {
    if (events != null) {
      for (int j = 0; j < events.size(); j++) {
        EventEntity event = events.get(j);
        toUUIDEvent(event);
      }
    }
  }

  /**
   * From uuid client.
   *
   * @param client the client
   */
  public static void fromUUIDClient(ClientEntity client) {
    if (client != null) {
      UuidSetter.setIdsFromUuid(client);
      fromUUIDProject(client.getProjects());
    }
  }

  /**
   * From uuid client.
   *
   * @param clients the clients
   */
  public static void fromUUIDClient(List<ClientEntity> clients) {
    if (clients != null) {
      for (int i = 0; i < clients.size(); i++) {
        ClientEntity client = clients.get(i);
        fromUUIDClient(client);
      }
    }
  }

  /**
   * To uuidc lient.
   *
   * @param clients the clients
   */
  public static void toUUIDCLient(List<ClientEntity> clients) {
    if (clients != null) {
      for (int i = 0; i < clients.size(); i++) {
        ClientEntity client = clients.get(i);
        toUUIDClient(client);
      }
    }
  }

  /**
   * To uuid client.
   *
   * @param client the client
   */
  public static void toUUIDClient(ClientEntity client) {
    if (client != null) {
      UuidSetter.setUuidFromIds(client);
      toUUIDProject(client.getProjects());
    }
  }

  /**
   * From uuid equipment.
   *
   * @param equipment the equipment
   */
  public static void fromUUIDEquipment(EquipmentEntity equipment) {
    UuidSetter.setIdsFromUuid(equipment);
  }

  /**
   * From uuid equipment.
   *
   * @param equipmentList the equipment list
   */
  public static void fromUUIDEquipment(List<EquipmentEntity> equipmentList) {
    if (equipmentList != null) {
      for (int i = 0; i < equipmentList.size(); i++) {
        EquipmentEntity equipment = equipmentList.get(i);
        fromUUIDEquipment(equipment);
      }
    }
  }

  /**
   * To uuid equipment.
   *
   * @param equipment the equipment
   */
  public static void toUUIDEquipment(EquipmentEntity equipment) {
    UuidSetter.setUuidFromIds(equipment);
  }

  /**
   * To uuid equipment.
   *
   * @param equipmentList the equipment list
   */
  public static void toUUIDEquipment(List<EquipmentEntity> equipmentList) {
    if (equipmentList != null) {
      for (int i = 0; i < equipmentList.size(); i++) {
        EquipmentEntity equipment = equipmentList.get(i);
        toUUIDEquipment(equipment);
      }
    }
  }

  /**
   * Gets events from project.
   *
   * @param project the project
   * @return the events from project
   */
  public static List<EventEntity> getEventsFromProject(ProjectEntity project) {
    List<EventEntity> events = null;
    if (project != null) {
      events = project.getEvents();
      MobilePunchDatabase.fromUUIDEvent(events);
      for (EventEntity event : events) {
        event.setProjectId1(project.getId1());
        event.setProjectId2(project.getId2());
      }
    }
    return events;
  }

  /**
   * Gets events from project.
   *
   * @param projects the projects
   * @return the events from project
   */
  public static List<EventEntity> getEventsFromProject(List<ProjectEntity> projects) {
    List<EventEntity> events = new ArrayList<>();
    if (projects != null) {
      for (ProjectEntity project : projects) {
        events.addAll(getEventsFromProject(project));
      }
    }
    return events;
  }

  /**
   * Gets project dao.
   *
   * @return the project dao
   */
  public abstract ProjectDao getProjectDao();

  /**
   * Gets client dao.
   *
   * @return the client dao
   */
  public abstract ClientDao getClientDao();

  /**
   * Gets equipment dao.
   *
   * @return the equipment dao
   */
  public abstract EquipmentDao getEquipmentDao();

  /**
   * Gets event dao.
   *
   * @return the event dao
   */
  public abstract EventDao getEventDao();

  /**
   * The type Converters.
   */
  public static class Converters {

    /**
     * Date from long date.
     *
     * @param time the time
     * @return the date
     */
    @TypeConverter
    public static Date dateFromLong(Long time) {
      return (time != null) ? new Date(time) : null;
    }

    /**
     * Long from date long.
     *
     * @param date the date
     * @return the long
     */
    @TypeConverter
    public static long longFromDate(Date date) {
      return (date != null) ? date.getTime() : 0;
    }
  }
}
