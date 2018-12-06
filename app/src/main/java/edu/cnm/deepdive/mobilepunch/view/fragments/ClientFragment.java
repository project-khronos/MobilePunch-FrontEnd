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
import edu.cnm.deepdive.mobilepunch.R;
import edu.cnm.deepdive.mobilepunch.model.db.MobilePunchDatabase;
import edu.cnm.deepdive.mobilepunch.model.entities.ClientEntity;
import edu.cnm.deepdive.mobilepunch.model.entities.EventEntity;
import java.util.UUID;


/**
 * The type Client fragment.
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
      new InsertClient(getContext(), new EventEntity()).execute(client);
      getFragmentManager().beginTransaction()
          .replace(R.id.fragment_container, new ClientFragment())
          .commit();
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

    private Context context;
    private ClientEntity clientEntity;

    /**
     * Instantiates a new Insert client.
     *
     * @param context the context
     * @param eventEntity the event entity
     */
    public InsertClient(Context context, EventEntity eventEntity) {
      this.context = context;
      this.clientEntity = clientEntity;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
      Toast.makeText(context, "Client saved!", Toast.LENGTH_SHORT).show();
    }


    @Override
    protected Void doInBackground(ClientEntity... clientEntities) {
      MobilePunchDatabase.getInstance(context).getClientDao().insert(clientEntities[0]);
      return null;
    }
  }
}
