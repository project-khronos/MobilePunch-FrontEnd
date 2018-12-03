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

  public static void convertfromProjectEventClientUUIDs(List<ProjectEntity> projects) {
    for (int i = 0; i < projects.size(); i++) {
      ProjectEntity project = projects.get(i);
      project.setId1(project.getUuid().getMostSignificantBits());
      project.setId2(project.getUuid().getLeastSignificantBits());
      List<EventEntity> events = project.getEvents();
      List<ClientEntity> clients = project.getClients();
      for (int j = 0; j < events.size(); j++) {
        EventEntity event = events.get(j);
        ClientEntity client = clients.get(j);
        client.setId1(client.getUuid().getMostSignificantBits());
        client.setId2(client.getUuid().getLeastSignificantBits());
        event.setId1(event.getUuid().getMostSignificantBits());
        event.setId2(event.getUuid().getLeastSignificantBits());
      }
    }
  }

  public static void convertToUUIDProject(List<ProjectEntity> projects) {
    for (int i = 0; i < projects.size(); i++) {
      ProjectEntity project = projects.get(i);
      project.setUuid(new UUID(project.getId1(), project.getId2()));
      List<EventEntity> events = project.getEvents();
      List<ClientEntity> clients = project.getClients();
      for (int j = 0; j < events.size(); j++) {
        EventEntity event = events.get(i);
        ClientEntity client = clients.get(i);
        client.setUuid(new UUID(client.getId1(), client.getId2()));
        event.setUuid(new UUID(event.getId1(), event.getId2()));
      }
    }
  }

//    public static void convertFormUUIDClient (List < ClientEntity > clients) {
//
//    }

    public static class Converters {

      @TypeConverter
      public static Date dateFromLong(Long time) {
        return (time != null) ? new Date(time) : null;
      }

      @TypeConverter
      public static long longFromDate(Date date) {
        return (date != null) ? date.getTime() : null;
      }


    }


  }

