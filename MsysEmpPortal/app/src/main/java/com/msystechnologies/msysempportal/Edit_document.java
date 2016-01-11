package com.msystechnologies.msysempportal;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONArray;

public class Edit_document extends AppCompatActivity {
    private Spinner document_spinner;
    private Spinner course_spinner;
    private Spinner submit_spinner;
    Button browse;
    EditText editText;
    String doc_type = "RESUME";
    String doc_course ="Regular";
    String doc_submit ="Photo copy";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__document);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        Documents documents =new Documents();
        document_spinner = (Spinner) findViewById(R.id.document_type_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> type_adapter = ArrayAdapter.createFromResource(this,
                R.array.document_type_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        type_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        document_spinner.setAdapter(type_adapter);
        int doc_position = type_adapter.getPosition(doc_type);
        document_spinner.setSelection(2);
        document_spinner.setEnabled(false);



        course_spinner   = (Spinner) findViewById(R.id.course_spinner);
        ArrayAdapter<CharSequence> course_adapter = ArrayAdapter.createFromResource(this,
                R.array.document_course_array, android.R.layout.simple_spinner_item);
        course_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        course_spinner.setAdapter(course_adapter);
        course_spinner.setSelection(1);
        course_spinner.setEnabled(false);


        submit_spinner   = (Spinner) findViewById(R.id.submitted_spinner);
        ArrayAdapter<CharSequence> submitted_adapter = ArrayAdapter.createFromResource(this,
                R.array.document_submitted_array, android.R.layout.simple_spinner_item);
        submitted_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        submit_spinner.setAdapter(submitted_adapter);
        submit_spinner.setSelection(1);
        submit_spinner.setEnabled(false);

        browse = (Button)findViewById(R.id.browse);
        browse.setEnabled(false);

        editText = (EditText)findViewById(R.id.doc_remark_editText);
        editText.setFocusable(false);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_edit_document, menu);
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
            case R.id.doc_edit:
                item.setIcon(R.drawable.ic_done_white_18dp);
                document_spinner.setEnabled(true);
                course_spinner.setEnabled(true);
                submit_spinner.setEnabled(true);
                browse.setEnabled(true);
//                editText.F(true);

                Toast.makeText(getApplicationContext(), "edit", Toast.LENGTH_SHORT).show();
                break;
            case R.id.doc_delete:
                Toast.makeText(getApplicationContext(), "deleted", Toast.LENGTH_SHORT).show();
                break;
            case R.id.doc_done:
                Toast.makeText(getApplicationContext(), "deleted", Toast.LENGTH_SHORT).show();
                break;

            case android.R.id.home:
                Intent intent = new Intent(Edit_document.this,Documents.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}
