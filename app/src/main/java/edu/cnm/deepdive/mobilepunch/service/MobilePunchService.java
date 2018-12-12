package edu.cnm.deepdive.mobilepunch.service;

import edu.cnm.deepdive.mobilepunch.model.entities.ClientEntity;
import edu.cnm.deepdive.mobilepunch.model.entities.EquipmentEntity;
import edu.cnm.deepdive.mobilepunch.model.entities.ProjectEntity;
import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;


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
   * @param project the project
   * @return the response
   */
  @POST("projects")
  Call<ResponseBody> postProject(
      @Header("Authorization") String authorization, @Body ProjectEntity project);

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
  @POST("clients")
  Call<ResponseBody> postClient(
      @Header("Authorization") String authorization, @Body ClientEntity clients);

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
   * @param equipment the equipment list
   * @return the response
   */
  @POST("equipment")
  Call<ResponseBody> postEquipment(
      @Header("Authorization") String authorization, @Body EquipmentEntity equipment);

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
