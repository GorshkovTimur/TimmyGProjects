package com.timmyg.quiz.timmygquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private TextView question_textview;
    private Button trueButton;
    private Button falseButton;
    private ImageButton nextButton;
    private ImageButton prevButton;

    private Question[] questionBank = new Question[]{
      new Question(R.string.square, true),
      new Question(R.string.java, false),
      new Question(R.string.android, false),
      new Question(R.string.oop, true),
      new Question(R.string.python, false),
    };

    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        question_textview = (TextView)findViewById(R.id.question_text_view);
        updateQuestion();
        question_textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex = (currentIndex+1)%questionBank.length;
                updateQuestion();
            }
        });

        trueButton=(Button)findViewById(R.id.true_button);
        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chechAnswer(true);
            }
        });

        falseButton=(Button)findViewById(R.id.false_button);
        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chechAnswer(false);
            }
        });

        nextButton = (ImageButton)findViewById(R.id.next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex = (currentIndex+1)%questionBank.length;
                updateQuestion();
            }
        });

        prevButton = (ImageButton)findViewById(R.id.prev_button);
        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentIndex == 0) {
                    currentIndex = questionBank.length;
                } else {
                    currentIndex = currentIndex-1;
                    updateQuestion();
                }
            }
        });

    }

    private void updateQuestion() {
        int question = questionBank[currentIndex].getTextResId();
        question_textview.setText(question);
    }

    private void chechAnswer(boolean userPressedTrue){
        boolean answerIsTrue = questionBank[currentIndex].isAnswerTrue();

        int messageResId = 0;

        if (userPressedTrue == answerIsTrue){
            messageResId = R.string.correct_toast;
        } else {
            messageResId = R.string.incorrect_toast;
        }
        Toast.makeText(this,messageResId,Toast.LENGTH_SHORT).show();
    }
}
