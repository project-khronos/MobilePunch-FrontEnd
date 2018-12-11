package edu.cnm.deepdive.mobilepunch.view.fragments;

import android.Manifest;
import android.Manifest.permission;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import edu.cnm.deepdive.mobilepunch.R;
import edu.cnm.deepdive.mobilepunch.controller.DateTimePickerFragment;
import edu.cnm.deepdive.mobilepunch.controller.DateTimePickerFragment.Mode;
import edu.cnm.deepdive.mobilepunch.controller.FrontendApplication;
import edu.cnm.deepdive.mobilepunch.controller.MainActivity;
import edu.cnm.deepdive.mobilepunch.model.db.MobilePunchDatabase;
import edu.cnm.deepdive.mobilepunch.model.entities.EquipmentEntity;
import edu.cnm.deepdive.mobilepunch.model.entities.EventEntity;
import edu.cnm.deepdive.mobilepunch.model.entities.ProjectEntity;
import edu.cnm.deepdive.mobilepunch.model.entities.abstraction.UuidSetter;
import edu.cnm.deepdive.mobilepunch.view.fragments.helpers.DayOfWeekHelper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * The type Event fragment. This class inflates the Event fragment. This is where user can edit text fields and
 * save information applied to database.
 */
public class EventFragment extends Fragment {

  private EventEntity event;

  private EditText expensesField,
      descriptionField,
      incomeField;

  private Button eventStartDateButton,
      eventEndDateButton,
      saveButton;
  private ProjectEntity pickedProject;
  private EquipmentEntity pickedEquipment;
  private Date startDate = new Date(), endDate = new Date();

  private String TAG = "tag";
  private Spinner projectSpinner;
  private Spinner equipmentSpinner;
  private List<ProjectEntity> localProjectList;
  private List<EquipmentEntity> localEquipmentList;
  private View view;

  private MapView mapView;
  private Bundle bundle;
  private FusedLocationProviderClient fusedLocationProviderClient;
  private LocationRequest locationRequest;
  private LocationCallback locationCallback;


  private int locationRequestCode = 1000;
  private double currentLatitude = 35.0844;
  private double currentLongitude = -106.6504;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    //event = new EventEntity();
    this.bundle = savedInstanceState;

    fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(getActivity());

    if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)
        != PackageManager.PERMISSION_GRANTED
        && ActivityCompat
        .checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION)
        != PackageManager.PERMISSION_GRANTED) {
      ActivityCompat.requestPermissions(getActivity(),
          new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
              Manifest.permission.ACCESS_COARSE_LOCATION},
          locationRequestCode);
    } else {
      // already permission granted
      getLocation();
    }
  }

  @Override
  public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
      @NonNull int[] grantResults) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    switch (requestCode) {
      case 1000: {
        // If request is cancelled, the result arrays are empty.
        if (grantResults.length > 0
            && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
        } else {
          Toast.makeText(getActivity(), "Permission denied", Toast.LENGTH_SHORT).show();
        }
        break;
      }
    }
  }

  private void getLocation() {

    locationRequest = LocationRequest.create();
    locationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
    locationRequest.setInterval(20 * 1000);

    locationCallback = new LocationCallback() {
      @Override
      public void onLocationResult(LocationResult locationResult) {
        if (locationResult == null) {
          return;
        }
        for (Location location : locationResult.getLocations()) {
          if (location != null) {
            currentLongitude = locationResult.getLastLocation().getLongitude();
            currentLatitude = locationResult.getLastLocation().getLatitude();
          }
        }
        Log.d(TAG, "Longitude" + Double.toString(currentLongitude));
        Log.d(TAG, "Latitide" + Double.toString(currentLatitude));

      }
    };

    if (ActivityCompat.checkSelfPermission(getActivity(), permission.ACCESS_FINE_LOCATION)
        != PackageManager.PERMISSION_GRANTED
        && ActivityCompat.checkSelfPermission(getActivity(), permission.ACCESS_COARSE_LOCATION)
        != PackageManager.PERMISSION_GRANTED) {
      // TODO: Consider calling
      //    ActivityCompat#requestPermissions
      // here to request the missing permissions, and then overriding
      //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
      //                                          int[] grantResults)
      // to handle the case where the user grants the permission. See the documentation
      // for ActivityCompat#requestPermissions for more details.
      return;
    }
    fusedLocationProviderClient.requestLocationUpdates(locationRequest, locationCallback, null);

  }


  @Override
  public void onStart() {
    super.onStart();
    mapView.onStart();
  }

  @Override
  public void onResume() {
    super.onResume();
    mapView.onResume();
  }

  @Override
  public void onPause() {
    super.onPause();
    mapView.onPause();
  }


  @Override
  public void onSaveInstanceState(@NonNull Bundle outState) {
    super.onSaveInstanceState(outState);
    mapView.onSaveInstanceState(outState);
  }

  @Override
  public void onLowMemory() {
    super.onLowMemory();
    mapView.onLowMemory();
  }

  @Override
  public void onStop() {
    super.onStop();
    mapView.onStop();
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    mapView.onDestroy();
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    view = inflater.inflate(R.layout.fragment_event, container, false);

    mapView = view.findViewById(R.id.event_map);
    //String title = "You are here";
    MapsInitializer.initialize(MainActivity.getInstance());
    mapView.onCreate(bundle);

    mapView.getMapAsync(new OnMapReadyCallback() {
      @Override
      public void onMapReady(GoogleMap googleMap) {
        if (googleMap != null) {
          LatLng currentLocation = new LatLng(currentLatitude, currentLongitude);
          googleMap.addMarker(new MarkerOptions()
              .position(currentLocation));
          googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLocation, 5));

        }


      }
    });

      //generateIds();
    initLayout();
    initListeners();

    return view;
  }


  private void generateIds() {
    UuidSetter.setNewRandomUuid(event);
  }

  private void initLayout() {

    expensesField = view.findViewById(R.id.event_expenses);
    descriptionField = view.findViewById(R.id.event_description);
    incomeField = view.findViewById(R.id.event_income);

    eventStartDateButton = view.findViewById(R.id.event_start_date);
    eventStartDateButton.setTag("Start date");
    eventEndDateButton = view.findViewById(R.id.event_end_date);
    eventEndDateButton.setTag("End date");
    projectSpinner = view.findViewById(R.id.project_spinner);
    equipmentSpinner = view.findViewById(R.id.equipment_spinner);
    ArrayAdapter<String> projectSpinnerAdapter = new ArrayAdapter<>(getContext(),
        R.layout.spinner_item, android.R.id.text1);
    ArrayAdapter<String> equipmentSpinnerAdapter = new ArrayAdapter<>(getContext(),
        R.layout.spinner_item, android.R.id.text1);
    projectSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    projectSpinner.setAdapter(projectSpinnerAdapter);
    equipmentSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    equipmentSpinner.setAdapter(equipmentSpinnerAdapter);

    localProjectList = new ArrayList<>(FrontendApplication.getMasterProjectSet());
    List<String> getProjectNames = new ArrayList<>();
    for (ProjectEntity project : localProjectList) {
      getProjectNames.add(project.getName());
    }
    projectSpinnerAdapter.addAll(getProjectNames);
    projectSpinnerAdapter.notifyDataSetChanged();

    localEquipmentList = new ArrayList<>(FrontendApplication.getMasterEquipmentSet());
    List<String> getEquipmentNames = new ArrayList<>();
    for (EquipmentEntity equipment : localEquipmentList) {
      getEquipmentNames.add(equipment.getName());
    }
    equipmentSpinnerAdapter.addAll(getEquipmentNames);
    equipmentSpinnerAdapter.notifyDataSetChanged();

    projectSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        EventFragment.this.pickedProject = localProjectList.get(position);
      }

      @Override
      public void onNothingSelected(AdapterView<?> parent) {

      }
    });

    equipmentSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        EventFragment.this.pickedEquipment = localEquipmentList.get(position);
      }

      @Override
      public void onNothingSelected(AdapterView<?> parent) {

      }
    });

    saveButton = view.findViewById(R.id.event_save);
  }


  private void initListeners() {
    DateTimePickerFragment picker = new DateTimePickerFragment();
    picker.setMode(Mode.DATE);

    setButton(eventStartDateButton, picker, startDate);
    setButton(eventEndDateButton, picker, endDate);

    saveButton.setOnClickListener(v -> {
      event = new EventEntity(pickedProject, pickedEquipment);
      grabFields();

      if (!descriptionField.getText().toString().equals("")) {
        new InsertEvent(MainActivity.getInstance(), pickedProject)
            .execute(event);
        Toast.makeText(getContext(), "Event saved", Toast.LENGTH_SHORT).show();
        getFragmentManager().beginTransaction()
            .replace(R.id.fragment_container, new ProjectFragment()).commit();
      } else {
        Toast.makeText(getContext(), "Please enter a Description", Toast.LENGTH_SHORT).show();
      }

      getFragmentManager().beginTransaction().replace(R.id.fragment_container, new EventFragment())
          .commit();

    });
  }

  private void grabFields() {
    double income;
    double expenses;
    income = incomeField.getText().toString().equals("") ? 0
        : Double.valueOf(incomeField.getText().toString());
    expenses = expensesField.getText().toString().equals("") ? 0
        : Double.valueOf(expensesField.getText().toString());
    event.setIncome(income);
    event.setExpenses(expenses);
    event.setDescription(descriptionField.getText().toString());
    event.setEndDate(endDate);
    event.setStartDate(startDate);
      generateIds();
    }


  private void setButton(Button button, DateTimePickerFragment picker, Date date) {
    button.setOnClickListener(v -> {
      picker.show(getFragmentManager(), picker.getClass().getSimpleName());
      picker.setListener((cal) -> {

                if (button.getTag().equals("Start date")) {
                    startDate = cal.getTime();
                } else {
                    endDate = (cal.getTime());
                }

        String dateFormat = button.getTag().toString() + ": " +
            DayOfWeekHelper.getDayOfWeekFromCalendarDayOfWeek(cal.get(Calendar.DAY_OF_WEEK))
            + " " + cal.get(Calendar.DAY_OF_MONTH) + "/" + (
            cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.YEAR);
        button.setText(dateFormat);
      });
    });
  }


  private static class InsertEvent extends AsyncTask<EventEntity, Void, Void> {

    private WeakReference<MainActivity> mainActivity;
    private ProjectEntity projectEntity;

    /**
     * Instantiates a new Insert event.
     *
     * @param mainActivity the main activity
     * @param projectEntity the project entity
     */
    public InsertEvent(MainActivity mainActivity, ProjectEntity projectEntity) {
      this.mainActivity = new WeakReference<>(mainActivity);
      this.projectEntity = projectEntity;
    }

    @Override
    protected Void doInBackground(EventEntity... eventEntity) {
      if (projectEntity.getEvents() == null) {
        projectEntity.setEvents(new ArrayList<>());
      }
      projectEntity.getEvents().add(eventEntity[0]);
      MobilePunchDatabase.getInstance(mainActivity.get()).getEventDao().insert(eventEntity[0]);
      FrontendApplication.getMasterProjectSet().remove(projectEntity);
      FrontendApplication.getMasterProjectSet().add(projectEntity);
      String token = mainActivity.get().getString(
          R.string.oauth2_header, FrontendApplication.getInstance().getAccount().getIdToken());
      List<ProjectEntity> project = new ArrayList<>();
      project.add(projectEntity);
      MainActivity.getInstance().getService().putProjects(token, project);
      return null;
    }
  }

}





