package edu.cnm.deepdive.mobilepunch.controller.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import edu.cnm.deepdive.mobilepunch.R;
import edu.cnm.deepdive.mobilepunch.model.entities.EquipmentEntity;
import java.util.List;

/**
 * The type Equipment recycler view adapter.
 */
public class EquipmentRecyclerViewAdapter extends
    RecyclerView.Adapter<EquipmentRecyclerViewAdapter.EquipmentHolder> {

  private List<EquipmentEntity> data;
  private LayoutInflater layoutinflater;
  private ItemClickListener itemClickListener;

  /**
   * Instantiates a new Equipment recycler view adapter.
   *
   * @param context the context
   * @param data the data
   */
  public EquipmentRecyclerViewAdapter(Context context, List<EquipmentEntity> data) {
    this.layoutinflater = LayoutInflater.from(context);
    this.data = data;
  }

  @NonNull
  @Override
  public EquipmentHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
    return null;
  }

  @Override
  public void onBindViewHolder(@NonNull EquipmentHolder equipmentHolder, int position) {
    equipmentHolder.name.setText(data.get(position).getName());
    equipmentHolder.identification.setText(data.get(position).getIdentification());
    equipmentHolder.make.setText(data.get(position).getMake());
    equipmentHolder.model.setText(data.get(position).getModel());
    equipmentHolder.year.setText(data.get(position).getMfcyear());
    equipmentHolder.description.setText(data.get(position).getDescription());

  }


  @Override
  public int getItemCount() {
    return data.size();
  }

  /**
   * Sets item click listener.
   *
   * @param itemClickListener the item click listener
   */
  void setItemClickListener(ItemClickListener itemClickListener) {
    this.itemClickListener = itemClickListener;

  }


  /**
   * The interface Item click listener.
   */
  public interface ItemClickListener {

    /**
     * On item click.
     *
     * @param view the view
     * @param position the position
     */
    void onItemClick(View view, int position);

  }

  /**
   * The type Equipment holder.
   */
  public class EquipmentHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView name;
    private TextView identification;
    private TextView make;
    private TextView model;
    private TextView year;
    private TextView description;

    /**
     * Instantiates a new Equipment holder.
     *
     * @param itemView the item view
     */
    public EquipmentHolder(@NonNull View itemView) {
      super(itemView);
      name = itemView.findViewById(R.id.li_equipment_name);
      identification = itemView.findViewById(R.id.li_equipment_id);
      make = itemView.findViewById(R.id.li_equipment_make);
      model = itemView.findViewById(R.id.li_equipment_model);
      year = itemView.findViewById(R.id.li_equipment_year);
      description = itemView.findViewById(R.id.li_equipment_description);
    }

    @Override
    public void onClick(View view) {

    }

  }
}
