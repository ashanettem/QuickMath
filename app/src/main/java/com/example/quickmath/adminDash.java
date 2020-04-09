package com.example.quickmath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class adminDash extends AppCompatActivity {

    Button results, createExam, logOut;
    TextView adminTV, tvAdmin;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    CollectionReference collRef = db.collection("Exams");
    CollectionReference users = db.collection("Users");
    String user;
    User currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dash);

        results = findViewById(R.id.results);
        createExam = findViewById(R.id.creatEx);
        logOut = findViewById(R.id.logOutbtn);
        adminTV = findViewById(R.id.adminTxt);
        tvAdmin = findViewById(R.id.tvAdmin);

        results.setOnClickListener(this::displayR);
        createExam.setOnClickListener(this::createX);
        logOut.setOnClickListener(this::lOut);
        user = getIntent().getStringExtra("User");
        tvAdmin.setText(user);



    }

    private void lOut(View view) {

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);

    }

    private void createX(View view) {
        Intent i = new Intent(this, createExam.class);
        i.putExtra("User", user);
        startActivity(i);

    }

    private void displayR(View view) {
        Intent i = new Intent(this, childResults.class);
        i.putExtra("User", user);
        startActivity(i);
    }
}