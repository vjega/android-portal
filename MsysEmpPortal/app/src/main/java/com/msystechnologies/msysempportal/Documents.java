package com.msystechnologies.msysempportal;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class Documents extends MainActivity {
    private  ListView listView;
    EditText editText;
    ArrayList<String> listItems;
    ArrayAdapter adapter;
//    Add_Document add_document = new Add_Document();



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



        listView = (ListView) findViewById(R.id.document_list);

        adapter = new ArrayAdapter<String>(this, R.layout.activity_document_listview,R.id.document_text,list());
        listView.setAdapter(adapter);




        // Get ListView object from xml
//        listView = (ListView) findViewById(R.id.document_list);
//        editText = (EditText) findViewById(R.id.editText);
//        listItems = new ArrayList<String>();
//        listItems.add("First Item - added on Activity Create");

//        Set the documents name
//        String[] document_name = {"RESUME","SSLC MARKSHEET","HSC MARKSHEET","UG MARKSHEET","UG PROVISIONAL",
//                            "PG DEFREE","OFFER LETTER","RELEVING LETTERS","PAYSLIPS","VOTER ID",
//
//                            "PASSPORT","PAN CARD","DRIVING LICENSE","FORM 16"};

//        String[] document_name = add_document.getlistitem();
        //set adapter for listview
//        adapter = new ArrayAdapter<String>(this, R.layout.activity_document_listview,R.id.document_text,listItems);
//        listView.setAdapter(adapter);

//        // ListView Item Click Listener
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view,
//                                    int position, long id) {
//
//                // ListView Clicked item index
//                int itemPosition     = position;
////                Intent intent = new Intent(Documents.this,Add_Document.class);
////                startActivity(intent);
//
//                // ListView Clicked item value
//                String  itemValue    = (String) listView.getItemAtPosition(position);
//
//                // Show Alert
//                Toast.makeText(getApplicationContext(),
//                        "Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG)
//                        .show();
//
//            }
//
//        });
//        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
//                                           int pos, long id) {
//                // TODO Auto-generated method stub
//
//                Log.v("long clicked","pos: " + pos);
//
//                return true;
//            }
//        });
//
//        registerForContextMenu(listView);







        FloatingActionButton document_fab = (FloatingActionButton) findViewById(R.id.document_fab);
        document_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                listItems.add(editText.getText().toString());
//                adapter.notifyDataSetChanged();
                Intent fab_intent = new Intent(Documents.this,Add_Document.class);
                startActivity(fab_intent);

            }
        });


    }



    public ArrayList<String> list(){
        listItems = new ArrayList<String>();
        listItems.add("BTECH");
        listItems.add("SSLC");
//        listItems = add_document.set_Items();
        System.out.println("OOOOOOOOOO"+listItems);
        return listItems;

    }




    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        if (v.getId()==R.id.document_list) {
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)menuInfo;
            String[] menuItems = getResources().getStringArray(R.array.document_listview_click);
            for (int i = 0; i<menuItems.length; i++) {
                menu.add(Menu.NONE, i, i, menuItems[i]);
            }
        }
    }


}
