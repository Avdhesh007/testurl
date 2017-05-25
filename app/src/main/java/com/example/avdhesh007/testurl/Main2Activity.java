package com.example.avdhesh007.testurl;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

public class Main2Activity extends AppCompatActivity {
    WebView webView;
    ToggleButton toggleButton;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle bundle=getIntent().getExtras();
        webView=(WebView)findViewById(R.id.webview);
        final String message=bundle.getString("message");
        textView=(TextView)findViewById(R.id.et2_url);
        button=(Button)findViewById(R.id.btn_src);
        textView.setText(message);
        Uri url=Uri.parse(message);
        Toast.makeText(Main2Activity.this,message,Toast.LENGTH_LONG).show();
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(message);
        webView.setWebViewClient(new WebViewClient());
        toggleButton=(ToggleButton)findViewById(R.id.tg_btn);
        //Bundle bundle = new Bundle();

        /*button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button.setText("html");
                startActivity(intent);

            }
        }); */
        toggleButton.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {
                Intent intent=new Intent(Main2Activity.this,Main3Activity.class);
                intent.putExtra("message",message);
                startActivity(intent);
               /* boolean state=toggleButton.isChecked();
                if(state==true){
                    Intent intent=new Intent(Main2Activity.this,Main3Activity.class);
                    intent.putExtra("message",message);
                    startActivity(intent);

                }
                else{

                    Toast.makeText(getApplicationContext(),
                            String.valueOf(toggleButton.isChecked()), Toast.LENGTH_SHORT).show();

                    finish();
                    startActivity(getIntent());

                } */

            }
        });
        //webView.clearCache(true);
      /*  toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                webView.clearCache(true);
                Toast.makeText(getApplicationContext(),
                        String.valueOf(buttonView.isChecked()), Toast.LENGTH_SHORT).show();
                if(isChecked){
                    webView.clearCache(true);
                    webView.loadUrl("view-source:"+""+message);
                    webView.setWebViewClient(new WebViewClient());
                    webView.clearCache(true);

                }
                else{
                    webView.clearCache(true);
                    webView.loadUrl(message);
                    webView.setWebViewClient(new WebViewClient());
                    webView.clearCache(true);
                }
            }
        }); */
        /*{

            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.toString());
                return true;
            }// then it is not handled by default action

            }); */



    }







    @Override
    public void onBackPressed() {
        if(webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }


}
