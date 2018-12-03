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
  @NonNull
  @ColumnInfo(name = "phone_number")
  private String phoneNumber;
  @ColumnInfo(name = "alt_phone_number")
  private String altPhoneNumber;
  @ColumnInfo(name = "billing_adress_id")
  private long billingAdressId;
  @ColumnInfo(name = "mailing_address_id")
  private long mailingAdressId;
  private String notes;

  @Ignore
  @Expose
  List<ProjectEntity> projects;

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

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getAltPhoneNumber() {
    return altPhoneNumber;
  }

  public void setAltPhoneNumber(String altPhoneNumber) {
    this.altPhoneNumber = altPhoneNumber;
  }

  public long getBillingAdressId() {
    return billingAdressId;
  }

  public void setBillingAdressId(long billingAdressId) {
    this.billingAdressId = billingAdressId;
  }

  public long getMailingAdressId() {
    return mailingAdressId;
  }

  public void setMailingAdressId(long mailingAdressId) {
    this.mailingAdressId = mailingAdressId;
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }
}
