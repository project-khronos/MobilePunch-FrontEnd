package edu.cnm.deepdive.mobilepunch.service;

import edu.cnm.deepdive.mobilepunch.model.entities.ClientEntity;
import edu.cnm.deepdive.mobilepunch.model.entities.EquipmentEntity;
import edu.cnm.deepdive.mobilepunch.model.entities.ProjectEntity;
import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;


public interface MobilePunchService {

  @GET("projects")
  Call<List<ProjectEntity>> getProjects(
      @Header("Authorization") String authorization);

  @GET("projects")
  Call<ResponseBody> getProjectsJson(
      @Header("Authorization") String authorization);


  @GET("clients")
  Call<List<ClientEntity>> getClients(
      @Header("Authorization") String authorization);

  @GET("clients")
  Call<ResponseBody> getClientsJson(
      @Header("Authorization") String authorization);

  @GET("equipment")
  Call<List<EquipmentEntity>> getEquipment(
      @Header("Authorization") String authorization);

  @GET("equipment")
  Call<ResponseBody> getEquipmentJson(
      @Header("Authorization") String authorization);

}
