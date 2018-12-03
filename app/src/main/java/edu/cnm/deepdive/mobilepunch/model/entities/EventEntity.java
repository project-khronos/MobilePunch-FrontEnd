package edu.cnm.deepdive.mobilepunch.model.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;
import java.util.Date;

@Entity(
    primaryKeys = {"event_id1","event_id2"}
)
public class EventEntity {
@NonNull
@ColumnInfo(name = "event_id1")
private long id2;

@NonNull
@ColumnInfo(name = "event_id2")
private long id1;

@ColumnInfo(name = "event_start_date")
private Date startDate;

@ColumnInfo(name = "event_end_date")
private Date endDate;

private int expenses;

private int income;

private String description;

private double longitude;

private double latidtude;

//  Image -URI


  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  public int getExpenses() {
    return expenses;
  }

  public void setExpenses(int expenses) {
    this.expenses = expenses;
  }

  public int getIncome() {
    return income;
  }

  public void setIncome(int income) {
    this.income = income;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public double getLongitude() {
    return longitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  public double getLatidtude() {
    return latidtude;
  }

  public void setLatidtude(double latidtude) {
    this.latidtude = latidtude;
  }

  public long getId2() {
    return id2;
  }

  public void setId2(long id2) {
    this.id2 = id2;
  }

  public long getId1() {
    return id1;
  }

  public void setId1(long id1) {
    this.id1 = id1;
  }
}
