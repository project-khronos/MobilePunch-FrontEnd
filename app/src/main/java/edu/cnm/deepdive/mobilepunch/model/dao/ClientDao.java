package edu.cnm.deepdive.mobilepunch.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import edu.cnm.deepdive.mobilepunch.model.entities.ClientEntity;
import java.util.List;

@Dao
public interface ClientDao{

  @Insert
  long insert(ClientEntity client);

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  List<Long> insert(List<ClientEntity> clients);

  @Query("SELECT * FROM ClientEntity")
  List<ClientEntity> select();

  @Query("SELECT * FROM ClientEntity ORDER BY name")
  List<ClientEntity> selectAll();

  @Query("SELECT * FROM ClientEntity WHERE :id1 = client_id1 AND :id2 = client_id2 ")
  ClientEntity select(long id1, long id2);
}
