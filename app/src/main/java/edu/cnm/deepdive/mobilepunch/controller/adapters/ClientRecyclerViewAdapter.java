package edu.cnm.deepdive.mobilepunch.controller.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import edu.cnm.deepdive.mobilepunch.R;
import edu.cnm.deepdive.mobilepunch.controller.adapters.EventRecyclerViewAdapter.ItemClickListener;
import edu.cnm.deepdive.mobilepunch.model.entities.ClientEntity;
import java.util.List;

/**
 * The type Client recycler view adapter.
 */
public class ClientRecyclerViewAdapter extends
    RecyclerView.Adapter<ClientRecyclerViewAdapter.ClientHolder> {

  private List<ClientEntity> data;
  private LayoutInflater layoutInflater;
  private ItemClickListener itemClickListener;

  /**
   * Instantiates a new Client recycler view adapter.
   *
   * @param context the context
   * @param data the data
   */
  public ClientRecyclerViewAdapter(Context context, List<ClientEntity> data) {
    this.layoutInflater = LayoutInflater.from(context);
    this.data = data;
  }


  @NonNull
  @Override
  public ClientHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
    View view = layoutInflater.inflate(R.layout.client_list_item, viewGroup, false);
    return new ClientHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull ClientHolder clientHolder, int position) {
    clientHolder.name.setText("Client name: " + data.get(position).getName());
    clientHolder.phone.setText("Phone number: " +data.get(position).getPhone());
    clientHolder.altPhone.setText("Alternate number: " +data.get(position).getAltPhone());
    clientHolder.email.setText("Email: " +data.get(position).getEmail());
    clientHolder.billingAddress.setText("Billing address: " +data.get(position).getAddress());
    clientHolder.mailingAddress.setText("Mailing address: " +data.get(position).getAltAddress());
    clientHolder.notes.setText("Notes: " +data.get(position).getNotes());

  }

  @Override
  public int getItemCount() {
    return data.size();
  }

  /**
   * The type Client holder.
   */
  public class ClientHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView name;
    private TextView phone;
    private TextView altPhone;
    private TextView email;
    private TextView billingAddress;
    private TextView mailingAddress;
    private TextView notes;


    /**
     * Instantiates a new Client holder.
     *
     * @param itemView the item view
     */
    public ClientHolder(@NonNull View itemView) {
      super(itemView);
      name = itemView.findViewById(R.id.li_client_name);
      phone = itemView.findViewById(R.id.li_client_phone);
      altPhone = itemView.findViewById(R.id.li_client_phone_alt);
      email = itemView.findViewById(R.id.li_client_email);
      billingAddress = itemView.findViewById(R.id.li_client_billing_address);
      mailingAddress = itemView.findViewById(R.id.li_client_mailing_address);
      notes = itemView.findViewById(R.id.li_client_notes);


    }

    @Override
    public void onClick(View v) {

    }
  }

}

