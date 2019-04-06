package com.timmyg.quiz.timmygquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class WinnerScreenActivity extends AppCompatActivity {

    private final String R_INDEX="R_INDEX";
    private final String QUESTION_COUNT="QUESTION_COUNT";

    private float right_result;
    private float question_count;
    private float result;
    private StringBuilder sb;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sb = new StringBuilder();
        setContentView(R.layout.activity_winscreen);
        right_result=getIntent().getIntExtra(R_INDEX,0);
        question_count=getIntent().getIntExtra(QUESTION_COUNT,1);
        result = (right_result/question_count)*100f;
        result = Math.round(result);
        sb.append(result).append('%');
        TextView resultText = (TextView)findViewById(R.id.result);

        resultText.setText(sb);

    }

}
