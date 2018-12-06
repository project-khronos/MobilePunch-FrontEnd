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

/**
 * The type Project recycler view adapter.
 */
public class ProjectRecyclerViewAdapter extends
    RecyclerView.Adapter<ProjectRecyclerViewAdapter.ProjectHolder> {

  private List<ProjectEntity> data;
  private LayoutInflater layoutInflater;
  private ItemClickListener itemClickListener;
  private Context context;

  /**
   * Instantiates a new Project recycler view adapter.
   *
   * @param context the context
   * @param data the data
   */
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
    projectHolder.name.setText(data.get(position).getName());
    projectHolder.description.setText(data.get(position).getDescription());
    projectHolder.startDate.setText(data.get(position).getStartTime().toString());
    projectHolder.endDate.setText(data.get(position).getEndTime().toString());
    projectHolder.expectedEndDate.setText(data.get(position).getExpectedEndTime().toString());
  }


  @Override
  public int getItemCount() {
    return data.size();
  }


  /**
   * The type Project holder.
   */
  public class ProjectHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView name;
    private TextView startDate;
    private TextView endDate;
    private TextView expectedEndDate;
    private TextView description;


    /**
     * Instantiates a new Project holder.
     *
     * @param itemView the item view
     */
    public ProjectHolder(@NonNull View itemView) {
      super(itemView);
      name = itemView.findViewById(R.id.li_project_name);
      startDate = itemView.findViewById(R.id.li_project_start_date);
      endDate = itemView.findViewById(R.id.li_project_end_date);
      expectedEndDate = itemView.findViewById(R.id.li_project_expected);
      description = itemView.findViewById(R.id.li_project_description);
    }

    @Override
    public void onClick(View v) {

    }
  }
}
