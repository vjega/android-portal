package com.msystechnologies.msysempportal;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class ItTickets extends MainActivity {


    private  ListView listView;
    EditText editText;
    ArrayList<String> listItems;
    ArrayAdapter adapter;
    String get_doc;
    ArrayList<String> arrayList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_it_tickets);
        LayoutInflater inflater = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_it_tickets, null, false);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.addView(contentView, 0);


        arrayList.add("Mouse not working");
        arrayList.add("My system not working");
        arrayList.add("Net not connected");
        arrayList.add("Keyboard not working");


        ListView list_View = (ListView) this.findViewById(R.id.it_ticket_listView);

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, arrayList);
        list_View.setAdapter(adapter);


        FloatingActionButton document_fab = (FloatingActionButton) findViewById(R.id.it_ticket_fab);
        document_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fab_intent = new Intent(ItTickets.this,Add_Document.class);
                startActivity(fab_intent);

            }
        });

        /*list_View.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent edit_doc = new Intent(ItTickets.this,Edit_document.class);
                startActivity(edit_doc);

            }
        });*/


    }
}
