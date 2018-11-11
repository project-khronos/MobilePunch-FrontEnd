package edu.cnm.deepdive.mobilepunch.model.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import java.util.Date;

@Entity(
    primaryKeys = {"project_id"},
    foreignKeys = {@ForeignKey(
        entity = ProjectEntity.class,
        parentColumns = "project_id",
        childColumns = "project_id",
        onDelete = ForeignKey.CASCADE
    ),
        @ForeignKey(
            entity = ClientEntity.class,
            parentColumns = "client_id",
            childColumns = "client_id",
            onDelete = ForeignKey.CASCADE
        ),
        @ForeignKey(
            entity = EquipmentEntity.class,
            parentColumns = "equipment_id",
            childColumns = "equipment_id",
            onDelete = ForeignKey.CASCADE
        )}
)

public class EventEntity {

  private String mExpenses;
  private String mLocation;
  private String mIncome;
  private Date eventDate;


  public EventEntity() {

    eventDate = new Date();

  }

  public String getExpenses() {
    return mExpenses;
  }

  public void setExpenses(String expenses) {
    mExpenses = expenses;
  }

  public String getLocation() {
    return mLocation;
  }

  public void setLocation(String location) {
    mLocation = location;
  }

  public String getIncome() {
    return mIncome;
  }

  public void setIncome(String income) {
    mIncome = income;
  }

  public Date getEventDate() {
    return eventDate;
  }

  public void setEventDate(Date eventDate) {
    this.eventDate = eventDate;
  }

  @ColumnInfo(name = "project_id", index = true)
  private long projectId;

  @ColumnInfo(name = "client_id")
  private long clientId;

  @ColumnInfo(name = "equipment_id")
  private long equipmentId;


  public long getProjectId() {
    return projectId;
  }

  public void setProjectId(long projectId) {
    this.projectId = projectId;
  }

  public long getClientId() {
    return clientId;
  }

  public void setClientId(long clientId) {
    this.clientId = clientId;
  }

  public long getEquipmentId() {
    return equipmentId;
  }

  public void setEquipmentId(long equipmentId) {
    this.equipmentId = equipmentId;
  }
}
