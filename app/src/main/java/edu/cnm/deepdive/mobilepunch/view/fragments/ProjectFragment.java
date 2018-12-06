package edu.cnm.deepdive.mobilepunch.view.fragments;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import edu.cnm.deepdive.mobilepunch.R;
import edu.cnm.deepdive.mobilepunch.model.db.MobilePunchDatabase;
import edu.cnm.deepdive.mobilepunch.model.entities.ProjectEntity;
import edu.cnm.deepdive.mobilepunch.model.entities.abstraction.UuidSetter;


/**
 * The type Project fragment.
 */
public class ProjectFragment extends Fragment {

  /**
   * The Project.
   */
  ProjectEntity project;
  /**
   * The Save button.
   */
  Button saveButton;

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    project = new ProjectEntity();

  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_project, container, false);
    generateIds();

    return view;
  }

  private void generateIds() {
    UuidSetter.setNewRandomUuid(project);
  }

  private class InsertProject extends AsyncTask<ProjectEntity, Void, Void> {

    @Override
    protected Void doInBackground(ProjectEntity... projectEntities) {
      ProjectEntity projectEntity = new ProjectEntity();

      MobilePunchDatabase.getInstance(getContext()).getProjectDao().insert(projectEntity);
      return null;
    }
  }

}
