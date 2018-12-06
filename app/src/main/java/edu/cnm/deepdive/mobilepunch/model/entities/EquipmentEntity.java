package edu.cnm.deepdive.mobilepunch.model.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.support.annotation.NonNull;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import edu.cnm.deepdive.mobilepunch.model.entities.abstraction.UuidHaver;
import java.util.UUID;


/**
 * The type Equipment entity.
 */
@Entity(
    primaryKeys = {
        "equipment_id1", "equipment_id2"
    }
)
public class EquipmentEntity implements UuidHaver {

  @Ignore
  @Expose
  @SerializedName("uuid")
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
  private String identification;

  private String description;

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
   * Gets name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets name.
   *
   * @param name the name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets make.
   *
   * @return the make
   */
  public String getMake() {
    return make;
  }

  /**
   * Sets make.
   *
   * @param make the make
   */
  public void setMake(String make) {
    this.make = make;
  }

  /**
   * Gets model.
   *
   * @return the model
   */
  public String getModel() {
    return model;
  }

  /**
   * Sets model.
   *
   * @param model the model
   */
  public void setModel(String model) {
    this.model = model;
  }

  /**
   * Gets mfcyear.
   *
   * @return the mfcyear
   */
  public String getMfcyear() {
    return mfcyear;
  }

  /**
   * Sets mfcyear.
   *
   * @param mfcyear the mfcyear
   */
  public void setMfcyear(String mfcyear) {
    this.mfcyear = mfcyear;
  }

  /**
   * Gets identification.
   *
   * @return the identification
   */
  @NonNull
  public String getIdentification() {
    return identification;
  }

  /**
   * Sets identification.
   *
   * @param identification the identification
   */
  public void setIdentification(@NonNull String identification) {
    this.identification = identification;
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
}


