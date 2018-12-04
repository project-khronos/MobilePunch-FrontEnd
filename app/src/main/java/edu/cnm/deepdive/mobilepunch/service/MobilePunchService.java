package edu.cnm.deepdive.mobilepunch.service;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;


public interface MobilePunchService {

  @GET("projects")
  Call<ResponseBody> get(
      @Header("Authorization") String authorization);


}
