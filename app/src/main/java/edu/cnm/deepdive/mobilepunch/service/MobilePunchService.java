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


public interface MobilePunchService {

  @GET("projects")
  Call<List<ProjectEntity>> getProjects(
      @Header("Authorization") String authorization);

  @PUT("projects")
  Response<List<ProjectEntity>> putProjects(
      @Header("Authorization") String authorization, @Body List<ProjectEntity> projects);

  @GET("projects")
  Call<ResponseBody> getProjectsJson(
      @Header("Authorization") String authorization);


  @GET("clients")
  Call<List<ClientEntity>> getClients(
      @Header("Authorization") String authorization);

  @PUT("clients")
  Response<List<ClientEntity>> putClients(
      @Header("Authorization") String authorization, @Body List<ClientEntity> clients);

  @GET("clients")
  Call<ResponseBody> getClientsJson(
      @Header("Authorization") String authorization);

  @GET("equipment")
  Call<List<EquipmentEntity>> getEquipment(
      @Header("Authorization") String authorization);

  @PUT("equipment")
  Response<List<EquipmentEntity>> putEquipment(
      @Header("Authorization") String authorization, @Body List<EquipmentEntity> equipmentList);

  @GET("equipment")
  Call<ResponseBody> getEquipmentJson(
      @Header("Authorization") String authorization);

}
