package edu.cnm.deepdive.mobilepunch.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import edu.cnm.deepdive.mobilepunch.model.entities.ClientEntity;
import java.util.List;

/**
 * The interface Client dao. Maps application calls to the persistence layer.
 */
@Dao
public interface ClientDao {

  /**
   * Insert long.
   *
   * @param client the client
   * @return the long
   */
  @Insert
  long insert(ClientEntity client);

  /**
   * Insert list.
   *
   * @param clients the clients
   * @return the list
   */
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  List<Long> insert(List<ClientEntity> clients);

  /**
   * Select list.
   *
   * @return the list
   */
  @Query("SELECT * FROM ClientEntity")
  List<ClientEntity> select();

  /**
   * Select all list.
   *
   * @return the list
   */
  @Query("SELECT * FROM ClientEntity ORDER BY name")
  List<ClientEntity> selectAll();

  /**
   * Select client entity.
   *
   * @param id1 the id 1
   * @param id2 the id 2
   * @return the client entity
   */
  @Query("SELECT * FROM ClientEntity WHERE :id1 = client_id1 AND :id2 = client_id2 ")
  ClientEntity select(long id1, long id2);
}
