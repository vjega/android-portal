package com.msystechnologies.msysempportal;

/**
 * Created by pravinth on 21/12/15.
 */
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by pravinth on 17/12/15.
 */
public class Expandablelistadapter extends BaseExpandableListAdapter {
    private Context _context;
    private List<String> header; // header titles
    // child data in format of header title, child title
    private HashMap<String, List<String>> child;

    public Expandablelistadapter(Context context, List<String> listDataHeader,
                                 HashMap<String, List<String>> listChildData) {
        this._context = context;
        this.header = listDataHeader;
        this.child = listChildData;
    }

    public Expandablelistadapter() {
    }


    @Override
    public int getGroupCount() {
        return this.header.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.child.get(this.header.get(groupPosition))
                .size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.header.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return child.get(this.header.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String grouptitle =(String)getGroup(groupPosition);
        if(convertView == null){
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView =infalInflater.inflate(R.layout.parent,null);

        }
        TextView parent_textview = (TextView)convertView.findViewById(R.id.parent);
        parent_textview.setTypeface(null, Typeface.BOLD);
        parent_textview.setText(grouptitle);
        return convertView;


    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String childtitle =(String)getChild(groupPosition,childPosition);
        if(convertView == null){
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView =infalInflater.inflate(R.layout.child,null);


        }
        TextView parent_textview = (TextView)convertView.findViewById(R.id.child);
        parent_textview.setText(childtitle);

        return convertView;

    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}
