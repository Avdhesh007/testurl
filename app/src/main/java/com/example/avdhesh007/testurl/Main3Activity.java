package com.example.avdhesh007.testurl;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Main3Activity extends AppCompatActivity {
    WebView webView;
    ToggleButton toggleButton;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Bundle bundle=getIntent().getExtras();
        webView=(WebView)findViewById(R.id.webview3);
        final String message=bundle.getString("message");
        textView=(TextView)findViewById(R.id.et3_url);
        button=(Button)findViewById(R.id.btn_src3);
        textView.setText(message);

        Toast.makeText(Main3Activity.this,message,Toast.LENGTH_LONG).show();
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("view-source:"+""+message);
        webView.setWebViewClient(new WebViewClient());
        toggleButton=(ToggleButton)findViewById(R.id.tg_btn3);


        toggleButton.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {
                Intent intent=new Intent(Main3Activity.this,Main2Activity.class);
                intent.putExtra("message",message);
                startActivity(intent);

               /* boolean state=toggleButton.isChecked();
                if(state==true){
                    Intent intent=new Intent(Main3Activity.this,Main2Activity.class);
                    intent.putExtra("message",message);
                    startActivity(intent);

                }
                else{

                    Toast.makeText(getApplicationContext(),
                            String.valueOf(toggleButton.isChecked()), Toast.LENGTH_SHORT).show();

                    //finish();
                    //startActivity(getIntent());

                }  */

            }
        });
    }


}
