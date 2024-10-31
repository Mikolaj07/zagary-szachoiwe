package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
     Button buttonGracz1;
     Button buttonGracz2;
     Gracz gracz1;
     Gracz gracz2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonGracz1 = findViewById(R.id.buttonGracz1);
        buttonGracz2 = findViewById(R.id.buttonGracz2);
        gracz1 = new Gracz(true, buttonGracz1);
        gracz1.liczeCzas();
        gracz2 = new Gracz(false, buttonGracz2);

        buttonGracz1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(gracz1.czyAktywny){
                            gracz1.stopLiczenieCzasu();
                            gracz2.liczeCzas();
                        }
                    }
                }
        );

        buttonGracz2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(gracz2.czyAktywny){
                            gracz2.stopLiczenieCzasu();
                            gracz1.liczeCzas();
                        }
                    }
                }
        );
    }




}