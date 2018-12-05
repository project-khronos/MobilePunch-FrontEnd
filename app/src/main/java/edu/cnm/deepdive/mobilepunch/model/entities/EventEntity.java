package edu.cnm.deepdive.mobilepunch.model.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.OnConflictStrategy;
import com.google.gson.annotations.Expose;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity(
    primaryKeys = {"event_id1", "event_id2"},
    foreignKeys = {@ForeignKey(
        entity = ProjectEntity.class,
        parentColumns = {"project_id1", "project_id2"},
        childColumns = {"project_id1", "project_id2"},
        onDelete = OnConflictStrategy.FAIL
    )}
)

public class EventEntity {

  @Ignore
  @Expose
  // @SerializedName("uuid")
  private UUID uuid;

  @ColumnInfo(name = "event_id1")
  private long id2;

  @ColumnInfo(name = "event_id2")
  private long id1;

  @Expose
  @ColumnInfo(name = "event_start_date")
  private Date startDate;

  @Expose
  @ColumnInfo(name = "event_end_date")
  private Date endDate;

  @Expose
  private int expenses;

  @Expose
  private int income;

  @Expose
  private String description;

  @Expose
  private double longitude;

  @Expose
  private double latidtude;

  @ColumnInfo(name = "project_id1")
  private long projectId1;

  @ColumnInfo(name = "project_id2")
  private long projectId2;


  @ColumnInfo(name = "equipment_id1")
  private long equipmentId1;

  @ColumnInfo(name = "equipment_id2")
  private long equipmentId2;

  @Ignore
  @Expose
  private List<EquipmentEntity> equipmentList;
//  Image -URI


  public UUID getUuid() {
    return uuid;
  }

  public void setUuid(UUID uuid) {
    this.uuid = uuid;
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

  public long getProjectId1() {
    return projectId1;
  }

  public void setProjectId1(long projectId1) {
    this.projectId1 = projectId1;
  }

  public long getProjectId2() {
    return projectId2;
  }

  public void setProjectId2(long projectId2) {
    this.projectId2 = projectId2;
  }

  public long getEquipmentId1() {
    return equipmentId1;
  }

  public void setEquipmentId1(long equipmentId1) {
    this.equipmentId1 = equipmentId1;
  }

  public long getEquipmentId2() {
    return equipmentId2;
  }

  public void setEquipmentId2(long equipmentId2) {
    this.equipmentId2 = equipmentId2;
  }

  public List<EquipmentEntity> getEquipmentList() {
    return equipmentList;
  }

  public void setEquipmentList(
      List<EquipmentEntity> equipmentList) {
    this.equipmentList = equipmentList;
  }
}
