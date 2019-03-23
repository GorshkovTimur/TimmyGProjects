package com.timmyg.quiz.timmygquiz;

import android.content.res.Resources;

import java.util.ArrayList;
import java.util.List;

public class DataBuilder {

   private List<Question> dataSource;
   private Resources resources;


    public DataBuilder(Resources resources) {
        this.resources = resources;
    }

    public List<Question> build(){
        dataSource = new ArrayList<Question>();
    String[] question =resources.getStringArray(R.array.questions);
    int[] answers = resources.getIntArray(R.array.answers);
    boolean[] bool_ans = int2bool(answers);
    for (int i=0; i<question.length; i++){
        dataSource.add(new Question(question[i],bool_ans[i]));
    }
    return dataSource;
    }

    private boolean[] int2bool(int[] answers) {
        boolean[] bool_ans = new boolean[answers.length];
    for (int i=0; i <answers.length; i++){
        if (answers[i]==0){
            bool_ans[i] = false ;
        }
        else {
            bool_ans[i] = true ;
        }
    }

    return bool_ans;
    }


}
