package com.timmyg.quiz.timmygquiz;

public class Question {

    private int textResId;
    private boolean isAnswerTrue;
    private String textQuest;


    public Question(int textResId, boolean isAnswerTrue) {

        this.textResId = textResId;
        this.isAnswerTrue = isAnswerTrue;
    }

    public Question(String question, boolean isAnswerTrue) {

        this.textQuest = question;
        this.isAnswerTrue = isAnswerTrue;
    }

    public int getTextResId() {
        return textResId;
    }

    public void setTextResId(int textResId) {
        this.textResId = textResId;
    }

    public boolean isAnswerTrue() {
        return isAnswerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        isAnswerTrue = answerTrue;
    }

    public String getTextQuest() {
        return textQuest;
    }

    public void setTextQuest(String textQuest) {
        this.textQuest = textQuest;
    }

}
