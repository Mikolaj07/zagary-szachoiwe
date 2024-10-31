package com.example.myapplication;

import android.os.CountDownTimer;
import android.widget.Button;

public class Gracz {
    int liczbaSeekund;
    boolean czyAktywny = false;
    CountDownTimer coundDownTimer;
    Button button;
    String czasdowyswietlania;

    public Gracz(boolean czyAktywny, Button buttton) {
        this.czyAktywny = czyAktywny;
        this.button = buttton;
        liczbaSeekund = 1*10;
    }


    public void liczeCzas(){
        czyAktywny = true;
        coundDownTimer = new CountDownTimer(liczbaSeekund*1000, 1000) {
            @Override
            public void onTick(long l) {
                liczbaSeekund = (int)l/1000;
                int s60 = liczbaSeekund % 60;
                int h60 = liczbaSeekund / 3600;
                int m60 = (liczbaSeekund - h60 * 3600) / 60;
                czasdowyswietlania = String.format("%02d:%02d:%02d", h60, m60, s60);
               button.setText(czasdowyswietlania);

            }

            @Override
            public void onFinish() {

            }
        };
        coundDownTimer.start();

    }

    public void stopLiczenieCzasu(){
        czyAktywny = false;
        coundDownTimer.cancel();

    }

}
