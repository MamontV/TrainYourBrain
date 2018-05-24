package com.example.trainyourbrain;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class Planes extends Activity {

    ImageView one, two, three;
    LinearLayout f;
    Animation anim, anim2, anim3;
    ArrayList<Float> arr;
    int mistake, id, points, record;
    Button left, right;
    AlertDialog.Builder ad;
    String message;
    SharedPreferences pref;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.planes);

        pref = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        f = (LinearLayout) findViewById(R.id.fr);
        one = (ImageView) findViewById(R.id.image1);
        two = (ImageView) findViewById(R.id.image2);
        three = (ImageView) findViewById(R.id.image3);
        left = (Button) findViewById(R.id.button);
        right = (Button) findViewById(R.id.button2);

        one.setVisibility(View.INVISIBLE);
        two.setVisibility(View.INVISIBLE);
        three.setVisibility(View.INVISIBLE);

        left.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dealWithButtonClick(left);
            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dealWithButtonClick2(right);
            }
        });
        arr = new ArrayList();
        arr.add((float) 0);
        arr.add((float) 180);
        mistake = 0;
        id = 0;

        ad = new AlertDialog.Builder(this);
        ad.setPositiveButton(R.string.game, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int arg1) {
                points = 0;
                mistake = 0;
            }
        });
        ad.setNegativeButton(R.string.menu, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int arg1) {
                Intent intent = new Intent(Planes.this, MainActivity.class);
                startActivity(intent);
            }
        });
        ad.setCancelable(false);
        choice();
    }
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("Planes", record);
        editor.apply();
    }
    protected void onResume() {
        super.onResume();
        if (pref.contains("Planes")) {
            record = pref.getInt("Planes", 0);
        }
    }

    public void choice() {
        if (mistake == 3) {
            if (points > record) {
                record = points;
            }
            message = String.valueOf(R.string.points + points + R.string.rec + record);
            ad.setMessage(message);
            ad.show();
        }
            int rand = 1 + (int) (Math.random() * 4);
            if (rand == 1)
                redright();
            else if (rand == 2)
                redleft();
            else if (rand == 3)
                greenright();
            else if (rand == 4)
                greenleft();
        }

    public void redright() {
        id = 1;
        one.setImageResource(R.drawable.redplane);
        two.setImageResource(R.drawable.redplane);
        three.setImageResource(R.drawable.redplane);
        anim = AnimationUtils.loadAnimation(this, R.anim.right1);
        anim2 = AnimationUtils.loadAnimation(this, R.anim.right2);
        anim3 = AnimationUtils.loadAnimation(this, R.anim.right3);
        Collections.shuffle(arr);
        one.setRotation(arr.get(0));
        two.setRotation(arr.get(0));
        three.setRotation(arr.get(0));
        one.startAnimation(anim);
        three.startAnimation(anim2);
        two.startAnimation(anim3);
    }
    public void redleft() {
        id = 2;
        one.setImageResource(R.drawable.redplane);
        two.setImageResource(R.drawable.redplane);
        three.setImageResource(R.drawable.redplane);
        anim = AnimationUtils.loadAnimation(this, R.anim.left1);
        anim2 = AnimationUtils.loadAnimation(this, R.anim.left2);
        anim3 = AnimationUtils.loadAnimation(this, R.anim.left3);
        Collections.shuffle(arr);
        one.setRotation(arr.get(0));
        two.setRotation(arr.get(0));
        three.setRotation(arr.get(0));
        one.startAnimation(anim);
        three.startAnimation(anim2);
        two.startAnimation(anim3);
    }
    public void greenright() {
        id = 3;
        one.setImageResource(R.drawable.greenplane);
        two.setImageResource(R.drawable.greenplane);
        three.setImageResource(R.drawable.greenplane);
        anim = AnimationUtils.loadAnimation(this, R.anim.right1);
        anim2 = AnimationUtils.loadAnimation(this, R.anim.right2);
        anim3 = AnimationUtils.loadAnimation(this, R.anim.right3);
        Collections.shuffle(arr);
        one.setRotation(arr.get(0));
        two.setRotation(arr.get(0));
        three.setRotation(arr.get(0));
        one.startAnimation(anim);
        three.startAnimation(anim2);
        two.startAnimation(anim3);
    }
    public void greenleft() {
        id = 4;
        one.setImageResource(R.drawable.greenplane);
        two.setImageResource(R.drawable.greenplane);
        three.setImageResource(R.drawable.greenplane);
        anim = AnimationUtils.loadAnimation(this, R.anim.left1);
        anim2 = AnimationUtils.loadAnimation(this, R.anim.left2);
        anim3 = AnimationUtils.loadAnimation(this, R.anim.left3);
        Collections.shuffle(arr);
        one.setRotation(arr.get(0));
        two.setRotation(arr.get(0));
        three.setRotation(arr.get(0));
        one.startAnimation(anim);
        three.startAnimation(anim2);
        two.startAnimation(anim3);
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

    public void dealWithButtonClick(Button left) {
        switch (id) {
            case 1:
                showNo(f);
                mistake++;
                choice();
                break;
            case 2:
                showYes(f);
                points++;
                choice();
                break;
            case 3:
            case 4:
                switch ((int) one.getRotation()) {
                    case 0:
                        showNo(f);
                        mistake++;
                        choice();
                        break;
                    case 180:
                        showYes(f);
                        points++;
                        choice();
                        break;
                }
        }
    }
    public void dealWithButtonClick2(Button right) {
        switch (id) {
            case 1:
                showYes(f);
                points++;
                choice();
                break;
            case 2:
                showNo(f);
                mistake++;
                choice();
                break;
            case 3:
            case 4:
                switch ((int) one.getRotation()) {
                    case 0:
                        showYes(f);
                        points++;
                        choice();
                        break;
                    case 180:
                        showNo(f);
                        mistake++;
                        choice();
                        break;
                }
        }
    }
}