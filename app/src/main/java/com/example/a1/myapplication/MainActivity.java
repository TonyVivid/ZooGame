package com.example.a1.myapplication;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        /*
        Typeface fontFace = Typeface.createFromAsset(getAssets(),
                "04B_03.TTF");
        Button btn_start=(Button)findViewById(R.id.btn_start);
        btn_start.setTypeface(fontFace);*/
    }
    public void start_clicked(View view){
       Intent intent =new Intent();
       intent.setClass(MainActivity.this,GameActivity.class);
       startActivity(intent);


    }
}
