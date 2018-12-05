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
  long insert(ProjectEntity projectEntity);

  @Query("SELECT * FROM ProjectEntity ORDER BY start_time")
  List<ProjectEntity> select();

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  List<Long> insert(List<ProjectEntity> projects);
}
