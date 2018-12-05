package edu.cnm.deepdive.mobilepunch.model.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * The type Event entity.
 */
@Entity(
    primaryKeys = {"event_id1", "event_id2"}
//    foreignKeys = {@ForeignKey(
//        entity = ProjectEntity.class,
//        parentColumns = {"project_id1", "project_id2"},
//        childColumns = {"project_id1", "project_id2"},
//        onDelete = OnConflictStrategy.FAIL
//    )}
)

public class EventEntity {

  @Ignore
  @Expose
  @SerializedName("event_id")
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

  //TODO switch to BigDec and add converter save as a string
  @Expose
  private Double expenses;

  @Expose
  private Double income;

  @Expose
  private String description;

  @Expose
  private double longitude;

  @Expose
  private double latitude;

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


  /**
   * Gets uuid.
   *
   * @return the uuid
   */
  public UUID getUuid() {
    return uuid;
  }

  /**
   * Sets uuid.
   *
   * @param uuid the uuid
   */
  public void setUuid(UUID uuid) {
    this.uuid = uuid;
  }

  /**
   * Gets id 2.
   *
   * @return the id 2
   */
  public long getId2() {
    return id2;
  }

  /**
   * Sets id 2.
   *
   * @param id2 the id 2
   */
  public void setId2(long id2) {
    this.id2 = id2;
  }

  /**
   * Gets id 1.
   *
   * @return the id 1
   */
  public long getId1() {
    return id1;
  }

  /**
   * Sets id 1.
   *
   * @param id1 the id 1
   */
  public void setId1(long id1) {
    this.id1 = id1;
  }

  /**
   * Gets start date.
   *
   * @return the start date
   */
  public Date getStartDate() {
    return startDate;
  }

  /**
   * Sets start date.
   *
   * @param startDate the start date
   */
  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  /**
   * Gets end date.
   *
   * @return the end date
   */
  public Date getEndDate() {
    return endDate;
  }

  /**
   * Sets end date.
   *
   * @param endDate the end date
   */
  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  /**
   * Gets expenses.
   *
   * @return the expenses
   */
  public Double getExpenses() {
    return expenses;
  }

  /**
   * Sets expenses.
   *
   * @param expenses the expenses
   */
  public void setExpenses(Double expenses) {
    this.expenses = expenses;
  }

  /**
   * Gets income.
   *
   * @return the income
   */
  public Double getIncome() {
    return income;
  }

  /**
   * Sets income.
   *
   * @param income the income
   */
  public void setIncome(Double income) {
    this.income = income;
  }

  /**
   * Gets description.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Sets description.
   *
   * @param description the description
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Gets longitude.
   *
   * @return the longitude
   */
  public double getLongitude() {
    return longitude;
  }

  /**
   * Sets longitude.
   *
   * @param longitude the longitude
   */
  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  /**
   * Gets latitude.
   *
   * @return the latitude
   */
  public double getLatitude() {
    return latitude;
  }

  /**
   * Sets latitude.
   *
   * @param latitude the latitude
   */
  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  /**
   * Gets project id 1.
   *
   * @return the project id 1
   */
  public long getProjectId1() {
    return projectId1;
  }

  /**
   * Sets project id 1.
   *
   * @param projectId1 the project id 1
   */
  public void setProjectId1(long projectId1) {
    this.projectId1 = projectId1;
  }

  /**
   * Gets project id 2.
   *
   * @return the project id 2
   */
  public long getProjectId2() {
    return projectId2;
  }

  /**
   * Sets project id 2.
   *
   * @param projectId2 the project id 2
   */
  public void setProjectId2(long projectId2) {
    this.projectId2 = projectId2;
  }

  /**
   * Gets equipment id 1.
   *
   * @return the equipment id 1
   */
  public long getEquipmentId1() {
    return equipmentId1;
  }

  /**
   * Sets equipment id 1.
   *
   * @param equipmentId1 the equipment id 1
   */
  public void setEquipmentId1(long equipmentId1) {
    this.equipmentId1 = equipmentId1;
  }

  /**
   * Gets equipment id 2.
   *
   * @return the equipment id 2
   */
  public long getEquipmentId2() {
    return equipmentId2;
  }

  /**
   * Sets equipment id 2.
   *
   * @param equipmentId2 the equipment id 2
   */
  public void setEquipmentId2(long equipmentId2) {
    this.equipmentId2 = equipmentId2;
  }

  /**
   * Gets equipment list.
   *
   * @return the equipment list
   */
  public List<EquipmentEntity> getEquipmentList() {
    return equipmentList;
  }

  /**
   * Sets equipment list.
   *
   * @param equipmentList the equipment list
   */
  public void setEquipmentList(
      List<EquipmentEntity> equipmentList) {
    this.equipmentList = equipmentList;
  }
}
