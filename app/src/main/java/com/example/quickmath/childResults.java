package com.example.quickmath;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarEntry;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class childResults extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    CollectionReference users = db.collection("Users");
    CollectionReference exams = db.collection("Exams");
    Button returnHome, btnGraph;
    Parent currentUser;
    String child;
    ListView examList;
    List<Exam> childExams;
    ExamAdapter examAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_results);
        examList = findViewById(R.id.examList);

        childExams = new ArrayList<>();
        examAdapter = new ExamAdapter(this, R.layout.exam_result, childExams);
        returnHome = findViewById(R.id.btnHome);
        btnGraph = findViewById(R.id.btnGraph);

        queryUser();

        returnHome.setOnClickListener(this::backToDash);


    }



    private void backToDash(View view) {
        Intent i = new Intent(this, adminDash.class);
        startActivity(i);
    }


    public void queryUser() {

        users.whereEqualTo("email", getIntent().getStringExtra("User")).limit(1).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                    currentUser = documentSnapshot.toObject(Parent.class);

                    String childEmail = currentUser.getChildEmail();

                    queryExams(childEmail);
                }
            }
        });

    }

    public void queryExams(String string) {
        exams.whereEqualTo("child", string).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {

                    childExams.add(documentSnapshot.toObject(Exam.class));
                    examList.setAdapter(examAdapter);

                }
            }
        });
    }

}
