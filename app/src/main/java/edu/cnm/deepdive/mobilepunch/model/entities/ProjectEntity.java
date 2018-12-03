package edu.cnm.deepdive.mobilepunch.model.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.UUID;

@Entity(
    primaryKeys = {"project_id1","project_id2"}
)
public class ProjectEntity {

  @Ignore
  @Expose
  private UUID uuid;

  @ColumnInfo(name = "project_id1")
  private long id1;
  @ColumnInfo(name = "project_id2")
  private long id2;
  @ColumnInfo(name = "start_date")
  private long startDate;
  @ColumnInfo(name = "end_date")
  private long endDate;

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

  public long getStartDate() {
    return startDate;
  }

  public void setStartDate(long startDate) {
    this.startDate = startDate;
  }

  public long getEndDate() {
    return endDate;
  }

  public void setEndDate(long endDate) {
    this.endDate = endDate;
  }
}
