package com.example.myquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView t1,t2,t3;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        t1 = (TextView) findViewById(R.id.tx1);
        t2 = (TextView) findViewById(R.id.tx2);
        t3 = (TextView) findViewById(R.id.tx3);

        Intent i = getIntent();
        String questions = i.getStringExtra("total");
        String correct = i.getStringExtra("correct");
        String wrong = i.getStringExtra("incorrect");

        t1.setText(questions);
        t2.setText(correct);
        t3.setText(wrong);

        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j = new Intent(ResultActivity.this, lastActivity.class);
                startActivity(j);
            }
        });
    }
}