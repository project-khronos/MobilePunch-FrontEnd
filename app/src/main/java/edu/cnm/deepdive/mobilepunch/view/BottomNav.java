package edu.cnm.deepdive.mobilepunch.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.strictmode.CleartextNetworkViolation;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import edu.cnm.deepdive.mobilepunch.R;
import edu.cnm.deepdive.mobilepunch.view.fragments.ClientFragment;
import edu.cnm.deepdive.mobilepunch.view.fragments.EquipmentFragment;
import edu.cnm.deepdive.mobilepunch.view.fragments.EventFragment;
import edu.cnm.deepdive.mobilepunch.view.fragments.ProjectFragment;

public class BottomNav extends AppCompatActivity {

  private TextView mTextMessage;

  private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
      = new BottomNavigationView.OnNavigationItemSelectedListener() {

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
      switch (item.getItemId()) {
        case R.id.event:
          switchFragment(new EventFragment(), false, null);
          mTextMessage.setText(R.string.event);
          return true;
        case R.id.project:
          switchFragment(new ProjectFragment(), false, null);
          mTextMessage.setText(R.string.project);
          return true;
        case R.id.client:
          switchFragment(new ClientFragment(), false, null);
          mTextMessage.setText(R.string.client);
          return true;
        case R.id.equipment:
          switchFragment(new EquipmentFragment(), false, null);
          mTextMessage.setText(R.string.equipment);
          return true;
      }
      return false;
    }
  };
  private BottomNavigationView navigation;

  private void switchFragment(Fragment fragment, boolean useStack, String variant) {
    FragmentManager manager = getSupportFragmentManager();
    String tag = fragment.getClass().getSimpleName() + ((variant != null) ? variant : "");
    if (manager.findFragmentByTag(tag) != null) {
      manager.popBackStackImmediate(tag, FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }
    FragmentTransaction transaction = manager.beginTransaction();
    transaction.replace(R.id.fragment_container, fragment, tag);
    if (useStack) {
      transaction.addToBackStack(tag);
    }
    transaction.commit();
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_bottom_nav);
    ActionBar actionBar = getSupportActionBar();
    actionBar.hide();
    mTextMessage = (TextView) findViewById(R.id.message);
    navigation = (BottomNavigationView) findViewById(R.id.navigation);
    navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    fromMain();
    }

  public void fromMain(){
    Bundle b = getIntent().getExtras();
    int value = -1; // or other values
    if(b != null)
      value = b.getInt("key");
    switch (value){
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
