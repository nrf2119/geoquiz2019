package com.example.android.geoquiz2019;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button trueButton;
    private Button falseButton;
    private TextView questionTextView;
    private ArrayList<Question> questionBank = new ArrayList<>();
    private int currentIndex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        trueButton = findViewById(R.id.true_button);
        falseButton = findViewById(R.id.false_button);
        questionTextView = findViewById(R.id.question_text_view);

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
            }
        });

        questionBank.add(new Question(R.string.question_australia, true));
        questionBank.add(new Question(R.string.question_ocean, true));
        questionBank.add(new Question(R.string.question_mideast, false));
        questionBank.add(new Question(R.string.question_africa, false));
        questionBank.add(new Question(R.string.question_americas, true));

    }

    public void updateQuestion(View view) {
        currentIndex++;
        if (currentIndex >= questionBank.size()){
            currentIndex = 0;
            Toast.makeText(this, "Back to the beginning", Toast.LENGTH_SHORT).show();
        }
        Question q = questionBank.get(currentIndex);
        questionTextView.setText(q.getTextResId());
    }


    public void clickCheat(View view) {
        Intent mrIntent = new Intent(this, CheatActivity.class);
        Question question = questionBank.get(currentIndex);
        mrIntent.putExtra(Keys.QUESTION_KEY, question);
        startActivity(mrIntent);
    }
}
