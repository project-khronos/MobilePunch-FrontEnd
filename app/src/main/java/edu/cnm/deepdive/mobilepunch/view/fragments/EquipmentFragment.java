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
  private EditText licenseField;
  private EditText serialNumberField;
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
    modelField = view.findViewById(R.id.model);
    yearField = view.findViewById(R.id.year);
    licenseField = view.findViewById(R.id.license);
    serialNumberField = view.findViewById(R.id.serial_number);
    dateButton = view.findViewById(R.id.equipment_date);


    return view;
  }

}
