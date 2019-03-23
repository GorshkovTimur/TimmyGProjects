package com.timmyg.quiz.timmygquiz;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private TextView question_textview;
    private Button trueButton;
    private Button falseButton;
    private ImageButton nextButton;
    private ImageButton prevButton;
    private List<Question> questList;
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
        questList = new DataBuilder(getResources()).build();



        question_textview = (TextView)findViewById(R.id.question_text_view);
        updateQuestionByList();
        question_textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex = (currentIndex+1)%questList.size();
                updateQuestionByList();
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
                currentIndex = (currentIndex+1)%questList.size();
                updateQuestionByList();

            }
        });

        prevButton = (ImageButton)findViewById(R.id.prev_button);
        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentIndex == 0) {
                    currentIndex = questList.size()-1;

                } else {
                    currentIndex = currentIndex-1;

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
        } else {
            messageResId = R.string.incorrect_toast;
        }
        Toast.makeText(this,messageResId,Toast.LENGTH_SHORT).show();
        int tempIndex = currentIndex;
        currentIndex = (currentIndex+1)%questList.size();
        updateQuestionByList();
        questList.remove(tempIndex);
        currentIndex--;
    }

    private void updateQuestionByList(){
    String question = questList.get(currentIndex).getTextQuest();
    question_textview.setText(question);
    }

}
