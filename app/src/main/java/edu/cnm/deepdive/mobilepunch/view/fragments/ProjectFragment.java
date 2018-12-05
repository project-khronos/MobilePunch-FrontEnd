package edu.cnm.deepdive.mobilepunch.view.fragments;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import edu.cnm.deepdive.mobilepunch.R;
import edu.cnm.deepdive.mobilepunch.model.db.MobilePunchDatabase;
import edu.cnm.deepdive.mobilepunch.model.entities.ProjectEntity;
import java.util.Date;


public class ProjectFragment extends Fragment {
  private ProjectEntity project;

  private EditText descriptionField, nameField;


  private Button startDateButton, endDateButton,
      expectedEndDateButton, saveButton;

  private View view;

  private Date startDate = new Date(), endDate = new Date();

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

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
