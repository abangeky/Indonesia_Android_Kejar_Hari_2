package com.ekyadhiputra.loginaplikasi;

import static android.R.attr.x;

/**
 * Created by eky on 06/08/17.
 */

public class QuizBank {

    //array untuk pertanyaan
    private String squestion[] = {
            "Ibu kota provinsi Jawa Barat adalah ?",
            "Sasuke = ?",
            "Yang pernah mengalahkan goku ?",
            "Ruang apa yang paling di takutin di RS…?",
            "Berapa berat badan ?"
    };

    //array untuk jawaban
    private String schoice[][] = {
            {"Bandung", "Depok", "Bekasi", "Sukabumi"}, //Pilihan ganda 1, ..,, Pilihan Ganda 4
            {"Punya Sharingan", "Jutsu Api", "Uchiha", "Andika"},
            {"Bejitaa", "Jin Kura-Kura", "Pikoro", "Akira"},
            {"Ruang Mayat", "Ruang Security", "Ruang Administrasi", "Ruang Operasi"},
            {"50kg", "Cek Timbangan", "1Ton", "W = m.g"}
    };

    //private untuk jawaban yang benar
    private String scorrect[] = {
            "Bandung", "Andika", "Akira", "Ruang Administrasi", "W = m.g"
    };

    //method untuk mengembalikan nilai dari pertanyaan
    public int getLength() {
        return squestion.length;
    }

    //method untuk mengembalikan pertanyaan dari array
    public String getQuestion(int a) {
        String question = squestion[a];
        return question;
    }

    //method untuk mengembalikan opsi dari layar
    public String getChoice(int index, int num) {
        String choise = schoice[index][num-1];
        return choise;
    }

    //method untuk mengembalikan jawaban dari array
    public String getCorrect(int a) {
        String correct = scorrect[a];
        return correct;
    }



}
