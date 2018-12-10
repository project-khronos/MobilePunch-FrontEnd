package edu.cnm.deepdive.mobilepunch.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import edu.cnm.deepdive.mobilepunch.model.entities.ProjectEntity;
import java.util.List;

/**
 * The interface Project dao. Maps Application calls to the persistence layer.
 */
@Dao
public interface ProjectDao {

  /**
   * Insert long.
   *
   * @param projectEntity the project entity
   * @return the long
   */
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  long insert(ProjectEntity projectEntity);

  /**
   * Insert list.
   *
   * @param projects the projects
   * @return the list
   */
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  List<Long> insert(List<ProjectEntity> projects);

  /**
   * Select list.
   *
   * @return the list
   */
  @Query("SELECT * FROM PROJECTENTITY")
  List<ProjectEntity> select();

  /**
   * Select all list.
   *
   * @return the list
   */
  @Query("SELECT * FROM ProjectEntity ORDER BY start_time")
  List<ProjectEntity> selectAll();

  /**
   * Select project entity.
   *
   * @param id1 the id 1
   * @param id2 the id 2
   * @return the project entity
   */
  @Query("SELECT * FROM ProjectEntity WHERE :id1 = project_id1 AND :id2 = project_id2")
  ProjectEntity select(long id1, long id2);

}
