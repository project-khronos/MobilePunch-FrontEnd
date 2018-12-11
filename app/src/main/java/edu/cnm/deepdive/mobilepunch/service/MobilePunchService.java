package edu.cnm.deepdive.mobilepunch.service;

import edu.cnm.deepdive.mobilepunch.model.entities.ClientEntity;
import edu.cnm.deepdive.mobilepunch.model.entities.EquipmentEntity;
import edu.cnm.deepdive.mobilepunch.model.entities.ProjectEntity;
import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PUT;


/**
 * The interface Mobile punch service. Defines all the http requests.
 */
public interface MobilePunchService {

  /**
   * Gets projects.
   *
   * @param authorization the authorization
   * @return the projects
   */
  @GET("projects")
  Call<List<ProjectEntity>> getProjects(
      @Header("Authorization") String authorization);

  /**
   * Put projects response.
   *
   * @param authorization the authorization
   * @param projects the projects
   * @return the response
   */
  @PUT("projects")
  Response<List<ProjectEntity>> putProjects(
      @Header("Authorization") String authorization, @Body List<ProjectEntity> projects);

  /**
   * Gets projects json.
   *
   * @param authorization the authorization
   * @return the projects json
   */
  @GET("projects")
  Call<ResponseBody> getProjectsJson(
      @Header("Authorization") String authorization);

  /**
   * Gets clients.
   *
   * @param authorization the authorization
   * @return the clients
   */
  @GET("clients")
  Call<List<ClientEntity>> getClients(
      @Header("Authorization") String authorization);

  /**
   * Put clients response.
   *
   * @param authorization the authorization
   * @param clients the clients
   * @return the response
   */
  @PUT("clients")
  Response<List<ClientEntity>> putClients(
      @Header("Authorization") String authorization, @Body List<ClientEntity> clients);

  /**
   * Gets clients json.
   *
   * @param authorization the authorization
   * @return the clients json
   */
  @GET("clients")
  Call<ResponseBody> getClientsJson(
      @Header("Authorization") String authorization);

  /**
   * Gets equipment.
   *
   * @param authorization the authorization
   * @return the equipment
   */
  @GET("equipment")
  Call<List<EquipmentEntity>> getEquipment(
      @Header("Authorization") String authorization);

  /**
   * Put equipment response.
   *
   * @param authorization the authorization
   * @param equipmentList the equipment list
   * @return the response
   */
  @PUT("equipment")
  Response<List<EquipmentEntity>> putEquipment(
      @Header("Authorization") String authorization, @Body List<EquipmentEntity> equipmentList);

  /**
   * Gets equipment json.
   *
   * @param authorization the authorization
   * @return the equipment json
   */
  @GET("equipment")
  Call<ResponseBody> getEquipmentJson(
      @Header("Authorization") String authorization);

}
