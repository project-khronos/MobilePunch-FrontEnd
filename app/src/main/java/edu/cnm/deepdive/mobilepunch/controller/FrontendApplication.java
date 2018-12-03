package edu.cnm.deepdive.mobilepunch.controller;

import android.app.Application;
import com.facebook.stetho.Stetho;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions.Builder;
import edu.cnm.deepdive.mobilepunch.R;

public class FrontendApplication  extends Application {

  private static FrontendApplication instance = null;

  private GoogleSignInClient client;
  private GoogleSignInAccount account;

  public static FrontendApplication getInstance() {
    return instance;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    instance = this;
    GoogleSignInOptions options = new Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestEmail()
        .requestId()
        .requestIdToken(getString(R.string.client_id))
        .build();
    client = GoogleSignIn.getClient(this, options);
    Stetho.initializeWithDefaults(this);
  }

  public GoogleSignInClient getClient() {
    return client;
  }

  public void setClient(GoogleSignInClient client) {
    this.client = client;
  }

  public GoogleSignInAccount getAccount() {
    return account;
  }

  public void setAccount(GoogleSignInAccount account) {
    this.account = account;
  }
}
