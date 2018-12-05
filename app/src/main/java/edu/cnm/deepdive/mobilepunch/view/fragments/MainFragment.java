package edu.cnm.deepdive.mobilepunch.view.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import edu.cnm.deepdive.mobilepunch.R;
import edu.cnm.deepdive.mobilepunch.model.db.MobilePunchDatabase;
import edu.cnm.deepdive.mobilepunch.model.entities.ProjectEntity;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

private CardView event, project, client, equipment;
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
    event = view.findViewById(R.id.event_card);
    event.setTag("event");
    project = view.findViewById(R.id.project_card);
    project.setTag("project");
    client = view.findViewById(R.id.client_card);
    client.setTag("client");
    equipment = view.findViewById(R.id.equipment_card);
    equipment.setTag("equipment");
    setListener(event,recyclerFragment);
    setListener(project,recyclerFragment);
    setListener(client,recyclerFragment);
    setListener(equipment,recyclerFragment);
    return view;

  }

  private void setListener(CardView cardView, Fragment fragment){
    cardView.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        bundle.putString("fragment", cardView.getTag().toString());
        recyclerFragment.setArguments(bundle);
        switchFragment(fragment,true,"");
      }
    });
  }

  public void switchFragment(Fragment fragment, boolean useStack, String variant) {

    FragmentManager manager = getFragmentManager();
    String tag = fragment.getClass().getSimpleName() + ((variant != null) ? variant : "");
    if (manager.findFragmentByTag(tag) != null) {
      manager.popBackStackImmediate(tag, FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }
    FragmentTransaction transaction = manager.beginTransaction();
    transaction.replace(R.id.fragment_container, fragment, tag);
    if (useStack) {
      transaction.addToBackStack(tag);
    }
    transaction.commit();
  }

  //TODO REMOVE FROM CODE{
private class InsertProject extends AsyncTask<ProjectEntity, Void, Void>{

    @Override
    protected Void doInBackground(ProjectEntity... projectEntity) {
      MobilePunchDatabase.getInstance(getContext()).getProjectDao().insert(projectEntity[0]);
      return null;
    }
  }
}
