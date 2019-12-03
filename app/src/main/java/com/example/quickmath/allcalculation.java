package com.example.quickmath;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class allcalculation extends AppCompatActivity implements TextToSpeech.OnInitListener{
    private TextView num11;
    private TextView num12;
    private TextView result;
    private TextView num_of_question;
    private EditText enter_num;
    private TextView textView2;
    private Button inputButton;
    private int input;
    int count=0;
    int tryMe=0;
    int Final_result=0;
    String email;
    String value;
    String amount;
    int numOfquestions;
    SharedPreferences sp;

    @Override
    public void onInit(int i) { }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allcalculation);


        email = getIntent().getStringExtra("User");
        value = getIntent().getStringExtra("value");

        sp = getSharedPreferences("SP", MODE_PRIVATE);
        numOfquestions = sp.getInt("numOfQuestions" , 5);


        inputButton = (Button)findViewById(R.id.button);
        result=findViewById(R.id.result);
        num11=findViewById(R.id.num_one);
        num12=findViewById(R.id.num_two);
        num_of_question=findViewById(R.id.textView5);
        enter_num=findViewById(R.id.editText);
        textView2=findViewById(R.id.textView2);


        tocall();


        inputButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.ENGLISH);
                startActivityForResult(intent, 10);

            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && data != null) {
            switch (requestCode) {
                case 10:
                    int intFound = getNumberFromResult(data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS));
                    if (intFound != -1) {
                        input = intFound;
                        result.setText(String.valueOf(intFound));
                        validateAnswer();
                    } else {
                        Toast.makeText(getApplicationContext(), "Sorry, I didn't catch that! Please try again", Toast.LENGTH_LONG).show();
                    }
                    break;

            }
        } else {
            Toast.makeText(getApplicationContext(), "Failed to recognize speech!", Toast.LENGTH_LONG).show();
        }
    }


    //return the
    private int getNumberFromResult(ArrayList<String> results) {
        for (String str : results) {
            if (getIntNumberFromText(str) != -1) {
                return getIntNumberFromText(str);
            }
        }
        return -1;
    }

    private void tocall() {
        count++;

        if (count<=numOfquestions){ // how many question you want to get
            to_get_random();
            num_of_question.setText(count + " /" + numOfquestions);




        }
        else{
            FirebaseFirestore db = FirebaseFirestore.getInstance();
            CollectionReference examDB = db.collection("Exams");

            Exam currentExam = new Exam(value, numOfquestions,  email, Final_result);

            examDB.add(currentExam);

            Intent go_back_to_first_page= new Intent(this,choices.class);
            startActivity(go_back_to_first_page);
            //Toast.makeText(this,"Sorry you are done for the day  ",Toast.LENGTH_SHORT).show();
        }
    }


    private void to_get_random() {
        int rand1=new Random().nextInt(5);// random number between 0 to 5
        int rand2=new Random().nextInt(5);


        if (rand1<rand2){
            to_get_random();
            // Toast.makeText(this," here",Toast.LENGTH_LONG).show();


        }
        else if(rand1>rand2 || rand1==rand2) {  //make sure that random number 1 is greater than random number 2(save some time)
            num11.setText(String.valueOf(rand1));
            num12.setText(String.valueOf(rand2));

            String mychoice=getIntent().getStringExtra("value");


            if( mychoice.equals("addition")){
                toadd(rand1, rand2);
            }
            else if(mychoice.equals("multiply")){
                tomultiply(rand1,rand2);

            }
            else if(mychoice.equals("substract")){
                tosubstract(rand1,rand2);

            }
            else if(mychoice.equals("divide")){
                todivide(rand1,rand2);

            }

            else {
                Toast.makeText(this," inside error",Toast.LENGTH_LONG).show();
            }


        }
        else {
            Toast.makeText(this," there is an error",Toast.LENGTH_LONG).show();
        }

    }


    private void todivide(int rand1, int rand2) {
        textView2.setText("/");  // this is for the sign
        if(rand1%rand2!=0){
            to_get_random();
        }

        else {
            int the_result= rand1/rand2;
            tryMe=the_result;
           // result.setText(String.valueOf(the_result)); //comment out
        }

    }


    private void tosubstract(int rand1, int rand2) {

        textView2.setText("-");

        int the_result= rand1- rand2;
        tryMe=the_result;
        //result.setText(String.valueOf(the_result)); //comment out

    }


    private void tomultiply(int rand1, int rand2) {
        int the_result=rand1 * rand2;
        textView2.setText("X");
        tryMe=the_result;
        //result.setText(String.valueOf(the_result)); //comment out

    }


    private void toadd(int rand1, int rand2) {

        int the_result=rand1 + rand2;
        tryMe=the_result;
        //result.setText(String.valueOf(the_result)); //comment out

    }





    public void validateAnswer() {

        //if(enter_num.getText().toString().length()==0){// make sure that the editext is not empty
            //Toast.makeText(this,"enter number",Toast.LENGTH_LONG).show();
        //}
        //else {



            //int my_input=Integer.parseInt(enter_num.getText().toString());  // this part is to get the user input


            if (input==tryMe){
                Final_result+=20;
                Toast.makeText(this,"RESULT :"+Final_result,Toast.LENGTH_LONG).show();  //display the result

            }
            else {
                Toast.makeText(this,enter_num.getText().toString()+ "not equal" +result.getText().toString() ,Toast.LENGTH_LONG).show();

            }


            enter_num.getText().clear();//clear the editText
            result.setText("");// clears input
            tocall();// goback and call the call method

        }



    // method to convert string number to integer
    private int getIntNumberFromText(String strNum) {

        //int num = Integer.parseInt(strNum);
        switch (strNum) {
            case "zero":
                return 0;
            case "one":
                return 1;
            case "two":
                return 2;
            case "three":
                return 3;
            case "four":
                return 4;
            case "five":
                return 5;
            case "six":
                return 6;
            case "seven":
                return 7;
            case "eight":
                return 8;
            case "nine":
                return 9;
            case "ten":
                return 10;
            case "eleven":
                return 11;
            case "twelve":
                return 12;
            case "thirteen":
                return 13;
            case "fourteen":
                return 14;
            case "fifteen":
                return 15;
            case "sixteen":
                return 16;
            case "seventeen":
                return 17;
            case "eighteen":
                return 18;
            case "nineteen":
                return 19;
            case "twenty":
                return 20;
            case "twenty one":
                return 21;
            case "twenty two":
                return 22;
            case "twenty three":
                return 23;
            case "twenty four":
                return 24;
            case "twenty five":
                return 25;
            case "twenty six":
                return 26;
            case "twenty seven":
                return 27;
            case "twenty eight":
                return 28;
            case "twenty nine":
                return 29;
            case "thirty":
                return 30;
            case "thirty one":
                return 31;
            case "thirty two":
                return 32;
            case "thirty three":
                return 33;
            case "thirty four":
                return 34;
            case "thirty five":
                return 35;
            case "thirty six":
                return 36;
            case "thirty seven":
                return 37;
            case "thirty eight":
                return 38;
            case "thirty nine":
                return 39;
            case "fourty":
                return 40;
            case "fourty one":
                return 41;
            case "fourty two":
                return 42;
            case "fourty three":
                return 43;
            case "fourty four":
                return 44;
            case "fourty five":
                return 45;

        }
        return -1;

        //return num;
    }

}

