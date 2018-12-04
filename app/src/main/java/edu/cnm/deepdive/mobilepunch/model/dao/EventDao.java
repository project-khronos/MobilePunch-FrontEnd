package edu.cnm.deepdive.mobilepunch.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import edu.cnm.deepdive.mobilepunch.model.entities.EventEntity;

@Dao
public interface EventDao {

  @Insert(onConflict = OnConflictStrategy.FAIL)
  long insert(EventEntity event);
}
