package com.msystechnologies.msysempportal;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.internal.CardThumbnail;
import it.gmariotti.cardslib.library.view.CardGridView;
import it.gmariotti.cardslib.library.view.CardListView;


public class Dashboard extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        String[] dashboard_items = new String[]{"Uploaded Docs", "Current Projects", "Leave Applied", "Leaves For Approval"};

        int listImages[] = new int[]{R.drawable.angry_1, R.drawable.angry_2,
                R.drawable.angry_3, R.drawable.angry_4};

        ArrayList<Card> cards = new ArrayList<Card>();

        for (int i = 0; i<listImages.length; i++) {
            // Create a Card
            Card card = new Card(this);
            // Create a CardHeader
            CardHeader header = new CardHeader(this);
            // Add Header to card
            header.setTitle(dashboard_items[i]);
            card.addCardHeader(header);

            CardThumbnail thumb = new CardThumbnail(this);
            thumb.setDrawableResource(listImages[i]);
            card.addCardThumbnail(thumb);

            cards.add(card);
        }

//        CardArrayAdapter mCardArrayAdapter = new CardArrayAdapter(this, cards)
//        CardGridView cardGridView = (CardGridView) this.findViewById(R.id.myList);

        MyCardArrayMultiChoiceAdapter myCardArrayMultiChoiceAdapter =new MyCardArrayMultiChoiceAdapter(this,cards);

        CardListView cardListView = (CardListView) this.findViewById(R.id.myList);

        if (cardListView != null) {
            cardListView.setAdapter(myCardArrayMultiChoiceAdapter);

        }


    }
}
