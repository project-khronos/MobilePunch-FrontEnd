package edu.cnm.deepdive.mobilepunch.model.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(foreignKeys = {
    @ForeignKey(entity = ProjectEntity.class, parentColumns = {"project_id1",
        "project_id2"}, childColumns = {"projectId1", "projectId2"}),
    @ForeignKey(entity = ClientEntity.class, parentColumns = {"client_id1",
        "client_id2"}, childColumns = {"clientId1", "clientId2"})
}
)
public class ProjectClient {

  @PrimaryKey
  private long id;
  private long projectId1;
  private long projectId2;
  private long clientId1;
  private long clientId2;

  public ProjectClient() {
  }

  public ProjectClient(ProjectEntity project, ClientEntity client) {
    projectId1 = project.getId1();
    projectId2 = project.getId2();
    clientId1 = client.getId1();
    clientId2 = client.getId2();
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
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

  public long getClientId1() {
    return clientId1;
  }

  public void setClientId1(long clientId1) {
    this.clientId1 = clientId1;
  }

  public long getClientId2() {
    return clientId2;
  }

  public void setClientId2(long clientId2) {
    this.clientId2 = clientId2;
  }
}
