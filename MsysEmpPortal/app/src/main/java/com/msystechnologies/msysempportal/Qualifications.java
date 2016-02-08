package com.msystechnologies.msysempportal;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.internal.CardExpand;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.internal.ViewToClickToExpand;
import it.gmariotti.cardslib.library.view.CardListView;

public class Qualifications extends MainActivity {


    String get_doc;
    MyCard card;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_qualifications);

        // Set Navigation drawyer tool
        LayoutInflater inflater = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_qualifications, null, false);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.addView(contentView, 0);


        String[] courseitems = new String[]{"Bachelor of Engineering","Bachelor of Arts"};
        CardListView cardListView = (CardListView) findViewById(R.id.card_qualification);
        ArrayList<Card> qualification = new ArrayList<Card>();

        for (int i = 0; i<courseitems.length; i++) {

            //Create a Card
            card = new MyCard(this);
            card.setSwipeable(true);

            //Set enable icon visible
            CardHeader header = new CardHeader(this);
            card.addCardHeader(header);
            header.setButtonExpandVisible(true);



            //Add expand to card
            CustomExpandCard expand = new CustomExpandCard(getApplicationContext());
            card.addCardExpand(expand);

            //show the
            card.Header=courseitems[i];


            //Add cards to arraylist
            qualification.add(card);

        }

        CardArrayAdapter cardArrayAdapter = new CardArrayAdapter(this,qualification);
        cardListView.setAdapter(cardArrayAdapter);

//        Set enable the expand/collapse action by clicking on a different View
        ViewToClickToExpand viewToClickToExpand = ViewToClickToExpand.builder().setupView(cardListView);
        card.setViewToClickToExpand(viewToClickToExpand);


        //Add action to setOnSwipeListener
        card.setOnSwipeListener(new Card.OnSwipeListener() {
            @Override
            public void onSwipe(Card card) {
                Toast.makeText(getBaseContext(),"REMOVED",Toast.LENGTH_SHORT).show();
            }
        });

        //Floating  button action
        FloatingActionButton documentfab = (FloatingActionButton) findViewById(R.id.qualifications_fab);
        documentfab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fab_intent = new Intent(Qualifications.this,Add_qualifications.class);
                startActivity(fab_intent);

            }
        });
    }

}

//Custumize Expand view
class CustomExpandCard extends CardExpand {

    //Use your resource ID for your inner layout
    public CustomExpandCard(Context context) {
        super(context, R.layout.qualification_detailed_view);
    }

    @Override
    public void setupInnerViewElements(ViewGroup parent, View view) {
        parent.setBackgroundColor(Color.WHITE);
    }

}

//Custumize card
class MyCard extends Card{
    String Header;

    public MyCard(Context context){
        super(context, R.layout.qualification_card_innner_view);
    }

    @Override
    public void setupInnerViewElements(ViewGroup parent, View view) {

        TextView header= (TextView)view.findViewById(R.id.header);
        header.setText(Header);

        TextView edittxt= (TextView)view.findViewById(R.id.edit);
        edittxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getContext(),Edit_qualifications.class);
                mContext.startActivity(intent);
            }
        });
    }

}
