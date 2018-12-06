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

import java.util.UUID;

import edu.cnm.deepdive.mobilepunch.R;
import edu.cnm.deepdive.mobilepunch.model.db.MobilePunchDatabase;
import edu.cnm.deepdive.mobilepunch.model.entities.EquipmentEntity;
import edu.cnm.deepdive.mobilepunch.model.entities.EventEntity;


/**
 * The type Equipment fragment.
 */
public class EquipmentFragment extends Fragment {

    private EquipmentEntity equipment;

    private EditText makeField, modelField, yearField, identificationField;

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
        equipment.setId1(UUID.randomUUID().getMostSignificantBits());
        equipment.setId2(UUID.randomUUID().getLeastSignificantBits());
    }

    private void initLayout() {
        makeField = view.findViewById(R.id.equipment_make);
        modelField = view.findViewById(R.id.equipment_model);
        yearField = view.findViewById(R.id.equipment_year);
        identificationField = view.findViewById(R.id.equipment_identification);
        saveButton = view.findViewById(R.id.equipment_save);

    }

    private void initListeners() {
        saveButton.setOnClickListener(v -> {
            grabFields();
            new InsertEquipment(getContext(), new EventEntity()).execute(equipment);
            getFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new EquipmentFragment())
                    .commit();
        });
    }

    private void grabFields() {
        equipment.setMake(makeField.getText().toString());
        equipment.setModel(modelField.getText().toString());
        equipment.setMfcyear(yearField.getText().toString());
        equipment.setIdentification(identificationField.getText().toString());

    }


    private static class InsertEquipment extends AsyncTask<EquipmentEntity, Void, Void> {

        private Context context;
        private EventEntity eventEntity;


        /**
         * Instantiates a new Insert equipment.
         *
         * @param context     the context
         * @param eventEntity the event entity
         */
        public InsertEquipment(Context context, EventEntity eventEntity) {
            this.context = context;
            this.eventEntity = eventEntity;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Toast.makeText(context, "Equipment saved!", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected Void doInBackground(EquipmentEntity... equipmentEntity) {
            MobilePunchDatabase.getInstance(context).getEquipmentDao().insert(equipmentEntity[0]);
            return null;
        }
    }
}




