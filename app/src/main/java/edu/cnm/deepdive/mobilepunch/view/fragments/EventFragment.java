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
import edu.cnm.deepdive.mobilepunch.model.entities.EquipmentEntity;
import edu.cnm.deepdive.mobilepunch.model.entities.EventEntity;

public class EventFragment extends Fragment {

  private EventEntity mEvent;
  private EditText mExpensesField;
  private EditText mLocationField;
  private EditText mIncomeField;
  private Button eventDateButton;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    mEvent = new EventEntity();

  }
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_event, container, false);
      mExpensesField = (EditText) view.findViewById(R.id.expenses);
      mExpensesField.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
          mEvent.setExpenses(s.toString());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
      });
      mLocationField = (EditText) view.findViewById(R.id.location);
      mLocationField.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
          mEvent.setLocation(s.toString());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
      });
      mIncomeField = (EditText) view.findViewById(R.id.income);
      mIncomeField.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
          mEvent.setIncome(s.toString());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
      });

      eventDateButton = (Button) view.findViewById(R.id.event_date);
      eventDateButton.setText(mEvent.getEventDate().toString());
      eventDateButton.setEnabled(false);

      return view;
    }

  }
