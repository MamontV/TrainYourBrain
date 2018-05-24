package com.example.trainyourbrain;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class Matrix extends Activity {
    int number = 3;
    int id, record;
    int buttonCount = 9;
    ArrayList<Button> buttonList;
    LinearLayout one, two, three, four, main, five, six, seven;
    int mistake, points;
    AlertDialog.Builder ad;
    int method = 1;
    String message;
    SharedPreferences pref;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        buttonList = new ArrayList<>();
        pref = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        main = (LinearLayout) findViewById(R.id.mainview);
        createBoard();
        ad = new AlertDialog.Builder(this);
        ad.setPositiveButton(R.string.game, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int arg1) {
                points = 0;
                mistake = 0;
                number = 3;
                method = 1;
                buttonCount = 9;
                createBoard();
            }
        });
        ad.setNegativeButton(R.string.menu, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int arg1) {
                Intent intent = new Intent(Matrix.this, MainActivity.class);
                startActivity(intent);
            }
        });
        ad.setCancelable(false);
    }
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("Matrix", record);
        editor.apply();
    }
    protected void onResume() {
        super.onResume();
        if (pref.contains("Matrix")) {
            record = pref.getInt("Matrix", 0);
        }
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

    public void createBoard() {
        if (mistake == 3) {
            if (points > record) {
                record = points;
            }
            message = String.valueOf(getString(R.string.points) + " " + points + getString(R.string.rec) + " " + record);
            ad.setMessage(message);
            ad.show();
        }
        setContentView(R.layout.matrix);
        buttonList.clear();
        one = (LinearLayout) findViewById(R.id.one);
        two = (LinearLayout) findViewById(R.id.two);
        three = (LinearLayout) findViewById(R.id.three);
        four = (LinearLayout) findViewById(R.id.four);
        five = (LinearLayout) findViewById(R.id.five);
        six = (LinearLayout) findViewById(R.id.six);
        seven = (LinearLayout) findViewById(R.id.seven);
        id = 0;
        //Создание кнопок
        for (int i = 0; i < buttonCount; i++) {
            final Button b = new Button(this);
            b.setGravity(Gravity.CENTER_HORIZONTAL);
            b.setId(generateUniqueId());
            b.setLayoutParams(new LinearLayout.LayoutParams(100, 100));
            if (b.getId() < number)
                b.setBackgroundResource(R.drawable.backb);
            else
                b.setBackgroundResource(R.drawable.back);
            b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    OnClick(b);
                }
            });
            buttonList.add(b);
        }
        Collections.shuffle(buttonList);
        if (method == 1) {
            //Вывод на экран
            for (int i = 0; i < buttonCount; i++) {
                if (i < 3) {
                    one.addView(buttonList.get(i));
                } else if (i > 2 && i < 6) {
                    two.addView(buttonList.get(i));
                } else {
                    three.addView(buttonList.get(i));
                }
            }
        } else if (method == 2) {
            for (int i = 0; i < buttonCount; i++) {
                if (i < 3) {
                    one.addView(buttonList.get(i));
                } else if (i > 2 && i < 6) {
                    two.addView(buttonList.get(i));
                } else if (i > 5 && i < 9) {
                    three.addView(buttonList.get(i));
                } else {
                    four.addView(buttonList.get(i));
                }
            }
        } else if (method == 3) {
            for (int i = 0; i < buttonCount; i++) {
                if (i < 4) {
                    one.addView(buttonList.get(i));
                } else if (i > 3 && i < 8) {
                    two.addView(buttonList.get(i));
                } else if (i > 7 && i < 12) {
                    three.addView(buttonList.get(i));
                } else {
                    four.addView(buttonList.get(i));
                }
            }
        } else if (method == 4) {
            for (int i = 0; i < buttonCount; i++) {
                if (i < 5) {
                    one.addView(buttonList.get(i));
                } else if (i > 4 && i < 10) {
                    two.addView(buttonList.get(i));
                } else if (i > 9 && i < 15) {
                    three.addView(buttonList.get(i));
                } else {
                    four.addView(buttonList.get(i));
                }
            }
        } else if (method == 5) {
            for (int i = 0; i < buttonCount; i++) {
                if (i < 5) {
                    one.addView(buttonList.get(i));
                } else if (i > 4 && i < 10) {
                    two.addView(buttonList.get(i));
                } else if (i > 9 && i < 15) {
                    three.addView(buttonList.get(i));
                } else if (i > 14 && i < 20) {
                    four.addView(buttonList.get(i));
                } else {
                    five.addView(buttonList.get(i));
                }
            }
        } else if (method == 6) {
            for (int i = 0; i < buttonCount; i++) {
                if (i < 6) {
                    one.addView(buttonList.get(i));
                } else if (i > 5 && i < 12) {
                    two.addView(buttonList.get(i));
                } else if (i > 11 && i < 18) {
                    three.addView(buttonList.get(i));
                } else if (i > 17 && i < 24) {
                    four.addView(buttonList.get(i));
                } else {
                    five.addView(buttonList.get(i));
                }
            }
        } else if (method == 7) {
            for (int i = 0; i < buttonCount; i++) {
                if (i < 6) {
                    one.addView(buttonList.get(i));
                } else if (i > 5 && i < 12) {
                    two.addView(buttonList.get(i));
                } else if (i > 11 && i < 18) {
                    three.addView(buttonList.get(i));
                } else if (i > 17 && i < 24) {
                    four.addView(buttonList.get(i));
                } else if (i > 23 && i < 30) {
                    five.addView(buttonList.get(i));
                } else {
                    six.addView(buttonList.get(i));
                }
            }
        } else if (method == 8) {
            for (int i = 0; i < buttonCount; i++) {
                if (i < 7) {
                    one.addView(buttonList.get(i));
                } else if (i > 6 && i < 14) {
                    two.addView(buttonList.get(i));
                } else if (i > 13 && i < 21) {
                    three.addView(buttonList.get(i));
                } else if (i > 20 && i < 28) {
                    four.addView(buttonList.get(i));
                } else if (i > 27 && i < 35) {
                    five.addView(buttonList.get(i));
                } else {
                    six.addView(buttonList.get(i));
                }
            }
        } else if (method == 9) {
            for (int i = 0; i < buttonCount; i++) {
                if (i < 7) {
                    one.addView(buttonList.get(i));
                } else if (i > 6 && i < 14) {
                    two.addView(buttonList.get(i));
                } else if (i > 13 && i < 21) {
                    three.addView(buttonList.get(i));
                } else if (i > 20 && i < 28) {
                    four.addView(buttonList.get(i));
                } else if (i > 27 && i < 35) {
                    five.addView(buttonList.get(i));
                } else if (i > 34 && i < 42) {
                    six.addView(buttonList.get(i));
                } else {
                    seven.addView(buttonList.get(i));
                }
            }
        }
        new CountDownTimer(3000, 1000) {
            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                for (int i = 0; i < buttonCount; i++) {
                    if (buttonList.get(i).getId() < number) {
                        buttonList.get(i).setBackgroundResource(R.drawable.back);
                    }
                }
            }
        }
                .start();
    }

    public void OnClick(Button b) {
        if (method == 1) {
            switch (b.getId()) {
                case 0: case 1: case 2:
                    number--;
                    points++;
                    b.setBackgroundResource(R.drawable.backb);
                    if (number == 0) {
                        showYes(main);
                        method = 2;
                        buttonCount = 12;
                        number = 4;
                        createBoard();
                    }
                    break;
                default:
                    mistake++;
                    showNo(main);
                    method = 2;
                    buttonCount = 12;
                    number = 4;
                    createBoard();
                    break;
            }
        }
        else if (method == 2) {
            switch (b.getId()) {
                case 0: case 1: case 2: case 3:
                    number--;
                    points++;
                    b.setBackgroundResource(R.drawable.backb);
                    if (number == 0) {
                        showYes(main);
                        buttonCount = 16;
                        number = 5;
                        method = 3;
                        createBoard();
                    }
                    break;
                default:
                    mistake++;
                    showNo(main);
                    buttonCount = 16;
                    number = 5;
                    method = 3;
                    createBoard();
                    break;
            }
        }
        else if (method == 3) {
            switch (b.getId()) {
                case 1: case 2: case 3: case 4: case 0:
                    number--;
                    points++;
                    b.setBackgroundResource(R.drawable.backb);
                    if (number == 0) {
                        showYes(main);
                        buttonCount = 20;
                        number = 6;
                        method = 4;
                        createBoard();
                    }
                    break;
                default:
                    mistake++;
                    showNo(main);
                    buttonCount = 20;
                    number = 6;
                    method = 4;
                    createBoard();
                    break;
            }
        }
        else if (method == 4) {
            switch (b.getId()) {
                case 0: case 1: case 2: case 3: case 4: case 5:
                    number--;
                    points++;
                    b.setBackgroundResource(R.drawable.backb);
                    if (number == 0) {
                        showYes(main);
                        buttonCount = 25;
                        number = 7;
                        method = 5;
                        createBoard();
                    }
                    break;
                default:
                    mistake++;
                    showNo(main);
                    buttonCount = 25;
                    number = 7;
                    method = 5;
                    createBoard();
                    break;
            }
        }
        else if (method == 5) {
            switch (b.getId()) {
                case 1: case 2: case 3: case 4: case 5: case 6: case 0:
                    number--;
                    points++;
                    b.setBackgroundResource(R.drawable.backb);
                    if (number == 0) {
                        showYes(main);
                        buttonCount = 30;
                        number = 8;
                        method = 6;
                        createBoard();
                    }
                    break;
                default:
                    mistake++;
                    showNo(main);
                    buttonCount = 30;
                    number = 8;
                    method = 6;
                    createBoard();
                    break;
            }
        }
        else if (method == 6) {
            switch (b.getId()) {
                case 1: case 2: case 3: case 4: case 5: case 6: case 7: case 0:
                    number--;
                    points++;
                    b.setBackgroundResource(R.drawable.backb);
                    if (number == 0) {
                        showYes(main);
                        buttonCount = 36;
                        number = 9;
                        method = 7;
                        createBoard();
                    }
                    break;
                default:
                    mistake++;
                    showNo(main);
                    buttonCount = 36;
                    number = 9;
                    method = 7;
                    createBoard();
                    break;
            }
        }
        else if (method == 7) {
            switch (b.getId()) {
                case 1: case 2: case 3: case 4: case 5: case 6: case 7: case 8: case 0:
                    number--;
                    points++;
                    b.setBackgroundResource(R.drawable.backb);
                    if (number == 0) {
                        showYes(main);
                        buttonCount = 42;
                        number = 10;
                        method = 8;
                        createBoard();
                    }
                    break;
                default:
                    mistake++;
                    showNo(main);
                    buttonCount = 42;
                    number = 10;
                    method = 8;
                    createBoard();
                    break;
            }
        }
        else if (method == 8) {
            switch (b.getId()) {
                case 1: case 2: case 3: case 4: case 5: case 6: case 7: case 8: case 9: case 0:
                    number--;
                    points++;
                    b.setBackgroundResource(R.drawable.backb);
                    if (number == 0) {
                        showYes(main);
                        buttonCount = 49;
                        number = 11;
                        method = 9;
                        createBoard();
                    }
                    break;
                default:
                    mistake++;
                    showNo(main);
                    buttonCount = 49;
                    number = 11;
                    method = 9;
                    createBoard();
                    break;
            }
        }
        else if (method == 9) {
            switch (b.getId()) {
                case 1: case 2: case 3: case 4: case 5: case 6: case 7: case 8: case 9: case 10: case 0:
                    number--;
                    points++;
                    b.setBackgroundResource(R.drawable.backb);
                    if (number == 0) {
                        showYes(main);
                        buttonCount = 49;
                        number = 11;
                        method = 9;
                        createBoard();
                    }
                    break;
                default:
                    mistake++;
                    showNo(main);
                    buttonCount = 49;
                    number = 11;
                    method = 9;
                    createBoard();
                    break;
            }
        }
    }

    public int generateUniqueId(){
        View v = findViewById(id);
        while (v != null){
            v = findViewById(++id);
        }
        return id++;
    }
}