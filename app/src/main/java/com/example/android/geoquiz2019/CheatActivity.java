package com.example.android.geoquiz2019;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

    TextView answerTextView; // declare member variable (outside of any method)


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        answerTextView = (TextView) findViewById(R.id.answer_text_view); // initialized onCreate() method

        Intent myIntent = getIntent();
        Question q = (Question) myIntent.getSerializableExtra(Keys.QUESTION_KEY);
        answerTextView.setText(q.getTextResId());

    }
}
