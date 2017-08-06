package com.ekyadhiputra.loginaplikasi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HighestScore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highest_score);

        //inisialisasi komponen
        TextView score_text = (TextView) findViewById(R.id.score_text);
        TextView highscore_text  = (TextView) findViewById(R.id.hiscore_text);

        Intent i = getIntent(); //menerima skor melalu intent pada activity sebelumnya
        int score = i.getIntExtra("score", 0);
        //menampilkan skor kita pada activity ini
        score_text.setText("Your score is " + score);

        //menyetel untuk skor terbaik
        SharedPreferences high = getPreferences(MODE_PRIVATE);
        int HighScore = high.getInt("high score", 0);
        if (HighScore >= score){
            highscore_text.setText("Highest score is " + HighScore);
        }else{
            highscore_text.setText("Highest score is " + score);
            SharedPreferences.Editor editor = high.edit();
            editor.putInt("high score", score);
            editor.commit();
        }

    }

    public void onClick(View view){
        Intent i = new Intent(HighestScore.this, Quiz.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }
}
