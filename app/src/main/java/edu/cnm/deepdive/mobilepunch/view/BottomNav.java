package edu.cnm.deepdive.mobilepunch.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.widget.TextView;
import com.google.common.collect.Maps;
import edu.cnm.deepdive.mobilepunch.FragmentSwitcherActivity;
import edu.cnm.deepdive.mobilepunch.R;
import edu.cnm.deepdive.mobilepunch.view.fragments.ClientFragment;
import edu.cnm.deepdive.mobilepunch.view.fragments.EquipmentFragment;
import edu.cnm.deepdive.mobilepunch.view.fragments.EventFragment;
import edu.cnm.deepdive.mobilepunch.view.fragments.ProjectFragment;

public class BottomNav extends FragmentSwitcherActivity {

  private TextView mTextMessage;

  private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
      = new BottomNavigationView.OnNavigationItemSelectedListener() {

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
      switch (item.getItemId()) {
        case R.id.event:
          switchFragment(new EventFragment(), false, null);

          return true;
        case R.id.project:
          switchFragment(new ProjectFragment(), false, null);

          return true;
        case R.id.client:
          switchFragment(new ClientFragment(), false, null);

          return true;
        case R.id.equipment:
          switchFragment(new EquipmentFragment(), false, null);

          return true;
      }
      return false;
    }
  };
  private BottomNavigationView navigation;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_bottom_nav);
    ActionBar actionBar = getSupportActionBar();
    actionBar.hide();
    mTextMessage = findViewById(R.id.message);
    navigation = findViewById(R.id.navigation);
    navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    fromMain();
  }

  public void fromMain() {
    Bundle b = getIntent().getExtras();
    int value = -1; // or other values
    if (b != null) {
      value = b.getInt("key");
    }
    switch (value) {
      case 1:
        navigation.setSelectedItemId(R.id.event);
        break;
      case 2:
        navigation.setSelectedItemId(R.id.project);
        break;
      case 3:
        navigation.setSelectedItemId(R.id.client);
        break;
      case 4:
        navigation.setSelectedItemId(R.id.equipment);
        break;
    }
  }

}