package edu.cnm.deepdive.mobilepunch.controller;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
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
import edu.cnm.deepdive.mobilepunch.model.dao.abstraction.DaoHelper;
import edu.cnm.deepdive.mobilepunch.model.db.MobilePunchDatabase;
import edu.cnm.deepdive.mobilepunch.model.entities.ClientEntity;
import edu.cnm.deepdive.mobilepunch.model.entities.EquipmentEntity;
import edu.cnm.deepdive.mobilepunch.model.entities.EventEntity;
import edu.cnm.deepdive.mobilepunch.model.entities.ProjectEntity;
import edu.cnm.deepdive.mobilepunch.service.MobilePunchService;
import edu.cnm.deepdive.mobilepunch.view.BottomNav;
import edu.cnm.deepdive.mobilepunch.view.fragments.MainFragment;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import retrofit2.Response;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * The type Main activity. This class inflates the main menu and the navigation drawer. Also, sets
 * up the database api task and replaces fragment container.
 */
public class MainActivity extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener {

  private static MainActivity instance = null;
  private MobilePunchService service;
  private MobilePunchDatabase dataBase;
  private String TAG = "tag";

  /**
   * Gets the current service
   *
   * @return the service
   */
  public MobilePunchService getService() {
    return service;
  }

  /**
   * Gets instance.
   *
   * @return the instance
   */
  public static MainActivity getInstance() {
    return instance;
  }

  /**
   * Sign out.
   */
  static void signOut() {
    FrontendApplication.getInstance().getClient().signOut()
        .addOnCompleteListener(MainActivity.getInstance(), (task) -> {
          Intent intent = new Intent(MainActivity.getInstance(), LoginActivity.class);
          intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
          MainActivity.getInstance().startActivity(intent);
        });
  }


  @Override
  public void onBackPressed() {
    DrawerLayout drawer = findViewById(R.id.drawer_layout);

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

    } else if (id == R.id.sign_out) {
      signOut();
    }

    return true;
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    DrawerLayout drawer = findViewById(R.id.drawer_layout);
    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
        this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
    drawer.addDrawerListener(toggle);
    toggle.syncState();

    NavigationView navigationView = findViewById(R.id.nav_view);
    navigationView.setNavigationItemSelectedListener(this);

    getSupportFragmentManager().beginTransaction()
        .replace(R.id.fragment_container, new MainFragment()).commit();

    setupService();
    dataBase = MobilePunchDatabase.getInstance(this);
    ApiTask apiTask = new ApiTask();
    apiTask.execute();
    instance = this;
    //new DaoHelper.ProjectGetterTask().execute();

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

    DrawerLayout drawer = findViewById(R.id.drawer_layout);
    drawer.closeDrawer(GravityCompat.START);
    return true;
  }

  private void setupService() {
    Gson gson = new GsonBuilder()
        .excludeFieldsWithoutExposeAnnotation()
        .create();
    service = new Builder()
        // TODO change base_url value.
        .baseUrl("https://straylense.space/pojectkhronos")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
        .create(MobilePunchService.class);
  }

  private class QueryTask extends AsyncTask<Void, Void, List<ProjectEntity>> {

    @Override
    protected void onPreExecute() {
      super.onPreExecute();
    }

    @Override
    protected List<ProjectEntity> doInBackground(Void... voids) {
      List<ProjectEntity> projects;
      MobilePunchDatabase.getInstance(MainActivity.this);
      projects = dataBase.getProjectDao().selectAll();
      return projects;
    }

    @Override
    protected void onPostExecute(List<ProjectEntity> projectEntities) {

    }

    @Override
    protected void onCancelled() {
      super.onCancelled();
    }

  }


  private class ApiTask extends AsyncTask<Void, Void, List<ProjectEntity>> {

    @Override
    protected void onPreExecute() {
      super.onPreExecute();
    }

    @Override
    protected List<ProjectEntity> doInBackground(Void... voids) {
      List<ProjectEntity> projects = null;
      List<ClientEntity> clients = null;
      List<EquipmentEntity> equipment = null;

      Log.d(TAG, "Executing API TASK");
      FrontendApplication.refreshToken();
      Log.d(TAG, "Token Refreshed");
      FrontendApplication
          .setMasterProjectSet(DaoHelper.getProjects(MainActivity.this));
      FrontendApplication.setMasterClientSet(DaoHelper.getClients(MainActivity.this));
      FrontendApplication.setMasterEquipmentSet(DaoHelper.getEquipment(MainActivity.this));
      try {
        String token = getString(
            R.string.oauth2_header, FrontendApplication.getInstance().getAccount().getIdToken());
        Response<List<ProjectEntity>> projectsResponse = service.getProjects(token).execute();
        Response<List<ClientEntity>> clientsResponse = service.getClients(token).execute();
        Response<List<EquipmentEntity>> equipmentResponse = service.getEquipment(token).execute();

        service.putClients(token, new ArrayList<>(FrontendApplication.getMasterClientSet()));
        service.putEquipment(token, new ArrayList<>(FrontendApplication.getMasterEquipmentSet()));
        service.putProjects(token, new ArrayList<>(FrontendApplication.getMasterProjectSet()));

        // Response<ResponseBody> eqJson = service.getEquipmentJson(token).execute();
        //Use this to see raw response, needs a jsoncall.
        // Log.d(TAG, "RAW JSON: " + eqJson.body().string());
        if (projectsResponse.isSuccessful()
            && clientsResponse.isSuccessful()
            && equipmentResponse.isSuccessful()) {
          projects = projectsResponse.body();
          clients = clientsResponse.body();
          equipment = equipmentResponse.body();

        } else {
          Log.d(TAG, "Service Execution Failed: ");
        }
      } catch (Exception e) {
        Log.d(TAG, "Exception in service execution: " + e.getLocalizedMessage());
      } finally {
        if (projects == null || clients == null || equipment == null) {
          Log.d(TAG, "Service execution cancelled");
          cancel(true);
        }
        try {
          MobilePunchDatabase.fromUUIDProject(projects);
          List<EventEntity> events = MobilePunchDatabase.getEventsFromProject(projects);
          MobilePunchDatabase.fromUUIDClient(clients);
          dataBase.getClientDao().insert(clients);
          for (ProjectEntity project : projects) {
            UUID clientID = project.getClient().getUuid();
            project.setClientId1(clientID.getMostSignificantBits());
            project.setClientId2(clientID.getLeastSignificantBits());
          }
          dataBase.getProjectDao().insert(projects);
          MobilePunchDatabase.fromUUIDEquipment(equipment);
          dataBase.getEquipmentDao().insert(equipment);
          for (EventEntity event : events) {
            if (event.getEquipment() != null) {
              UUID equipmentID = event.getEquipment().getUuid();
              event.setEquipmentId1(equipmentID.getMostSignificantBits());
              event.setEquipmentId2(equipmentID.getLeastSignificantBits());
            } else {
              event.setEquipmentId1(0L);
              event.setEquipmentId2(0L);
            }
          }

          dataBase.getEventDao().insert(events);


        } catch (Exception e) {
          // FIXME do what
          Log.d(TAG, "insert method failed: " + e.getLocalizedMessage());
          e.printStackTrace();
        }
      }
      FrontendApplication.getMasterProjectSet().removeAll(projects);
      FrontendApplication.getMasterClientSet().removeAll(clients);
      FrontendApplication.getMasterEquipmentSet().removeAll(equipment);
      FrontendApplication.getMasterProjectSet().addAll(projects);
      FrontendApplication.getMasterClientSet().addAll(clients);
      FrontendApplication.getMasterEquipmentSet().addAll(equipment);

      return projects;
    }


    @Override
    protected void onPostExecute(List<ProjectEntity> projectEntities) {
      //FIXME Move this so its called no matter the status of APITask
      QueryTask queryTask = new QueryTask();
      queryTask.execute();
      Toast.makeText(MainActivity.this, "Database Updated",
          Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCancelled() {
      Toast.makeText(MainActivity.this,
          "Unable to connect to server... Check network connection", Toast.LENGTH_LONG).show();
      Log.d(TAG, "Service cancelled");
    }
  }
}
