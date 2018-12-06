package edu.cnm.deepdive.mobilepunch.controller;

import android.os.AsyncTask;

import java.util.List;

/**
 * The type Query tasks.
 */
public class QueryTasks {


    /**
     * The interface Query executor.
     *
     * @param <T> the type parameter
     */
    public interface QueryExecutor<T> {

        /**
         * Query list.
         *
         * @return the list
         */
        List<T> query();
    }

    /**
     * The interface Query result handler.
     *
     * @param <T> the type parameter
     */
    public interface QueryResultHandler<T> {

        /**
         * Handle.
         *
         * @param values the values
         */
        void handle(List<T> values);
    }

    /**
     * The type List query.
     *
     * @param <T> the type parameter
     */
    public class ListQuery<T> extends AsyncTask<Void, Void, List<T>> {

        private QueryExecutor<T> queryExecutor;
        private QueryResultHandler<T> resultHandler;

        /**
         * Instantiates a new List query.
         *
         * @param queryExecutor the query executor
         * @param resultHandler the result handler
         */
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
