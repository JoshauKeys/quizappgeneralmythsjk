package org.forestpark.quizappgeneralmythsjk;

public class Question {
    private String text;
    private boolean answer;

    public Question(String text, boolean answer) {
        this.text = text;
        this.answer = answer;
    }

    public String getText() {
        return text;
    }

    public boolean isAnswer() {
        return answer;
    }

    public int getCorrectAnswerIndex() {
        return 0;
    }
}
