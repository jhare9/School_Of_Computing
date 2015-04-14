package edu.schoolapp.usm.jon.schoolofcomputing;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by jon on 4/13/2015.
 */
public class How_To_Apply_Fragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ActionBarActivity abv = (ActionBarActivity) getActivity();
        ActionBar ab = abv.getSupportActionBar();
        ab.setTitle("How to Apply");

        ListView list = (ListView) inflater.inflate(R.layout.custom_list_view,container,false);
        list.setAdapter(new Custom_menu_Adpater(getActivity(),new String[]{"First-time applicants","Previous applicants"}));
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        getFragmentManager().beginTransaction().replace(R.id.container,new first_time_app()).addToBackStack("first time app").commit();
                        break;
                    case 1:
                        getFragmentManager().beginTransaction().replace(R.id.container,new previous_app()).addToBackStack("previous app").commit();
                        break;
                }
            }
        });
        return list;
    }

    public static class first_time_app extends Fragment{
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = (View)inflater.inflate(R.layout.how_to_apply_first_time_app,container,false);
            TextView tv = (TextView) view.findViewById(R.id.application_info);
            tv.setText(new file_reader().line_reader(getActivity(),R.raw.first_time_applicant));
            return view;
        }
    }

    public static class previous_app extends Fragment{
        private file_reader fr;

        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = (View) inflater.inflate(R.layout.how_to_apply_previous_app,container,false);
            TextView tv1 = (TextView) view.findViewById(R.id.second_app_top);
            TextView tv2 = (TextView) view.findViewById(R.id.second_app_mid);
            TextView tv3 = (TextView) view.findViewById(R.id.second_app_bottom);

            fr = new file_reader();

            tv1.setText(fr.line_reader(getActivity(),R.raw.previous_app));
            tv2.setText(fr.line_reader(getActivity(),R.raw.previous_app_hattiesburg));
            tv3.setText(fr.line_reader(getActivity(),R.raw.previous_app_gulf_coast));

            return view;
        }
    }

}
