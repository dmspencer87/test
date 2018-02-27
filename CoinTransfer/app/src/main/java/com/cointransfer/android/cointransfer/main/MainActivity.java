package com.cointransfer.android.cointransfer.main;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.cointransfer.android.cointransfer.Netowrk.API;
import com.cointransfer.android.cointransfer.R;
import com.coinbase.api.entity.OAuthTokensResponse;
import static android.content.ContentValues.TAG;


public class MainActivity extends AppCompatActivity {

    private Button bLogin;
    API testApi;

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
                testApi = new API();
                testApi.login(MainActivity.this);
                testApi.completAuth(MainActivity.this,getIntent());

            }
        });

    }
    public void handleIntent(Intent intent) {

        if(intent != null && intent.getAction() != null) {
            if(intent.getAction().equals("android.intent.action.VIEW")) {
                Log.d(TAG, "COMPLETE AUTH");
                testApi.completAuth(MainActivity.this,getIntent());
            }
        }
    }


    @Override
    protected void onNewIntent(Intent intent) {
        Log.d(TAG, "onNewIntent");
        handleIntent(intent);
    }
}
