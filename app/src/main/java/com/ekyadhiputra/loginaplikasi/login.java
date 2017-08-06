package com.ekyadhiputra.loginaplikasi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {

    EditText edituser, editpass;
    Button loginbutton, clearbutton;

    int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //inisialisasi EditText
        edituser = (EditText) findViewById(R.id.edituser);
        editpass = (EditText) findViewById(R.id.editpass);

        //inisialisassi Button
        loginbutton = (Button) findViewById(R.id.loginbutton);
        clearbutton = (Button) findViewById(R.id.clearbutton);

        //inisialisasi TextView
        final TextView attleft = (TextView) findViewById(R.id.attleft);

        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edituser.getText().toString().equals("admin") && editpass.getText().toString().equals("admin")){
                    Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(login.this, Quiz.class);
                    i.setFlags(i.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                }else{
                    Toast.makeText(getApplicationContext(), "Username of Password incorrect", Toast.LENGTH_SHORT).show();
                    attleft.setVisibility(View.VISIBLE);
                    counter--;
                    attleft.setText(Integer.toString(counter));

                    if (counter==0) {
                        Toast.makeText(getApplicationContext(), "Anda telah salah memasukkan password 3 kali", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
            }
        });

        clearbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edituser.setText("");
                editpass.setText("");
            }
        });

    }
}
