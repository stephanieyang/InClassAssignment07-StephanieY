package com.example.android.inclassassignment07_stephaniey;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView movieListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieListView = (TextView) findViewById(R.id.movie_list);
    }

    public void launchAddScreen(View view) {

        Intent intent = new Intent(this, InfoActivity.class);
        startActivityForResult(intent, Keys.REQUEST_ADD_MOVIE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Keys.REQUEST_ADD_MOVIE & resultCode == RESULT_OK) {
            Movie movie = (Movie) data.getSerializableExtra(Keys.MOVIE_KEY);
            CharSequence movieListText = movieListView.getText();
            movieListText = movieListText + "\n\n" + movie.toString();
            movieListView.setText(movieListText);
        }
    }
}
