package edu.cnm.deepdive.mobilepunch.view.fragments;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.cnm.deepdive.mobilepunch.R;
import edu.cnm.deepdive.mobilepunch.model.db.MobilePunchDatabase;
import edu.cnm.deepdive.mobilepunch.model.entities.ProjectEntity;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

public static ProjectEntity projectEntity = new ProjectEntity();

  public MainFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_main, container, false);
    MainFragment.projectEntity.setId1(1010);
    MainFragment.projectEntity.setId2(1010);
    new InsertProject().execute(projectEntity);
    return view;

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
