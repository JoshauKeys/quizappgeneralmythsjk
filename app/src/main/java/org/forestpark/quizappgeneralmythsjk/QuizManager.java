package org.forestpark.quizappgeneralmythsjk;

import java.util.List;

public class QuizManager {
    private List<Question> questions;
    private int currentQuestionIndex = 0;
    private int score = 0;

    public QuizManager(List<Question> questions) {
        this.questions = questions;
    }

    public Question getNextQuestion() {
        if (currentQuestionIndex < questions.size()) {
            return questions.get(currentQuestionIndex++);
        }
        return null; // No more questions
    }

    public void checkAnswer(int selectedAnswerIndex) {
        if (selectedAnswerIndex == questions.get(currentQuestionIndex - 1).getCorrectAnswerIndex()) {
            score++;
        }
    }

    public int getScore() {
        return score;
    }

    public boolean hasMoreQuestions() {
        return currentQuestionIndex < questions.size();
    }
}
