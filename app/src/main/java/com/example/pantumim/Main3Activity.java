package com.example.pantumim;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Main3Activity extends Activity {



    TextView timer;
    TextView kalame;
    private static final String FORMAT = "%02d:%02d:%02d";

    static int points = 1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        timer=findViewById(R.id.Timer);
        kalame=findViewById(R.id.Wordtext);
        String sss = "Words";

        DatabaseAccess dbAccess = new DatabaseAccess(this);
        Cursor c = dbAccess.getDb().rawQuery("SELECT * FROM '"+sss+"'",null);
        c.moveToFirst();

        Random random = new Random();
        int col = 0;
        int row = random.nextInt(5);
        row+=1;
        points = getIntent().getIntExtra("points",0);


            if (getIntent().getStringExtra("subject").equals("Animals") && points == 4)
                col = 0;
            else if (getIntent().getStringExtra("subject").equals("Film")&& points == 4)
                col = 1;
            else if (getIntent().getStringExtra("subject").equals("Things")&& points == 4)
                col = 2;
            else if (getIntent().getStringExtra("subject").equals("Sport")&& points == 4)
                col = 3;
            else if (getIntent().getStringExtra("subject").equals("Animals")&& points == 6)
                col = 4;
            else if (getIntent().getStringExtra("subject").equals("Film")&& points == 6)
                col = 5;
            else if (getIntent().getStringExtra("subject").equals("Things")&& points == 6)
                col = 6;
            else if (getIntent().getStringExtra("subject").equals("Sport")&& points == 6)
                col = 7;


        for (int i = 0; i < row; i++) {
            if(c.isLast())
                c.moveToFirst();
            else
                c.moveToNext();
        }
        kalame.setText(c.getString(col));



        new CountDownTimer(120000, 1000) { // adjust the milli seconds here

            public void onTick(long millisUntilFinished) {

                timer.setText(""+String.format(FORMAT,
                        TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(
                                TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                                TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
            }

            public void onFinish() {
                timer.setText("Time Out!");
            }
        }.start();

        final Button Done =  findViewById(R.id.CAnext);
        final Intent intent1 = new Intent(this , Main4Activity.class);

        Done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                if(!timer.getText().equals("Time Out!"))
                    intent1.putExtra("points",getIntent().getExtras().getInt("points"));
                else
                    intent1.putExtra("points",0);
                finish();
                startActivity(intent1);

            }
        });


    }

}