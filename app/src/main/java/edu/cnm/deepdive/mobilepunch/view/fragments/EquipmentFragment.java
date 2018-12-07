package edu.cnm.deepdive.mobilepunch.view.fragments;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import edu.cnm.deepdive.mobilepunch.R;
import edu.cnm.deepdive.mobilepunch.controller.MainActivity;
import edu.cnm.deepdive.mobilepunch.model.db.MobilePunchDatabase;
import edu.cnm.deepdive.mobilepunch.model.entities.EquipmentEntity;
import edu.cnm.deepdive.mobilepunch.model.entities.abstraction.UuidSetter;
import java.lang.ref.WeakReference;


/**
 * The type Equipment fragment.
 */
public class EquipmentFragment extends Fragment {

  private EquipmentEntity equipment;

  private EditText nameField, makeField, modelField, yearField, identificationField;

  private Button saveButton;

  private View view;


  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    equipment = new EquipmentEntity();
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {

    view = inflater.inflate(R.layout.fragment_equipment, container, false);
    generateIds();
    initLayout();
    initListeners();
    return view;
  }

  private void generateIds() {
    UuidSetter.setNewRandomUuid(equipment);
  }

  private void initLayout() {
    nameField = view.findViewById(R.id.equipment_name);
    makeField = view.findViewById(R.id.equipment_make);
    modelField = view.findViewById(R.id.equipment_model);
    yearField = view.findViewById(R.id.equipment_year);
    identificationField = view.findViewById(R.id.equipment_identification);
    saveButton = view.findViewById(R.id.equipment_save);

  }

  private void initListeners() {
    saveButton.setOnClickListener(
        v -> {
          grabFields();
          if (!nameField.getText().toString().equals("")) {
            new InsertEquipment(MainActivity.getInstance()).execute(equipment);
            Toast.makeText(getContext(), "Equipment saved", Toast.LENGTH_SHORT).show();
            getFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new EquipmentFragment()).commit();
          } else {
            Toast.makeText(getContext(), "Please enter equipment name", Toast.LENGTH_SHORT)
                .show();
          }
        });
  }

  private void grabFields() {
    equipment.setName(nameField.getText().toString());
    equipment.setMake(makeField.getText().toString());
    equipment.setModel(modelField.getText().toString());
    equipment.setMfcyear(yearField.getText().toString());
    equipment.setIdentification(identificationField.getText().toString());

  }

  private static class InsertEquipment extends AsyncTask<EquipmentEntity, Void, Void> {

    private WeakReference<MainActivity> mainActivity;

    /**
     * Instantiates a new Insert equipment.
     *
     * @param mainActivity the main activity
     */
    public InsertEquipment(MainActivity mainActivity) {
      this.mainActivity = new WeakReference<>(mainActivity);
    }

    @Override
    protected Void doInBackground(EquipmentEntity... equipmentEntities) {

      MobilePunchDatabase.getInstance(mainActivity.get()).getEquipmentDao()
          .insert(equipmentEntities[0]);
      return null;
    }
  }

}




