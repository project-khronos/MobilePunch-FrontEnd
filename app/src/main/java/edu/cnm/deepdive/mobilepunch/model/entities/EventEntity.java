package edu.cnm.deepdive.mobilepunch.model.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.support.annotation.NonNull;
import com.google.gson.annotations.Expose;
import java.util.List;
import java.util.UUID;

@Entity(
    primaryKeys = {"event_id1", "event_id2"}
)
public class EventEntity {

  @Ignore
  @Expose
  private UUID uuid;

  @NonNull
  @ColumnInfo(name = "event_id1")
  private long id2;

  @NonNull
  @ColumnInfo(name = "event_id2")
  private long id1;

  @Ignore
  @Expose
  List<EquipmentEntity> equipment;

  public UUID getUuid() {
    return uuid;
  }

  public void setUuid(UUID uuid) {
    this.uuid = uuid;
  }

  public List<EquipmentEntity> getEquipment() {
    return equipment;
  }

  public void setEquipment(
      List<EquipmentEntity> equipment) {
    this.equipment = equipment;
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
