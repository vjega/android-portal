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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayMultiChoiceAdapter;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.view.CardListView;
import it.gmariotti.cardslib.library.view.CardView;

import static java.lang.System.*;

public class Qualifications extends MainActivity {

    public static final String JSON_URL = "http://www.mocky.io/v2/569669bf1300002440f9e421";
    private  ListView list_View;
    private  EditText editText;
    ArrayAdapter adapter;
    ArrayList<String> arrayList = new ArrayList<String>();
    String get_doc;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_qualifications);

        // Set Navigation drawyer tool
        LayoutInflater inflater = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_qualifications, null, false);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.addView(contentView, 0);

        //Valley request
        sendRequest();


        //Floating action
        FloatingActionButton document_fab = (FloatingActionButton) findViewById(R.id.qualifications_fab);
        document_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fab_intent = new Intent(Qualifications.this,Add_qualifications.class);
                startActivity(fab_intent);

            }
        });
    }

    //use volley to fetch the json string.
    private void sendRequest(){
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET,JSON_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        showJSON(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println("####"+error);

                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

        //        stringRequest.setRetryPolicy(new RetryPolicy() {
        //            @Override
        //            public int getCurrentTimeout() {
        //                return 50000;
        //            }
        //
        //            @Override
        //            public int getCurrentRetryCount() {
        //                return 50000;
        //            }
        //
        //            @Override
        //            public void retry(VolleyError error) throws VolleyError {
        //
        //            }
        //        });
    }

    //After getting the JSON we can display it in the ListView.
    private void showJSON(String json){
//        ParseJSON pj = new ParseJSON(json);
//        pj.parseJSON();

        try {
            JSONArray get_json_array = new JSONArray(json);
            for(int i =0;i<get_json_array.length();i++){
                get_doc = get_json_array.getJSONObject(i).getString("doc_name");
                arrayList.add(get_doc);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        list_View = (ListView) this.findViewById(R.id.qualifications_listView);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, arrayList);
        list_View.setAdapter(adapter);

        //Onclick listener for listview
        list_View.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent edit_doc = new Intent(Qualifications.this,Edit_qualifications.class);
                startActivity(edit_doc);

            }
        });
    }

}
