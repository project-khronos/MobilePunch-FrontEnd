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


/**
 * The type Client entity.
 */
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

  /**
   * The Projects.
   */
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
   * Gets email.
   *
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * Sets email.
   *
   * @param email the email
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Gets phone.
   *
   * @return the phone
   */
  public String getPhone() {
    return phone;
  }

  /**
   * Sets phone.
   *
   * @param phone the phone
   */
  public void setPhone(String phone) {
    this.phone = phone;
  }

  /**
   * Gets alt phone.
   *
   * @return the alt phone
   */
  public String getAltPhone() {
    return altPhone;
  }

  /**
   * Sets alt phone.
   *
   * @param altPhone the alt phone
   */
  public void setAltPhone(String altPhone) {
    this.altPhone = altPhone;
  }

  /**
   * Gets address.
   *
   * @return the address
   */
  public String getAddress() {
    return address;
  }

  /**
   * Sets address.
   *
   * @param address the address
   */
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   * Gets alt address.
   *
   * @return the alt address
   */
  public String getAltAddress() {
    return altAddress;
  }

  /**
   * Sets alt address.
   *
   * @param altAddress the alt address
   */
  public void setAltAddress(String altAddress) {
    this.altAddress = altAddress;
  }

  /**
   * Gets notes.
   *
   * @return the notes
   */
  public String getNotes() {
    return notes;
  }

  /**
   * Sets notes.
   *
   * @param notes the notes
   */
  public void setNotes(String notes) {
    this.notes = notes;
  }

  /**
   * Gets projects.
   *
   * @return the projects
   */
  public List<ProjectEntity> getProjects() {
    return projects;
  }

  /**
   * Sets projects.
   *
   * @param projects the projects
   */
  public void setProjects(
      List<ProjectEntity> projects) {
    this.projects = projects;
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
}
