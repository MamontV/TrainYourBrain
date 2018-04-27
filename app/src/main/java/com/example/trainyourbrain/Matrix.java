package com.example.trainyourbrain;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.trainyourbrain.R;

import java.util.ArrayList;
import java.util.Collections;

public class Matrix extends AppCompatActivity {
    int number = 3;
    ArrayList<Button> buttonList, buttonList2;
    LinearLayout one, two, three, four, main;
    int mistake = 0;
    int time = 0;
    AlertDialog.Builder ad;
    int points = 0;
    int id;
    int method = 1;
    String message2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.matrix_one);
        main = (LinearLayout) findViewById(R.id.mainview);
        main.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (time == 0) {
                    createBoard();
                    time++;
                }
            }
        });
        ad = new AlertDialog.Builder(this);
        ad.setPositiveButton(R.string.game, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int arg1) {
                points = 0;
                mistake = 0;
                createBoard();
            }
        });
        ad.setNegativeButton(R.string.menu, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int arg1) {
            }
        });
        ad.setCancelable(false);
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
        buttonList = new ArrayList<>();
        one = (LinearLayout) findViewById(R.id.one);
        two = (LinearLayout) findViewById(R.id.two);
        three = (LinearLayout) findViewById(R.id.three);
        id = 1;
        //Создание кнопок
        for (int i = 0; i < 9; i++) {
            final Button b = new Button(this);
            b.setGravity(Gravity.CENTER_HORIZONTAL);
            b.setId(generateUniqueId());
            if (id < 5)
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
        //Вывод на экран
        for (int i = 0; i < 9; i++) {
            if (i < 3) {
                one.addView(buttonList.get(i));
            }
            else if (i > 2 && i < 6) {
                two.addView(buttonList.get(i));
            }
            else {
                three.addView(buttonList.get(i));
            }
        }
        new CountDownTimer(3000, 1000) {
            public void onTick(long millisUntilFinished) {
            }
            public void onFinish() {
                makeWhite();
            }
        }
                .start();
    }

    public void createNextBoard() {
        setContentView(R.layout.matrix_two);
        buttonList2 = new ArrayList<>();
        one = (LinearLayout) findViewById(R.id.one);
        two = (LinearLayout) findViewById(R.id.two);
        three = (LinearLayout) findViewById(R.id.three);
        four = (LinearLayout) findViewById(R.id.four);
        id = 1;
        method = 2;
        number = 4;
        //Создание кнопок
        for (int i = 0; i < 12; i++) {
            final Button b = new Button(this);
            b.setGravity(Gravity.CENTER_HORIZONTAL);
            b.setId(generateUniqueId());
            if (id < 6)
                b.setBackgroundResource(R.drawable.backb);
            else
                b.setBackgroundResource(R.drawable.back);
            b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    OnClick(b);
                }
            });
            buttonList2.add(b);
        }

        Collections.shuffle(buttonList2);
        //Вывод на экран
        for (int i = 0; i < 12; i++) {
            if (i < 3) {
                one.addView(buttonList2.get(i));
            } else if (i > 2 && i < 6) {
                two.addView(buttonList2.get(i));
            } else if (i > 5 && i < 9) {
                three.addView(buttonList2.get(i));
            } else {
                four.addView(buttonList2.get(i));
            }
        }
        new CountDownTimer(3000, 1000) {
            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                for (int i = 0; i < 12; i++) {
                    if (buttonList2.get(i).getId() < 6) {
                        buttonList2.get(i).setBackgroundResource(R.drawable.back);
                    }
                }
            }
        }
                .start();
    }
    public void OnClick(Button b) {
        if (method == 1) {
            switch (b.getId()) {
                case 1:
                case 2:
                case 3:
                    number--;
                    points++;
                    b.setBackgroundResource(R.drawable.backb);
                    if (number == 0) {
                        showYes(main);
                        createNextBoard();
                    }
                    break;
                default:
                    mistake++;
                    showNo(main);
                    createNextBoard();
                    if (mistake == 3) {
                        message2 = String.valueOf("Очки: " + points + " Рекорд: ");
                        ad.setMessage(message2);
                        ad.show();
                    }
                    break;
            }
        }
        else if (method == 2) {
            switch (b.getId()) {
                case 1:
                case 2:
                case 3:
                case 4:
                    number--;
                    points++;
                    b.setBackgroundResource(R.drawable.backb);
                    if (number == 0) {
                        showYes(main);
                        createNextBoard();
                    }
                    break;
                default:
                    mistake++;
                    showNo(main);
                    createNextBoard();
                    if (mistake == 3) {
                        message2 = String.valueOf("Очки: " + points + " Рекорд: ");
                        ad.setMessage(message2);
                        ad.show();
                    }
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
    public void makeWhite() {
        for (int i = 0; i < 9; i++) {
            if (buttonList.get(i).getId() == 1) {
                buttonList.get(i).setBackgroundResource(R.drawable.back);
            }
            else if (buttonList.get(i).getId() == 2) {
                buttonList.get(i).setBackgroundResource(R.drawable.back);
            }
            else if (buttonList.get(i).getId() == 3) {
                buttonList.get(i).setBackgroundResource(R.drawable.back);
            }
        }
    }
}