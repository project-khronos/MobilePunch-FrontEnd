package edu.cnm.deepdive.mobilepunch.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import edu.cnm.deepdive.mobilepunch.model.entities.ClientEntity;

@Dao
public interface ClientDao {

  @Insert
  long insert(ClientEntity client);
}
