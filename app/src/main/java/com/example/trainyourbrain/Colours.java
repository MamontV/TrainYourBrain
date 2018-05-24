package com.example.trainyourbrain;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class Colours extends Activity {
    TextView color;
    Button yes, no;
    int mistake, record, points;
    ArrayList<String> stringarr = new ArrayList<>();
    ArrayList<Integer> colorarr = new ArrayList<>();
    AlertDialog.Builder ad;
    LinearLayout l;
    CountDownTimer timer;
    String message;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.colours);
        color = (TextView) findViewById(R.id.textcolor);
        yes = (Button) findViewById(R.id.yes);
        no = (Button) findViewById(R.id.no);
        l = (LinearLayout) findViewById(R.id.l);
        yes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dealWithButtonClick(yes);
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dealWithButtonClick2(no);
            }
        });
        pref = getSharedPreferences("MyPref", Context.MODE_PRIVATE);

        stringarr.add("Красный");
        stringarr.add("Желтый");
        stringarr.add("Зеленый");
        stringarr.add("Синий");
        stringarr.add("Черный");

        colorarr.add(Color.RED);
        colorarr.add(Color.YELLOW);
        colorarr.add(Color.GREEN);
        colorarr.add(Color.BLUE);
        colorarr.add(Color.BLACK);
        changeString(stringarr, colorarr);


        ad = new AlertDialog.Builder(this);
        ad.setPositiveButton(R.string.game, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int arg1) {
                points = 0;
                mistake = 0;
                changeString(stringarr, colorarr);
            }
        });
        ad.setNegativeButton(R.string.menu, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int arg1) {
                Intent intent = new Intent(Colours.this, MainActivity.class);
                startActivity(intent);
            }
        });
        ad.setCancelable(false);
        createTimer();
    }
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("Colours", record);
        editor.apply();
    }
    protected void onResume() {
        super.onResume();
        if (pref.contains("Colours")) {
            record = pref.getInt("Colours", 0);
        }
    }

    public void createTimer() {
        timer = new CountDownTimer(3000, 1000) {
            public void onTick(long millisUntilFinished) {}
            public void onFinish() {
                changeString(stringarr, colorarr);
            }
        }
                .start();
    }

    public void showYes(View view) {
        final Toast toast = new Toast(this);
        ImageView yes2 = new ImageView(this);
        yes2.setImageResource(R.drawable.yes);
        toast.setView(yes2);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                toast.cancel();
            }
        }, 500);
    }
    public void showNo(View view) {
        final Toast toast = new Toast(this);
        ImageView no2 = new ImageView(this);
        no2.setImageResource(R.drawable.no);
        toast.setView(no2);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                toast.cancel();
            }
        }, 500);
    }

    public void changeString(ArrayList stringarr, ArrayList colorarr) {
        if (mistake == 3) {
            if (points > record) {
                record = points;
            }
            message = String.valueOf(R.string.points + points + R.string.rec + record);
            ad.setMessage(message);
            ad.show();
        } else {
            int i = 0 + (int) (Math.random() * 5);
            Collections.shuffle(stringarr);
            Collections.shuffle(colorarr);
            String text = (String) stringarr.get(i);
            color.setText(text);
            color.setTextColor((Integer) colorarr.get(i));
        }
    }

    public void dealWithButtonClick(Button yes) {
        if (color.getText().equals("Красный")) {
            switch(color.getCurrentTextColor()) {
                case Color.BLACK:
                case Color.BLUE:
                case Color.YELLOW:
                case Color.GREEN:
                    mistake++;
                    showNo(l);
                    timer.cancel();
                    changeString(stringarr, colorarr);
                    createTimer();
                    break;
                case Color.RED:
                    points++;
                    showYes(l);
                    timer.cancel();
                    changeString(stringarr, colorarr);
                    createTimer();
                    break;
            }
        }
        if (color.getText().equals("Желтый")) {
            switch(color.getCurrentTextColor()) {
                case Color.BLACK:
                case Color.BLUE:
                case Color.RED:
                case Color.GREEN:
                    mistake++;
                    showNo(l);
                    timer.cancel();
                    changeString(stringarr, colorarr);
                    createTimer();
                    break;
                case Color.YELLOW:
                    points++;
                    showYes(l);
                    timer.cancel();
                    changeString(stringarr, colorarr);
                    createTimer();
                    break;
            }
        }
        if (color.getText().equals("Зеленый")) {
            switch(color.getCurrentTextColor()) {
                case Color.BLACK:
                case Color.BLUE:
                case Color.YELLOW:
                case Color.RED:
                    mistake++;
                    showNo(l);
                    timer.cancel();
                    changeString(stringarr, colorarr);
                    createTimer();
                    break;
                case Color.GREEN:
                    points++;
                    showYes(l);
                    timer.cancel();
                    changeString(stringarr, colorarr);
                    createTimer();
                    break;
            }
        }
        if (color.getText().equals("Синий")) {
            switch(color.getCurrentTextColor()) {
                case Color.BLACK:
                case Color.RED:
                case Color.YELLOW:
                case Color.GREEN:
                    mistake++;
                    showNo(l);
                    timer.cancel();
                    changeString(stringarr, colorarr);
                    createTimer();
                    break;
                case Color.BLUE:
                    points++;
                    showYes(l);
                    timer.cancel();
                    changeString(stringarr, colorarr);
                    createTimer();
                    break;
            }
        }
        if (color.getText().equals("Черный")) {
            switch(color.getCurrentTextColor()) {
                case Color.RED:
                case Color.BLUE:
                case Color.YELLOW:
                case Color.GREEN:
                    mistake++;
                    showNo(l);
                    timer.cancel();
                    changeString(stringarr, colorarr);
                    createTimer();
                    break;
                case Color.BLACK:
                    points++;
                    showYes(l);
                    timer.cancel();
                    changeString(stringarr, colorarr);
                    createTimer();
                    break;
            }
        }
    }
    public void dealWithButtonClick2(Button no) {
        if (color.getText().equals("Красный")) {
            switch(color.getCurrentTextColor()) {
                case Color.BLACK:
                case Color.BLUE:
                case Color.YELLOW:
                case Color.GREEN:
                    points++;
                    showYes(l);
                    timer.cancel();
                    changeString(stringarr, colorarr);
                    createTimer();
                    break;
                case Color.RED:
                    mistake++;
                    showNo(l);
                    timer.cancel();
                    changeString(stringarr, colorarr);
                    createTimer();
                    break;
            }
        }
        if (color.getText().equals("Желтый")) {
            switch(color.getCurrentTextColor()) {
                case Color.BLACK:
                case Color.BLUE:
                case Color.RED:
                case Color.GREEN:
                    points++;
                    showYes(l);
                    timer.cancel();
                    changeString(stringarr, colorarr);
                    createTimer();
                    break;
                case Color.YELLOW:
                    mistake++;
                    showNo(l);
                    timer.cancel();
                    changeString(stringarr, colorarr);
                    createTimer();
                    break;
            }
        }
        if (color.getText().equals("Зеленый")) {
            switch(color.getCurrentTextColor()) {
                case Color.BLACK:
                case Color.BLUE:
                case Color.YELLOW:
                case Color.RED:
                    points++;
                    showYes(l);
                    timer.cancel();
                    changeString(stringarr, colorarr);
                    createTimer();
                    break;
                case Color.GREEN:
                    mistake++;
                    showNo(l);
                    timer.cancel();
                    changeString(stringarr, colorarr);
                    createTimer();
                    break;
            }
        }
        if (color.getText().equals("Синий")) {
            switch(color.getCurrentTextColor()) {
                case Color.BLACK:
                case Color.RED:
                case Color.YELLOW:
                case Color.GREEN:
                    points++;
                    showYes(l);
                    timer.cancel();
                    changeString(stringarr, colorarr);
                    createTimer();
                    break;
                case Color.BLUE:
                    mistake++;
                    showNo(l);
                    timer.cancel();
                    changeString(stringarr, colorarr);
                    createTimer();
                    break;
            }
        }
        if (color.getText().equals("Черный")) {
            switch(color.getCurrentTextColor()) {
                case Color.RED:
                case Color.BLUE:
                case Color.YELLOW:
                case Color.GREEN:
                    points++;
                    showYes(l);
                    timer.cancel();
                    changeString(stringarr, colorarr);
                    createTimer();
                    break;
                case Color.BLACK:
                    mistake++;
                    showNo(l);
                    timer.cancel();
                    changeString(stringarr, colorarr);
                    createTimer();
                    break;
            }
        }
    }
}