package edu.cnm.deepdive.mobilepunch.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.view.ViewDebug.IntToString;
import edu.cnm.deepdive.mobilepunch.model.entities.ProjectEntity;

@Dao
public interface ProjectDao {
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  long insert(ProjectEntity projectEntity);
}
