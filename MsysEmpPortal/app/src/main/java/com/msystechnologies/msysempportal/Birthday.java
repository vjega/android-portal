package com.msystechnologies.msysempportal;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.internal.CardExpand;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.internal.CardThumbnail;
import it.gmariotti.cardslib.library.internal.ViewToClickToExpand;
import it.gmariotti.cardslib.library.view.CardListView;

public class Birthday extends MainActivity {
    ArrayAdapter adapter;
    ArrayList<String> arrayList = new ArrayList<String>();
    Birthdaycard card;
    ArrayList<Card> birthday = new ArrayList<Card>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_birthday);
        LayoutInflater inflater = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_birthday, null, false);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.addView(contentView, 0);


        String[] courseitems = new String[]{"Karthick","Mohanrajan"};
        int listImages[] = new int[]{R.drawable.karthik, R.drawable.mohan};
        CardListView cardListView = (CardListView) findViewById(R.id.card_birthday);
        for (int i = 0; i<courseitems.length; i++) {

            //Create a Card
            card = new Birthdaycard(this);
            card.setSwipeable(true);

            card.birthadyname = courseitems[i];
            card.drawable=listImages[i];


            //Add cards to arraylist
            birthday.add(card);

        }

        //Adapter for card
        CardArrayAdapter cardArrayAdapter = new CardArrayAdapter(this,birthday) {

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                return super.getView(position, convertView, parent);
            }

        };

        //Add adapter to cardview
        if (cardListView!=null){
            cardListView.setAdapter(cardArrayAdapter);
        }


        //Add action to setOnSwipeListener
        card.setOnSwipeListener(new Card.OnSwipeListener() {
            @Override
            public void onSwipe(Card card) {
                Toast.makeText(getBaseContext(),"REMOVED",Toast.LENGTH_SHORT).show();
            }
        });
    }
}



//Custumize Expand view
class BirthdayExpandCard extends CardExpand {

    //Use your resource ID for your inner layout
    public BirthdayExpandCard(Context context) {
        super(context, R.layout.qualification_detailed_view);

    }

    @Override
    public void setupInnerViewElements(ViewGroup parent, View view) {
        parent.setBackgroundColor(Color.WHITE);
    }

}

//Custumize card
class Birthdaycard extends Card{
    int drawable;
    String birthadyname;

    public Birthdaycard(Context context){
        super(context, R.layout.birthday_inner_view);

    }

    @Override
    public void setupInnerViewElements(ViewGroup parent, View view) {
        super.setupInnerViewElements(parent, view);
        ImageView imageView = (ImageView)view.findViewById(R.id.birthday_image);
        imageView.setImageResource(drawable);

        TextView header = (TextView)view.findViewById(R.id.birthday_header);
        header.setText(birthadyname);

    }
}