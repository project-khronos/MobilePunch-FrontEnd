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


public class ProjectFragment extends Fragment {


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_project, container, false);
    new InsertProject().execute();
    return view;
  }
private class InsertProject extends AsyncTask<ProjectEntity,Void,Void>{

  @Override
  protected Void doInBackground(ProjectEntity... projectEntities) {
    ProjectEntity projectEntity = new ProjectEntity();
    projectEntity.setId1(1010);
    projectEntity.setId2(1010);
    MobilePunchDatabase.getInstance(getContext()).getProjectDao().insert(projectEntity);
    return null;
  }
}

}
