package com.example.quickmath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Collection;

public class createExam extends AppCompatActivity {

    RadioButton q5, q10, q15, qAdd, qSub, qMutl, qDiv;
    Button submit;

    FirebaseFirestore db;
    CollectionReference exams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_exam);

        q5 =  findViewById(R.id.q5);
        q10 = findViewById(R.id.q10);
        q15 = findViewById(R.id.q15);
        qAdd = findViewById(R.id.qAdd);
        qSub = findViewById(R.id.qSub);
        qMutl = findViewById(R.id.qMult);
        qDiv = findViewById(R.id.qDiv);
        submit = findViewById(R.id.subBtn);

        submit.setOnClickListener(this::CreateExam);
    }

    private void CreateExam(View view) {

        Exam newExam = new Exam ();

        if (q5.isChecked()) {
            newExam.setNumOfQuestions(5);
            if (qAdd.isChecked()) {
                newExam.setType("addition");
            }
            else if (qSub.isChecked()) {
                newExam.setType("substract");
            }
            else if (qMutl.isChecked()) {
                newExam.setType("multiply");
            }
            else if (qDiv.isChecked()){
                newExam.setType("divide");
            }
            else{
                Toast.makeText(this, "Please Select How Many \nQuestions You Wish To Do.", Toast.LENGTH_SHORT).show();
            }
            newExam.setState("incomplete");
            exams.add(newExam);
        }
        else if (q10.isChecked()) {
            newExam.setNumOfQuestions(10);
            if (qAdd.isChecked()) {
                newExam.setType("addition");
            }
            else if (qSub.isChecked()) {
                newExam.setType("substract");
            }
            else if (qMutl.isChecked()) {
                newExam.setType("multiply");
            }
            else if (qDiv.isChecked()){
                newExam.setType("divide");
            }
            else{
                Toast.makeText(this, "Please Select How Many \nQuestions You Wish To Do.", Toast.LENGTH_SHORT).show();
            }
            newExam.setState("incomplete");
            exams.add(newExam);
        }
        else if (q15.isChecked()) {
            newExam.setNumOfQuestions(15);
            if (qAdd.isChecked()) {
                newExam.setType("addition");
            }
            else if (qSub.isChecked()) {
                newExam.setType("substract");
            }
            else if (qMutl.isChecked()) {
                newExam.setType("multiply");
            }
            else if (qDiv.isChecked()){
                newExam.setType("divide");
            }
            else{
                Toast.makeText(this, "Please Select How Many \nQuestions You Wish To Do.", Toast.LENGTH_SHORT).show();
            }
            newExam.setState("incomplete");
            exams.add(newExam);
        }
        else{
            Toast.makeText(this, "Please Select How Many \nQuestions You Wish To Do.", Toast.LENGTH_SHORT).show();
        }









    }
}
