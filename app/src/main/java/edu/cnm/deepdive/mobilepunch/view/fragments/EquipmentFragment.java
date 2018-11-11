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


public class EquipmentFragment extends Fragment {

  private EquipmentEntity equipment;
  private EditText makeField;
  private EditText modelField;
  private EditText yearField;
  private Button dateButton;


  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    equipment = new EquipmentEntity();


  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {

    View view = inflater.inflate(R.layout.fragment_equipment, container, false);
    makeField = view.findViewById(R.id.make);
    makeField.addTextChangedListener(new TextWatcher() {
      @Override
      public void beforeTextChanged(CharSequence s, int start, int count, int after) {

      }

      @Override
      public void onTextChanged(CharSequence s, int start, int before, int count) {
        equipment.setMake(s.toString());
      }

      @Override
      public void afterTextChanged(Editable s) {

      }
    });
    modelField = view.findViewById(R.id.model);
    modelField.addTextChangedListener(new TextWatcher() {
      @Override
      public void beforeTextChanged(CharSequence s, int start, int count, int after) {

      }

      @Override
      public void onTextChanged(CharSequence s, int start, int before, int count) {
        equipment.setModel(s.toString());
      }

      @Override
      public void afterTextChanged(Editable s) {

      }
    });
    yearField = view.findViewById(R.id.year);
    yearField.addTextChangedListener(new TextWatcher() {
      @Override
      public void beforeTextChanged(CharSequence s, int start, int count, int after) {

      }

      @Override
      public void onTextChanged(CharSequence s, int start, int before, int count) {
        equipment.setYear(s.toString());
      }

      @Override
      public void afterTextChanged(Editable s) {

      }
    });

    dateButton = view.findViewById(R.id.equipment_date);
    dateButton.setText(equipment.getDate().toString());
    dateButton.setEnabled(false);

    return view;
  }

}
