package com.example.quickmath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class choices extends AppCompatActivity {

    String email;
    RadioButton q5, q10, q15;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choices);
        email = getIntent().getStringExtra("User");
        q5 = findViewById(R.id.q5);
        q10 = findViewById(R.id.q10);
        q15 = findViewById(R.id.q15);



    }

    public void Button_add(View view) {

        if (q5.isChecked()) {
            getIntent().putExtra("numOfQuestions", 5);
        }
        else if (q10.isChecked()) {
            getIntent().putExtra("numOfQuestions", 10);
        }
        else if (q15.isChecked()) {
            getIntent().putExtra("numOfQuestions", 15);
        }
        else{
            Toast.makeText(this, "Please Select How Many \nQuestions You Wish To Do.", Toast.LENGTH_SHORT).show();
        }



        Intent intent=new Intent(this,allcalculation.class);
        intent.putExtra("value","addition");
        intent.putExtra("User", email);

        startActivity(intent);

    }

    public void Button_multiply(View view) {

        if (q5.isChecked()) {
            getIntent().putExtra("numOfQuestions", 5);
        }
        else if (q10.isChecked()) {
            getIntent().putExtra("numOfQuestions", 10);
        }
        else if (q15.isChecked()) {
            getIntent().putExtra("numOfQuestions", 15);
        }
        else{
            Toast.makeText(this, "Please Select How Many \nQuestions You Wish To Do.", Toast.LENGTH_SHORT).show();
        }


        Intent intent=new Intent(this,allcalculation.class);
        intent.putExtra("value","multiply");
        intent.putExtra("User", email);
        startActivity(intent);

    }

    public void Button_substract(View view) {

        if (q5.isChecked()) {
            getIntent().putExtra("numOfQuestions", 5);
        }
        else if (q10.isChecked()) {
            getIntent().putExtra("numOfQuestions", 10);
        }
        else if (q15.isChecked()) {
            getIntent().putExtra("numOfQuestions", 15);
        }
        else{
            Toast.makeText(this, "Please Select How Many \nQuestions You Wish To Do.", Toast.LENGTH_SHORT).show();
        }

        Intent intent=new Intent(this,allcalculation.class);
        intent.putExtra("value","substract");
        intent.putExtra("User", email);
        startActivity(intent);


    }

    public void divide_button(View view) {

        if (q5.isChecked()) {
            getIntent().putExtra("numOfQuestions", 5);
        }
        else if (q10.isChecked()) {
            getIntent().putExtra("numOfQuestions", 10);
        }
        else if (q15.isChecked()) {
            getIntent().putExtra("numOfQuestions", 15);
        }
        else{
            Toast.makeText(this, "Please Select How Many \nQuestions You Wish To Do.", Toast.LENGTH_SHORT).show();
        }
        Intent intent=new Intent(this,allcalculation.class);
        intent.putExtra("value","divide");
        intent.putExtra("User", email);
        startActivity(intent);


    }


}
