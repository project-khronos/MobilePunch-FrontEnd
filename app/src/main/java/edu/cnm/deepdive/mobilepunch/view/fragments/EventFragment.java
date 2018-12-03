package edu.cnm.deepdive.mobilepunch.view.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.maps.MapView;
import edu.cnm.deepdive.mobilepunch.R;
import edu.cnm.deepdive.mobilepunch.controller.DateTimePickerFragment;
import edu.cnm.deepdive.mobilepunch.controller.DateTimePickerFragment.Mode;
import edu.cnm.deepdive.mobilepunch.controller.DateTimePickerFragment.OnChangeListener;
import edu.cnm.deepdive.mobilepunch.model.db.MobilePunchDatabase;
import edu.cnm.deepdive.mobilepunch.model.entities.EventEntity;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class EventFragment extends Fragment {

  private EventEntity event;
  private EditText expensesField;
  private EditText descriptionField;
  private EditText incomeField;
  private MapView mapview;
  private View view;

  private Button eventStartDateButton;
  private Button eventExpectedDateButton;
  private Button eventEndDateButton;
  private Button saveButton;

  private Date startDate = new Date();
  private Date expectedDate = new Date();
  private Date endDate = new Date();


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
    initLayout();
    initListeners();
    return view;
  }

  private void initLayout() {
    mapview = view.findViewById(R.id.event_map);

    expensesField = view.findViewById(R.id.event_expenses);
    descriptionField = view.findViewById(R.id.event_description);
    incomeField = view.findViewById(R.id.event_income);

    eventStartDateButton = view.findViewById(R.id.event_start_date);
    eventEndDateButton = view.findViewById(R.id.event_end_date);

    saveButton = view.findViewById(R.id.event_save);
  }

  private void initListeners() {
    DateTimePickerFragment picker = new DateTimePickerFragment();
    picker.setMode(Mode.DATE);

    setButton(eventStartDateButton, picker, startDate);
    setButton(eventEndDateButton, picker, endDate);

    saveButton.setOnClickListener(v -> {
      Toast.makeText(getContext(), startDate.toString(), Toast.LENGTH_SHORT).show();
    });
  }


  private void setButton(Button button, DateTimePickerFragment picker, Date date) {
    button.setOnClickListener(v -> {
      picker.show(getFragmentManager(), picker.getClass().getSimpleName());
      picker.setListener((cal) -> {
        date.setTime(cal.getTimeInMillis());
        new SimpleDateFormat("EE").format(cal);
        button.setText("Start Date: " + cal.get(Calendar.DAY_OF_WEEK));


      });
    });
  }

  private class InsertEvent extends AsyncTask<EventEntity, Void, Void> {

    @Override
    protected Void doInBackground(EventEntity... eventEntity) {
      MobilePunchDatabase.getInstance(getContext()).getEventDao().insert(eventEntity[0]);
      return null;
    }
  }

  private class DatePickerListener implements OnChangeListener {
    private Date date;

    public DatePickerListener(Date date) {
      this.date = date;
    }

    @Override
    public void onChange(Calendar calendar) {
     date.setTime(calendar.getTimeInMillis());
    }
  }
}
