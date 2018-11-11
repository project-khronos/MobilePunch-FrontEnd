package edu.cnm.deepdive.mobilepunch.view.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.cnm.deepdive.mobilepunch.R;
import edu.cnm.deepdive.mobilepunch.model.entities.PostTest;
import edu.cnm.deepdive.mobilepunch.service.MobilePunchService;
import java.util.List;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrotest extends Fragment {

  MobilePunchService service;
  EditText keyText;
  EditText valueText;
  EditText getkey;
  TextView getResponse;
  Button postButton;
  Button getButton;
  private static final String TAG = "tag";
  PostTest post;
  PostTask postTask;

  public static Retrotest newInstance() {
    Retrotest retroTest = new Retrotest();
    return retroTest;
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    final View view = inflater.inflate(R.layout.retro_test, container, false);

    keyText = view.findViewById(R.id.key_text);
    valueText = view.findViewById(R.id.value_text);
    getkey = view.findViewById(R.id.get_key);
    getResponse = view.findViewById(R.id.repsonse);
    final Button postButton = view.findViewById(R.id.post_button);
    postButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {

        String key = keyText.getText().toString();
        String value = valueText.getText().toString();
        service.get();
      }
    });

    Button getButton = view.findViewById(R.id.get_button);
    getButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        new PostTask().execute();
        // postTask.execute();

      }
    });
    return view;
  }

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Gson gson = new GsonBuilder()
        //    .excludeFieldsWithoutExposeAnnotation()
        .create();
    Retrofit retrofit = new Builder()
        // TODO change base_url value.
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build();
    service = retrofit.create(MobilePunchService.class);

  }

  public class PostTask extends AsyncTask<Void, Void, List<PostTask>> {

    @Override
    protected List<PostTask> doInBackground(Void... voids) {
      try {
        List<PostTest> posts;
        Response<List<PostTest>> response = service.get().execute();
        if (response.isSuccessful()) {
          posts = response.body();
          post = posts.get(0);
        } else {
          post = null;
        }

      } catch (Exception e) {
        Log.d(TAG, "exception caught on 'GET", e);
      }
      return null;
    }

    @Override
    protected void onPostExecute(List<PostTask> postTasks) {
      getResponse.setText(post.title);
    }

  }
}

