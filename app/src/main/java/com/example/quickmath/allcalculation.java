package com.example.quickmath;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class allcalculation extends AppCompatActivity {
    private TextView num11;
    private TextView num12;
    private TextView result;
    private TextView num_of_question;
    private EditText enter_num;
    private TextView tvSign;
    private Button inputButton;
    int count = 0;
    int tryMe = 0;
    int Final_result = 0;
    String email;
    String value;
    int numOfquestions;
    SharedPreferences sp;
    private ImageView gc, rx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_allcalculation);


        email = getIntent().getStringExtra("User");
        value = getIntent().getStringExtra("value");

        sp = getSharedPreferences("SP", MODE_PRIVATE);
        numOfquestions = sp.getInt("numOfQuestions", 5);


        inputButton = findViewById(R.id.btnInput);
        result = findViewById(R.id.result);
        num11 = findViewById(R.id.num_one);
        num12 = findViewById(R.id.num_two);
        num_of_question = findViewById(R.id.tvNumOfQuestions);
        enter_num = findViewById(R.id.etInput);
        tvSign = findViewById(R.id.tvSign);
        gc = findViewById(R.id.greenCheck);
        rx = findViewById(R.id.redX);


        tocall();


        inputButton.setOnClickListener(this::calulate);
    }

    private void calulate(View view) {
        validateAnswer();
    }


    private void tocall() {
        gc.setVisibility(View.INVISIBLE);
        rx.setVisibility(View.INVISIBLE);
        enter_num.setText("");//clear the editText
        result.setText("");// clears input
        count++;

        if (count <= numOfquestions) { // how many question you want to get
            to_get_random();
            num_of_question.setText(count + "/" + numOfquestions);


        } else {
            FirebaseFirestore db = FirebaseFirestore.getInstance();
            CollectionReference gamesDB = db.collection("Games");

            Game currentGame = new Game(value, numOfquestions, email, Final_result);
            currentGame.setState("complete");
            currentGame.setChild(email);
            gamesDB.add(currentGame);

            Intent go_back_to_first_page = new Intent(this, choices.class);
            startActivity(go_back_to_first_page);
            Toast.makeText(this,"Complete",Toast.LENGTH_LONG).show();
        }
    }


    private void to_get_random() {
        int rand1 = new Random().nextInt(100);// random number between 0 to 5
        int rand2 = new Random().nextInt(5);


        if (rand1 < rand2) {
            to_get_random();
            // Toast.makeText(this," here",Toast.LENGTH_LONG).show();


        } else if (rand1 > rand2 || rand1 == rand2) {  //make sure that random number 1 is greater than random number 2(save some time)
            num11.setText(String.valueOf(rand1));
            num12.setText(String.valueOf(rand2));

            String mychoice = getIntent().getStringExtra("value");


            if (mychoice.equals("addition")) {
                toadd(rand1, rand2);
            } else if (mychoice.equals("multiply")) {
                tomultiply(rand1, rand2);

            } else if (mychoice.equals("subtract")) {
                tosubtract(rand1, rand2);

            } else if (mychoice.equals("divide")) {
                todivide(rand1, rand2);

            } else {
                Toast.makeText(this, " inside error", Toast.LENGTH_LONG).show();
            }


        } else {
            Toast.makeText(this, " there is an error", Toast.LENGTH_LONG).show();
        }

    }


    private void todivide(int rand1, int rand2) {
        tvSign.setText(" / ");  // this is for the sign
        if (rand1 % rand2 != 0) {
            to_get_random();
        } else {
            int the_result = rand1 / rand2;
            tryMe = the_result;
            // result.setText(String.valueOf(the_result)); //comment out
        }

    }


    private void tosubtract(int rand1, int rand2) {

        tvSign.setText(" - ");

        int the_result = rand1 - rand2;
        tryMe = the_result;
        //result.setText(String.valueOf(the_result)); //comment out

    }


    private void tomultiply(int rand1, int rand2) {
        int the_result = rand1 * rand2;
        tvSign.setText(" X ");
        tryMe = the_result;
        //result.setText(String.valueOf(the_result)); //comment out

    }


    private void toadd(int rand1, int rand2) {

        int the_result = rand1 + rand2;
        tryMe = the_result;
        //result.setText(String.valueOf(the_result)); //comment out

    }


    public void validateAnswer() {

        if (enter_num.getText().toString().length() == 0) {// make sure that the editext is not empty
            Toast.makeText(this, "enter number", Toast.LENGTH_LONG).show();
        } else {


            int input = Integer.parseInt(enter_num.getText().toString().trim());  // this part is to get the user input


            if (input == tryMe) {
                if (numOfquestions == 5) {
                    Final_result += 20;
                    Toast.makeText(this, "Correct!", Toast.LENGTH_LONG).show();//display the result
                    gc.setVisibility(View.VISIBLE);
                } else if (numOfquestions == 10) {
                    int scoreValue = 100 / numOfquestions;
                    Final_result += scoreValue;
                    Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
                    gc.setVisibility(View.VISIBLE);
                } else {
                    int scoreValue = 100 / numOfquestions;
                    Final_result += scoreValue;
                    Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
                    gc.setVisibility(View.VISIBLE);
                }
            } else {
                rx.setVisibility(View.VISIBLE);
            }


            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    tocall();// goback and call the call method
                }
            }, 2000);


        }
    }

}

