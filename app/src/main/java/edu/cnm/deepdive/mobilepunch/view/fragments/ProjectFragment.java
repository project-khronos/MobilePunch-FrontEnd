package edu.cnm.deepdive.mobilepunch.view.fragments;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import edu.cnm.deepdive.mobilepunch.R;
import edu.cnm.deepdive.mobilepunch.controller.DateTimePickerFragment;
import edu.cnm.deepdive.mobilepunch.controller.DateTimePickerFragment.Mode;
import edu.cnm.deepdive.mobilepunch.controller.FrontendApplication;
import edu.cnm.deepdive.mobilepunch.controller.MainActivity;
import edu.cnm.deepdive.mobilepunch.model.db.MobilePunchDatabase;
import edu.cnm.deepdive.mobilepunch.model.entities.ProjectEntity;
import edu.cnm.deepdive.mobilepunch.model.entities.abstraction.UuidSetter;
import edu.cnm.deepdive.mobilepunch.view.custom_widgets.BasicEditText;
import edu.cnm.deepdive.mobilepunch.view.fragments.helpers.DayOfWeekHelper;
import java.lang.ref.WeakReference;
import java.util.Calendar;
import java.util.Date;


/**
 * The type Project fragment.
 */
public class ProjectFragment extends Fragment {

  private String TAG = "tag";

  private ProjectEntity project;

  private Button saveButton,
      startDateButton,
      endDateButton,
      expectedEndDate;

  private View view;
  private BasicEditText projectName,
      description;

  private Date startDate = new Date(),
      endDate = new Date();

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    project = new ProjectEntity();

  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    view = inflater.inflate(R.layout.fragment_project, container, false);
    generateIds();
    initLayout();
    initListeners();
    return view;
  }

  private void generateIds() {
    UuidSetter.setNewRandomUuid(project);
  }

  private void initLayout() {
    saveButton = view.findViewById(R.id.project_save);

    projectName = view.findViewById(R.id.project_name);
    description = view.findViewById(R.id.project_description);

    startDateButton = view.findViewById(R.id.project_start_date);
    startDateButton.setTag("Start date");
    endDateButton = view.findViewById(R.id.project_end_date);
    endDateButton.setTag("End date");
    expectedEndDate = view.findViewById(R.id.project_expected_date);
    expectedEndDate.setTag("Expected end date");
  }

  private void initListeners() {
    DateTimePickerFragment picker = new DateTimePickerFragment();
    picker.setMode(Mode.DATE);

    setButton(startDateButton, picker, startDate);
    setButton(endDateButton, picker, endDate);
    setButton(expectedEndDate,picker,null);

    saveButton.setOnClickListener(
        v -> {
          grabFields();
          if (!projectName.getText().toString().equals("")) {
            FrontendApplication.getMasterProjectSet().add(project);
            new InsertProject(MainActivity.getInstance()).execute(project);
            Toast.makeText(getContext(), "Project saved", Toast.LENGTH_SHORT).show();
            getFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new ProjectFragment()).commit();
          } else {
            Toast.makeText(getContext(), "Please enter a project Name", Toast.LENGTH_SHORT).show();
          }
        });
  }

  private void grabFields() {
    project.setName(projectName.getText().toString());
    project.setDescription(description.getText().toString());

  }

  private void setButton(Button button, DateTimePickerFragment picker, Date date) {
    button.setOnClickListener(v -> {
      picker.show(getFragmentManager(), picker.getClass().getSimpleName());
      picker.setListener((cal) -> {

        if (button.getTag().equals("Start date")) {
          project.setStartTime(cal.getTime());
        } else if (button.getTag().equals("End date")) {
          project.setEndTime(cal.getTime());
        } else {
          project.setExpectedEndTime(cal.getTime());
        }
          String day = DayOfWeekHelper
              .getDayOfWeekFromCalendarDayOfWeek(cal.get(Calendar.DAY_OF_WEEK));
          button.setText(
              button.getTag().toString() + ": " + day + " " + cal.get(Calendar.DAY_OF_MONTH) + "/"
                  + (
                  cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.YEAR));
      });
    });
  }
    private static class InsertProject extends AsyncTask<ProjectEntity, Void, Void> {

      private WeakReference<MainActivity> mainActivity;

      /**
       * Instantiates a new Insert project.
       *
       * @param mainActivity the main activity
       */
      public InsertProject(MainActivity mainActivity) {
        this.mainActivity = new WeakReference<>(mainActivity);
      }

      @Override
      protected Void doInBackground(ProjectEntity... projectEntities) {

        MobilePunchDatabase.getInstance(mainActivity.get()).getProjectDao()
            .insert(projectEntities[0]);
        return null;
      }
    }

  }