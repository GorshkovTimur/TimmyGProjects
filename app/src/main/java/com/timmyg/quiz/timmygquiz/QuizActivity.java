package com.timmyg.quiz.timmygquiz;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private final String R_INDEX="R_INDEX";
    private final String QUESTION_COUNT="QUESTION_COUNT";

    private TextView question_textview;
    private Button trueButton;
    private Button falseButton;
    private ImageButton nextButton;
    private ImageButton prevButton;
    private List<Question> questList;
    private TextView textCounter;

    private int currentIndex = 0;

    private int rightQuestion=0;
    private int questionCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        questList = new DataBuilder(getResources()).build();
        questionCount=questList.size();

        textCounter = (TextView)findViewById(R.id.score);

        question_textview = (TextView)findViewById(R.id.question_text_view);


            updateQuestionByList();
            updateCounter();
            question_textview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    currentIndex = (currentIndex + 1) % questList.size();
                    updateQuestionByList();
                }
            });

            trueButton = (Button) findViewById(R.id.true_button);
            trueButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    chechAnswer(true);
                }
            });

            falseButton = (Button) findViewById(R.id.false_button);
            falseButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    chechAnswer(false);
                }
            });

            nextButton = (ImageButton) findViewById(R.id.next_button);
            nextButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    currentIndex = (currentIndex + 1) % questList.size();
                    updateQuestionByList();

                }
            });

            prevButton = (ImageButton) findViewById(R.id.prev_button);
            prevButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (currentIndex == 0) {
                        currentIndex = questList.size() - 1;

                    } else {
                        currentIndex = currentIndex - 1;

                    }
                    updateQuestionByList();
                }
            });
    }




    private void chechAnswer(boolean userPressedTrue){
        boolean answerIsTrue = questList.get(currentIndex).isAnswerTrue();

        int messageResId = 0;

        if (userPressedTrue == answerIsTrue){
            messageResId = R.string.correct_toast;
            rightQuestion++;
        } else {
            messageResId = R.string.incorrect_toast;
        }
        Toast.makeText(this,messageResId,Toast.LENGTH_SHORT).show();
        int tempIndex = currentIndex;
        currentIndex = (currentIndex+1)%questList.size();
        updateQuestionByList();
        updateCounter();
        questList.remove(tempIndex);
        currentIndex--;
        if (questList.size()==0){
            startWinActivity();
            finish();
        }
    }

    private void updateQuestionByList(){
    String question = questList.get(currentIndex).getTextQuest();
    question_textview.setText(question);
    }

    private void updateCounter(){
        StringBuilder counter = new StringBuilder();
        counter.append(rightQuestion).append("/").append(questionCount);
        textCounter.setText(counter);
    }

    private void startWinActivity() {
        Intent intent = new Intent(this, WinnerScreenActivity.class);
        intent.putExtra(R_INDEX,rightQuestion);
        intent.putExtra(QUESTION_COUNT,questionCount);
        startActivity(intent);
    }

}
