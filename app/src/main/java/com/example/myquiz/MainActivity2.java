
package com.example.myquiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myquiz.Model.Question;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.net.HttpCookie;

public class MainActivity2 extends AppCompatActivity {
    Button b1,b2,b3,b4;
    TextView t1_question,timerTxt;
    int total=0;
    int correct = 0;
    int wrong = 0;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        b1 = (Button) findViewById(R.id.button12);
        b2 = (Button) findViewById(R.id.button22);
        b3 = (Button) findViewById(R.id.button32);
        b4 = (Button) findViewById(R.id.button42);

        t1_question = (TextView) findViewById(R.id.questionTxt2);
        timerTxt = (TextView) findViewById(R.id.timerTxt2);

        updateQuestion();
        reverseTimer(30,timerTxt);



    }

    private void updateQuestion()
    {
        total++;
        if(total >7)
        {
            Intent f = new Intent(MainActivity2.this, ResultActivity.class);
            f.putExtra("total",String.valueOf(total));
            f.putExtra("correct",String.valueOf(correct));
            f.putExtra("incorrect",String.valueOf(wrong));
            startActivity(f);

        }
        else
        {
            reference = FirebaseDatabase.getInstance().getReference().child("Questions2").child(String.valueOf(total));
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    Question question = dataSnapshot.getValue(Question.class);
                    t1_question.setText(question.getQuestion());
                    b1.setText(question.getOption1());
                    b2.setText(question.getOption2());
                    b3.setText(question.getOption3());
                    b4.setText(question.getOption4());

                    b1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if(b1.getText().toString().equals(question.getAnswer())){
                                b1.setBackgroundColor(getResources().getColor(R.color.correctColor));

                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        b1.setBackgroundColor(Color.parseColor("#03A9F4"));

                                        updateQuestion(); //another question will be appload


                                    }
                                },1500);
                            }
                            else{
                                //answer is wrong we will find the correct answer and make it green
                                wrong++;
                                b1.setBackgroundColor(getResources().getColor(R.color.falseColor));


                                if(b2.getText().toString().equals(question.getAnswer())){
                                    b2.setBackgroundColor(getResources().getColor(R.color.correctColor));

                                }
                                else if(b3.getText().toString().equals(question.getAnswer())){
                                    b3.setBackgroundColor(getResources().getColor(R.color.correctColor));

                                }
                                else if(b4.getText().toString().equals(question.getAnswer())){
                                    b4.setBackgroundColor(getResources().getColor(R.color.correctColor));

                                }

                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        b1.setBackgroundColor(getResources().getColor(R.color.purple_500));
                                        b2.setBackgroundColor(getResources().getColor(R.color.purple_500));
                                        b3.setBackgroundColor(getResources().getColor(R.color.purple_500));
                                        b4.setBackgroundColor(getResources().getColor(R.color.purple_500));
                                        updateQuestion();
                                    }
                                }, 1500);
                            }
                        }
                    });



                    b2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if(b2.getText().toString().equals(question.getAnswer())){
                                b2.setBackgroundColor(getResources().getColor(R.color.correctColor));

                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        b1.setBackgroundColor(getResources().getColor(R.color.purple_500));
                                        b2.setBackgroundColor(getResources().getColor(R.color.purple_500));
                                        b3.setBackgroundColor(getResources().getColor(R.color.purple_500));
                                        b4.setBackgroundColor(getResources().getColor(R.color.purple_500));

                                        updateQuestion(); //another question will be appload


                                    }
                                },1500);
                            }
                            else{
                                //answer is wrong we will find the correct answer and make it green
                                wrong++;
                                b2.setBackgroundColor(getResources().getColor(R.color.falseColor));


                                if(b1.getText().toString().equals(question.getAnswer())){
                                    b1.setBackgroundColor(getResources().getColor(R.color.correctColor));

                                }
                                else if(b3.getText().toString().equals(question.getAnswer())){
                                    b3.setBackgroundColor(getResources().getColor(R.color.correctColor));

                                }
                                else if(b4.getText().toString().equals(question.getAnswer())){
                                    b4.setBackgroundColor(getResources().getColor(R.color.correctColor));

                                }

                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        b1.setBackgroundColor(getResources().getColor(R.color.purple_500));
                                        b2.setBackgroundColor(getResources().getColor(R.color.purple_500));
                                        b3.setBackgroundColor(getResources().getColor(R.color.purple_500));
                                        b4.setBackgroundColor(getResources().getColor(R.color.purple_500));
                                        updateQuestion();
                                    }
                                }, 1500);
                            }

                        }
                    });



                    b3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if(b3.getText().toString().equals(question.getAnswer())){
                                b3.setBackgroundColor(getResources().getColor(R.color.correctColor));

                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        b1.setBackgroundColor(getResources().getColor(R.color.purple_500));
                                        b2.setBackgroundColor(getResources().getColor(R.color.purple_500));
                                        b3.setBackgroundColor(getResources().getColor(R.color.purple_500));
                                        b4.setBackgroundColor(getResources().getColor(R.color.purple_500));

                                        updateQuestion(); //another question will be appload


                                    }
                                },1500);
                            }
                            else{
                                //answer is wrong we will find the correct answer and make it green
                                wrong++;
                                b3.setBackgroundColor(getResources().getColor(R.color.falseColor));


                                if(b1.getText().toString().equals(question.getAnswer())){
                                    b1.setBackgroundColor(getResources().getColor(R.color.correctColor));

                                }
                                else if(b2.getText().toString().equals(question.getAnswer())){
                                    b2.setBackgroundColor(getResources().getColor(R.color.correctColor));

                                }
                                else if(b4.getText().toString().equals(question.getAnswer())){
                                    b4.setBackgroundColor(getResources().getColor(R.color.correctColor));

                                }

                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        b1.setBackgroundColor(getResources().getColor(R.color.purple_500));
                                        b2.setBackgroundColor(getResources().getColor(R.color.purple_500));
                                        b3.setBackgroundColor(getResources().getColor(R.color.purple_500));
                                        b4.setBackgroundColor(getResources().getColor(R.color.purple_500));
                                        updateQuestion();
                                    }
                                }, 1500);
                            }

                        }
                    });


                    b4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if(b4.getText().toString().equals(question.getAnswer())){
                                b4.setBackgroundColor(getResources().getColor(R.color.correctColor));

                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        b1.setBackgroundColor(getResources().getColor(R.color.purple_500));
                                        b2.setBackgroundColor(getResources().getColor(R.color.purple_500));
                                        b3.setBackgroundColor(getResources().getColor(R.color.purple_500));
                                        b4.setBackgroundColor(getResources().getColor(R.color.purple_500));

                                        updateQuestion(); //another question will be appload


                                    }
                                },1500);
                            }
                            else{
                                //answer is wrong we will find the correct answer and make it green
                                wrong++;
                                b4.setBackgroundColor(getResources().getColor(R.color.falseColor));


                                if(b1.getText().toString().equals(question.getAnswer())){
                                    b1.setBackgroundColor(getResources().getColor(R.color.correctColor));

                                }
                                else if(b2.getText().toString().equals(question.getAnswer())){
                                    b2.setBackgroundColor(getResources().getColor(R.color.correctColor));

                                }
                                else if(b3.getText().toString().equals(question.getAnswer())){
                                    b3.setBackgroundColor(getResources().getColor(R.color.correctColor));

                                }

                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        b1.setBackgroundColor(getResources().getColor(R.color.purple_500));
                                        b2.setBackgroundColor(getResources().getColor(R.color.purple_500));
                                        b3.setBackgroundColor(getResources().getColor(R.color.purple_500));
                                        b4.setBackgroundColor(getResources().getColor(R.color.purple_500));
                                        updateQuestion();
                                    }
                                }, 1500);
                            }

                        }
                    });


                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
    }
    public void reverseTimer(int seconds,final TextView tv)
    {
        new CountDownTimer(seconds* 1000+1000, 1000){
            @Override
            public void onTick(long millisUntilFinished) {
                int seconds = (int) (millisUntilFinished / 1000);
                int minutes = seconds / 60;
                seconds = seconds % 60;
                tv.setText(String.format("%02d", minutes)
                        + ":" + String.format("%02d", seconds));
            }

            @Override
            public void onFinish() {
                tv.setText("Fin");
                Intent myIntent = new Intent(MainActivity2.this, ResultActivity.class);
                myIntent.putExtra("total",String.valueOf(total));
                myIntent.putExtra("correct",String.valueOf(correct));
                myIntent.putExtra("incorrect",String.valueOf(wrong));
                startActivity(myIntent);
            }
        }.start();
    }
}