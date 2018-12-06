package edu.cnm.deepdive.mobilepunch.view.fragments;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.MapView;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import edu.cnm.deepdive.mobilepunch.R;
import edu.cnm.deepdive.mobilepunch.controller.DateTimePickerFragment;
import edu.cnm.deepdive.mobilepunch.controller.DateTimePickerFragment.Mode;
import edu.cnm.deepdive.mobilepunch.model.db.MobilePunchDatabase;
import edu.cnm.deepdive.mobilepunch.model.entities.EventEntity;
import edu.cnm.deepdive.mobilepunch.model.entities.ProjectEntity;

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

    private View view;


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
        event.setId1(UUID.randomUUID().getMostSignificantBits());
        event.setId2(UUID.randomUUID().getLeastSignificantBits());
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

        saveButton = view.findViewById(R.id.event_save);
    }


    private void initListeners() {
        DateTimePickerFragment picker = new DateTimePickerFragment();
        picker.setMode(Mode.DATE);

        setButton(eventStartDateButton, picker, startDate);
        setButton(eventEndDateButton, picker, endDate);

        saveButton.setOnClickListener(v -> {
            grabFields();
            event.setProjectId1(1010);
            event.setProjectId2(1010);
            new InsertEvent(getContext(), null).execute(event);
            getFragmentManager().beginTransaction().replace(R.id.fragment_container, new EventFragment()).commit();
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

                String day = "UNKNOWN";
                switch (cal.get(Calendar.DAY_OF_WEEK)) {
                    case 2:
                        day = "Monday";
                        break;
                    case 3:
                        day = "Tuesday";
                        break;
                    case 4:
                        day = "Wednesday";
                        break;
                    case 5:
                        day = "Thursday";
                        break;
                    case 6:
                        day = "Friday";
                        break;
                    case 7:
                        day = "Saturday";
                        break;
                    case 8:
                        day = "Sunday";
                        break;
                }

                button.setText(button.getTag().toString() + ": " + day + " " + cal.get(Calendar.DAY_OF_MONTH) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.YEAR));

            });
        });
    }

    private static class InsertEvent extends AsyncTask<EventEntity, Void, Void> {

        private Context context;
        private ProjectEntity projectEntity;

        /**
         * Instantiates a new Insert event.
         *
         * @param context       the context
         * @param projectEntity the project entity
         */
        public InsertEvent(Context context, ProjectEntity projectEntity) {
            this.context = context;
            this.projectEntity = projectEntity;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Toast.makeText(context, "Event saved!", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected Void doInBackground(EventEntity... eventEntity) {
            MobilePunchDatabase.getInstance(context).getEventDao().insert(eventEntity[0]);
            return null;
        }

    }

}
