package edu.cnm.deepdive.mobilepunch.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import edu.cnm.deepdive.mobilepunch.model.entities.EventEquipment;
import java.util.List;

/**
 * The interface Event equipment dao.
 */
@Dao
public interface EventEquipmentDao {

  /**
   * Insert long.
   *
   * @param eventEquipment the event equipment
   * @return the long
   */
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  long insert(EventEquipment eventEquipment);

  /**
   * Insert list.
   *
   * @param eventEquipments the event equipments
   * @return the list
   */
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  List<Long> insert(List<EventEquipment> eventEquipments);

  /**
   * Select list.
   *
   * @param eventId1 the event id 1
   * @param eventId2 the event id 2
   * @return the list
   */
  @Query("SELECT * FROM EventEquipment WHERE eventId1 = :eventId1 AND eventId2 = :eventId2")
  List<EventEquipment> select(long eventId1, long eventId2);

}
