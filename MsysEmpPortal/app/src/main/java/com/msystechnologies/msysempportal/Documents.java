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

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.internal.CardArrayMultiChoiceAdapter;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.internal.CardThumbnail;
import it.gmariotti.cardslib.library.view.CardGridView;
import it.gmariotti.cardslib.library.view.CardListView;
import it.gmariotti.cardslib.library.view.CardView;

public class Documents extends MainActivity {
    private  ListView listView;
    EditText editText;
    ArrayList<String> listItems;
    ArrayAdapter adapter;




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

//        /*Create json*/
//        JSONObject student1 = new JSONObject();
//        JSONObject student2 = new JSONObject();
//        try {
//            student1.put("id", "3");
//            student1.put("doc_name", "SSLC");
//            student1.put("id", "4");
//            student1.put("doc_name", "RESUME");
//
//        } catch (JSONException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        JSONArray jsonArray = new JSONArray();
//        jsonArray.put(student1);
//        jsonArray.put(student2);
//



////        /*get json */
//        JSONArray get_json_array =new JSONArray();
//        get_json_array = jsonArray;
//        try {
//            String str = get_json_array.getJSONObject(0).getString("doc_name");
//            System.out.println("ffffff"+str);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//



        ListView list_View = (ListView) this.findViewById(R.id.document_listView);
        registerForContextMenu(list_View);
        ArrayList<String> arrayList = new ArrayList<String>();
        ArrayList<Card> cards = new ArrayList<Card>();

        HashMap<String, String> map = new HashMap<String, String>();
        ArrayList<String> a = new ArrayList<String>();
        arrayList.add("Resume");
        arrayList.add("SSlc");

        for (int i = 0; i<arrayList.size(); i++) {
            // Create a Card
            Card card = new Card(this);
            // Create a CardHeader
            CardHeader header = new CardHeader(this);
            // Add Header to card
            header.setTitle(arrayList.get(i));
            card.addCardHeader(header);
            cards.add(card);
        }

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, arrayList);
        list_View.setAdapter(adapter);


        FloatingActionButton document_fab = (FloatingActionButton) findViewById(R.id.document_fab);
        document_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fab_intent = new Intent(Documents.this,Add_Document.class);
                startActivity(fab_intent);

            }
        });

        list_View.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent edit_doc = new Intent(Documents.this,Edit_document.class);
                startActivity(edit_doc);

            }
        });
    }

}

