package edu.cnm.deepdive.mobilepunch.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import edu.cnm.deepdive.mobilepunch.model.entities.EventEntity;
import java.util.List;

@Dao
public interface EventDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  long insert(EventEntity event);

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  List<Long> insert(List<EventEntity> events);

  @Query("SELECT * FROM EventEntity WHERE project_id1 = :project_id1 AND project_id2= :project_id2 ")
  List<EventEntity> select(long project_id1, long project_id2);

  @Query("SELECT * FROM EventEntity")
  List<EventEntity> select();

}
