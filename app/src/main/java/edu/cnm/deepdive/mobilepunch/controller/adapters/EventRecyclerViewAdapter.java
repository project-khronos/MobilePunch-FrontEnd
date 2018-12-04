package edu.cnm.deepdive.mobilepunch.controller.adapters;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import edu.cnm.deepdive.mobilepunch.R;
import edu.cnm.deepdive.mobilepunch.model.entities.EventEntity;
import java.util.List;

public class EventRecyclerViewAdapter extends RecyclerView.Adapter<EventRecyclerViewAdapter.EventHolder> {
private List<EventEntity> data;
private LayoutInflater layoutInflater;
private ItemClickListener itemClickListener;


  public EventRecyclerViewAdapter(Context context, List<EventEntity> data) {
    this.layoutInflater = LayoutInflater.from(context);
    this.data = data;
  }


  @NonNull
  @Override
  public EventHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
    return null;
  }

  @Override
  public void onBindViewHolder(@NonNull EventHolder eventHolder, int position) {
    eventHolder.startDate.setText(data.get(position).getStartDate().toString());
    eventHolder.endDate.setText(data.get(position).getEndDate().toString());
    eventHolder.expenses.setText(data.get(position).getExpenses());
    eventHolder.income.setText(data.get(position).getIncome());
    eventHolder.description.setText(data.get(position).getDescription());
    eventHolder.latitude.setText(String.valueOf(data.get(position).getLatidtude()));
    eventHolder.longitude.setText(String.valueOf(data.get(position).getLongitude()));
  }



  @Override
  public int getItemCount() {
    return data.size();
  }

  public class EventHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView startDate;
    private TextView endDate;
    private TextView expenses;
    private TextView income;
    private TextView description;
    private TextView latitude;
    private TextView longitude;

    public EventHolder(@NonNull View itemView) {
      super(itemView);
      startDate = itemView.findViewById(R.id.li_event_start_date);
      endDate = itemView.findViewById(R.id.li_event_end_date);
      expenses = itemView.findViewById(R.id.li_event_expenses);
      income = itemView.findViewById(R.id.li_event_income);
      description = itemView.findViewById(R.id.li_event_description);
      latitude = itemView.findViewById(R.id.li_event_latitude);
      longitude = itemView.findViewById(R.id.li_event_longitude);
      itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
      if(itemClickListener != null) itemClickListener.onItemClick(view, getAdapterPosition());
    }
  }
  void setItemClickListener(ItemClickListener itemClickListener) {
    this.itemClickListener = itemClickListener;
  }
  public interface ItemClickListener {
    void onItemClick(View view, int position);
  }
}
