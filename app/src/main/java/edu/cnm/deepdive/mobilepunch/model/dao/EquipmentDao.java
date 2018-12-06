package edu.cnm.deepdive.mobilepunch.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import edu.cnm.deepdive.mobilepunch.model.entities.EquipmentEntity;
import java.util.List;

/**
 * The interface Equipment dao.
 */
@Dao
public interface EquipmentDao {

  /**
   * Insert long.
   *
   * @param equipment the equipment
   * @return the long
   */
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  long insert(EquipmentEntity equipment);

  /**
   * Insert list.
   *
   * @param equipmentList the equipment list
   * @return the list
   */
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  List<Long> insert(List<EquipmentEntity> equipmentList);

  /**
   * Select all list.
   *
   * @return the list
   */
  @Query("SELECT * FROM EquipmentEntity ORDER BY name")
  List<EquipmentEntity> selectAll();

  /**
   * Select equipment entity.
   *
   * @param id1 the id 1
   * @param id2 the id 2
   * @return the equipment entity
   */
  @Query("SELECT * FROM EquipmentEntity WHERE :id1 = equipment_id1 AND :id2 = equipment_id2 ")
  EquipmentEntity select(long id1, long id2);

  /**
   * Select list.
   *
   * @return the list
   */
  @Query("SELECT * FROM EquipmentEntity")
  List<EquipmentEntity> select();
}
