package org.forestpark.quizappgeneralmythsjk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView questionTextView;
    private Button trueButton;
    private Button falseButton;
    private Button finishedButton;
    private ImageView questionImage;

    private String[] questions = {
            "The Great Wall of China is visible from space.",
            "Bulls get angry when they see the color red.",
            "Humans only use 10% of their brains.",
            "Lightning never strikes the same place twice.",
            "You can see the Great Pyramids of Giza from the moon."
    };

    private boolean[] answers = {false, false, false, false, false};

    private int currentQuestion = 0;
    private int correctAnswers = 0;

    private int[] images = {
            R.drawable.greatwall, // 1st question
            R.drawable.bullred,   // 2nd question
            R.drawable.humanbrain, // 3rd question
            R.drawable.lightning, // 4th question
            R.drawable.pyramid // 5th question
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionTextView = findViewById(R.id.questionTextView);
        trueButton = findViewById(R.id.trueButton);
        falseButton = findViewById(R.id.falseButton);
        finishedButton = findViewById(R.id.finishedButton);
        questionImage = findViewById(R.id.questionImage);

        displayQuestion();

        trueButton.setOnClickListener(v -> checkAnswer(true));
        falseButton.setOnClickListener(v -> checkAnswer(false));
        finishedButton.setOnClickListener(v -> finishQuiz());
    }

    private void displayQuestion() {
        questionTextView.setText(questions[currentQuestion]);
        questionImage.setImageResource(images[currentQuestion]);
    }

    private void checkAnswer(boolean answer) {
        if (answer == answers[currentQuestion]) {
            Toast.makeText(MainActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
            correctAnswers++;
        } else {
            Toast.makeText(MainActivity.this, "Incorrect!", Toast.LENGTH_SHORT).show();
        }

        currentQuestion++;

        if (currentQuestion < questions.length) {
            displayQuestion();
        } else {
            finishQuiz();
        }
    }

    private void finishQuiz() {
        Intent intent = new Intent(MainActivity.this, ScoreActivity.class);
        intent.putExtra("score", correctAnswers);
        startActivity(intent);
        finish();
    }
}
