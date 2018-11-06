package edu.cnm.deepdive.mobilepunch.service;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface MobilePunchService {

  @GET
  Call<String> get(String key);

  @POST
  Call<String> post(String key, String value);


}
