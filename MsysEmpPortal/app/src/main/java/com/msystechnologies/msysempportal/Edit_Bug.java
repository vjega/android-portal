package com.msystechnologies.msysempportal;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class Edit_Bug extends AppCompatActivity {

    private Spinner bug_type_spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__bug);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);

        bug_type_spinner = (Spinner) findViewById(R.id.bug_type_spinner);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> type_adapter = ArrayAdapter.createFromResource(this,
                R.array.bug_type_array, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        type_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        bug_type_spinner.setAdapter(type_adapter);



    }

    public void get_spinner_value(){
        String document_text = bug_type_spinner.getSelectedItem().toString();
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
                bug_type_spinner.setEnabled(true);
//                editText.F(true);
                Toast.makeText(getApplicationContext(), "edit", Toast.LENGTH_SHORT).show();
                break;
            case R.id.doc_delete:
                Toast.makeText(getApplicationContext(), "deleted", Toast.LENGTH_SHORT).show();
                break;
            case R.id.doc_done:
                Toast.makeText(getApplicationContext(), "saved", Toast.LENGTH_SHORT).show();
                break;

            case android.R.id.home:
                Intent intent = new Intent(Edit_Bug.this,Bug.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
