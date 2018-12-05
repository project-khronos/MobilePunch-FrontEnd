package edu.cnm.deepdive.mobilepunch.controller;

import android.app.Application;
import com.facebook.stetho.Stetho;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions.Builder;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import edu.cnm.deepdive.mobilepunch.R;

/**
 * The type Frontend application.
 */
public class FrontendApplication extends Application {

  private static FrontendApplication instance = null;

  private GoogleSignInClient client;
  private GoogleApiClient refreshClient;
  private GoogleSignInAccount account;

  /**
   * Gets instance.
   *
   * @return the instance
   */
  public static FrontendApplication getInstance() {
    return instance;
  }

  /**
   * Refresh token.
   */
  public static void refreshToken() {
    OptionalPendingResult<GoogleSignInResult> pendingResult =
        Auth.GoogleSignInApi.silentSignIn(instance.refreshClient);
    GoogleSignInResult result = null;
    if (pendingResult.isDone()) {
      result = pendingResult.get();
    } else {
      result = pendingResult.await();
    }
    instance.account = result.getSignInAccount();
  }

  /**
   * Gets client.
   *
   * @return the client
   */
  public GoogleSignInClient getClient() {
    return client;
  }

  /**
   * Sets client.
   *
   * @param client the client
   */
  public void setClient(GoogleSignInClient client) {
    this.client = client;
  }

  /**
   * Gets account.
   *
   * @return the account
   */
  public GoogleSignInAccount getAccount() {
    return account;
  }

  /**
   * Sets account.
   *
   * @param account the account
   */
  public void setAccount(GoogleSignInAccount account) {
    this.account = account;
  }

  /**
   * Refresh in background.
   */
  public static void refreshInBackground() {
    new Thread(new RefreshTokenTask()).start();
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
    refreshClient = new GoogleApiClient.Builder(this).addApi(Auth.GOOGLE_SIGN_IN_API, options)
        .build();
    Stetho.initializeWithDefaults(this);
  }

  /**
   * The type Refresh token task.
   */
  public static class RefreshTokenTask implements Runnable {
    @Override
    public void run() {
      refreshToken();
    }
  }


}
