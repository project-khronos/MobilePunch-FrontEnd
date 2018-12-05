package edu.cnm.deepdive.mobilepunch.model.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.OnConflictStrategy;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.UUID;


@Entity(
    primaryKeys = {
        "equipment_id1", "equipment_id2"
    },
    foreignKeys = {@ForeignKey(
    entity = EventEntity.class,
    parentColumns = {"event_id1","event_id2"},
    childColumns = {"event_id1","event_id2"},
    onDelete = OnConflictStrategy.FAIL
)}
)
public class EquipmentEntity {

  @Ignore
  @SerializedName("uuid")
  @Expose
  private UUID uuid;

  @ColumnInfo(name = "equipment_id1")
  private long id1;

  @ColumnInfo(name = "equipment_id2")
  private long id2;

  @Expose
  private String name;

  @Expose
  private String Identification;

  @Expose
  private String make;

  @Expose
  private String model;

  @Expose
  private String mfcyear;

  @Expose
  private String description;

  @ColumnInfo(name = "event_id2")
  private long eventId2;

  @ColumnInfo(name = "event_id1")
  private long eventId1;

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

  public String getIdentification() {
    return Identification;
  }

  public void setIdentification(String identification) {
    Identification = identification;
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

  public String getMfcyear() {
    return mfcyear;
  }

  public void setMfcyear(String mfcyear) {
    this.mfcyear = mfcyear;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public long getEventId2() {
    return eventId2;
  }

  public void setEventId2(long eventId2) {
    this.eventId2 = eventId2;
  }

  public long getEventId1() {
    return eventId1;
  }

  public void setEventId1(long eventId1) {
    this.eventId1 = eventId1;
  }
}


