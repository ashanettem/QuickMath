package com.example.quickmath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;


public class MainActivity extends AppCompatActivity {

    EditText emailTxt;
    EditText passTxt;
    Button loginBtn;
    TextView regLnk, submit;

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
        submit = findViewById(R.id.adminReg);

        sp = getSharedPreferences("registrationLog", 0);


        regLnk.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {

                                          Intent startNewActivity = new Intent(v.getContext(), regActivity.class);
                                          startActivity(startNewActivity);

                                      }


                                  }
        );

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),adminReg.class);
                startActivity(intent);
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener()

            {
                @Override
                public void onClick (View view){

                FirebaseFirestore db = FirebaseFirestore.getInstance();
                CollectionReference usersDB = db.collection("Students");

                String user = emailTxt.getText().toString();
                String pass = passTxt.getText().toString();


                usersDB.whereEqualTo("email", user).limit(1).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                            Student currentUser = documentSnapshot.toObject(Student.class);

                            String email = currentUser.getEmail();
                            String password = currentUser.getPassword();

                            if (email.equals(user) && password.equals(pass)) {
                                Intent intent = new Intent(view.getContext(), choices.class);
                                intent.putExtra("User", email);
                                startActivity(intent);
                            } else {
                                Toast.makeText(MainActivity.this, "Please Try Again", Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                });

            }
            });

        }


}
