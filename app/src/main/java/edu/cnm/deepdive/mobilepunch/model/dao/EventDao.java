package edu.cnm.deepdive.mobilepunch.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import edu.cnm.deepdive.mobilepunch.model.entities.EventEntity;
import java.util.List;

@Dao
public interface EventDao {

  @Insert(onConflict = OnConflictStrategy.FAIL)
  long insert(EventEntity event);

  @Query("Select * from EventEntity")
  List<EventEntity> query();
}
