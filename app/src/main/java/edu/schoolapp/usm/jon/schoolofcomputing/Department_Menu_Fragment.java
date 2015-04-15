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
                        }
                        break;
                    case "Information Technology":
                        switch(position){
                            case 0:
                                getFragmentManager().beginTransaction().replace(R.id.container,MainActivity.PlaceholderFragment.newInstance(position)).commit();
                                ab.setTitle(getString(R.string.app_name));
                                break;
                            case 1:
                                af = new About_Fragment();
                                bun.putString("department name","Information Technology");
                                bun.putStringArray("about section",new String[]{"Client-server networking"," wide-area networking","information security","cloud Security","operating system administrations"});

                                bun.putString("header","Topics in Information Technology");
                                bun.putString("footer","Andrew Sung CSC director Hattiesburg, Ms 39406-5106 601-266-6639");
                                af.setArguments(bun);
                                getFragmentManager().beginTransaction().replace(R.id.container,af).addToBackStack("about").commit();
                                break;
                            case 2:
                                swv = new simple_web_view();
                                bun.putString("department name","Itc degree plan");
                                bun.putString("html","<img src='info_degree_plan.png' height='"+MainActivity.height+" width='"+MainActivity.width+"'/>");
                                bun.putInt("scale",250);
                                swv.setArguments(bun);
                                getFragmentManager().beginTransaction().replace(R.id.container,swv).addToBackStack("degree plan").commit();
                                break;
                            case 3:
                                course_des = new Course_Des_Fragment();
                                bun.putInt("text file",R.raw.information_techonolgy_course_des);
                                bun.putString("department name","ITC course description");
                                course_des.setArguments(bun);
                                getFragmentManager().beginTransaction().replace(R.id.container,course_des).addToBackStack("course des").commit();
                                break;
                        }
                        break;
                    case "Information Technology(developer)":
                        switch(position){
                            case 0:
                                getFragmentManager().beginTransaction().replace(R.id.container,MainActivity.PlaceholderFragment.newInstance(position)).commit();
                                ab.setTitle(getString(R.string.app_name));
                                break;
                            case 1:
                                af = new About_Fragment();
                                bun.putString("department name","Information Technology(Developer)");
                                bun.putStringArray("about section",new String[]{"Client-server networking","information security","Software Development","Algorithm Design and Analysis","cloud Security","operating system administrations"});
                                bun.putString("header","Topics in Information Technology(Developer)");
                                bun.putString("footer","Andrew Sung CSC director Hattiesburg, Ms 39406-5106 601-266-6639");
                                af.setArguments(bun);
                                getFragmentManager().beginTransaction().replace(R.id.container,af).addToBackStack("about").commit();
                                break;
                            case 2:
                                swv = new simple_web_view();
                                bun.putString("department name","Itc(dev) degree plan");
                                bun.putString("html","<img src='dev_info_degree_plan.png' height='"+MainActivity.height+" width='"+MainActivity.width+"'/>");
                                bun.putInt("scale",250);
                                swv.setArguments(bun);
                                getFragmentManager().beginTransaction().replace(R.id.container,swv).addToBackStack("degree plan").commit();
                                break;
                            case 3:
                                course_des = new Course_Des_Fragment();
                                bun.putInt("text file",R.raw.information_techonolgy_course_des);
                                bun.putString("department name","Itc(dev) course description");
                                course_des.setArguments(bun);
                                getFragmentManager().beginTransaction().replace(R.id.container,course_des).addToBackStack("course des").commit();
                                break;

                        }
                        break;
                    case "Electrical Engineering":
                        switch(position){
                            case 0:
                                getFragmentManager().beginTransaction().replace(R.id.container,MainActivity.PlaceholderFragment.newInstance(position)).commit();
                                ab.setTitle(getString(R.string.app_name));
                                break;
                            case 1:
                                af = new About_Fragment();
                                bun.putString("department name","Electronics Engineering");
                                bun.putStringArray("about section",new String[]{"analog circuits","digital circuits","embedded computers","traditional instrumentation"
                                ,"virtual instrumentation","analog communications","digital communications","electrical power","audio/video","automation/control systems"});
                                bun.putString("header","Topics in Electronic Engineering");
                                bun.putString("footer","Andrew Sung CSC director Hattiesburg, Ms 39406-5106 601-266-6639");
                                af.setArguments(bun);
                                getFragmentManager().beginTransaction().replace(R.id.container,af).addToBackStack("about").commit();
                                break;
                            case 2:
                                swv = new simple_web_view();
                                bun.putString("department name","Ee degree plan");
                                bun.putString("html","<img src='ee_degree_plan.png' height='"+MainActivity.height+" width='"+MainActivity.width+"'/>");
                                bun.putInt("scale",250);
                                swv.setArguments(bun);
                                getFragmentManager().beginTransaction().replace(R.id.container,swv).addToBackStack("degree plan").commit();
                                break;
                            case 3:
                                course_des = new Course_Des_Fragment();
                                bun.putInt("text file",R.raw.electrical_engineering_cousre_des);
                                bun.putString("department name","Electronic Engineering");
                                course_des.setArguments(bun);
                                getFragmentManager().beginTransaction().replace(R.id.container,course_des).addToBackStack("course des").commit();
                                break;

                        }
                        break;
                    case "Computer Engineering":
                        switch(position){
                            case 0:
                                getFragmentManager().beginTransaction().replace(R.id.container,MainActivity.PlaceholderFragment.newInstance(position)).commit();
                                ab.setTitle(getString(R.string.app_name));
                               break;
                            case 1:
                                af = new About_Fragment();
                                bun.putString("department name","Computer Engineering");
                                bun.putStringArray("about section",new String[]{"analog and digital circuits","computers","microprocessors communications","microcontrollers","automation/control systems"});
                                bun.putString("header","Topics in Computer Engineering");
                                bun.putString("footer","Andrew Sung CSC director Hattiesburg, Ms 39406-5106 601-266-6639");
                                af.setArguments(bun);
                                getFragmentManager().beginTransaction().replace(R.id.container,af).addToBackStack("about").commit();
                                break;
                            case 2:
                                swv = new simple_web_view();
                                bun.putString("department name","Ce degree plan");
                                bun.putString("html","<img src='ce_degree_plan.png' height='"+MainActivity.height+" width='"+MainActivity.width+"'/>");
                                bun.putInt("scale",250);
                                swv.setArguments(bun);
                                getFragmentManager().beginTransaction().replace(R.id.container,swv).addToBackStack("degree plan").commit();
                                break;
                            case 3:
                                course_des = new Course_Des_Fragment();
                                bun.putInt("text file",R.raw.computer_engineering_course_des);
                                bun.putString("department name","Computer Engineering");
                                course_des.setArguments(bun);
                                getFragmentManager().beginTransaction().replace(R.id.container,course_des).addToBackStack("course des").commit();
                                break;
                        }
                        break;
                }
            }
        });

        return list;

    }
}
