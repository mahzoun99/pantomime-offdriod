package com.example.pantumim;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    static int groupnum = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button G2 =  findViewById(R.id.Group2);
        Button G3 =  findViewById(R.id.Group3);
        Button G4 =  findViewById(R.id.Group4);

        final Intent intent = new Intent(this , Main2Activity.class);

        final Intent intent4 = new Intent(this , Main4Activity.class);

        G2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                groupnum = 2;
                intent4.putExtra("num", 2);
                startActivity(intent);

            }
        });
        G3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                groupnum = 3;
                intent4.putExtra("num", 3);
                startActivity(intent);

            }
        });
        G4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                groupnum = 4;
                intent4.putExtra("num", 4);
                startActivity(intent);

            }

        });



    }

}
