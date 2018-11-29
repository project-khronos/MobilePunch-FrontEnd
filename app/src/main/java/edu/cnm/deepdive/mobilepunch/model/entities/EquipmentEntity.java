package edu.cnm.deepdive.mobilepunch.model.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.support.annotation.Nullable;
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
  private Date date;
  @ColumnInfo(name = "desc_or_name")
  private String descOrName;
  @Nullable
  @ColumnInfo(name = "license_plate")
  private String licensePlate;
  @Nullable
  @ColumnInfo(name = "serial_number")
  private String serialNumber;

  @Nullable
  public String getSerialNumber() {
    return serialNumber;
  }

  public void setSerialNumber(@Nullable String serialNumber) {
    this.serialNumber = serialNumber;
  }

  public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public long getYear() {
    return year;
  }

  public void setYear(long year) {
    this.year = year;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getDescOrName() {
    return descOrName;
  }

  public void setDescOrName(String descOrName) {
    this.descOrName = descOrName;
  }

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

  public String getLicensePlate() {
    return licensePlate;
  }

  public void setLicensePlate(String licensePlate) {
    this.licensePlate = licensePlate;
  }


}


