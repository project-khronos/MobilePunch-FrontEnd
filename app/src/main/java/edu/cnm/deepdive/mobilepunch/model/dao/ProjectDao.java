package edu.cnm.deepdive.mobilepunch.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import edu.cnm.deepdive.mobilepunch.model.entities.ProjectEntity;
import java.util.List;

@Dao
public interface ProjectDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  List<Long> insert(List<ProjectEntity> projects);

  @Query("SELECT * From ProjectEntity")
  List<ProjectEntity> select();
}
