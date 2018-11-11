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

  private String expenses;
  private String location;
  private String income;
  private Date eventDate;


  public EventEntity() {

    eventDate = new Date();

  }

  public String getExpenses() {
    return expenses;
  }

  public void setExpenses(String expenses) {
    this.expenses = expenses;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getIncome() {
    return income;
  }

  public void setIncome(String income) {
    this.income = income;
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
