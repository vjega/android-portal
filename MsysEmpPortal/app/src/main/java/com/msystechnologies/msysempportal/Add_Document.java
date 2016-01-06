package com.msystechnologies.msysempportal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__document);

        Spinner document_spinner = (Spinner) findViewById(R.id.document_type_spinner);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> type_adapter = ArrayAdapter.createFromResource(this,
                R.array.document_type_array, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        type_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        document_spinner.setAdapter(type_adapter);



        Spinner course_spinner = (Spinner) findViewById(R.id.course_spinner);
        ArrayAdapter<CharSequence> course_adapter = ArrayAdapter.createFromResource(this,
                R.array.document_course_array, android.R.layout.simple_spinner_item);
        course_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        course_spinner.setAdapter(course_adapter);


        Spinner submit_spinner = (Spinner) findViewById(R.id.submitted_spinner);
        ArrayAdapter<CharSequence> submitted_adapter = ArrayAdapter.createFromResource(this,
                R.array.document_submitted_array, android.R.layout.simple_spinner_item);
        submitted_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        submit_spinner.setAdapter(submitted_adapter);




        Button document_save =(Button)findViewById(R.id.document_save_button);
        document_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent return_documents = new Intent(Add_Document.this,Documents.class);
                startActivity(return_documents);

            }
        });



    }


}
