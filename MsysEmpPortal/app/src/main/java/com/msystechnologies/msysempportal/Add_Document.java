package com.msystechnologies.msysempportal;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import static android.os.SystemClock.sleep;

public class Add_Document extends AppCompatActivity {
    private Spinner document_spinner;
    private Spinner course_spinner;
    private Spinner submit_spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__document);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);



        document_spinner = (Spinner) findViewById(R.id.document_type_spinner);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> type_adapter = ArrayAdapter.createFromResource(this,
                R.array.document_type_array, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        type_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        document_spinner.setAdapter(type_adapter);




        course_spinner = (Spinner) findViewById(R.id.course_spinner);
        ArrayAdapter<CharSequence> course_adapter = ArrayAdapter.createFromResource(this,
                R.array.document_course_array, android.R.layout.simple_spinner_item);
        course_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        course_spinner.setAdapter(course_adapter);


        submit_spinner = (Spinner) findViewById(R.id.submitted_spinner);
        ArrayAdapter<CharSequence> submitted_adapter = ArrayAdapter.createFromResource(this,
                R.array.document_submitted_array, android.R.layout.simple_spinner_item);
        submitted_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        submit_spinner.setAdapter(submitted_adapter);


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_document, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Profile/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        switch (id) {
            case android.R.id.home:
                Intent intent = new Intent(Add_Document.this,Documents.class);
                startActivity(intent);
            case R.id.doc_done:
                Toast.makeText(getApplicationContext(), "Document Saved", Toast.LENGTH_SHORT).show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

}
