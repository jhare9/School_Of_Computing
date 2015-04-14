package edu.schoolapp.usm.jon.schoolofcomputing;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by jon on 4/14/2015.
 */
public class Facilities_Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ActionBarActivity abv = (ActionBarActivity) getActivity();
        ActionBar ab =  abv.getSupportActionBar();
        ab.setTitle("Facilities");

        ListView list = (ListView) inflater.inflate(R.layout.custom_list_view,container,false);
        list.setAdapter(new Custom_menu_Adpater(getActivity(),new String[]{"Tutoring Lab","High Performance Visualization Lab"}));
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Bundle bun = new Bundle();
                simple_web_view swv = new simple_web_view();

                switch(position){
                    case 0:
                        bun.putString("html","<img src='tutoring_lab.jpg' height='"+MainActivity.height+" width='"+MainActivity.width+"'/>");
                        bun.putString("department name","Tutoring Lab");
                        swv.setArguments(bun);
                        getFragmentManager().beginTransaction().replace(R.id.container,swv).addToBackStack("tutoring lab").commit();
                        break;
                    case 1:
                        bun.putString("html","<img src='vis_lab.jpg' height='"+MainActivity.height+" width='"+MainActivity.width+"'/>");
                        bun.putString("department name","High Performance Visualization Lab");
                        swv.setArguments(bun);
                        getFragmentManager().beginTransaction().replace(R.id.container,swv).addToBackStack("vis lab").commit();
                        break;
                }// add more computer labs if needed
            }
        });

        return list;
    }
}
