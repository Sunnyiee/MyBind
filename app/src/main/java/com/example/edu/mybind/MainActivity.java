package com.example.edu.mybind;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button2);
        button.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent intent=new Intent(this, Main2Activity.class);
        startActivity(intent);
    }
}
