package com.example.quickmath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Random;

public class allcalculation extends AppCompatActivity {
    private TextView num11;
    private TextView num12;
    private TextView result;
    private TextView num_of_question;
    private EditText enter_num;
    private TextView textView2;
    int count=0;
    int tryMe=0;
    int Final_result=0;
    String email;
    String value;
    int numOfquestions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allcalculation);


        email = getIntent().getStringExtra("User");
        value = getIntent().getStringExtra("value");
        numOfquestions = Integer.parseInt(getIntent().getStringExtra("numOfQuestions"));

        result=findViewById(R.id.result);
        num11=findViewById(R.id.num_one);
        num12=findViewById(R.id.num_two);
        num_of_question=findViewById(R.id.textView5);
        enter_num=findViewById(R.id.editText);
        textView2=findViewById(R.id.textView2);



        tocall();


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
        int rand1=new Random().nextInt(20);// random number between 0 to 20
        int rand2=new Random().nextInt(20);


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
            result.setText(String.valueOf(the_result));
        }

    }


    private void tosubstract(int rand1, int rand2) {

        textView2.setText("-");

        int the_result= rand1- rand2;
        tryMe=the_result;
        result.setText(String.valueOf(the_result));

    }


    private void tomultiply(int rand1, int rand2) {
        int the_result=rand1 * rand2;
        textView2.setText("X");
        tryMe=the_result;
        result.setText(String.valueOf(the_result));

    }


    private void toadd(int rand1, int rand2) {

        int the_result=rand1 + rand2;
        tryMe=the_result;
        result.setText(String.valueOf(the_result));

    }





    public void onclick(View view) {

        if(enter_num.getText().toString().length()==0){// make sure that the editext is not empty
            Toast.makeText(this,"enter number",Toast.LENGTH_LONG).show();
        }
        else {



            int my_input=Integer.parseInt(enter_num.getText().toString());  // this part is to get the user input



            if (my_input==tryMe){
                Final_result+=20;
                Toast.makeText(this,"RESULT :"+Final_result,Toast.LENGTH_LONG).show();  //display the result

            }
            else {
                Toast.makeText(this,enter_num.getText().toString()+ "not equal" +result.getText().toString() ,Toast.LENGTH_LONG).show();

            }




            enter_num.getText().clear();  // clear the edittext
            tocall();// goback and call the call method





        }

    }

}