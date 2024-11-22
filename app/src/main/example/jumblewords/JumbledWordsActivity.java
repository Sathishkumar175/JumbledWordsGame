package com.example.jumbledwords;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.DragEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.Collections;

public class JumbledWordsActivity extends AppCompatActivity {

    private TextView tvTimer, tvFeedback;
    private LinearLayout llWordContainer;
    private Button btnSubmit;
    private ProgressBar progressBar;

    private String correctSentence = "I love programming";
    private String[] jumbledWords = {"love", "I", "programming"};
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jumbled_words);

        // Initialize views
        tvTimer = findViewById(R.id.tvTimer);
        tvFeedback = findViewById(R.id.tvFeedback);
        llWordContainer = findViewById(R.id.llWordContainer);
        btnSubmit = findViewById(R.id.btnSubmit);
        progressBar = findViewById(R.id.progressBar);

        // Start Timer
        startTimer(60000);

        // Initialize game
        initializeWords();

        btnSubmit.setOnClickListener(v -> validateAnswer());
    }

    private void initializeWords() {
        Collections.shuffle(Arrays.asList(jumbledWords));
        llWordContainer.removeAllViews();
        for (String word : jumbledWords) {
            TextView textView = new TextView(this);
            textView.setText(word);
            textView.setTextSize(18);
            textView.setPadding(16, 16, 16, 16);
            textView.setBackgroundResource(R.drawable.word_background);
            textView.setOnDragListener((view, event) -> handleDrag(event));
            llWordContainer.addView(textView);
        }
    }

    private boolean handleDrag(DragEvent event) {
        // Implement drag-and-drop logic
        return true;
    }

    private void validateAnswer() {
        StringBuilder userAnswer = new StringBuilder();
        for (int i = 0; i < llWordContainer.getChildCount(); i++) {
            TextView wordView = (TextView) llWordContainer.getChildAt(i);
            userAnswer.append(wordView.getText()).append(" ");
        }
        userAnswer = new StringBuilder(userAnswer.toString().trim());

        if (userAnswer.toString().equals(correctSentence)) {
            tvFeedback.setText("Correct!");
            score += 10;
        } else {
            tvFeedback.setText("Try Again!");
        }
    }

    private void startTimer(long duration) {
        new CountDownTimer(duration, 1000) {
            public void onTick(long millisUntilFinished) {
                tvTimer.setText("Time: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                tvFeedback.setText("Time's up! Your score: " + score);
                btnSubmit.setEnabled(false);
            }
        }.start();
    }
}
