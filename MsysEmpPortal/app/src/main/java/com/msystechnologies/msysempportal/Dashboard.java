package com.msystechnologies.msysempportal;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.internal.CardGridArrayAdapter;
import it.gmariotti.cardslib.library.internal.CardGridArrayMultiChoiceAdapter;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.internal.CardThumbnail;
import it.gmariotti.cardslib.library.view.CardGridView;
import it.gmariotti.cardslib.library.view.CardListView;
import it.gmariotti.cardslib.library.view.CardView;


public class Dashboard extends MainActivity {
    private Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_dashboard);

        //set navigation drawer
        LayoutInflater inflater = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_dashboard, null, false);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.addView(contentView, 0);

        //get the id of gridview
        CardGridView gridView = (CardGridView) this.findViewById(R.id.cardGridMenu);

        String[] dashboard_items = new String[]{"Uploaded Docs", "Current Projects", "Leave Applied", "Circulars","Birthdays","Holidays"};

        int listImages[] = new int[]{R.drawable.upload,
                R.drawable.project,
                R.drawable.leave, R.drawable.circular,R.drawable.gift,R.drawable.calendar};

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

            CardGridArrayMultiChoiceAdapter cardGridArrayMultiChoiceAdapter = new CardGridArrayMultiChoiceAdapter(this, cards) {
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked, CardView cardView, Card card) {

            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                return false;
            }

            public Card getItem(final int position){
                Card card = super.getItem(position);
                card.setOnClickListener(new Card.OnCardClickListener() {
                    @Override
                    public void onClick(Card card, View view) {
                        switch(position){
                            case 0:
                                Intent doc_intent = new Intent(Dashboard.this, Documents.class);
                                startActivity(doc_intent);
                                break;
                            case 1:
                                Intent projects_intent = new Intent(Dashboard.this, Projects.class);
                                startActivity(projects_intent);
                                break;
                            case 2:
                                Intent leave_history_intent = new Intent(Dashboard.this, LeaveHistory.class);
                                startActivity(leave_history_intent);
                                break;
                            case 3:
                                Intent circular_intent = new Intent(Dashboard.this, Circulars.class);
                                startActivity(circular_intent);
                                break;
                            case 4:
                                Intent birthday_intent = new Intent(Dashboard.this, Birthday.class);
                                startActivity(birthday_intent);
                                break;
                            case 5:
                                Intent holiday_intent = new Intent(Dashboard.this, Holiday.class);
                                startActivity(holiday_intent);
                                break;


                        }
                        Toast.makeText(getContext(), "Document clicked" , Toast.LENGTH_SHORT).show();

                    }
                });
                    return card;
                }

        };

        if (gridView!=null){
            gridView.setAdapter(cardGridArrayMultiChoiceAdapter);

        }



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_dashboard, menu);
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
            case R.id.dashboard_notifications:
                Toast.makeText(getApplicationContext(), "Notification Saved", Toast.LENGTH_SHORT).show();
                break;
            case R.id.dashboard_todolist:
                Toast.makeText(getApplicationContext(), "Todolist Saved", Toast.LENGTH_SHORT).show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }



}
