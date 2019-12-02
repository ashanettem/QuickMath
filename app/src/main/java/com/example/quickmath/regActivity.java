package com.example.quickmath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class regActivity extends AppCompatActivity {

    EditText regEmail;
    EditText regPass;
    EditText regFName;
    EditText regLName;
    EditText regAge;
    Button regBtn;

    SharedPreferences sp;
    SharedPreferences.Editor edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);


        regEmail = findViewById(R.id.eRegTxt);
        regPass = findViewById(R.id.pRegTxt);
        regFName = findViewById(R.id.nameTxt);
        regLName = findViewById(R.id.lNameTxt);
        regAge = findViewById(R.id.dobTxt);
        regBtn = findViewById(R.id.btnReg);

        sp = getSharedPreferences("registrationLog", MODE_PRIVATE);

        edit = sp.edit();


    }

    private void register(View view){

        String firstName = regFName.getText().toString().trim();
        String lastName = regLName.getText().toString().trim();
        String password = regPass.getText().toString().trim();
        String email = regEmail.getText().toString().trim();
        String age = regAge.getText().toString().trim();


        if(firstName== " " || firstName.length() < 3 || firstName.length() > 12 ){

            Toast.makeText(regActivity.this, "Invalid Input, name too short or too long", Toast.LENGTH_SHORT).show();

        }

        if(lastName== " " || lastName.length() < 3 || lastName.length() > 12 ){

            Toast.makeText(regActivity.this, "Invalid Input, name too short or too long", Toast.LENGTH_SHORT).show();

        }


        if(email == " "){
            Toast.makeText(regActivity.this, "Invalid Input, Email Syntax Incorrect", Toast.LENGTH_SHORT).show();


        }

        if(password == " " || password.length() < 8 || password.length() > 16){
            Toast.makeText(regActivity.this, "Invalid Input, Password must be between 8 - 16 characters", Toast.LENGTH_SHORT).show();


        }

        if(age == " " || age.length() != 8){
            Toast.makeText(regActivity.this, "Invalid Input, Date of Birth must be between 8 characters in numerical format", Toast.LENGTH_SHORT).show();


        }

        else {

            edit.putString("First Name", firstName);
            edit.putString("Last Name", lastName);
            edit.putString("Password", password);
            edit.putString("Email", email);
            edit.putString("Date of Birth", age);


            edit.commit();


            Intent intent;
            intent = new Intent(this, MainActivity.class);
            startActivity(intent);


        }

    }

}
