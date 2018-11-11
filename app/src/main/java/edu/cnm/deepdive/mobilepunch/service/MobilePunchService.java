package edu.cnm.deepdive.mobilepunch.service;

import edu.cnm.deepdive.mobilepunch.model.entities.PostTest;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface MobilePunchService {

  @GET("posts")
  Call<List<PostTest>> get();

  @POST
  Call<String> post(@Query("posts") String key, @Query("post") String value);


}
