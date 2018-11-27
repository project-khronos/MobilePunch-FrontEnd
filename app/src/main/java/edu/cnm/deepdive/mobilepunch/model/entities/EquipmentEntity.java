package edu.cnm.deepdive.mobilepunch.model.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import java.util.Date;


@Entity(
 primaryKeys = {
     "equipment_id1", "equipment_id2"
 }
)
public class EquipmentEntity {



  @ColumnInfo(name = "equipment_id1")
  private long id1;
  @ColumnInfo(name = "equipment_id2")
  private long id2;
  private String make;
  private String model;
  private long year;
  private long date;
  @ColumnInfo(name = "desc_or_name")
  private String descOrName;
  @ColumnInfo(name = "license_plate")
  private String licensePlate;

  public long getId1() {
    return id1;
  }

  public void setId1(long id1) {
    this.id1 = id1;
  }

  public long getId2() {
    return id2;
  }

  public void setId2(long id2) {
    this.id2 = id2;
  }

  public void setYear(long year) {
    this.year = year;
  }

  public void setDate(long date) {
    this.date = date;
  }

  public String getLicensePlate() {
    return licensePlate;
  }

  public void setLicensePlate(String licensePlate) {
    this.licensePlate = licensePlate;
  }


}


