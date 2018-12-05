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

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  List<Long> insert(List<ProjectEntity> projects);

  @Query("SELECT * FROM PROJECTENTITY")
  List<ProjectEntity> select();

  @Query("SELECT * FROM ProjectEntity ORDER BY start_time")
  List<ProjectEntity> selectAll();

  @Query("SELECT * FROM ProjectEntity WHERE :id1 = project_id1 AND :id2 = project_id2")
  ProjectEntity select(long id1, long id2);

}
