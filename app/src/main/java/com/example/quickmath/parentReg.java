
package com.example.quickmath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;

public class parentReg extends AppCompatActivity {

    EditText parEmail;
    EditText parPassword;
    EditText parFirstN;
    EditText parLastN;
    EditText chldEmail;
    Button submit;

    SharedPreferences sp;
    SharedPreferences.Editor edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_admin_reg);

        parEmail = findViewById(R.id.parRegEmail);
        parPassword = findViewById(R.id.parRegPass);
        parFirstN = findViewById(R.id.nameTxt);
        parLastN = findViewById(R.id.lNameTxt);
        chldEmail = findViewById(R.id.childEmail);
        submit = findViewById(R.id.btnReg);


        submit.setOnClickListener(this::register);

    }

    private void register(View view){


        String firstName = parFirstN.getText().toString().trim();
        String lastName = parLastN.getText().toString().trim();
        String password = parPassword.getText().toString().trim();
        String email = parEmail.getText().toString().trim();
        String childE = chldEmail.getText().toString().trim();


        if(firstName== "" || firstName.length() < 3 || firstName.length() > 12 ){

            Toast.makeText(parentReg.this, "Invalid Input, name too short or too long", Toast.LENGTH_SHORT).show();

        }

        if(lastName== "" || lastName.length() < 3 || lastName.length() > 12 ){

            Toast.makeText(parentReg.this, "Invalid Input, name too short or too long", Toast.LENGTH_SHORT).show();

        }


        if(email == ""){
            Toast.makeText(parentReg.this, "Invalid Input, Email Syntax Incorrect", Toast.LENGTH_SHORT).show();


        }

        if(password == "" || password.length() < 8 || password.length() > 16){
            Toast.makeText(parentReg.this, "Invalid Input, Password must be between 8 - 16 characters", Toast.LENGTH_SHORT).show();


        }

        if(childE == ""){
            Toast.makeText(parentReg.this, "Invalid Input, Email Syntax Incorrect", Toast.LENGTH_SHORT).show();


        }

        else {

            User Parent = new Parent( firstName, lastName, email,  password,"Teacher", childE);

            FirebaseFirestore db = FirebaseFirestore.getInstance();
            db.collection("Users").add(Parent);

            Intent intent;
            intent = new Intent(this, MainActivity.class);
            startActivity(intent);

        }

    }

}

