package edu.schoolapp.usm.jon.schoolofcomputing;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by jon on 4/13/2015.
 */
public class About_Fragment extends Fragment {

    private simple_web_view swv;
    private Bundle bun;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = (View) inflater.inflate(R.layout.about,container,false);

        bun = new Bundle();

        ActionBarActivity abv = (ActionBarActivity) getActivity();
        android.support.v7.app.ActionBar ab = abv.getSupportActionBar();
        ab.setTitle("About "+getArguments().getString("department name"));

        ListView listView = (ListView) view.findViewById(R.id.AboutlistView);
        listView.setAdapter(new custom_about_adapter(getActivity(),getArguments().getStringArray("about section")));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    switch(getArguments().getString("department name")){
                        case "Computer Science":
                            switch(position){
                                case 0:
                                    swv = new simple_web_view();
                                    bun.putString("html","<img src='ada.jpg' height='"+MainActivity.height+" width='"+MainActivity.width+"'/>");
                                    bun.putString("department name","Algorithm Design and Analysis");
                                    swv.setArguments(bun);
                                    getFragmentManager().beginTransaction().replace(R.id.container,swv).addToBackStack("about webview").commit();
                                    break;
                                case 1:
                                    swv = new simple_web_view();
                                    bun.putString("html","<img src='ai.jpg' height='"+MainActivity.height+" width='"+MainActivity.width+"'/>");
                                    bun.putString("department name","Artificial Intelligence");
                                    swv.setArguments(bun);
                                    getFragmentManager().beginTransaction().replace(R.id.container,swv).addToBackStack("about webview").commit();
                                    break;
                                case 2:
                                    swv = new simple_web_view();
                                    bun.putString("html","<img src='ip.jpg' height='"+MainActivity.height+" width='"+MainActivity.width+"'/>");
                                    bun.putString("department name","Image Processing");
                                    swv.setArguments(bun);
                                    getFragmentManager().beginTransaction().replace(R.id.container,swv).addToBackStack("about webview").commit();
                                    break;
                                case 3:
                                    swv = new simple_web_view();
                                    bun.putString("html","<img src='bi.jpg' height='"+MainActivity.height+" width='"+MainActivity.width+"'/>");
                                    bun.putString("department name","Bioinformatics");
                                    swv.setArguments(bun);
                                    getFragmentManager().beginTransaction().replace(R.id.container,swv).addToBackStack("about webview").commit();
                                    break;
                                // add more about departments if needed
                            }// end of csc switch
                            break;
                        // add more department names if need
                    }
            }
        });

        TextView header = (TextView) view.findViewById(R.id.about_title);
        TextView footer = (TextView) view.findViewById(R.id.about_footer);

        header.setText(getArguments().getString("header"));
        footer.setText(getArguments().getString("footer"));

        return view;
    }
}
