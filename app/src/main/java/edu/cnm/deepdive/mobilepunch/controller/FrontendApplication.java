package edu.cnm.deepdive.mobilepunch.controller;

import android.app.Application;
import com.facebook.stetho.Stetho;

public class FrontendApplication  extends Application {


  @Override
  public void onCreate() {
    super.onCreate();
    Stetho.initializeWithDefaults(this);
  }
}
