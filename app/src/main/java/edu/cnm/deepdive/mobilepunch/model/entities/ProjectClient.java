package edu.cnm.deepdive.mobilepunch.model.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;

/**
 * The type Project client.
 */
@Entity(primaryKeys = {"projectId1", "projectId2"}, foreignKeys = {
    @ForeignKey(entity = ProjectEntity.class, parentColumns = {"project_id1",
        "project_id2"}, childColumns = {"projectId1", "projectId2"}),
    @ForeignKey(entity = ClientEntity.class, parentColumns = {"client_id1",
        "client_id2"}, childColumns = {"clientId1", "clientId2"})
}, indices = @Index(value = {"projectId1", "projectId2", "clientId1", "clientId2"}, unique = true)
)
public class ProjectClient {

  private long projectId1;
  private long projectId2;
  private long clientId1;
  private long clientId2;

  /**
   * Instantiates a new Project client.
   */
  public ProjectClient() {
  }

  /**
   * Instantiates a new Project client.
   *
   * @param project the project
   * @param client the client
   */
  public ProjectClient(ProjectEntity project, ClientEntity client) {
    projectId1 = project.getId1();
    projectId2 = project.getId2();
    clientId1 = client.getId1();
    clientId2 = client.getId2();
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

  /**
   * Gets client id 1.
   *
   * @return the client id 1
   */
  public long getClientId1() {
    return clientId1;
  }

  /**
   * Sets client id 1.
   *
   * @param clientId1 the client id 1
   */
  public void setClientId1(long clientId1) {
    this.clientId1 = clientId1;
  }

  /**
   * Gets client id 2.
   *
   * @return the client id 2
   */
  public long getClientId2() {
    return clientId2;
  }

  /**
   * Sets client id 2.
   *
   * @param clientId2 the client id 2
   */
  public void setClientId2(long clientId2) {
    this.clientId2 = clientId2;
  }
}
