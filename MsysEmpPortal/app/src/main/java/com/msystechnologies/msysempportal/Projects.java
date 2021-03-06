package com.msystechnologies.msysempportal;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayMultiChoiceAdapter;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.view.CardListView;
import it.gmariotti.cardslib.library.view.CardView;

public class Projects extends MainActivity {
    ArrayAdapter adapter;
    ArrayList<String> arrayList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_projects);
        LayoutInflater inflater = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_projects, null, false);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.addView(contentView, 0);

        ListView list_View = (ListView) this.findViewById(R.id.project_listView);

        arrayList.add("GMSAT");
        arrayList.add("GROUP CARE");
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, arrayList);
        list_View.setAdapter(adapter);





        FloatingActionButton document_fab = (FloatingActionButton) findViewById(R.id.project_fab);
        document_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fab_intent = new Intent(Projects.this,Add_Projects.class);
                startActivity(fab_intent);

            }
        });
    }
}
