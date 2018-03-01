package com.example.maddiemaniaci.gitreference;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InputStream is = null;

        try {
            is = getApplicationContext().getAssets().open("gitReference.json");
            String jsonString = JsonUtils.parseJsonToString(is);

            ArrayList<GitReference> refs = JsonUtils.populateGitReferences(jsonString);

            ListView listView = findViewById(R.id.listView);
            GitAdapter adapter = new GitAdapter(this, refs);
            listView.setAdapter(adapter);
        }
        catch (Exception e) {}

        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.filter_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        final MainActivity main = this;

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                TextView textView = (TextView) selectedItemView;
                String text = (String) textView.getText();

                InputStream is = null;

                try {
                    is = getApplicationContext().getAssets().open("gitReference.json");
                    String jsonString = JsonUtils.parseJsonToString(is);

                    ArrayList<GitReference> refs = JsonUtils.populateGitReferences(jsonString);
                    ArrayList<GitReference> newRefs = new ArrayList<>();

                    if (text.equals("All")) {
                        newRefs = refs;
                    }
                    else {
                        for (int i = 0; i < refs.size(); i++) {
                            GitReference reference = refs.get(i);
                            if (reference.getSection().equals(text)) {
                                newRefs.add(reference);
                            }
                        }
                    }

                    ListView listView = findViewById(R.id.listView);
                    GitAdapter adapter = new GitAdapter(main, newRefs);
                    listView.setAdapter(adapter);
                }
                catch (Exception e) {}
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {}

        });
    }

}
