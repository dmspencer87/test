package com.cointransfer.android.cointransfer.Netowrk;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.coinbase.android.sdk.OAuth;
import com.coinbase.api.Coinbase;
import com.coinbase.api.CoinbaseBuilder;
import com.coinbase.api.entity.OAuthTokensResponse;
import com.coinbase.api.exception.UnauthorizedException;

import java.io.IOException;
import java.net.URL;

import static android.content.ContentValues.TAG;

/**
 * Created by Daniel Spencer on 2/26/2018.
 */

public class API {
    private static final String CLIENT_ID = "906c34540b7a5a3f54c0c723e06aa5b34a9b6953e46032d2829653fc01e478d0";
    private static final String CLIENT_SECRET = "99d451f9a320f6a90234ad06062e67f079956f892120e33b8663f8de8d1afee0";
    private static final String REDIRECT_URI = "bwallet://coinbase-oauth";

    private static Coinbase cb;

    private static API api = new API();

    public API() {
        cb = new CoinbaseBuilder().build();
    }

//    public void login(final Context context){
//        try {
//            OAuth.beginAuthorization(context, CLIENT_ID, "user", REDIRECT_URI, null);
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//    public void completAuth( Context context, Intent intent){
//        new CompleteAuthorizationTask(context, intent).execute();
//    }

//    public class CompleteAuthorizationTask extends AsyncTask<Intent, String, OAuthTokensResponse> {
//        Context context;
//        private Intent mIntent;
//
//        public CompleteAuthorizationTask(Context c, Intent intent){
//            this.context = c;
//            this.mIntent = intent;
//        }
//        @Override
//        protected OAuthTokensResponse doInBackground(Intent... intents) {
//            //Log.d(TAG, "doInBackground AUTH");
//            try {
//                return OAuth.completeAuthorization(context, CLIENT_ID,
//                        CLIENT_SECRET, mIntent.getData());
//            } catch (UnauthorizedException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(OAuthTokensResponse oAuthTokensResponse) {
//            super.onPostExecute(oAuthTokensResponse);
//            Log.d(TAG, "Post Called");
//        }
//
//        @Override
//        protected void onPreExecute() {
//            Log.d(TAG, "Pre Called");
//        }
//    }
//test



}
