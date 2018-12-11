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
import edu.cnm.deepdive.mobilepunch.controller.FrontendApplication;
import edu.cnm.deepdive.mobilepunch.controller.MainActivity;
import edu.cnm.deepdive.mobilepunch.model.db.MobilePunchDatabase;
import edu.cnm.deepdive.mobilepunch.model.entities.ClientEntity;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.UUID;


/**
 * The type Client fragment. This class inflates the Client fragment. This is where user can edit text fields and
 * save information applied to database.
 */
public class ClientFragment extends Fragment {

  private ClientEntity client;

  private EditText nameField, phoneField, altNumberField, emailField,
      addressField, altAddressField, notesField;

  private Button saveButton;

  private View view;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    client = new ClientEntity();
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    view = inflater.inflate(R.layout.fragment_client, container, false);
    generateIds();
    initLayout();
    initListeners();
    return view;
  }

  private void generateIds() {
    client.setId1(UUID.randomUUID().getMostSignificantBits());
    client.setId2(UUID.randomUUID().getLeastSignificantBits());
  }

  private void initLayout() {
    nameField = view.findViewById(R.id.client_name);
    phoneField = view.findViewById(R.id.client_number);
    altNumberField = view.findViewById(R.id.client_alternate_num);
    emailField = view.findViewById(R.id.client_email);
    addressField = view.findViewById(R.id.client_address);
    altAddressField = view.findViewById(R.id.client_alt_address);
    notesField = view.findViewById(R.id.client_note);

    saveButton = view.findViewById(R.id.client_save);
  }

  private void initListeners() {
    saveButton.setOnClickListener(v -> {
      grabFields();
      if (!nameField.getText().toString().equals("")) {
        new InsertClient(MainActivity.getInstance()).execute(client);
        Toast.makeText(getContext(), "Client saved", Toast.LENGTH_SHORT).show();
        getFragmentManager().beginTransaction()
            .replace(R.id.fragment_container, new ClientFragment()).commit();
      } else {
        Toast.makeText(getContext(), "Please enter a client Name", Toast.LENGTH_SHORT).show();
      }
    });
  }

  private void grabFields() {
    client.setName(nameField.getText().toString());
    client.setPhone(phoneField.getText().toString());
    client.setAltPhone(altNumberField.getText().toString());
    client.setEmail(emailField.getText().toString());
    client.setAddress(addressField.getText().toString());
    client.setAltAddress(altAddressField.getText().toString());
    client.setNotes(notesField.getText().toString());

  }

  private static class InsertClient extends AsyncTask<ClientEntity, Void, Void> {

    private WeakReference<MainActivity> mainActivity;

    /**
     * Instantiates a new Insert client.
     *
     * @param mainActivity the main activity
     */
    public InsertClient(MainActivity mainActivity) {
      this.mainActivity = new WeakReference<>(mainActivity);
    }


    @Override
    protected Void doInBackground(ClientEntity... clientEntities) {
      MobilePunchDatabase.getInstance(mainActivity.get()).getClientDao()
          .insert(clientEntities[0]);
      String token = mainActivity.get().getString(
          R.string.oauth2_header, FrontendApplication.getInstance().getAccount().getIdToken());
      mainActivity.get().getService().putClients(token, Arrays.asList(clientEntities));

      FrontendApplication.getMasterClientSet().add(clientEntities[0]);
      return null;
    }
  }

}
