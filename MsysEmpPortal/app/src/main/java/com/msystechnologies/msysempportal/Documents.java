package com.msystechnologies.msysempportal;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.util.Log;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class Documents extends MainActivity {
    private  ListView list_View;
    EditText editText;
    ArrayList<String> listItems;
    ArrayAdapter adapter;
    ArrayAdapter adapter2;
    String get_doc;
    ArrayList<String> arrayList = new ArrayList<String>();



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





        /*Create json*/
        JSONObject emp1 = new JSONObject();
        JSONObject emp2 = new JSONObject();
        try {
            emp1.put("id", "3");
            emp1.put("doc_name", "SSLC MARKSHEET");
            emp1.put("course", "Regular");
            emp1.put("in_hand", "Copy");


            emp2.put("id", "4");
            emp2.put("doc_name", "RESUME");
            emp2.put("course", "Distance");
            emp2.put("in_hand", "Original");

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        JSONArray jsonArray = new JSONArray();
        jsonArray.put(emp1);
        jsonArray.put(emp2);

        ArrayList<String> arrayList2 = new ArrayList<String>();
        arrayList2.add("a");
        arrayList2.add("b");





////        /*get json */
        JSONArray get_json_array =new JSONArray();
        get_json_array = jsonArray;
        try {
            for(int i =0;i<jsonArray.length();i++){
                get_doc = get_json_array.getJSONObject(i).getString("doc_name");
                arrayList.add(get_doc);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        //get a listview from xml
        list_View = (ListView) this.findViewById(R.id.document_listView);


        //set to the adapter
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, arrayList);

        list_View.setAdapter(adapter);



        //Onclick listener for listview
        list_View.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent edit_doc = new Intent(Documents.this,Edit_document.class);
                startActivity(edit_doc);

            }
        });


        //Floating action
        FloatingActionButton document_fab = (FloatingActionButton) findViewById(R.id.document_fab);
        document_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fab_intent = new Intent(Documents.this,Add_Document.class);
                startActivity(fab_intent);

            }
        });
    }

}

