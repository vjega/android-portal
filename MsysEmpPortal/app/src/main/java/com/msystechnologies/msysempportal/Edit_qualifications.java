package com.msystechnologies.msysempportal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * Created by pravinth on 14/1/16.
 */

public class Edit_qualifications extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_qualifications);
        setTitle("Qualification Details");

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        RelativeLayout relativeLayout =(RelativeLayout)findViewById(R.id.qualifications_form);
        disable(relativeLayout);
    }

    public void disable(ViewGroup layout) {
        layout.setEnabled(false);
        for (int i = 0; i < layout.getChildCount(); i++) {
            View child = layout.getChildAt(i);
            if (child instanceof ViewGroup) {
                disable((ViewGroup) child);
            } else {
                child.setEnabled(false);
            }
        }
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
                Toast.makeText(getApplicationContext(), "edit", Toast.LENGTH_SHORT).show();
                break;
            case R.id.doc_delete:
                Toast.makeText(getApplicationContext(), "deleted", Toast.LENGTH_SHORT).show();
                break;
            case R.id.doc_done:
                Toast.makeText(getApplicationContext(), "saved", Toast.LENGTH_SHORT).show();
                break;

            case android.R.id.home:
                Intent intent = new Intent(Edit_qualifications.this,Qualifications.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}
