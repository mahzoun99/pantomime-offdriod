package com.example.pantumim;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SoundEffectConstants;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class Main4Activity extends AppCompatActivity {

    static int[] GroupsPoints = new int [4];
    static int round = 0;
    static int addpoints = 0;
    static int groupsnumber = MainActivity.groupnum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        addpoints = getIntent().getIntExtra("points",0);
        GroupsPoints[round%groupsnumber] += addpoints ;
        round++;

        final Intent intent = new Intent(this , Main2Activity.class);
        final Button Exit =  findViewById(R.id.Exit);
        final Button Next =  findViewById(R.id.Next);

        TextView First = findViewById(R.id.First);
        TextView Second = findViewById(R.id.Second);
        TextView Third = findViewById(R.id.Third);
        TextView Fourth = findViewById(R.id.Fourth);

        First.setText("      Points Of First Group : "+GroupsPoints[0]);
        Second.setText("      Points Of Second Group : "+GroupsPoints[1]);
        Third.setText("      Points Of Third Group : "+GroupsPoints[2]);
        Fourth.setText("      Points Of Fourth Group : "+GroupsPoints[3]);

        final Intent goback = new Intent(this , MainActivity.class);

        Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                round = 0;
                for (int i = 0; i <4 ; i++) {
                    GroupsPoints[i]=0;
                }
                startActivity(goback);
            }
        });

        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                startActivity(intent);
            }
        });
    }
}
