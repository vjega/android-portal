package com.msystechnologies.msysempportal;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
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

//        ActionBar actionBar = getActionBar();
//        actionBar.setHomeButtonEnabled(true);

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



        CardListView card_list_View = (CardListView) this.findViewById(R.id.document_cardlist);
        registerForContextMenu(card_list_View);
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

        CardArrayMultiChoiceAdapter cardArrayMultiChoiceAdapter =new CardArrayMultiChoiceAdapter(this,cards) {
            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                return true;
            }

            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked, CardView cardView, Card card) {

            }


        };
        card_list_View.setAdapter(cardArrayMultiChoiceAdapter);
        registerForContextMenu(card_list_View);



        FloatingActionButton document_fab = (FloatingActionButton) findViewById(R.id.document_fab);
        document_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fab_intent = new Intent(Documents.this,Add_Document.class);
                startActivity(fab_intent);

            }
        });
    }




    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select The Action");
        menu.add(0, v.getId(), 0, "Call");//groupId, itemId, order, title
        menu.add(0, v.getId(), 0, "SMS");
    }
    @Override
    public boolean onContextItemSelected(MenuItem item){
        if(item.getTitle()=="Call"){
            Toast.makeText(getApplicationContext(),"calling code",Toast.LENGTH_LONG).show();
        }
        else if(item.getTitle()=="SMS"){
            Toast.makeText(getApplicationContext(),"sending sms code",Toast.LENGTH_LONG).show();
        }else{
            return false;
        }
        return true;
    }

}

