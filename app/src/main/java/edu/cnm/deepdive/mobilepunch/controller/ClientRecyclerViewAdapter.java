package edu.cnm.deepdive.mobilepunch.controller;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import edu.cnm.deepdive.mobilepunch.R;
import edu.cnm.deepdive.mobilepunch.controller.EventRecyclerViewAdapter.ItemClickListener;
import java.util.List;

public class ClientRecyclerViewAdapter extends
    RecyclerView.Adapter<ClientRecyclerViewAdapter.ClientHolder> {

  private List<String> data;
  private LayoutInflater layoutInflater;
  private ItemClickListener itemClickListener;

  public ClientRecyclerViewAdapter(Context context, List<String> data) {
    this.layoutInflater = LayoutInflater.from(context);
    this.data = data;
  }


  @NonNull
  @Override
  public ClientHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
    return null;
  }

  @Override
  public void onBindViewHolder(@NonNull ClientHolder clientHolder, int position) {
    clientHolder.name.setText(data.get(position));
    clientHolder.phone.setText(data.get(position));
    clientHolder.altPhone.setText(data.get(position));
    clientHolder.email.setText(data.get(position));
    clientHolder.billingAddress.setText(data.get(position));
    clientHolder.mailingAddress.setText(data.get(position));
    clientHolder.notes.setText(data.get(position));

  }

  @Override
  public int getItemCount() {
    return data.size();
  }

  public class ClientHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView name;
    private TextView phone;
    private TextView altPhone;
    private TextView email;
    private TextView billingAddress;
    private TextView mailingAddress;
    private TextView notes;


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

