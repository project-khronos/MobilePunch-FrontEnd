package edu.cnm.deepdive.mobilepunch.model.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.support.annotation.NonNull;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.UUID;


@Entity(
    primaryKeys = {"client_id1", "client_id2"}
)
public class ClientEntity {


  @Ignore
  @Expose
  @SerializedName("client_id")
  private UUID uuid;

  @NonNull
  @ColumnInfo(name = "client_id1")
  private long id1;


  @NonNull
  @ColumnInfo(name = "client_id2")
  private long id2;

  @NonNull
  private String name;

  private String email;

  @Ignore
  @Expose
  List<ProjectEntity> projects;
  @NonNull

  private String phone;

  @ColumnInfo(name = "alt_phone")
  private String altPhone;

  private long address;

  private String notes;

  @ColumnInfo(name = "alt_address")
  private long altAddress;

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

  public List<ProjectEntity> getProjects() {
    return projects;
  }

  public void setProjects(
      List<ProjectEntity> projects) {
    this.projects = projects;
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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @NonNull
  public String getPhone() {
    return phone;
  }

  public void setPhone(@NonNull String phone) {
    this.phone = phone;
  }

  public String getAltPhone() {
    return altPhone;
  }

  public void setAltPhone(String altPhone) {
    this.altPhone = altPhone;
  }

  public long getAddress() {
    return address;
  }

  public void setAddress(long address) {
    this.address = address;
  }

  public long getAltAddress() {
    return altAddress;
  }

  public void setAltAddress(long altAddress) {
    this.altAddress = altAddress;
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }
}
