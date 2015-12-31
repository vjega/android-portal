package com.msystechnologies.msysempportal;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Documents extends MainActivity {
    private  ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_documents);

//        Set Navigation drawyer tool
        LayoutInflater inflater = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_documents, null, false);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.addView(contentView, 0);

        // Get ListView object from xml
        listView = (ListView) findViewById(R.id.document_list);

        //Set the documents name
        String[] document_name = {"RESUME","SSLC MARKSHEET","HSC MARKSHEET","UG MARKSHEET","UG PROVISIONAL",
                            "PG DEFREE","OFFER LETTER","RELEVING LETTERS","PAYSLIPS","VOTER ID",

                            "PASSPORT","PAN CARD","DRIVING LICENSE","FORM 16"};
        //set adapter for listview
        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_document_listview,R.id.document_text,document_name);

        listView.setAdapter(adapter);

        // ListView Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition     = position;
                Intent intent = new Intent(Documents.this,Card_Document.class);
                startActivity(intent);

                // ListView Clicked item value
                String  itemValue    = (String) listView.getItemAtPosition(position);

                // Show Alert
                Toast.makeText(getApplicationContext(),
                        "Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG)
                        .show();

            }

        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int pos, long id) {
                // TODO Auto-generated method stub

                Log.v("long clicked","pos: " + pos);

                return true;
            }
        });

    }
}
