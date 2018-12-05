package edu.cnm.deepdive.mobilepunch.model.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity(
    primaryKeys = {"project_id1", "project_id2"}
)
public class ProjectEntity {

  @Ignore
  @Expose
  @SerializedName("uuid")
  private UUID uuid;

  @ColumnInfo(name = "project_id1")
  private long id1;

  @ColumnInfo(name = "project_id2")
  private long id2;

  @Expose
  private String name;

  @Expose
  @ColumnInfo(name = "start_time")
  private Date startTime;

  @Expose
  @ColumnInfo(name = "end_time")
  private Date endTime;

  @Expose
  @ColumnInfo(name = "expected_end_time")
  private Date expectedEndTime;

  @Expose
  private String description;

  @Ignore
  @Expose
  private List<EventEntity> events;

  @Ignore
  @Expose
  private List<ClientEntity> clients;

  public UUID getUuid() {
    return uuid;
  }

  public void setUuid(UUID uuid) {
    this.uuid = uuid;
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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getStartTime() {
    return startTime;
  }

  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }

  public Date getEndTime() {
    return endTime;
  }

  public void setEndTime(Date endTime) {
    this.endTime = endTime;
  }

  public Date getExpectedEndTime() {
    return expectedEndTime;
  }

  public void setExpectedEndTime(Date expectedEndTime) {
    this.expectedEndTime = expectedEndTime;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<EventEntity> getEvents() {
    return events;
  }

  public void setEvents(List<EventEntity> events) {
    this.events = events;
  }

  public List<ClientEntity> getClients() {
    return clients;
  }

  public void setClients(List<ClientEntity> clients) {
    this.clients = clients;
  }
}
