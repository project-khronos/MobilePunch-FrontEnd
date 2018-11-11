package edu.cnm.deepdive.mobilepunch.view.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import edu.cnm.deepdive.mobilepunch.R;
import edu.cnm.deepdive.mobilepunch.model.entities.EventEntity;

public class EventFragment extends Fragment {

  private EventEntity event;
  private EditText expensesField;
  private EditText locationField;
  private EditText incomeField;
  private Button eventDateButton;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    event = new EventEntity();

  }
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_event, container, false);
    expensesField = view.findViewById(R.id.expenses);
    expensesField.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
          event.setExpenses(s.toString());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
      });
    locationField = view.findViewById(R.id.location);
    locationField.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
          event.setLocation(s.toString());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
      });
    incomeField = view.findViewById(R.id.income);
    incomeField.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
          event.setIncome(s.toString());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
      });

    eventDateButton = view.findViewById(R.id.event_date);
    eventDateButton.setText(event.getEventDate().toString());
      eventDateButton.setEnabled(false);

      return view;
    }

  }
