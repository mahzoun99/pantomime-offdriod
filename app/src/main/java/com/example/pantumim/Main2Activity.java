package com.example.pantumim;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.PointerIcon;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final Intent intent = new Intent(this , Main3Activity.class);
        Button Play =  findViewById(R.id.Play);

        final Button Sport =  findViewById(R.id.Sport);
        final Button Animals =  findViewById(R.id.Animals);
        final Button Things =  findViewById(R.id.Things);
        final Button Film =  findViewById(R.id.Film);

        final Button Points4 =  findViewById(R.id.Points4);
        final Button Points6 =  findViewById(R.id.Points6);

        Sport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {

                if(intent.hasExtra("subject")) {
                    intent.removeExtra("subject");
                }

                if(Sport.getText().equals("Sport")){
                    intent.putExtra("subject","Sport");
                    Sport.setText("[Sport]");
                }
                else if(Sport.getText().equals("[Sport]")){
                    Sport.setText("Sport");
                }
            }
        });
        Animals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {

                if(intent.hasExtra("subject"))
                    intent.removeExtra("subject");

                if(Animals.getText().equals("Animals")){
                    intent.putExtra("subject","Animals");
                    Animals.setText("[Animals]");
                }
                else if(Animals.getText().equals("[Animals]")){
                    Animals.setText("Animals");
                }
            }
        });
        Things.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {

                if(intent.hasExtra("subject"))
                    intent.removeExtra("subject");

                if(Things.getText().equals("Things")){
                    intent.putExtra("subject","Things");
                    Things.setText("[Things]");
                }
                else if(Things.getText().equals("[Things]")){
                    Things.setText("Things");
                }
            }
        });
        Film.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {

                if(intent.hasExtra("subject"))
                    intent.removeExtra("subject");

                if(Film.getText().equals("Film")){
                    intent.putExtra("subject","Film");
                    Film.setText("[Film]");
                }
                else if(Film.getText().equals("[Film]")){
                    Film.setText("Film");
                }
            }
        });


        Points4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {

                if(intent.hasExtra("points"))
                    intent.removeExtra("points");

                if(Points4.getText().equals("4 points")){
                    intent.putExtra("points",4);
                    Points4.setText("[4 points]");
                }
                else if(Points4.getText().equals("[4 points]")){
                    Points4.setText("4 points");
                }
            }
        });
        Points6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {

                if(intent.hasExtra("points"))
                    intent.removeExtra("points");


                if(Points6.getText().equals("6 points")){
                    intent.putExtra("points",6);
                    Points6.setText("[6 points]");
                }
                else if(Points6.getText().equals("[6 points]")){
                    Points6.setText("6 points");
                }
            }
        });


        Play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {

                if(intent.hasExtra("subject") && intent.hasExtra("points"))
                    startActivity(intent);


            }
        });
    }
}
