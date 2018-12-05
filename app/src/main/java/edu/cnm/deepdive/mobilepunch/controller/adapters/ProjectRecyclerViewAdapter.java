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
import edu.cnm.deepdive.mobilepunch.model.entities.ProjectEntity;
import java.util.List;

public class ProjectRecyclerViewAdapter extends
    RecyclerView.Adapter<ProjectRecyclerViewAdapter.ProjectHolder> {

  private List<ProjectEntity> data;
  private LayoutInflater layoutInflater;
  private ItemClickListener itemClickListener;
  private Context context;

  public ProjectRecyclerViewAdapter(Context context, List<ProjectEntity> data) {
    this.layoutInflater = LayoutInflater.from(context);
    this.data = data;
    this.context = context;
  }


  @NonNull
  @Override
  public ProjectHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    View view = layoutInflater.inflate(R.layout.project_list_item, viewGroup, false);
    return new ProjectHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull ProjectHolder projectHolder, int position) {

  }


  @Override
  public int getItemCount() {
    return data.size();
  }


  public class ProjectHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView name;
    private TextView startDate;
    private TextView endDate;
    private TextView expectedEndDate;
    private TextView description;


    public ProjectHolder(@NonNull View itemView) {
      super(itemView);
      name = itemView.findViewById(R.id.li_project_name);
      startDate = itemView.findViewById(R.id.li_project_start_date);
      endDate = itemView.findViewById(R.id.li_project_end_date);
      expectedEndDate = itemView.findViewById(R.id.li_project_expected);
      description = itemView.findViewById(R.id.li_event_description);
    }

    @Override
    public void onClick(View v) {

    }
  }
}
