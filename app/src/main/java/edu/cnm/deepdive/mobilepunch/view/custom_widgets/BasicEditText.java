package edu.cnm.deepdive.mobilepunch.view.custom_widgets;

import android.content.Context;
import android.support.v4.content.res.ResourcesCompat;
import android.util.AttributeSet;
import edu.cnm.deepdive.mobilepunch.R;

/**
 * The type Basic edit text.
 */
public class BasicEditText extends android.support.v7.widget.AppCompatEditText {

  /**
   * Instantiates a new Basic edit text.
   *
   * @param context the context
   */
  public BasicEditText(Context context) {
    super(context);
  }

  /**
   * Instantiates a new Basic edit text.
   *
   * @param context the context
   * @param attrs the attrs
   */
  public BasicEditText(Context context, AttributeSet attrs) {
    super(context, attrs);
    setTextColor(ResourcesCompat.getColor(getResources(), R.color.rallyGreen, null));
    setHintTextColor(ResourcesCompat.getColor(getResources(), R.color.rallyBlue, null));
    setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.edit_text_style, null));
  }

  /**
   * Instantiates a new Basic edit text.
   *
   * @param context the context
   * @param attrs the attrs
   * @param defStyleAttr the def style attr
   */
  public BasicEditText(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }
}