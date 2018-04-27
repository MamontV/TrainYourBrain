package com.example.trainyourbrain;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class SchulteTable extends Activity {
    int number = 1;
    int colour = 1;
    AlertDialog.Builder ad;
    private Chronometer mChronometer;
    long rec = 1000;
    ArrayList buttonList;
    LinearLayout one, two, three, four;
    TextView myname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table);
        buttonList = new ArrayList<>();
        one = (LinearLayout) findViewById(R.id.one);
        two = (LinearLayout) findViewById(R.id.two);
        three = (LinearLayout) findViewById(R.id.three);
        four = (LinearLayout) findViewById(R.id.four);
        createFirstBoard();
        mChronometer = (Chronometer) findViewById(R.id.time);
        mChronometer.setBase(SystemClock.elapsedRealtime());
        mChronometer.start();
        myname = (TextView) findViewById(R.id.myname);
    }

    public void dealWithButtonClick(Button b) {
        if (colour == 1) {
            if (number == 1) {
                switch (b.getId()) {
                    case 1:
                        number = 8;
                        colour = 2;
                        myname.setText("Следующее число: " + number);
                        myname.setTextColor(Color.RED);
                        break;
                }
            }
            if (number == 2) {
                switch (b.getId()) {
                    case 2:
                        number = 7;
                        colour = 2;
                        myname.setText("Следующее число: " + number);
                        myname.setTextColor(Color.RED);
                        break;
                }
            }
            if (number == 3) {
                switch (b.getId()) {
                    case 3:
                        number = 6;
                        colour = 2;
                        myname.setText("Следующее число: " + number);
                        myname.setTextColor(Color.RED);
                        break;
                }
            }
            if (number == 4) {
                switch (b.getId()) {
                    case 4:
                        number = 5;
                        colour = 2;
                        myname.setText("Следующее число: " + number);
                        myname.setTextColor(Color.RED);
                        break;
                }
            }
            if (number == 5) {
                switch (b.getId()) {
                    case 5:
                        number = 4;
                        colour = 2;
                        myname.setText("Следующее число: " + number);
                        myname.setTextColor(Color.RED);
                        break;
                }
            }
            if (number == 6) {
                switch (b.getId()) {
                    case 6:
                        number = 3;
                        colour = 2;
                        myname.setText("Следующее число: " + number);
                        myname.setTextColor(Color.RED);
                        break;
                }
            }
            if (number == 7) {
                switch (b.getId()) {
                    case 7:
                        number = 2;
                        colour = 2;
                        myname.setText("Следующее число: " + number);
                        myname.setTextColor(Color.RED);
                        break;
                }}
            if (number == 8) {
                switch (b.getId()) {
                    case 8:
                        number = 1;
                        colour = 2;
                        myname.setText("Следующее число: " + number);
                        myname.setTextColor(Color.RED);
                        break;
                }}
        }
        if (colour == 2) {
            if (number == 8) {
                switch (b.getId()) {
                    case 16:
                        number = 2;
                        colour = 1;
                        myname.setText("Следующее число: " + number);
                        myname.setTextColor(Color.BLACK);
                        break;
                }
            }
            if (number == 7) {
                switch (b.getId()) {
                    case 15:
                        number = 3;
                        colour = 1;
                        myname.setText("Следующее число: " + number);
                        myname.setTextColor(Color.BLACK);
                        break;
                }
            }
            if (number == 6) {
                switch (b.getId()) {
                    case 14:
                        number = 4;
                        colour = 1;
                        myname.setText("Следующее число: " + number);
                        myname.setTextColor(Color.BLACK);
                        break;
                }
            }
            if (number == 5) {
                switch (b.getId()) {
                    case 13:
                        number = 5;
                        colour = 1;
                        myname.setText("Следующее число: " + number);
                        myname.setTextColor(Color.BLACK);
                        break;
                }
            }
            if (number == 4) {
                switch (b.getId()) {
                    case 12:
                        number = 6;
                        colour = 1;
                        myname.setText("Следующее число: " + number);
                        myname.setTextColor(Color.BLACK);
                        break;
                }
            }
            if (number == 3) {
                switch (b.getId()) {
                    case 11:
                        number = 7;
                        colour = 1;
                        myname.setText("Следующее число: " + number);
                        myname.setTextColor(Color.BLACK);
                        break;
                }
            }
            if (number == 2) {
                switch (b.getId()) {
                    case 10:
                        number = 8;
                        colour = 1;
                        myname.setText("Следующее число: " + number);
                        myname.setTextColor(Color.BLACK);
                        break;
                }
            }
            if (number == 1) {
                switch (b.getId()) {
                    case 9:
                        mChronometer.stop();
                        long elapsedMillis = SystemClock.elapsedRealtime() - mChronometer.getBase();
                        long time = elapsedMillis / 1000;
                        if (rec > time) {
                            rec = time;
                        }
                        ad = new AlertDialog.Builder(this);
                        ad.setMessage("Время: " + time + " Рекорд: " + rec);
                        ad.setPositiveButton(R.string.game, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int arg1) {
                                mChronometer.setBase(SystemClock.elapsedRealtime());
                            }
                        });
                        ad.setNegativeButton(R.string.menu, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int arg1) {

                            }
                        });
                        ad.show();
                        break;
                }
            }
        }
    }

    public void createFirstBoard() {

        for (int i = 0; i < 8; i++) {
            final Button b = new Button(this);
            b.setId(generateUniqueId());
            b.setBackgroundColor(Color.BLACK);
            b.setText("" + (i + 1));
            b.setTextColor(Color.WHITE);
            b.setGravity(Gravity.CENTER_HORIZONTAL);
            b.setLayoutParams(new LinearLayout.LayoutParams(120, 120));
            b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    dealWithButtonClick(b);
                }
            });
            buttonList.add(b);
        }

        for (int i = 0; i < 8; i++) {
            final Button b = new Button(this);
            b.setId(generateUniqueId());
            b.setBackgroundResource(R.drawable.redback);
            b.setText("" + (i + 1));
            b.setTextColor(Color.WHITE);
            b.setGravity(Gravity.CENTER_HORIZONTAL);
            b.setLayoutParams(new LinearLayout.LayoutParams(120, 120));
            b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    dealWithButtonClick(b);
                }
            });
            buttonList.add(b);
        }


        Collections.shuffle(buttonList);

        //Вывод на экран
        for (int i = 0; i < 16; i++) {
            if (i < 4) {
                one.addView((View) buttonList.get(i));
            } else if (i > 3 && i < 8) {
                two.addView((View) buttonList.get(i));
            } else if (i > 7 && i < 12) {
                three.addView((View) buttonList.get(i));
            } else {
                four.addView((View) buttonList.get(i));
            }
        }
    }

    int id = 1;
    public int generateUniqueId() {
        View v = findViewById(id);
        while (v != null) {
            v = findViewById(++id);
        }
        return id++;
    }
}