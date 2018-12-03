package edu.cnm.deepdive.mobilepunch.view.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import edu.cnm.deepdive.mobilepunch.R;


public class ClientFragment extends Fragment {

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    final View view = inflater.inflate(R.layout.fragment_client, container, false);
    final EditText alt_num = view.findViewById(R.id.client_alternate_num);
    EditText test = view.findViewById(R.id.client_number);
    test.addTextChangedListener(new TextWatcher() {
      @Override
      public void beforeTextChanged(CharSequence s, int start, int count, int after) {

      }

      @Override
      public void onTextChanged(CharSequence s, int start, int before, int count) {
        alt_num.setVisibility(View.VISIBLE);
      }

      @Override
      public void afterTextChanged(Editable s) {

      }
    });
    return view;
  }

}
