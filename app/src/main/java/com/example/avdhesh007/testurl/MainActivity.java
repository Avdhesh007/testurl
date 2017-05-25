package com.example.avdhesh007.testurl;

import android.content.Intent;
import android.os.PatternMatcher;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import static com.example.avdhesh007.testurl.R.id.btn_submit;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=(EditText)findViewById(R.id.et_url);
        button=(Button)findViewById(R.id.btn_submit);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ur=editText.getText().toString();
               Boolean b= Patterns.WEB_URL.matcher(ur).matches();
                if(b==true)
                {
                    Intent intent=new Intent(MainActivity.this, Main2Activity.class);
                    intent.putExtra("message",ur);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Not valid URL",Toast.LENGTH_LONG).show();
                }

            }
        });
    }

}
