package edu.cnm.deepdive.mobilepunch.view.fragments.helpers;

/**
 * The type Day of week helper. Gets and returns day of the week from calender.
 */
public class DayOfWeekHelper {

  /**
   * Gets day of week from calendar day of week.
   *
   * @param dayOfWeek the day of week
   * @return the day of week from calendar day of week
   */
  public static String getDayOfWeekFromCalendarDayOfWeek(int dayOfWeek) {
    String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    return days[dayOfWeek - 1];
  }
}
