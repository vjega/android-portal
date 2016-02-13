package com.msystechnologies.msysempportal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by pravinth on 14/1/16.
 */

public class Edit_qualifications extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Spinner course_spinner;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_qualifications);
        setTitle("Qualification Details");

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);

        course_spinner = (Spinner) findViewById(R.id.course_type);
        ArrayAdapter<CharSequence> course_adapter = ArrayAdapter.createFromResource(this,
                R.array.qualification_course_array, android.R.layout.simple_spinner_item);
        course_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        course_spinner.setAdapter(course_adapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_save, menu);
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
            case R.id.doc_done:
                Toast.makeText(getApplicationContext(), "saved", Toast.LENGTH_SHORT).show();
                break;

            case R.id.doc_delete:
                Toast.makeText(getApplicationContext(), "deleted", Toast.LENGTH_SHORT).show();
                break;

            case android.R.id.home:
                Intent intent = new Intent(Edit_qualifications.this,Qualifications.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}
