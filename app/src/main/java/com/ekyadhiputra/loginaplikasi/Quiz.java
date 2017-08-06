package com.ekyadhiputra.loginaplikasi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Quiz extends AppCompatActivity {
    //deklarasi variable
    private QuizBank mQuizLibrary = new QuizBank();
    private TextView sScore; //untuk update score
    private TextView sQuestion; //untuk update pertanyaan
    private RadioButton mchoice1; //untuk juyupo pasti A
    private RadioButton mchoice2 ;//untuk juyupo pasti B
    private RadioButton mchoice3; //untuk juyupo pasti Ds
    private RadioButton mchoice4; //untuk juyupo pasti C

    private String manswer; // Untuk mengambil jawaban
    private int mScore = 0; //nilai awal untuk skor
    private int mQuestonNumber = 0; //Nilai dari pertanyaan

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        //inisialisasi variable
        sQuestion = (TextView) findViewById(R.id.question);
        mchoice1 = (RadioButton) findViewById(R.id.choise1);
        mchoice2 = (RadioButton) findViewById(R.id.choise2);
        mchoice3 = (RadioButton) findViewById(R.id.choise3);
        mchoice4 = (RadioButton) findViewById(R.id.choise4);

        sScore = (TextView) findViewById(R.id.score);
        updateQuestion();
        updateScore(mScore);
    }

    //method untuk mengatur pertanyaan
    private void updateQuestion(){
        mchoice1.setChecked(false);
        mchoice2.setChecked(false);
        mchoice3.setChecked(false);
        mchoice4.setChecked(false);

        if (mQuestonNumber < mQuizLibrary.getLength()){
            //menset setiap textview dan radiobutton untuk diubah jadi pertanyaan
            sQuestion.setText(mQuizLibrary.getQuestion(mQuestonNumber));
            //mengatur opsi sesuai pada optional A
            mchoice1.setText(mQuizLibrary.getChoice(mQuestonNumber, 1)); //Pilihan Ganda ke 1
            //mengatur opsi sesuai pada optional B
            mchoice2.setText(mQuizLibrary.getChoice(mQuestonNumber, 2)); //Pilihan Ganda ke 2
            //mengatur opsi sesuai pada optional C
            mchoice3.setText(mQuizLibrary.getChoice(mQuestonNumber, 3)); //Pilihan Ganda ke 3
            //mengatur opsi sesuai pada optional D
            mchoice4.setText(mQuizLibrary.getChoice(mQuestonNumber, 4)); //Pilihan Ganda ke 4

            manswer = mQuizLibrary.getCorrect(mQuestonNumber);
            //untuk mengkoreksi jawaban yang ada di class QuizBank sesuai nomor urut
            mQuestonNumber++; //update pertanyaan
        }else{
            Toast.makeText(Quiz.this, "ini pertanyaan terakhir", Toast.LENGTH_LONG).show();
            Intent i = new Intent (Quiz.this, HighestScore.class);
            i.putExtra("score", mScore);  //UNTUK MENGIRIM NILAI KE activity melalui intent
            startActivity(i);
        }
    }

    //method untuk mengatur skor
    private void updateScore(int point){
        sScore.setText("" + mScore + "/" + mQuizLibrary.getLength());

    }

    //method untuk radiobutton ketika diklik
    public void onClick(View view){
        RadioButton answer = (RadioButton) view;
        if (answer.getText() == manswer) {
            mScore = mScore + 1;
            Toast.makeText(Quiz.this, "Correct", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(Quiz.this, "InCorrect", Toast.LENGTH_LONG).show();
        }
        updateScore(mScore);
        updateQuestion();

    }
}
