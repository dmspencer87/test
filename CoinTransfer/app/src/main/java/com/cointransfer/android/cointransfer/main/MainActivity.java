package com.cointransfer.android.cointransfer.main;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.coinbase.android.sdk.OAuth;
import com.coinbase.api.entity.OAuthTokensResponse;
import com.coinbase.api.exception.UnauthorizedException;
import com.cointransfer.android.cointransfer.Netowrk.API;
import com.cointransfer.android.cointransfer.R;

import java.io.IOException;
import java.net.URI;

import static android.content.ContentValues.TAG;


public class MainActivity extends AppCompatActivity {

    private Button bLogin;
    API testApi;
    private static final String CLIENT_ID = "906c34540b7a5a3f54c0c723e06aa5b34a9b6953e46032d2829653fc01e478d0";
    private static final String CLIENT_SECRET = "99d451f9a320f6a90234ad06062e67f079956f892120e33b8663f8de8d1afee0";
    private static final String REDIRECT_URI = "bwallet://coinbase-oauth";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init(){
        bLogin = (Button) findViewById(R.id.bLogin);

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "clickasdfaeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeedf");
                login();
            }
        });

    }
    public void login(){
        try {
            OAuth.beginAuthorization(MainActivity.this, CLIENT_ID, "user", REDIRECT_URI, null);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    protected void onNewIntent(Intent intent) {
        if (intent != null && intent.getAction() != null && intent.getAction().equals("android.intent.action.VIEW")) {
            new CompleteAuthorizationTask(intent.getData()).execute();
        }
    }
    public class CompleteAuthorizationTask extends AsyncTask<Intent, String, OAuthTokensResponse> {
        private Uri u;

        public CompleteAuthorizationTask(Uri uri) {
           u = uri;
        }

        @Override
        protected OAuthTokensResponse doInBackground(Intent... uris) {
            Log.d(TAG, "doInBackground AUTH");
            try {
                return OAuth.completeAuthorization(MainActivity.this, CLIENT_ID,
                        CLIENT_SECRET, u);
            } catch (UnauthorizedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        protected void onPostExecute(OAuthTokensResponse result) {
            Log.d(TAG, "onPostExecute AUTH: " + result.getAccessToken());
            Bundle args = new Bundle();
            args.putString("oauth", result.getAccessToken());
            //createAndAddFragment("WalletFragment", WalletFragment.class, true, args);
            Log.d(TAG,"AUTHENTICATED SUCCESSFULLY");
        }


        @Override
        protected void onPreExecute() {
            Log.d(TAG, "onPreExecute AUTH");
        }
    }

}
