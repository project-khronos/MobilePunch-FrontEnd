package edu.cnm.deepdive.mobilepunch.view.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import edu.cnm.deepdive.mobilepunch.R;
import edu.cnm.deepdive.mobilepunch.service.MobilePunchService;

public class Retrotest extends Fragment {

  MobilePunchService service;
  EditText keyText;
  EditText valueText;
  EditText getkey;
  TextView getResponse;
  Button postButton;
  Button getButton;

  public static Retrotest newInstance() {
    Retrotest retroTest = new Retrotest();
    return retroTest;
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    final View view = inflater.inflate(R.layout.retro_test, container, false);
    keyText = view.findViewById(R.id.key_text);
    valueText = view.findViewById(R.id.value_text);
    getkey = view.findViewById(R.id.get_key);
    getResponse = view.findViewById(R.id.repsonse);
    Button postButton = view.findViewById(R.id.post_button);
    postButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {

       String key = keyText.getText().toString();
       String value = valueText.getText().toString();
       service.post(key, value);
      }
    });

    Button getButton = view.findViewById(R.id.get_button);
    getButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
      String key = keyText.getText().toString();
      service.get(key);
      }
    });
    return view;
  }

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }
}
