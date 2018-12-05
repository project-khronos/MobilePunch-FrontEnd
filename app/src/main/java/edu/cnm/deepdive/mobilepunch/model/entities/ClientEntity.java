package edu.cnm.deepdive.mobilepunch.model.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import io.reactivex.annotations.NonNull;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;


@Entity(
    primaryKeys = {"client_id1", "client_id2"}
//    foreignKeys = {@ForeignKey(
//        entity = ProjectEntity.class,
//        parentColumns = {"project_id1","project_id2"},
//        childColumns = {"project_id1","project_id2"},
//        onDelete = OnConflictStrategy.FAIL
//    )}
)
public class ClientEntity implements Serializable {


  @Ignore
  @Expose
  @SerializedName("uuid")
  private UUID uuid;

  @ColumnInfo(name = "client_id1")
  private long id1;

  @ColumnInfo(name = "client_id2")
  private long id2;

  @Ignore
  @Expose
  List<ProjectEntity> projects;
  @NonNull
  @Expose
  private String name;
  @Expose
  private String email;

  @ColumnInfo(name = "alt_phone")
  private String altPhone;
  @NonNull
  @Expose
  private String phone;
  @Expose
  private String address;
  @Expose
  @ColumnInfo(name = "alt_address")
  private String altAddress;
  @Expose
  private String notes;
  @ColumnInfo(name = "project_id1")
  private long projectId1;

  @ColumnInfo(name = "project_id2")
  private long projectId2;

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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getAltPhone() {
    return altPhone;
  }

  public void setAltPhone(String altPhone) {
    this.altPhone = altPhone;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getAltAddress() {
    return altAddress;
  }

  public void setAltAddress(String altAddress) {
    this.altAddress = altAddress;
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public List<ProjectEntity> getProjects() {
    return projects;
  }

  public void setProjects(
      List<ProjectEntity> projects) {
    this.projects = projects;
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
}
