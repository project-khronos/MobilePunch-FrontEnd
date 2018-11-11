package edu.cnm.deepdive.mobilepunch.view.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintSet;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Toast;
import edu.cnm.deepdive.mobilepunch.R;


public class ClientFragment extends Fragment {
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    final View view = inflater.inflate(R.layout.fragment_client, container, false);
    CheckBox alt = view.findViewById(R.id.alt_num);
    alt.setOnCheckedChangeListener(new OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked){

        }else{
        }

      }
    });
    return view;
  }

}
