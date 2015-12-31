package com.msystechnologies.msysempportal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Card_Document extends AppCompatActivity {
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card__document);

        spinner = (Spinner) findViewById(R.id.course_spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> course_adapter = ArrayAdapter.createFromResource(this,
                R.array.document_course_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        course_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(course_adapter);

        spinner = (Spinner) findViewById(R.id.submitted_spinner);
        ArrayAdapter<CharSequence> submitted_adapter = ArrayAdapter.createFromResource(this,
                R.array.document_submitted_array, android.R.layout.simple_spinner_item);
        submitted_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(submitted_adapter);
    }
}
