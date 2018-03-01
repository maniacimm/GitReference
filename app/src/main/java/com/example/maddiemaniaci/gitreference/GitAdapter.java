package com.example.maddiemaniaci.gitreference;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by maddiemaniaci on 3/1/18.
 */

public class GitAdapter extends ArrayAdapter {


    public GitAdapter(Context context, ArrayList<GitReference> refs) {
        super(context, 0, refs);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        GitReference ref = (GitReference) this.getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.reference_text, parent, false);
        }
        //Command
        TextView command = convertView.findViewById(R.id.gitCommand);
        command.setText(ref.getCommand());
        //Explanation
        TextView explanation = convertView.findViewById(R.id.gitExplanation);
        explanation.setText(ref.getExplanation());
        //Example
        TextView example = convertView.findViewById(R.id.gitExample);
        example.setText(ref.getExample());
        //Section
        TextView section = convertView.findViewById(R.id.gitSection);
        section.setText(ref.getSection());
        return convertView;
    }
}
