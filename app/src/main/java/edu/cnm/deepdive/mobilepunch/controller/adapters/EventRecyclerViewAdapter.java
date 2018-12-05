package edu.cnm.deepdive.mobilepunch.controller.adapters;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import android.widget.Toast;
import edu.cnm.deepdive.mobilepunch.R;
import edu.cnm.deepdive.mobilepunch.model.entities.EventEntity;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class EventRecyclerViewAdapter extends RecyclerView.Adapter<EventRecyclerViewAdapter.EventHolder> {
private List<EventEntity> data;
private LayoutInflater layoutInflater;
private ItemClickListener itemClickListener;
private Context context;

  public EventRecyclerViewAdapter(Context context, List<EventEntity> data) {
    this.layoutInflater = LayoutInflater.from(context);
    this.data = data;
    this.context = context;
  }


  @NonNull
  @Override
  public EventHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
    View view = layoutInflater.inflate(R.layout.event_list_item, viewGroup, false);
    return new EventHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull EventHolder eventHolder, int position) {

      eventHolder.startDate.setText("Start date: " + setTimeFormat(data.get(position).getStartDate()));
      eventHolder.endDate.setText("End date: " + setTimeFormat(data.get(position).getEndDate()));
      eventHolder.expenses.setText(String.valueOf(data.get(position).getExpenses()));
      eventHolder.income.setText(String.valueOf(data.get(position).getIncome()));
      eventHolder.description.setText(data.get(position).getDescription());
      eventHolder.latitude.setText(String.valueOf(data.get(position).getLatidtude()));
      eventHolder.longitude.setText(String.valueOf(data.get(position).getLongitude()));


  }

  private String setTimeFormat(Date date) {
    if (date == null) {
      return "DATE NOT SET";
    } else {
      SimpleDateFormat sdf = new SimpleDateFormat("MMMM-dd-yyyy");
      return sdf.format(date);
    }
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
