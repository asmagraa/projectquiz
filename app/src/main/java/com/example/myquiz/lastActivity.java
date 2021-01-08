package com.example.myquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class lastActivity extends AppCompatActivity {
    Button b1,b2;
    TextView tx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);


        b1 = (Button) findViewById(R.id.boutton1);
        b2 = (Button) findViewById(R.id.SignOut);
        tx = (TextView) findViewById(R.id.cvdeposer);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent r = new Intent(lastActivity.this, offreActivity.class);
                startActivity(r);
            }
        });

        tx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent n = new Intent(lastActivity.this, uploadActivity.class);
                startActivity(n);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent i = new Intent(lastActivity.this,accueilActivity.class);
                startActivity(i);

            }
        });

    }
}