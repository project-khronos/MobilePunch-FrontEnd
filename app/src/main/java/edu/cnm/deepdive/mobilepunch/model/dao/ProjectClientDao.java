package edu.cnm.deepdive.mobilepunch.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import edu.cnm.deepdive.mobilepunch.model.entities.ProjectClient;
import java.util.List;

@Dao
public interface ProjectClientDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  long insert(ProjectClient projectClient);

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  List<Long> insert(List<ProjectClient> projectclients);

  @Query("SELECT * FROM ProjectClient WHERE projectId1 = :projectId1 AND projectId2 = :projectId2")
  List<ProjectClient> select(long projectId1, long projectId2);


}
