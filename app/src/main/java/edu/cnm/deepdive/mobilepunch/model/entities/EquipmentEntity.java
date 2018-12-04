package edu.cnm.deepdive.mobilepunch.model.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.support.annotation.NonNull;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.UUID;


@Entity(
    primaryKeys = {
        "equipment_id1", "equipment_id2"
    }
)
public class EquipmentEntity {


  @Ignore
  @SerializedName("equipment_id")
  @Expose
  private UUID uuid;

  @ColumnInfo(name = "equipment_id1")
  private long id1;

  @ColumnInfo(name = "equipment_id2")
  private long id2;

  private String name;

  private String make;

  private String model;

  private String mfcyear;

  @NonNull
  private String Identification;

  public UUID getUuid() {
    return uuid;
  }

  public void setUuid(UUID uuid) {
    this.uuid = uuid;
  }

  @NonNull
  public String getIdentification() {
    return Identification;
  }

  public void setIdentification(@NonNull String identification) {
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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getMfcyear() {
    return mfcyear;
  }

  public void setMfcyear(String mfcyear) {
    this.mfcyear = mfcyear;
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


}


