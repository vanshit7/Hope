package com.example.vanshit.minihope;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    public Button but1;
    public Button but2;
    public void init(){
        but1 = (Button)findViewById(R.id.sec1but);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent act1 = new Intent(MainActivity.this,Section1.class);
                startActivity(act1);
            }
        });
        but2 = (Button)findViewById(R.id.sec2but);
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent act2 = new Intent(MainActivity.this,Section2.class);
                startActivity(act2);
            }
        });

    }

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
}
