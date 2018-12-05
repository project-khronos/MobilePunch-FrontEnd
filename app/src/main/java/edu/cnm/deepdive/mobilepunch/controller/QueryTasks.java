package edu.cnm.deepdive.mobilepunch.controller;

import android.os.AsyncTask;
import java.util.List;

public class QueryTasks {


  public interface QueryExecutor<T> {

    List<T> query();
  }

  public interface QueryResultHandler<T> {

    void handle(List<T> values);
  }

  public class ListQuery<T> extends AsyncTask<Void, Void, List<T>> {

    private QueryExecutor<T> queryExecutor;
    private QueryResultHandler<T> resultHandler;

    public ListQuery(QueryExecutor<T> queryExecutor, QueryResultHandler<T> resultHandler) {
      this.queryExecutor = queryExecutor;
      this.resultHandler = resultHandler;
    }


    @Override
    protected List<T> doInBackground(Void... voids) {
      FrontendApplication.refreshToken();
      return queryExecutor.query();
    }

    @Override
    protected void onPostExecute(List<T> values) {
      resultHandler.handle(values);
    }
  }

}
