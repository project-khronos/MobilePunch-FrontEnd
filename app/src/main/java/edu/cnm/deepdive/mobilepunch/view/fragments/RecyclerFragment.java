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
import android.widget.Toast;

import java.util.List;

import edu.cnm.deepdive.mobilepunch.R;
import edu.cnm.deepdive.mobilepunch.controller.adapters.ClientRecyclerViewAdapter;
import edu.cnm.deepdive.mobilepunch.controller.adapters.EquipmentRecyclerViewAdapter;
import edu.cnm.deepdive.mobilepunch.controller.adapters.EventRecyclerViewAdapter;
import edu.cnm.deepdive.mobilepunch.controller.adapters.ProjectRecyclerViewAdapter;
import edu.cnm.deepdive.mobilepunch.model.db.MobilePunchDatabase;
import edu.cnm.deepdive.mobilepunch.model.entities.ClientEntity;
import edu.cnm.deepdive.mobilepunch.model.entities.EquipmentEntity;
import edu.cnm.deepdive.mobilepunch.model.entities.EventEntity;
import edu.cnm.deepdive.mobilepunch.model.entities.ProjectEntity;

/**
 * The type Recycler fragment.
 */
public class RecyclerFragment extends Fragment {

    private RecyclerView recyclerView;

    private List<EventEntity> events;
    private List<ProjectEntity> projects;
    private List<ClientEntity> clients;
    private List<EquipmentEntity> equipment;

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
        checkFrag();
        return view;
    }

    private void checkFrag() {
        switch (bundle.getString("fragment")) {
            case "event":
                new QueryEvents().execute();
                break;
            case "project":
                new QueryProjects().execute();
                break;
            case "client":
                new QueryClients().execute();
                break;
            case "equipment":
                new QueryEquipment().execute();
                break;
        }
    }

    private class QueryEvents extends AsyncTask<Void, Void, List<EventEntity>> {

        @Override
        protected void onPostExecute(List<EventEntity> entities) {
            super.onPostExecute(entities);
            events = entities;
            adapter = new EventRecyclerViewAdapter(getContext(), events);
            if (adapter.getItemCount() == 0) {
                Toast.makeText(getContext(), "No items found.", Toast.LENGTH_SHORT).show();
            }
            recyclerView.setAdapter(adapter);
        }

        @Override
        protected List<EventEntity> doInBackground(Void... voids) {
            return MobilePunchDatabase.getInstance(getContext()).getEventDao().select();
        }
    }

    private class QueryProjects extends AsyncTask<Void, Void, List<ProjectEntity>> {

        @Override
        protected void onPostExecute(List<ProjectEntity> entities) {
            super.onPostExecute(entities);
            projects = entities;
            adapter = new ProjectRecyclerViewAdapter(getContext(), projects);
            if (adapter.getItemCount() == 0) {
                Toast.makeText(getContext(), "No items found.", Toast.LENGTH_SHORT).show();
            }
            recyclerView.setAdapter(adapter);
        }

        @Override
        protected List<ProjectEntity> doInBackground(Void... voids) {
            return MobilePunchDatabase.getInstance(getContext()).getProjectDao().select();
        }
    }

    private class QueryClients extends AsyncTask<Void, Void, List<ClientEntity>> {

        @Override
        protected void onPostExecute(List<ClientEntity> entities) {
            super.onPostExecute(entities);
            clients = entities;
            adapter = new ClientRecyclerViewAdapter(getContext(), clients);
            if (adapter.getItemCount() == 0) {
                Toast.makeText(getContext(), "No items found.", Toast.LENGTH_SHORT).show();
            }
            recyclerView.setAdapter(adapter);
        }

        @Override
        protected List<ClientEntity> doInBackground(Void... voids) {
            return MobilePunchDatabase.getInstance(getContext()).getClientDao().select();
        }
    }

    private class QueryEquipment extends AsyncTask<Void, Void, List<EquipmentEntity>> {

        @Override
        protected void onPostExecute(List<EquipmentEntity> entities) {
            super.onPostExecute(entities);
            equipment = entities;
            adapter = new EquipmentRecyclerViewAdapter(getContext(), equipment);
            if (adapter.getItemCount() == 0) {
                Toast.makeText(getContext(), "No items found.", Toast.LENGTH_SHORT).show();
            }
            recyclerView.setAdapter(adapter);
        }

        @Override
        protected List<EquipmentEntity> doInBackground(Void... voids) {
            return MobilePunchDatabase.getInstance(getContext()).getEquipmentDao().select();
        }
    }

}
