package com.example.a1.myapplication;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class GameActivity extends AppCompatActivity {
    int a = 0;
    int b = 0;
    int c=0;
    int d=0;
    int SIGN = 17;
    int ENDTIMER = 18;
    String choice="";
    int scores=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

    }
    public  void setscores(){
        if(choice.equals(compareall())){
            scores++;
            String myscore=String.valueOf(scores);
            TextView textView=(TextView)findViewById(R.id.tv_score);
            textView.setText(myscore);
            Log.d("TAG",myscore);

        }
    }
    public void img1_click(View view){
        choice="a";
        ImageView imgview1 = findViewById(R.id.img_first);
        imgview1.setImageDrawable(getResources().getDrawable(R.drawable.fish96_pressed));
        Toast.makeText(getApplicationContext(),"you have chose the fish",Toast.LENGTH_LONG).show();

    }
    public void img2_click(View view){
        choice="b";
        ImageView imgview1 = findViewById(R.id.img_second);
        imgview1.setImageDrawable(getResources().getDrawable(R.drawable.honey96_pressed));
        Toast.makeText(getApplicationContext(),"you have chose the bee",Toast.LENGTH_LONG).show();
    }
    public void img3_click(View view){
        choice="c";
        ImageView imgview1 = findViewById(R.id.img_third);
        imgview1.setImageDrawable(getResources().getDrawable(R.drawable.cat96_pressed));
        Toast.makeText(getApplicationContext(),"you have chose the cat",Toast.LENGTH_LONG).show();
    }
    public void img4_click(View view){
        choice="d";
        ImageView imgview1 = findViewById(R.id.img_fourth);
        imgview1.setImageDrawable(getResources().getDrawable(R.drawable.bird96_pressed));
        Toast.makeText(getApplicationContext(),"you have chose the bird",Toast.LENGTH_LONG).show();
    }
public String  compareall(){
        int temp=a;
        String final_champion="a";
        if(temp<b){
            temp=b;
            final_champion="b";
        }

        if(temp<c){
            temp=c;
            final_champion="c";
        }

         if(temp<d){
            temp=d;
            final_champion="d";
        }
            return  final_champion;



}
    public  void refresh(View view){
        choice="";
        a=b=c=d=0;
        ImageView imgview1 = findViewById(R.id.img_first);
        imgview1.setImageDrawable(getResources().getDrawable(R.drawable.fish96));
        ImageView imgview2 = findViewById(R.id.img_second);
        imgview2.setImageDrawable(getResources().getDrawable(R.drawable.honey96));
        ImageView imgview3 = findViewById(R.id.img_third);
        imgview3.setImageDrawable(getResources().getDrawable(R.drawable.cat96));
        ImageView imgview4 = findViewById(R.id.img_fourth);
        imgview4.setImageDrawable(getResources().getDrawable(R.drawable.bird96));
        getImgviewFirst();
        getImgviewSecond();
        getImgviewThird();
        getImgviewFourth();
        Button btn =(Button)findViewById(R.id.btn_start);
        btn.setEnabled(true);
    }
    public void getImgviewFirst() {

        ImageView imgview1 = findViewById(R.id.img_first);
        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) imgview1.getLayoutParams();
        lp.topMargin = a;
        imgview1.setLayoutParams(lp);
    }

    public void getImgviewSecond() {

        ImageView imgview1 = findViewById(R.id.img_second);
        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) imgview1.getLayoutParams();
        lp.topMargin = b;
        imgview1.setLayoutParams(lp);
    }
    public void getImgviewThird() {

        ImageView imgview1 = findViewById(R.id.img_third);
        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) imgview1.getLayoutParams();
        lp.topMargin = c;
        imgview1.setLayoutParams(lp);
    }
    public void getImgviewFourth() {

        ImageView imgview1 = findViewById(R.id.img_fourth);
        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) imgview1.getLayoutParams();
        lp.topMargin = d;
        imgview1.setLayoutParams(lp);
    }
    public void click(View view) {
        if(choice=="") {
            Toast.makeText(getBaseContext(), "please choose your ideal champion", Toast.LENGTH_SHORT).show();
            return;
        }
        Button btn =(Button)findViewById(R.id.btn_start);
        btn.setEnabled(false);
        final Random random= new Random();

        final Timer timer = new Timer();
        final Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == SIGN) {
                    a = a + Math.abs(random.nextInt()%100);
                    b = b + Math.abs(random.nextInt()%100);
                    c=c+Math.abs(random.nextInt()%100);
                    d=d+Math.abs(random.nextInt()%100);
                    getImgviewFirst();
                    getImgviewSecond();
                    getImgviewThird();
                    getImgviewFourth();


                }
                if (msg.what == ENDTIMER) {
                    setscores();
                    timer.cancel();

                }
            }
        };
        final TimerTask timertask = new TimerTask() {
            @Override
            public void run() {

                Message msg = new Message();
                msg.what = SIGN;
                if (a <= 1300&&b<=1300&&c<=1300&&d<=1300) {
                    handler.sendMessage(msg);
                } else  {

                    msg.what = ENDTIMER;
                    handler.sendMessage(msg);
                }


            }

        };
        timer.schedule(timertask, 1000, 200);

    }
        private class changView extends AsyncTask<String, Void, String> {


            @Override
            protected String doInBackground(String... strings) {


                getImgviewFirst();


                return null;
            }


        }

    }
