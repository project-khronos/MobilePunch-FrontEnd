package edu.cnm.deepdive.mobilepunch.view.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import com.google.android.gms.maps.MapView;
import edu.cnm.deepdive.mobilepunch.R;
import edu.cnm.deepdive.mobilepunch.controller.DateTimePickerFragment;
import edu.cnm.deepdive.mobilepunch.controller.DateTimePickerFragment.Mode;
import edu.cnm.deepdive.mobilepunch.controller.MainActivity;
import edu.cnm.deepdive.mobilepunch.model.db.MobilePunchDatabase;
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
 * The type Event fragment.
 */
public class EventFragment extends Fragment {

  private EventEntity event;

  private EditText expensesField,
      descriptionField,
      incomeField;

  private Button eventStartDateButton,
      eventEndDateButton,
      saveButton;

  private MapView mapview;
  private Spinner projectSpinner;
  private Spinner equipmentSpinner;

  private View view;

  private ProjectEntity pickedProject;

  private Date startDate = new Date(), endDate = new Date();


  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    event = new EventEntity();
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    view = inflater.inflate(R.layout.fragment_event, container, false);
    generateIds();
    initLayout();
    initListeners();

    return view;
  }

  private void generateIds() {
    UuidSetter.setNewRandomUuid(event);
  }

  private void initLayout() {
    mapview = view.findViewById(R.id.event_map);

    expensesField = view.findViewById(R.id.event_expenses);
    descriptionField = view.findViewById(R.id.event_description);
    incomeField = view.findViewById(R.id.event_income);

    eventStartDateButton = view.findViewById(R.id.event_start_date);
    eventStartDateButton.setTag("Start date");
    eventEndDateButton = view.findViewById(R.id.event_end_date);
    eventEndDateButton.setTag("End date");
    projectSpinner = view.findViewById(R.id.project_spinner);
    ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(getContext(),
        android.R.layout.simple_spinner_item, android.R.id.text1);
    spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    projectSpinner.setAdapter(spinnerAdapter);
    List<String> getProjectNames = new ArrayList<>();
    for (ProjectEntity project : MainActivity.getInstance().getProjects()) {
      getProjectNames.add(project.getName());
    }
    spinnerAdapter.addAll(getProjectNames);
    spinnerAdapter.notifyDataSetChanged();
    projectSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        EventFragment.this.pickedProject = MainActivity.getInstance().getProjects().get(position);
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
      grabFields();

      if (!descriptionField.getText().toString().equals("")) {
        new InsertEvent(MainActivity.getInstance(), pickedProject).execute(event);
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
  }


  private void setButton(Button button, DateTimePickerFragment picker, Date date) {
    button.setOnClickListener(v -> {
      picker.show(getFragmentManager(), picker.getClass().getSimpleName());
      picker.setListener((cal) -> {

        if (button.getTag().equals("Start date")) {
          event.setStartDate(cal.getTime());
        } else {
          event.setEndDate(cal.getTime());
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
      this.projectEntity = projectEntity;
      this.mainActivity = new WeakReference<>(mainActivity);
    }

    @Override
    protected Void doInBackground(EventEntity... eventEntity) {
      eventEntity[0].setProjectId1(projectEntity.getId1());
      eventEntity[0].setProjectId2(projectEntity.getId2());
      if (projectEntity.getEvents() == null) {
        projectEntity.setEvents(new ArrayList<>());
      }
      projectEntity.getEvents().add(eventEntity[0]);
      MobilePunchDatabase.getInstance(mainActivity.get()).getEventDao().insert(eventEntity[0]);
      return null;
    }
  }

}





