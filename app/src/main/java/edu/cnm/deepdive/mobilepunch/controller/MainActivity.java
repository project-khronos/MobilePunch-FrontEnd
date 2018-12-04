package edu.cnm.deepdive.mobilepunch.controller;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.cnm.deepdive.mobilepunch.R;
import edu.cnm.deepdive.mobilepunch.model.db.MobilePunchDatabase;
import edu.cnm.deepdive.mobilepunch.model.entities.ProjectEntity;
import edu.cnm.deepdive.mobilepunch.service.MobilePunchService;
import edu.cnm.deepdive.mobilepunch.view.BottomNav;
import edu.cnm.deepdive.mobilepunch.view.fragments.Retrotest;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener {

  private MobilePunchService service;
  private List<ProjectEntity> projects;
  private MobilePunchDatabase dataBase;
  private String TAG = "tag";

  public void setProjects(
      List<ProjectEntity> projects) {
    this.projects = projects;
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
        this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
    drawer.addDrawerListener(toggle);
    toggle.syncState();

    NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
    navigationView.setNavigationItemSelectedListener(this);


    setupService();
    dataBase = MobilePunchDatabase.getInstance(this);
    ProjectsTask projectsTask = new ProjectsTask();
    projectsTask.execute();

  }

  @Override
  public void onBackPressed() {
    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

    if (drawer.isDrawerOpen(GravityCompat.START)) {
      drawer.closeDrawer(GravityCompat.START);
    } else {
      super.onBackPressed();
    }
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      FragmentManager manager = getSupportFragmentManager();
      FragmentTransaction transaction = manager.beginTransaction();
      transaction.replace(R.id.fragment_container, Retrotest.newInstance(), "");
      transaction.commit();
    } else if (id == R.id.sign_out) {
      signOut();
    }

    return true;
  }


  private void signOut() {
    FrontendApplication.getInstance().getClient().signOut().addOnCompleteListener(this, (task) -> {
      Intent intent = new Intent(this, LoginActivity.class);
      intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
      startActivity(intent);
    });
  }


  @SuppressWarnings("StatementWithEmptyBody")
  @Override
  public boolean onNavigationItemSelected(MenuItem item) {
    // Handle navigation view item clicks here.
    int id = item.getItemId();

    if (id == R.id.event) {
      Intent intent = new Intent(MainActivity.this, BottomNav.class);
      Bundle send = new Bundle();
      send.putInt("key", 1);
      intent.putExtras(send);
      startActivity(intent);
    } else if (id == R.id.project) {
      Intent intent = new Intent(MainActivity.this, BottomNav.class);
      Bundle send = new Bundle();
      send.putInt("key", 2);
      intent.putExtras(send);
      startActivity(intent);
    } else if (id == R.id.client) {
      Intent intent = new Intent(MainActivity.this, BottomNav.class);
      Bundle send = new Bundle();
      send.putInt("key", 3);
      intent.putExtras(send);
      startActivity(intent);
    } else if (id == R.id.equipment) {
      Intent intent = new Intent(MainActivity.this, BottomNav.class);
      Bundle send = new Bundle();
      send.putInt("key", 4);
      intent.putExtras(send);
      startActivity(intent);
    }

    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    drawer.closeDrawer(GravityCompat.START);
    return true;
  }

  private void setupService() {
    Gson gson = new GsonBuilder()
        .excludeFieldsWithoutExposeAnnotation()
        .create();
    service = new Builder()
        // TODO change base_url value.
        .baseUrl("http://10.0.2.2:8080/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
        .create(MobilePunchService.class);
  }

  private class QuerryProjects extends AsyncTask<Void, Void, List<ProjectEntity>> {

    @Override
    protected void onPreExecute() {
      super.onPreExecute();
    }

    @Override
    protected List<ProjectEntity> doInBackground(Void... voids) {
      List<ProjectEntity> projects = new ArrayList<>();
      MobilePunchDatabase.getInstance(MainActivity.this);
      projects = dataBase.getProjectDao().select();
      return projects;
    }

    @Override
    protected void onPostExecute(List<ProjectEntity> projectEntities) {
      if (projects != null) {
        Toast.makeText(MainActivity.this, Integer.toString(projectEntities.size()),
            Toast.LENGTH_LONG).show();
      }
    }

    @Override
    protected void onCancelled() {
      super.onCancelled();
    }

  }

  private class ProjectsTask extends AsyncTask<Void, Void, List<ProjectEntity>> {

    @Override
    protected void onPreExecute() {
      super.onPreExecute();
    }

    @Override
    protected List<ProjectEntity> doInBackground(Void... voids) {
      List<ProjectEntity> projects = null;

      try {
        String token = getString(
            R.string.oauth2_header, FrontendApplication.getInstance().getAccount().getIdToken());
        //GoogleSignIn.getLastSignedInAccount(MainActivity.this).getIdToken());
        Call<List<ProjectEntity>> call = service.get(token);
        Response<List<ProjectEntity>> response = call.execute();
        if (response.isSuccessful()) {
          projects = response.body();
          Log.d(TAG, "RESPONSE SUCCESS: " + response.message());

        } else {
          Log.d(TAG, "RESPONSE NOT SUCCESS: " + response.errorBody().string());
        }
      } catch (Exception e) {
        Log.d(TAG, "Caught Exception on Call: " + e.getLocalizedMessage());
      } finally {
        if (projects == null) {
          Log.d(TAG, "On Cancelled called");
          cancel(true);
        }
        try {
          MobilePunchDatabase.fromUUIDProject(projects);
          dataBase.getProjectDao().insert(projects);
        } catch (Exception e) {
          // FIXME do what
          Log.d(TAG, "insert method failed: " + e.getLocalizedMessage());
        }
      }
      return projects;
    }


    @Override
    protected void onPostExecute(List<ProjectEntity> projectEntities) {
      setProjects(projectEntities);
      QuerryProjects querryProjects = new QuerryProjects();
      querryProjects.execute();
    }

    @Override
    protected void onCancelled() {
      Toast.makeText(MainActivity.this, "Cancelled", Toast.LENGTH_LONG).show();
    }
  }
}
