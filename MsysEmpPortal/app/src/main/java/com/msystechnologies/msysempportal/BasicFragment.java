package com.msystechnologies.msysempportal;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by pravinth on 21/1/16.
 */
public class BasicFragment extends Fragment {
    private Spinner profile_material_spinner;
    private Spinner profile_religion_spinner;
    private Spinner profile_blood_spinner;
    private Spinner profile_gender_spinner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.basic_info, container, false);
//        add spinner for profile matial status
        profile_material_spinner = (Spinner) view.findViewById(R.id.profile_martial_status);
        ArrayAdapter<CharSequence> submitted_adapter = ArrayAdapter.createFromResource(getActivity().getBaseContext(),
                R.array.profile_maritialstatus, android.R.layout.simple_spinner_item);
        submitted_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        profile_material_spinner.setAdapter(submitted_adapter);

        //add spinner for religion
        profile_religion_spinner = (Spinner) view.findViewById(R.id.profile_religion);
        ArrayAdapter<CharSequence> religion_adapter = ArrayAdapter.createFromResource(getActivity().getBaseContext(),
                R.array.profile_religion, android.R.layout.simple_spinner_item);
        religion_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        profile_religion_spinner.setAdapter(religion_adapter);

        //add spinner for blood group
        profile_blood_spinner = (Spinner) view.findViewById(R.id.profile_blood);
        ArrayAdapter<CharSequence> blood_adapter = ArrayAdapter.createFromResource(getActivity().getBaseContext(),
                R.array.profile_bloodgroup, android.R.layout.simple_spinner_item);
        blood_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        profile_blood_spinner.setAdapter(blood_adapter);

        //add spinner for gender
        profile_gender_spinner = (Spinner) view.findViewById(R.id.profile_gender);
        ArrayAdapter<CharSequence> gender_adapter = ArrayAdapter.createFromResource(getActivity().getBaseContext(),
                R.array.profile_gender, android.R.layout.simple_spinner_item);
        blood_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        profile_gender_spinner.setAdapter(gender_adapter);

        return view;
    }
}
