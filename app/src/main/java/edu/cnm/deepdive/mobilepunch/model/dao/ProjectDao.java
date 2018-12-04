package edu.cnm.deepdive.mobilepunch.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import edu.cnm.deepdive.mobilepunch.model.entities.ProjectEntity;
import java.util.List;

@Dao
public interface ProjectDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  List<Long> insert(List<ProjectEntity> projects);

}
