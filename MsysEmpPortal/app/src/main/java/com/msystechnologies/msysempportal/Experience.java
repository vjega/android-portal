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

import java.util.ArrayList;
import java.util.HashMap;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayMultiChoiceAdapter;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.view.CardListView;
import it.gmariotti.cardslib.library.view.CardView;

public class Experience extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_experience);
        LayoutInflater inflater = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_experience, null, false);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.addView(contentView, 0);

        //card list start
        CardListView card_list_View = (CardListView) this.findViewById(R.id.experience_cardlist);
        registerForContextMenu(card_list_View);
        ArrayList<String> arrayList = new ArrayList<String>();
        ArrayList<Card> cards = new ArrayList<Card>();

        HashMap<String, String> map = new HashMap<String, String>();
        ArrayList<String> a = new ArrayList<String>();
        arrayList.add("item1");
        arrayList.add("item2");

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



        FloatingActionButton document_fab = (FloatingActionButton) findViewById(R.id.experience_fab);
        document_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fab_intent = new Intent(Experience.this,Add_Experience.class);
                startActivity(fab_intent);

            }
        });
    }
}
