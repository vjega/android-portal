package com.msystechnologies.msysempportal;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by pravinth on 21/1/16.
 */
public class EmployeeFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.employee_info, container, false);
//        TextView textView = (TextView) view;
//        textView.setText("Fragment #" + mPage);
        return view;
    }
}
