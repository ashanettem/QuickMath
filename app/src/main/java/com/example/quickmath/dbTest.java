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
    TestStudent testStudent, testStudent2;
    FirebaseFirestore test1;
    DocumentReference testDoc;


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

        btnTest.setOnClickListener(this::TEST);
        btnDisplay.setOnClickListener(this::Display);


        //test = FirebaseDatabase.getInstance();
        //testRef = test.getReference().child("TEST");

        test1 = FirebaseFirestore.getInstance();
        testDoc = test1.document("TEST/TESTLL");




        testStudent = new TestStudent("90", "TEST", "1");
        testStudent2 = new TestStudent("100", "TEST1", "1");





    }

    private void Display(View view) {

        testDoc.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()){
                    tvTestNumber.setText(documentSnapshot.getString(TEST_NUMBER));
                    tvScore.setText(documentSnapshot.getString(SCORE));
                    tvUser.setText(documentSnapshot.getString(USER));
                }
            }
        });
    }

    private void TEST(View view) {

        Map<String, Object> dataToSave = new HashMap<>();
        dataToSave.put(SCORE,testStudent.getScore());
        dataToSave.put(USER, testStudent.getUID());
        dataToSave.put(TEST_NUMBER, testStudent.getTestNumber());
        testDoc.set(dataToSave);

        Map<String, Object> dataToSave2 = new HashMap<>();
        dataToSave.put(SCORE,testStudent2.getScore());
        dataToSave.put(USER, testStudent2.getUID());
        dataToSave.put(TEST_NUMBER, testStudent2.getTestNumber());
        testDoc.set(dataToSave);
        //testRef.push().setValue(testStudent);

    }


}
