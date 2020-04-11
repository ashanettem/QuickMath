package com.example.quickmath;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class GameAdapter extends ArrayAdapter<Game> {
    public GameAdapter(Context context, int resource, List<Game> objects){
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if (convertView == null){
            convertView = ((Activity) getContext()).getLayoutInflater()
                    .inflate(R.layout.game_result, parent,false);
        }

        TextView tvChild = (TextView) convertView.findViewById(R.id.tvChild);
        TextView tvGameType = (TextView) convertView.findViewById(R.id.tvGameType);
        TextView tvQuestionCount = (TextView) convertView.findViewById(R.id.tvQuestionCount);
        TextView tvScore = (TextView) convertView.findViewById(R.id.tvScore);


        Game currentGame = getItem(position);

        tvChild.setText("Child Email: ");
        tvGameType.setText("Operator: ");
        tvQuestionCount.setText("Number of Questions: ");
        tvScore.setText("Score: ");



        tvChild.append(currentGame.getChild());
        tvGameType.append(currentGame.getType());
        tvQuestionCount.append(String.valueOf(currentGame.getNumOfQuestions()));
        tvScore.append(String.valueOf(currentGame.getScore()));

        return convertView;
    }
}
