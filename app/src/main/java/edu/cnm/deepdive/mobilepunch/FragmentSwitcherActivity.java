package edu.cnm.deepdive.mobilepunch;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class FragmentSwitcherActivity extends AppCompatActivity {
  private static FragmentManager manager;

  public static FragmentManager getManager() {
    return manager;
  }

  public static void setManager(FragmentManager manager) {
    FragmentSwitcherActivity.manager = manager;
  }

  public static void switchFragment(Fragment fragment, boolean useStack, String variant) {
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

}
