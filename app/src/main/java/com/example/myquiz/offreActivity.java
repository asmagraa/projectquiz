package com.example.myquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class offreActivity extends AppCompatActivity {
    private Button btnn1,btnn2,btnn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offre);
        btnn1 = (Button) findViewById(R.id.btnn1);
        btnn2 = (Button) findViewById(R.id.btnn2);
        btnn3 = (Button) findViewById(R.id.btnn3);
        btnn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent s = new Intent(offreActivity.this, MainActivity.class);
                startActivity(s);
            }
        });

        btnn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent l = new Intent(offreActivity.this,MainActivity2.class);
                startActivity(l);
            }
        });

        btnn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent u = new Intent(offreActivity.this, MainActivity3.class);
                startActivity(u);
            }
        });
    }
}