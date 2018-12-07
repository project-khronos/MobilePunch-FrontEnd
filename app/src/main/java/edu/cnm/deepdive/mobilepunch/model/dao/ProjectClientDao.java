package edu.cnm.deepdive.mobilepunch.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import edu.cnm.deepdive.mobilepunch.model.entities.ProjectClient;
import java.util.List;

/**
 * The interface Project client dao.
 */
@Dao
public interface ProjectClientDao {

  /**
   * Insert long.
   *
   * @param projectClient the project client
   * @return the long
   */
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  long insert(ProjectClient projectClient);

  /**
   * Insert list.
   *
   * @param projectclients the projectclients
   * @return the list
   */
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  List<Long> insert(List<ProjectClient> projectclients);

  /**
   * Select list.
   *
   * @param projectId1 the project id 1
   * @param projectId2 the project id 2
   * @return the list
   */
  @Query("SELECT * FROM ProjectClient WHERE projectId1 = :projectId1 AND projectId2 = :projectId2")
  List<ProjectClient> select(long projectId1, long projectId2);


}
