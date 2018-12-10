package edu.cnm.deepdive.mobilepunch.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import edu.cnm.deepdive.mobilepunch.model.entities.EventEntity;
import java.util.List;

/**
 * The interface Event dao. Maps Application calls to the persistence layer.
 */
@Dao
public interface EventDao {

  /**
   * Insert long.
   *
   * @param event the event
   * @return the long
   */
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  long insert(EventEntity event);

  /**
   * Insert list.
   *
   * @param events the events
   * @return the list
   */
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  List<Long> insert(List<EventEntity> events);

  /**
   * Select list.
   *
   * @param project_id1 the project id 1
   * @param project_id2 the project id 2
   * @return the list
   */
  @Query("SELECT * FROM EventEntity WHERE project_id1 = :project_id1 AND project_id2= :project_id2 ")
  List<EventEntity> select(long project_id1, long project_id2);

  /**
   * Select list.
   *
   * @return the list
   */
  @Query("SELECT * FROM EventEntity")
  List<EventEntity> select();

}
