package com.timmyg.quiz.timmygquiz;

import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class WinnerScreenActivity extends AppCompatActivity {

    private final String R_INDEX="R_INDEX";
    private final String QUESTION_COUNT="QUESTION_COUNT";
    private String who;
    private String messageText;

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
        TextView message = findViewById(R.id.who);
        TextView resultText = findViewById(R.id.result);
        ImageView win_image = findViewById(R.id.win_image);

        if (result>=66.66f){
            win_image.setImageResource(R.drawable.cool);
            message.setText(getString(R.string.win));
            messageText = getString(R.string.good_text);
            sb.append(messageText).append("\n").append("Твой результат - ").append(result).append(" ").append("%");
            resultText.setText(sb.toString());
        }

        else if (result>=33.33f){
            win_image.setImageResource(R.drawable.think);
            message.setText(getString(R.string.average));
            messageText = getString(R.string.middle_text);
            sb.append(messageText).append("\n").append("Твой результат - ").append(result).append(" ").append("%");
            resultText.setText(sb.toString());

        }
        else if (result<33.33f){
            win_image.setImageResource(R.drawable.bad);
            message.setText(getString(R.string.bad));
            messageText = getString(R.string.dniwe_text);
            sb.append(messageText).append("\n").append("Твой результат - ").append(result).append(" ").append("%");
            resultText.setText(sb.toString());
        }

    }

}
