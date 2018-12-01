package edu.cnm.deepdive.mobilepunch.view.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import edu.cnm.deepdive.mobilepunch.R;
import edu.cnm.deepdive.mobilepunch.controller.DateTimePickerFragment;
import edu.cnm.deepdive.mobilepunch.controller.DateTimePickerFragment.Mode;
import edu.cnm.deepdive.mobilepunch.model.db.MobilePunchDatabase;
import edu.cnm.deepdive.mobilepunch.model.entities.EventEntity;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class EventFragment extends Fragment {

  private EventEntity event;
  private EditText expensesField;
  private EditText locationField;
  private EditText incomeField;
  private MapView mapview;
  private View view;
  private Button eventStartDateButton;
  private Button eventExpectedDateButton;
  private Button eventEndDateButton;
  private Calendar startDate;

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
private  void initLayout(){

  mapview = view.findViewById(R.id.map);
  expensesField = view.findViewById(R.id.expenses);
  locationField = view.findViewById(R.id.location);
  incomeField = view.findViewById(R.id.income);
  eventStartDateButton = view.findViewById(R.id.event_start_date);
  eventExpectedDateButton = view.findViewById(R.id.event_expected_date);
  eventEndDateButton = view.findViewById(R.id.event_end_date);
}
private void initListeners() {
    eventStartDateButton.setOnClickListener(v -> {
     getFragmentManager().beginTransaction().add(R.id.container, new DateTimePickerFragment()).commit();
      Toast.makeText(getContext(), "Clicked", Toast.LENGTH_SHORT).show();

        DateTimePickerFragment picker = new DateTimePickerFragment();
        picker.setMode(Mode.DATE);
        picker.setCalendar(startDate);
        //TODO Add grabber for date
        picker.show(getFragmentManager(), picker.getClass().getSimpleName());

    });

  }

  private class InsertEvent extends AsyncTask<EventEntity, Void, Void> {

    @Override
    protected Void doInBackground(EventEntity... eventEntities) {
      MobilePunchDatabase.getInstance(getContext()).getEventDao().insert(eventEntities[0]);
      return null;
    }
  }

}
