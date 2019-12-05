package com.example.quickmath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class choices extends AppCompatActivity {

    String email;
    RadioButton q5, q10, q15;
    SharedPreferences sp;
    SharedPreferences.Editor spEdit;
    Button add,substract,mulitply,divide,logOut;
    

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choices);
        email = getIntent().getStringExtra("User");
        q5 = findViewById(R.id.q5);
        q10 = findViewById(R.id.q10);
        q15 = findViewById(R.id.q15);

        sp = getSharedPreferences("SP", MODE_PRIVATE);
        spEdit = sp.edit();

        add = findViewById(R.id.add_button);
        substract = findViewById(R.id.subtract_button);
        mulitply = findViewById(R.id.multiply_button);
        divide = findViewById(R.id.divide_button);
        logOut = findViewById(R.id.logOut_button);

        add.setOnClickListener(this::Button_add);
        substract.setOnClickListener(this::Button_substract);
        divide.setOnClickListener(this::divide_button);
        mulitply.setOnClickListener(this::Button_multiply);

        logOut.setOnClickListener(this::logOut);

    }

    private void logOut(View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void Button_add(View view) {



        if (q5.isChecked()) {
            Intent intent=new Intent(this,allcalculation.class);
            intent.putExtra("value","addition");
            intent.putExtra("User", email);
            spEdit.putInt("numOfQuestions", 5);
            spEdit.commit();
            startActivity(intent);
        }
        else if (q10.isChecked()) {
            Intent intent=new Intent(this,allcalculation.class);
            intent.putExtra("value","addition");
            intent.putExtra("User", email);
            spEdit.putInt("numOfQuestions", 10);
            spEdit.commit();
            startActivity(intent);
        }
        else if (q15.isChecked()) {
            Intent intent=new Intent(this,allcalculation.class);
            intent.putExtra("value","addition");
            intent.putExtra("User", email);
            spEdit.putInt("numOfQuestions", 15);
            spEdit.commit();
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "Please Select How Many \nQuestions You Wish To Do.", Toast.LENGTH_SHORT).show();
        }





    }

    public void Button_multiply(View view) {

        if (q5.isChecked() == true) {
            Intent intent=new Intent(this,allcalculation.class);
            intent.putExtra("value","multiply");
            intent.putExtra("User", email);
            spEdit.putInt("numOfQuestions", 5);
            spEdit.commit();
            startActivity(intent);
        }
        else if (q10.isChecked() == true) {
            Intent intent=new Intent(this,allcalculation.class);
            intent.putExtra("value","multiply");
            intent.putExtra("User", email);
            spEdit.putInt("numOfQuestions", 10);
            spEdit.commit();
            startActivity(intent);
        }
        else if (q15.isChecked() == true) {
            Intent intent=new Intent(this,allcalculation.class);
            intent.putExtra("value","multiply");
            intent.putExtra("User", email);
            spEdit.putInt("numOfQuestions", 15);
            spEdit.commit();
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "Please Select How Many \nQuestions You Wish To Do.", Toast.LENGTH_SHORT).show();
        }




    }

    public void Button_substract(View view) {

        if (q5.isChecked() == true) {
            Intent intent=new Intent(this,allcalculation.class);
            intent.putExtra("value","substract");
            intent.putExtra("User", email);
            spEdit.putInt("numOfQuestions", 5);
            spEdit.commit();
            startActivity(intent);

        }
        else if (q10.isChecked() == true) {
            Intent intent=new Intent(this,allcalculation.class);
            intent.putExtra("value","substract");
            intent.putExtra("User", email);
            spEdit.putInt("numOfQuestions", 10);
            spEdit.commit();
            startActivity(intent);
        }
        else if (q15.isChecked() == true) {
            Intent intent=new Intent(this,allcalculation.class);
            intent.putExtra("value","substract");
            intent.putExtra("User", email);
            spEdit.putInt("numOfQuestions", 15);
            spEdit.commit();
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "Please Select How Many \nQuestions You Wish To Do.", Toast.LENGTH_SHORT).show();
        }




    }

    public void divide_button(View view) {

        if (q5.isChecked() == true) {
            Intent intent=new Intent(this,allcalculation.class);
            intent.putExtra("value","divide");
            spEdit.putInt("numOfQuestions", 5);
            spEdit.commit();
            startActivity(intent);
        }
        else if (q10.isChecked() == true) {
            Intent intent=new Intent(this,allcalculation.class);
            intent.putExtra("value","divide");
            spEdit.putInt("numOfQuestions", 10);
            spEdit.commit();
            startActivity(intent);
        }
        else if (q15.isChecked() == true) {
            Intent intent=new Intent(this,allcalculation.class);
            intent.putExtra("value","divide");
            spEdit.putInt("numOfQuestions", 15);
            spEdit.commit();
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "Please Select How Many \nQuestions You Wish To Do.", Toast.LENGTH_SHORT).show();
        }



    }


}
