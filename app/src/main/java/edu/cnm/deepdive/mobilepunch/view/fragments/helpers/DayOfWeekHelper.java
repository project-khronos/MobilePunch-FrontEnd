package edu.cnm.deepdive.mobilepunch.view.fragments.helpers;

import android.util.Log;
import android.widget.Toast;

public class DayOfWeekHelper {


  public static String getDayOfWeekFromCalendarDayOfWeek(int dayOfWeek) {
    String[] days = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
    return days[dayOfWeek-1];
  }


}
