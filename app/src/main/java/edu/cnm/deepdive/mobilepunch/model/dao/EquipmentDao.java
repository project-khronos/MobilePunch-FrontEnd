package edu.cnm.deepdive.mobilepunch.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import edu.cnm.deepdive.mobilepunch.model.entities.EquipmentEntity;
import java.util.List;

@Dao
public interface EquipmentDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  long insert(EquipmentEntity equipment);

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  List<Long> insert(List<EquipmentEntity> equipmentList);

  @Query("SELECT * FROM EquipmentEntity ORDER BY name")
  List<EquipmentEntity> selectAll();

  @Query("SELECT * FROM EquipmentEntity WHERE :id1 = equipment_id1 AND :id2 = equipment_id2 ")
  EquipmentEntity select(long id1, long id2);

  @Query("SELECT * FROM EquipmentEntity")
  List<EquipmentEntity> select();
}
