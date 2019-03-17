package com.timmyg.quiz.timmygquiz;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {

    private TextView question_textview;
    private Button trueButton;
    private Button falseButton;
    private Button nextButton;

    private Question[] questionBank = new Question[]{
      new Question(R.string.tis, true),
      new Question(R.string.gorshkov, false),
      new Question(R.string.lokotkova, false),
      new Question(R.string.nelly, true),
      new Question(R.string.baturlova, false),
    };

    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        question_textview = (TextView)findViewById(R.id.question_text_view);
        updateQuestion();

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

        nextButton = (Button)findViewById(R.id.next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex = (currentIndex+1)%questionBank.length;
                updateQuestion();
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
