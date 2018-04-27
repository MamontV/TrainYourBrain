package com.example.trainyourbrain;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TableInfo extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tableinfo);
        Button play = (Button) findViewById(R.id.play);
        Button rules = (Button) findViewById(R.id.rules);
        play.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(TableInfo.this, SchulteTable.class);
                startActivity(intent);
            }
        });
        rules.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(TableInfo.this, TableRules.class);
                startActivity(intent);
            }
        });
    }
}