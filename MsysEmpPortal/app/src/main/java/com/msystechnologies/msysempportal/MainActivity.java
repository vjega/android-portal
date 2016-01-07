package com.msystechnologies.msysempportal;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.view.Display;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private  NavigationView navigationView;
    private DrawerLayout drawer;
    private ExpandableListView expandableListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        fab.hide();



            /*get the headers and subitems from string array*/
        ArrayList<String> Headings=new ArrayList<String>();

        ArrayList<String>home_sub=new ArrayList<String>();
        ArrayList<String>leave_sub=new ArrayList<String>();
        ArrayList<String>infrastructure_sub=new ArrayList<String>();
        ArrayList<String>others_sub=new ArrayList<String>();

        final HashMap<String,List<String>> childlist = new HashMap<String, List<String>>();

        String heading_items[]=getResources().getStringArray(R.array.menu_titles);

        String home[]=getResources().getStringArray(R.array.Home_sub);

        String leave[]=getResources().getStringArray(R.array.Leave_sub);

        String infrastructure[]=getResources().getStringArray(R.array.Infrastructure_sub);

        String others[]=getResources().getStringArray(R.array.Others_sub);

        for(String title:heading_items){
            Headings.add(title);
        }
        for(String title:home){
            home_sub.add(title);
        }
        for(String title:leave){
            leave_sub.add(title);
        }
        for(String title:infrastructure){
            infrastructure_sub.add(title);
        }
        for(String title:others){
            others_sub.add(title);
        }

        childlist.put(Headings.get(1),home_sub);
        childlist.put(Headings.get(2),leave_sub);
        childlist.put(Headings.get(3),infrastructure_sub);
        childlist.put(Headings.get(4),others_sub);


        /*Pass headings and subitems as a arguments to expandablelistadabter*/

        ExpandableListAdapter listAdapter = new Expandablelistadapter(this, Headings, childlist);

        /*Get the Expandable listview*/
         expandableListView = (ExpandableListView)findViewById(R.id.expand);

        expandableListView.setAdapter(listAdapter);


        /*Set activity for groups*/
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                if(groupPosition ==0)
                {
                    Intent myIntent = new Intent(MainActivity.this,Dashboard.class);
                    startActivity(myIntent);

                    return true; // This way the expander cannot be collapsed
                }
                else{
                    return false;
                }
            }
        });

        /*Set activity for subitems*/

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            public Context context;
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(getBaseContext(),
                        groupPosition+" * " +childPosition+"is selected",
                        Toast.LENGTH_LONG).show();

                if(groupPosition == 1){
                    switch (childPosition) {
                        case 0:
                            Intent home_intent = new Intent(MainActivity.this, Profile.class);
                            startActivity(home_intent);

                            break;
                        case 1:
                            Intent doc_intent = new Intent(MainActivity.this, Documents.class);
                            startActivity(doc_intent);
                            break;
                        case 2:
                            Intent qualify_intent = new Intent(MainActivity.this, Qualifications.class);
                            startActivity(qualify_intent);
                            break;
                        case 3:
                            Intent family_intent = new Intent(MainActivity.this, Family.class);
                            startActivity(family_intent);
                            break;
                        case 4:
                            Intent exp_intent = new Intent(MainActivity.this, Experience.class);
                            startActivity(exp_intent);
                            break;
                        case 5:
                            Intent visa_intent = new Intent(MainActivity.this, Visa.class);
                            startActivity(visa_intent);
                            break;
                        case 6:
                            Intent projects_intent = new Intent(MainActivity.this, Projects.class);
                            startActivity(projects_intent);
                            break;
                        case 7:
                            Intent team_intent = new Intent(MainActivity.this, Team.class);
                            startActivity(team_intent);
                            break;
                        case 8:
                            Intent skill_intent = new Intent(MainActivity.this, Skillset.class);
                            startActivity(skill_intent);
                            break;

                    }

                }
                else if (groupPosition == 2){
                    switch (childPosition) {

                        case 0:
                            Intent apply_leave_intent = new Intent(MainActivity.this, ApplyLeave.class);
                            startActivity(apply_leave_intent);
                            break;
                        case 1:
                            Intent leave_history_intent = new Intent(MainActivity.this, LeaveHistory.class);
                            startActivity(leave_history_intent);
                            break;
                        case 2:
                            Intent team_leves_intent = new Intent(MainActivity.this, TeamLeaves.class);
                            startActivity(team_leves_intent);
                            break;

                    }

                }else if(groupPosition == 3){
                    switch (childPosition) {
                        case 0:
                            Intent it_intent = new Intent(MainActivity.this, ItTickets.class);
                            startActivity(it_intent);
                            break;
                        case 1:
                            Intent hr_intent = new Intent(MainActivity.this, HrTickets.class);
                            startActivity(hr_intent);
                            break;
                        case 2:
                            Intent interview_details_intent = new Intent(MainActivity.this, InterviewDetails.class);
                            startActivity(interview_details_intent);
                            break;
                        case 3:
                            Intent interview_history_intent = new Intent(MainActivity.this, InterviewHistory.class);
                            startActivity(interview_history_intent);
                            break;
                        case 4:
                            Intent circulars_intent = new Intent(MainActivity.this, Circulars.class);
                            startActivity(circulars_intent);
                            break;
                        case 5:
                            Intent resource_intent = new Intent(MainActivity.this, Resource.class);
                            startActivity(resource_intent);
                            break;
                    }

                }else if(groupPosition == 4){
                    switch (childPosition) {

                        case 0:
                            Intent event_intent = new Intent(MainActivity.this, Events.class);
                            startActivity(event_intent);
                            break;
                        case 1:
                            Intent openings_intent = new Intent(MainActivity.this, Openings.class);
                            startActivity(openings_intent);
                            break;
                        case 2:
                            Intent bug_intent = new Intent(MainActivity.this, Bug.class);
                            startActivity(bug_intent);
                            break;

                    }
                }
                drawer.closeDrawer(GravityCompat.START);
                return false;
            }

        });


    }

//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Profile/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        switch(id){
//            case R.id.action_userprofile:
//                Intent home_intent = new Intent(this, Profile.class);
//                startActivity(home_intent);
//                break;
//            case R.id.action_settings:
//                Intent settings_intent = new Intent(this, Settings.class);
//                startActivity(settings_intent);
//                break;
//            case R.id.action_bugreport:
//                Intent bug_intent = new Intent(this, Bug.class);
//                startActivity(bug_intent);
//                break;
//            case R.id.action_logout:
//                Intent logout_intent = new Intent(this, LoginActivity.class);
//                startActivity(logout_intent);
//                break;
//
//        }
//
//
//
//        return super.onOptionsItemSelected(item);
//    }

    public void profileClick(View v){
        Intent home_intent = new Intent(this, Profile.class);
        startActivity(home_intent);
    }

    public void settingsClick(View v){
        Intent settings_intent = new Intent(this, Settings.class);
        startActivity(settings_intent);
    }

    public void logoutClick(View v){
        Intent logout_intent = new Intent(this, LoginActivity.class);
        startActivity(logout_intent);
    }


}
