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
 * Created by jon on 4/13/2015.
 */
public class Scholarship_Fragment extends Fragment {
    private Bundle bun;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle bundle) {
        ListView list = (ListView) inflater.inflate(R.layout.custom_list_view,container,false);
        String[] title={"Scholarship Guidelines","Scholarship Opportunities"};
        bun = new Bundle();

        ActionBarActivity abv = (ActionBarActivity) getActivity();
        ActionBar ab = abv.getSupportActionBar();
        ab.setTitle("Scholarships");

        list.setAdapter(new Custom_menu_Adpater(getActivity(),title));
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        simple_web_view scholar_guide = new simple_web_view();
                        bun.putString("html", "<img src='guide_sch.jpg' height='" + MainActivity.height + " width='" + MainActivity.width + "'/>");
                        bun.putString("department name","Scholarships");
                        scholar_guide.setArguments(bun);
                        getFragmentManager().beginTransaction().replace(R.id.container, scholar_guide).addToBackStack("scholar guide").commit();
                        break;
                    case 1:
                        getFragmentManager().beginTransaction().replace(R.id.container,new scholar_opp()).addToBackStack("scholar opp").commit();
                        break;
                }
            }

        });
        return list;
    }


    public static class scholar_opp extends Fragment{
        private Bundle bun;
        private simple_web_view scholar;
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            ListView list = (ListView) inflater.inflate(R.layout.custom_list_view,container,false);
            String[] title ={"General Admissions Scholarship Opportunities","Competitive Based Scholarship Opportunities"};

            bun = new Bundle();

            list.setAdapter(new Custom_menu_Adpater(getActivity(),title));

            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    switch(position){
                        case 0:
                            scholar = new simple_web_view();
                            bun.putString("html","<img src='gen_sch.jpg' height='"+MainActivity.height+" width='"+MainActivity.width+"'/>");
                            bun.putString("department name","Scholarships");
                            scholar.setArguments(bun);
                            getFragmentManager().beginTransaction().replace(R.id.container,scholar).addToBackStack("general").commit();
                            break;
                        case 1:
                            scholar = new simple_web_view();
                            bun.putString("html","<img src='comp_sch.jpg' height='"+MainActivity.height+" width='"+MainActivity.width+"'/>");
                            bun.putString("department name","Scholarships");
                            scholar.setArguments(bun);
                            getFragmentManager().beginTransaction().replace(R.id.container,scholar).addToBackStack("competitive").commit();
                            break;
                    }
                }
            });
            return list;
        }
    }

}

