package edu.cnm.deepdive.mobilepunch.view.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import edu.cnm.deepdive.mobilepunch.FragmentSwitcherActivity;
import edu.cnm.deepdive.mobilepunch.R;
import edu.cnm.deepdive.mobilepunch.model.db.MobilePunchDatabase;
import edu.cnm.deepdive.mobilepunch.model.entities.ClientEntity;
import edu.cnm.deepdive.mobilepunch.model.entities.EquipmentEntity;
import edu.cnm.deepdive.mobilepunch.model.entities.EventEntity;
import edu.cnm.deepdive.mobilepunch.model.entities.ProjectEntity;
import java.util.List;

public class MainFragment extends Fragment {

private TextView tEvent,
    tProject,
    tClient,
    tEquipment;

private CardView event,
    project,
    client,
    equipment;

private RecyclerFragment recyclerFragment = new RecyclerFragment();

private Bundle bundle = new Bundle();

  public MainFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_main, container, false);
    initViews(view);
    setListeners();
    getNumItems();
    return view;

  }

  private void getNumItems(){
    new NumItemsEvent().execute();
    new NumItemsProject().execute();
    new NumItemsClient().execute();
    new NumItemsEquipment().execute();
  }

  private void setListeners(){
    setListener(event,recyclerFragment);
    setListener(project,recyclerFragment);
    setListener(client,recyclerFragment);
    setListener(equipment,recyclerFragment);
  }

  private void initViews(View view){
    tEvent = view.findViewById(R.id.event_num_items);
    event = view.findViewById(R.id.event_card);
    event.setTag("event");
    tProject = view.findViewById(R.id.project_num_items);
    project = view.findViewById(R.id.project_card);
    project.setTag("project");
    tClient = view.findViewById(R.id.client_num_items);
    client = view.findViewById(R.id.client_card);
    client.setTag("client");
    tEquipment = view.findViewById(R.id.equipment_num_items);
    equipment = view.findViewById(R.id.equipment_card);
    equipment.setTag("equipment");
  }

  private void setListener(CardView cardView, Fragment fragment){
    cardView.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        bundle.putString("fragment", cardView.getTag().toString());
        recyclerFragment.setArguments(bundle);
        FragmentSwitcherActivity.setManager(getFragmentManager());
        FragmentSwitcherActivity.switchFragment(fragment,true,null);
      }
    });
  }

  private class NumItemsEvent extends AsyncTask<Void,Void, List<EventEntity>>{

    @Override
    protected void onPostExecute(List<EventEntity> eventEntities) {
      tEvent.setText("Number of events: " + eventEntities.size());
    }

    @Override
    protected List<EventEntity> doInBackground(Void... voids) {
      return MobilePunchDatabase.getInstance(getContext()).getEventDao().select();
    }
  }

  private class NumItemsProject extends AsyncTask<Void,Void, List<ProjectEntity>>{

    @Override
    protected void onPostExecute(List<ProjectEntity> projectEntities) {
      tProject.setText("Number of projects: " + projectEntities.size());
    }

    @Override
    protected List<ProjectEntity> doInBackground(Void... voids) {
      return MobilePunchDatabase.getInstance(getContext()).getProjectDao().select();
    }
  }

  private class NumItemsClient extends AsyncTask<Void,Void, List<ClientEntity>>{

    @Override
    protected void onPostExecute(List<ClientEntity> eventEntities) {
      tClient.setText("Number of clients: " + eventEntities.size());
    }

    @Override
    protected List<ClientEntity> doInBackground(Void... voids) {
      return MobilePunchDatabase.getInstance(getContext()).getClientDao().select();
    }
  }

  private class NumItemsEquipment extends AsyncTask<Void,Void, List<EquipmentEntity>>{

    @Override
    protected void onPostExecute(List<EquipmentEntity> equipmentEntities) {
      tEquipment.setText("Number of equipment: " + equipmentEntities.size());
    }

    @Override
    protected List<EquipmentEntity> doInBackground(Void... voids) {
      return MobilePunchDatabase.getInstance(getContext()).getEquipmentDao().select();
    }
  }
}
