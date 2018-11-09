package edu.cnm.deepdive.mobilepunch.model.entities;

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

  public long project_id;

  public long client_id;

  public long equipment_id;

  public long getProject_id() {
    return project_id;
  }

  public void setProject_id(long project_id) {
    this.project_id = project_id;
  }

  public long getClient_id() {
    return client_id;
  }

  public void setClient_id(long client_id) {
    this.client_id = client_id;
  }

  public long getEquipment_id() {
    return equipment_id;
  }

  public void setEquipment_id(long equipment_id) {
    this.equipment_id = equipment_id;
  }
}
