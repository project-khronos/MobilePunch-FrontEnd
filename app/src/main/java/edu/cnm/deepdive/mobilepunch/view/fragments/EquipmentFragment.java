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

  private EquipmentEntity mEquipment;
  private EditText mMakeField;
  private EditText mModelField;
  private EditText mYearField;
  private Button mDateButton;


  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mEquipment = new EquipmentEntity();


  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {

    View view = inflater.inflate(R.layout.fragment_equipment, container, false);
    mMakeField = (EditText) view.findViewById(R.id.make);
    mMakeField.addTextChangedListener(new TextWatcher() {
      @Override
      public void beforeTextChanged(CharSequence s, int start, int count, int after) {

      }

      @Override
      public void onTextChanged(CharSequence s, int start, int before, int count) {
        mEquipment.setMake(s.toString());
      }

      @Override
      public void afterTextChanged(Editable s) {

      }
    });
    mModelField = (EditText) view.findViewById(R.id.model);
    mModelField.addTextChangedListener(new TextWatcher() {
      @Override
      public void beforeTextChanged(CharSequence s, int start, int count, int after) {

      }

      @Override
      public void onTextChanged(CharSequence s, int start, int before, int count) {
        mEquipment.setModel(s.toString());
      }

      @Override
      public void afterTextChanged(Editable s) {

      }
    });
    mYearField = (EditText) view.findViewById(R.id.year);
    mYearField.addTextChangedListener(new TextWatcher() {
      @Override
      public void beforeTextChanged(CharSequence s, int start, int count, int after) {

      }

      @Override
      public void onTextChanged(CharSequence s, int start, int before, int count) {
        mEquipment.setYear(s.toString());
      }

      @Override
      public void afterTextChanged(Editable s) {

      }
    });

    mDateButton = (Button) view.findViewById(R.id.equipment_date);
    mDateButton.setText(mEquipment.getDate().toString());
    mDateButton.setEnabled(false);

    return view;
  }

}
