package com.example.quickmath;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FirebaseFirestore;

public class regActivity extends AppCompatActivity {

    EditText regPass;
    EditText regFName;
    EditText regLName;
    EditText regUName;
    Button regBtn;

    SharedPreferences sp;
    SharedPreferences.Editor edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_reg);


        regUName = findViewById(R.id.uNameRegTxt);
        regPass = findViewById(R.id.pRegTxt);
        regFName = findViewById(R.id.nameTxt);
        regLName = findViewById(R.id.lNameTxt);
        regBtn = findViewById(R.id.btnReg);


        regBtn.setOnClickListener(this::register);

    }

    private void register(View view) {

        String firstName = regFName.getText().toString().trim();
        String lastName = regLName.getText().toString().trim();
        String password = regPass.getText().toString().trim();
        String username = regUName.getText().toString().trim();



        if (firstName.isEmpty() == true && lastName.isEmpty() == true && password.isEmpty() == true && username.isEmpty() == true) {
            Toast.makeText(this, "Please Fill in All Fields", Toast.LENGTH_SHORT).show();
        }
        else {


                Child newChild = new Child(firstName, lastName, username, password, "Child");

                FirebaseFirestore db = FirebaseFirestore.getInstance();
                db.collection("Users").add(newChild);

                Intent intent;
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);

        }
    }
}
