package com.msystechnologies.msysempportal;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by pravinth on 18/1/16.
 */

public class Profile_expandable extends BaseExpandableListAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    private Spinner profile_material_spinner;
    private Spinner profile_religion_spinner;
    private Spinner profile_blood_spinner;
    private Spinner profile_gender_spinner;
    private EditText dob_editText;
    private EditText passing_editText;
    private Calendar calendar;
    private int year, month, day;
    private Button button;


    Profile_expandable(Context context, LayoutInflater layoutInflater) {
        this.context = context;
        this.layoutInflater = layoutInflater;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return true;
    }
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        convertView = null;
        //datepicker for date of birth

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        if(groupPosition == 0) {
            convertView = View.inflate(context, R.layout.basic_info, null);

            //add spinner for profile matial status
            profile_material_spinner = (Spinner) convertView.findViewById(R.id.profile_martial_status);
            ArrayAdapter<CharSequence> submitted_adapter = ArrayAdapter.createFromResource(context,
                    R.array.profile_maritialstatus, android.R.layout.simple_spinner_item);
            submitted_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            profile_material_spinner.setAdapter(submitted_adapter);

            //add spinner for religion
            profile_religion_spinner = (Spinner) convertView.findViewById(R.id.profile_religion);
            ArrayAdapter<CharSequence> religion_adapter = ArrayAdapter.createFromResource(context,
                    R.array.profile_religion, android.R.layout.simple_spinner_item);
            religion_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            profile_religion_spinner.setAdapter(religion_adapter);

            //add spinner for blood group
            profile_blood_spinner = (Spinner) convertView.findViewById(R.id.profile_blood);
            ArrayAdapter<CharSequence> blood_adapter = ArrayAdapter.createFromResource(context,
                    R.array.profile_bloodgroup, android.R.layout.simple_spinner_item);
            blood_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            profile_blood_spinner.setAdapter(blood_adapter);

            //add spinner for gender
            profile_gender_spinner = (Spinner) convertView.findViewById(R.id.profile_gender);
            ArrayAdapter<CharSequence> gender_adapter = ArrayAdapter.createFromResource(context,
                    R.array.profile_gender, android.R.layout.simple_spinner_item);
            blood_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            profile_gender_spinner.setAdapter(gender_adapter);

            dob_editText =(EditText)convertView.findViewById(R.id.profile_birth_editText);
            showbirthDate(year, month+1, day);

        }else if(groupPosition == 1) {
            convertView = View.inflate(context, R.layout.employee_info, null);
            passing_editText =(EditText)convertView.findViewById(R.id.profile_passing_year);
            showpassingyear(year, month+1, day);
        }else if(groupPosition == 2) {
            convertView = View.inflate(context, R.layout.additional_info, null);

        }
        return convertView;
    }


    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public long getCombinedChildId(long groupId, long childId) {
        return 0;
    }

    @Override
    public long getCombinedGroupId(long groupId) {
        return 0;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public int getGroupCount() {
        return 4;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {

        View v = View.inflate(context, R.layout.parent, null);
        TextView txtView = (TextView) v.findViewById(R.id.parent);
        if(groupPosition == 0) {
            txtView.setText("Basic Info");
            txtView.setTypeface(null, Typeface.BOLD);
        }
        if(groupPosition == 1) {
            txtView.setText("Employee Info");
            txtView.setTypeface(null, Typeface.BOLD);
        }
        if(groupPosition == 2) {
            txtView.setText("Additonal Info");
            txtView.setTypeface(null, Typeface.BOLD);
        }
        return v;

    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }



//
//    @SuppressWarnings("deprecation")
//    public void setDate(View view) {
//        showDialog(999);
//    }
//
//    @Override
//    protected Dialog onCreateDialog(int id) {
//        // TODO Auto-generated method stub
//        if (id == 999) {
//            return new DatePickerDialog(context, myDateListener, year, month, day);
//        }
//        return null;
//    }

    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
            // TODO Auto-generated method stub
            // arg1 = year
            // arg2 = month
            // arg3 = day
            showbirthDate(arg1, arg2+1, arg3);
            showpassingyear(arg1, arg2+1, arg3);

        }
    };
    private void showbirthDate(int year, int month, int day) {

        dob_editText.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));

    }

    private void showpassingyear(int year, int month, int day) {
        passing_editText.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));

    }


}

