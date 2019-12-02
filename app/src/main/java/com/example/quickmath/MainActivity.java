package com.example.quickmath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    EditText emailTxt;
    EditText passTxt;
    Button loginBtn;
    TextView regLnk;

    SharedPreferences sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assign ID's from XML to variables in Main Activity


        emailTxt = findViewById(R.id.uEmail);
        passTxt = findViewById(R.id.uPass);
        loginBtn = findViewById(R.id.uLogin);
        regLnk = findViewById(R.id.uReg);

        sp = getSharedPreferences( "registrationLog", 0);


        regLnk.setOnClickListener(new View.OnClickListener() {
            @Override
             public void onClick(View v) {

                Intent startNewActivity = new Intent(v.getContext(), regActivity.class);
                startActivity(startNewActivity);

                }
             }



        );

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(view.getContext(), choices.class);
                startActivity(i);
            }
        });



    }
}
