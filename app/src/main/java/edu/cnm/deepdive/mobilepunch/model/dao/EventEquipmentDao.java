package edu.cnm.deepdive.mobilepunch.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import edu.cnm.deepdive.mobilepunch.model.entities.EventEquipment;
import java.util.List;

@Dao
public interface EventEquipmentDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  long insert(EventEquipment eventEquipment);

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  List<Long> insert(List<EventEquipment> eventEquipments);

  @Query("SELECT * FROM EventEquipment WHERE eventId1 = :eventId1 AND eventId2 = :eventId2")
  List<EventEquipment> select(long eventId1, long eventId2);

}
