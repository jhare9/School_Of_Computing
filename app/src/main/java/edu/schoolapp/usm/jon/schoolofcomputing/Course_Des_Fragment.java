package edu.schoolapp.usm.jon.schoolofcomputing;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;



/**
 * Created by jon on 4/13/2015.
 */
public class Course_Des_Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ActionBarActivity abv = (ActionBarActivity)getActivity();
        ActionBar ab = abv.getSupportActionBar();
        ab.setTitle(getArguments().getString("department name"));

        ListView list = (ListView) inflater.inflate(R.layout.custom_list_view,container,false);
        list.setAdapter(new custom_course_des_list(getActivity(),getArguments().getInt("text file")));
        return list;
    }
}
