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
public class Department_Menu_Fragment extends Fragment {
    private About_Fragment af;
    private Bundle bun;
    private simple_web_view swv;
    private Course_Des_Fragment course_des;
    private Instructor_List_Fragment instructor_list;
    private ActionBar ab;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle bundle) {

        ActionBarActivity abv = (ActionBarActivity) getActivity();
        ab = abv.getSupportActionBar();
        ab.setTitle(getArguments().getString("department name"));

        ListView  list = (ListView) inflater.inflate(R.layout.custom_list_view,container,false);
        list.setAdapter(new Custom_menu_Adpater(getActivity(),getArguments().getStringArray("title")));
        bun = new Bundle();
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (getArguments().getString("department name")) {
                    case "Computer Science":
                        switch (position){
                            case 0:
                                // home
                                getFragmentManager().beginTransaction().replace(R.id.container,MainActivity.PlaceholderFragment.newInstance(position)).commit();
                                ab.setTitle(getString(R.string.app_name));
                                break;
                            case 1:
                                // about computer science
                                af = new About_Fragment();
                                bun.putString("department name","Computer Science");
                                bun.putStringArray("about section",new String[]{"Algorithm Design and Analysis","Artificial Intelligence","Image Processing","Bioinformatics"});
                                bun.putString("header","Topics in Computer Science");
                                bun.putString("footer","Andrew Sung CSC director Hattiesburg, Ms 39406-5106 601-266-6639");
                                af.setArguments(bun);
                                getFragmentManager().beginTransaction().replace(R.id.container,af).addToBackStack("about").commit();
                                break;
                            case 2:
                                // degree plan
                                swv = new simple_web_view();
                                bun.putString("department name","csc degree plan");
                                bun.putString("html","<img src='dp.jpg' height='"+MainActivity.height+" width='"+MainActivity.width+"'/>");
                                swv.setArguments(bun);
                                getFragmentManager().beginTransaction().replace(R.id.container,swv).addToBackStack("degree plan").commit();
                                break;
                            case 3:
                                // course Descriptions
                                course_des = new Course_Des_Fragment();
                                bun.putInt("text file",R.raw.csc_course_des);
                                bun.putString("department name","csc course description");
                                course_des.setArguments(bun);
                                getFragmentManager().beginTransaction().replace(R.id.container,course_des).addToBackStack("course des").commit();
                                break;
                            case 4:
                                // faculty
                                instructor_list = new Instructor_List_Fragment();
                                bun.putStringArray("instructor",getResources().getStringArray(R.array.csc_teachers));
                                bun.putIntArray("image", new int[]{R.drawable.dia, R.drawable.banerjee, R.drawable.bond, R.drawable.chen, R.drawable.koh, R.drawable.murali,
                                        R.drawable.anton, R.drawable.sun, R.drawable.sung,
                                        R.drawable.wang, R.drawable.zheng, R.drawable.xu, R.drawable.zhang, R.drawable.zhou});
                                bun.putString("department name","csc faculty");
                                instructor_list.setArguments(bun);
                                getFragmentManager().beginTransaction().replace(R.id.container,instructor_list).addToBackStack("instructor list").commit();
                                break;
                            case 5:
                                // scholarships
                                getFragmentManager().beginTransaction().replace(R.id.container,new Scholarship_Fragment()).addToBackStack("scholarships").commit();
                                break;
                            case 6:
                                // how to apply
                                getFragmentManager().beginTransaction().replace(R.id.container,new How_To_Apply_Fragment()).addToBackStack("how to apply").commit();
                                break;
                            case 7:
                                //student organization
                                swv = new simple_web_view();
                                bun.putString("html","<img src='acm.jpg' height='"+MainActivity.height+" width='"+MainActivity.width+"'/>");
                                bun.putString("department name","ACM");
                                swv.setArguments(bun);
                                getFragmentManager().beginTransaction().replace(R.id.container,swv).addToBackStack("student org").commit();
                                break;
                            case 8:
                                //facilities
                                swv = new simple_web_view();
                                bun.putString("html","<img src='labs.jpg' height='"+MainActivity.height+" width='"+MainActivity.width+"'/>");
                                bun.putString("department name","Facilities");
                                swv.setArguments(bun);
                                getFragmentManager().beginTransaction().replace(R.id.container,swv).addToBackStack("facilities").commit();
                                break;

                        }
                        break;
                }
            }
        });

        return list;

    }
}
