package com.msystechnologies.msysempportal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.List;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayMultiChoiceAdapter;
import it.gmariotti.cardslib.library.view.CardListView;
import it.gmariotti.cardslib.library.view.CardView;

/**
 * Created by pravinth on 26/12/15.
 */
public class MyCardArrayMultiChoiceAdapter extends CardArrayMultiChoiceAdapter {
    private Context context;
    public MyCardArrayMultiChoiceAdapter(Context context, List<Card> cards) {

        super(context, cards);
        this.context = context;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        return false;
    }

    @Override
    public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked, CardView cardView, Card card) {

    }




    public Card getItem(final int position){
        Card card = super.getItem(position);
        card.setOnClickListener(new Card.OnCardClickListener() {
            @Override
            public void onClick(Card card, View view) {
                switch(position){
                    case 0:
                        Intent doc_intent = new Intent(context, Documents.class);
                        context.startActivity(doc_intent);
                        break;
                    case 1:
                        Intent projects_intent = new Intent(context, Projects.class);
                        context.startActivity(projects_intent);
                        break;
                    case 2:
                        Intent leave_history_intent = new Intent(context, LeaveHistory.class);
                        context.startActivity(leave_history_intent);
                        break;
                    case 3:
                        Intent team_leves_intent = new Intent(context, TeamLeaves.class);
                        context.startActivity(team_leves_intent);
                        break;

                }
                Toast.makeText(getContext(), "Document clicked" , Toast.LENGTH_SHORT).show();

            }
        });
        return card;
    }




}


