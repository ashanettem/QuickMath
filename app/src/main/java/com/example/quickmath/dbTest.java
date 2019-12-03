package com.example.quickmath;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class dbTest extends AppCompatActivity {

    public static final String SCORE = "Score";
    public static final String USER = "USER";
    public static final String TEST_NUMBER = "Test Number";

    //FirebaseDatabase test;
    //DatabaseReference testRef;
    Student testStudent, testStudent2;
    FirebaseFirestore test1;
    CollectionReference testDoc;



    Button btnTest, btnDisplay;
    TextView tvTestNumber, tvScore, tvUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db_test);
        btnTest = findViewById(R.id.btnTest);
        btnDisplay = findViewById(R.id.btnDisplay);

        tvTestNumber = findViewById(R.id.tvExamNumber);
        tvScore = findViewById(R.id.tvExamScore);
        tvUser = findViewById(R.id.tvUser);



        test1 = FirebaseFirestore.getInstance();
        testDoc = test1.collection("TEST");





        btnTest.setOnClickListener(this::saveInfo);








    }

    private void saveInfo(View view) {
        User test = new User("M", "P", "mp@gmail.com","15", "Password1");
        testDoc.add(test);
    }



}
