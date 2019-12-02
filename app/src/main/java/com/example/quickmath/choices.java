package com.example.quickmath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class choices extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choices);
    }



    public void Button_add(View view) {

        Intent intent=new Intent(this,allcalculation.class);
        intent.putExtra("value","addition");

        startActivity(intent);

    }

    public void Button_multiply(View view) {


        Intent intent=new Intent(this,allcalculation.class);
        intent.putExtra("value","multiply");

        startActivity(intent);

    }

    public void Button_substract(View view) {

        Intent intent=new Intent(this,allcalculation.class);
        intent.putExtra("value","substract");

        startActivity(intent);


    }

    public void divide_button(View view) {
        Intent intent=new Intent(this,allcalculation.class);
        intent.putExtra("value","divide");

        startActivity(intent);


    }


}
