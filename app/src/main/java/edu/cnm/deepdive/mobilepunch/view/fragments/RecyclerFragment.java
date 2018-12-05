package edu.cnm.deepdive.mobilepunch.view.fragments;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import edu.cnm.deepdive.mobilepunch.R;
import edu.cnm.deepdive.mobilepunch.controller.adapters.EventRecyclerViewAdapter;
import edu.cnm.deepdive.mobilepunch.controller.adapters.ProjectRecyclerViewAdapter;
import edu.cnm.deepdive.mobilepunch.model.db.MobilePunchDatabase;
import edu.cnm.deepdive.mobilepunch.model.entities.EventEntity;
import java.util.List;

public class RecyclerFragment extends Fragment {

  private RecyclerView recyclerView;
  private List<EventEntity> data;
  private Adapter adapter;
  private Bundle bundle;
  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    bundle = getArguments();
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_recycler, container, false);
    recyclerView = view.findViewById(R.id.recycler);
    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    new QueryEntity().execute();

    return view;
  }

  private class QueryEntity extends AsyncTask<Void, Void, List<EventEntity>>{

    @Override
    protected void onPostExecute(List<EventEntity> entities) {
      super.onPostExecute(entities);
      data = entities;
      adapter = new EventRecyclerViewAdapter(getContext(), data);
      switch (bundle.getString("fragment")){

      }
      recyclerView.setAdapter(adapter);
    }

    @Override
    protected List<EventEntity> doInBackground(Void... voids) {
      return MobilePunchDatabase.getInstance(getContext()).getEventDao().query();
    }
  }
}
