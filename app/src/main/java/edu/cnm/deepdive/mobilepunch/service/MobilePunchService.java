package edu.cnm.deepdive.mobilepunch.service;

import edu.cnm.deepdive.mobilepunch.model.entities.ProjectEntity;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;


public interface MobilePunchService {

  @GET("projects")
  Call<List<ProjectEntity>> get(
      @Header("Authorization") String authorization);


}
