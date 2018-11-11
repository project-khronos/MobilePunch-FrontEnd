package edu.cnm.deepdive.mobilepunch.model.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import java.util.Date;


@Entity
public class EquipmentEntity {


  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "equipment_id")
  private long id;
  private String mMake;
  private String mModel;
  private String mYear;
  private Date mDate;
  public EquipmentEntity() {

    mDate = new Date();

  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getMake() {
    return mMake;
  }

  public void setMake(String make) {
    mMake = make;
  }

  public String getModel() {
    return mModel;
  }

  public void setModel(String model) {
    mModel = model;
  }

  public String getYear() {
    return mYear;
  }

  public void setYear(String year) {
    mYear = year;
  }

  public Date getDate() {
    return mDate;
  }

  public void setDate(Date date) {
    mDate = date;
  }


}


