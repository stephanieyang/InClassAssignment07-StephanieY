package com.example.android.inclassassignment07_stephaniey;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        final Spinner spinner = (Spinner) findViewById(R.id.genre_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.genre_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        /* from: https://stackoverflow.com/questions/10331854/how-to-get-spinner-selected-item-value-to-string/38407969 */
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent,
                                       View view, int pos, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

    }

    public void returnMovieInfo(View view) {
        EditText movieTitle = (EditText) findViewById(R.id.movie_title);
        EditText movieYear = (EditText) findViewById(R.id.movie_year);
        CheckBox inEng = (CheckBox) findViewById(R.id.movie_eng);
        Spinner movieGenre = (Spinner) findViewById(R.id.genre_spinner);

        Movie movie = new Movie(movieTitle.getText().toString(), Integer.parseInt(movieYear.getText().toString()), movieGenre.getSelectedItem().toString(), inEng.isChecked());

        Intent data = new Intent();
        data.putExtra(Keys.MOVIE_KEY, movie);
        setResult(RESULT_OK, data);
        finish();


    }
}

