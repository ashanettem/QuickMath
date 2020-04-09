package com.example.quickmath;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ExamAdapter extends ArrayAdapter<Exam> {
    public ExamAdapter(Context context, int resource, List<Exam> objects){
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if (convertView == null){
            convertView = ((Activity) getContext()).getLayoutInflater()
                    .inflate(R.layout.exam_result, parent,false);
        }

        TextView tvChild = (TextView) convertView.findViewById(R.id.tvChild);
        TextView tvExamType = (TextView) convertView.findViewById(R.id.tvExamType);
        TextView tvQuestionCount = (TextView) convertView.findViewById(R.id.tvQuestionCount);
        TextView tvScore = (TextView) convertView.findViewById(R.id.tvScore);


        Exam currentExam = getItem(position);

        tvChild.setText("Child Email: ");
        tvExamType.setText("Operator: ");
        tvQuestionCount.setText("Number of Questions: ");
        tvScore.setText("Score: ");



        tvChild.append(currentExam.getChild());
        tvExamType.append(currentExam.getType());
        tvQuestionCount.append(String.valueOf(currentExam.getNumOfQuestions()));
        tvScore.append(String.valueOf(currentExam.getScore()));

        return convertView;
    }
}
