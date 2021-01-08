package com.example.myquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class accueilActivity extends AppCompatActivity {
    public static int selected_cat_index;
    private Button commencer;
    private TextView appName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        appName = findViewById(R.id.appName);
        Animation anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.myanim);
        appName.setAnimation(anim);


        commencer = (Button) findViewById(R.id.commencer);
        commencer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openMainActivity();
            }
        });
    }
    public void openMainActivity(){
        Intent intent = new Intent(this, loginActivity.class);
        startActivity(intent);
    }
}