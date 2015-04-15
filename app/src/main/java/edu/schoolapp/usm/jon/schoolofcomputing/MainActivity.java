package edu.schoolapp.usm.jon.schoolofcomputing;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.ArrayAdapter;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    public static int width;
    public static int height;
    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    private Department_Menu_Fragment dmf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DisplayMetrics dm = getResources().getDisplayMetrics();
        width = dm.widthPixels;
        height = dm.heightPixels;


        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
                .commit();

        Bundle bun = new Bundle();
        dmf = new Department_Menu_Fragment();

        switch(position) {

            case 1:
                // computer science department
                bun.putStringArray("title", new String[]{ "Home", "About Computer Science", "Degree Plan",
                    "Course Descriptions"});
                bun.putString("department name", "Computer Science");
                dmf.setArguments(bun);
                fragmentManager.beginTransaction().replace(R.id.container, dmf).addToBackStack("department menu").commit();
                break;

            case 2:
                // itc department
                bun.putStringArray("title", new String[]{ "Home", "About Information Technology", "Degree Plan",
                        "Course Descriptions"});
                bun.putString("department name", "Information Technology");
                dmf.setArguments(bun);
                fragmentManager.beginTransaction().replace(R.id.container, dmf).addToBackStack("department menu").commit();
                break;
            case 3:
                // itc developer department
                bun.putStringArray("title", new String[]{ "Home", "About Information technology(developer)", "Degree Plan",
                        "Course Descriptions"});
                bun.putString("department name", "Information Technology(developer)");
                dmf.setArguments(bun);
                fragmentManager.beginTransaction().replace(R.id.container, dmf).addToBackStack("department menu").commit();
                break;
            case 4:
                //ee department
                bun.putStringArray("title", new String[]{ "Home", "About Electronic Engineering", "Degree Plan",
                        "Course Descriptions"});
                bun.putString("department name", "Electrical Engineering");
                dmf.setArguments(bun);
                fragmentManager.beginTransaction().replace(R.id.container, dmf).addToBackStack("department menu").commit();
                break;
            case 5:
                bun.putStringArray("title", new String[]{ "Home", "About Computer Engineering", "Degree Plan",
                        "Course Descriptions"});
                bun.putString("department name", "Computer Engineering");
                dmf.setArguments(bun);
                fragmentManager.beginTransaction().replace(R.id.container, dmf).addToBackStack("department menu").commit();
                break;
            case 6:
                // faculty
                Instructor_List_Fragment instructor_list = new Instructor_List_Fragment();
                bun.putStringArray("instructor",getResources().getStringArray(R.array.csc_teachers));
                bun.putIntArray("image", new int[]{R.drawable.todd_adams,R.drawable.dia,R.drawable.biju_bajracharya, R.drawable.banerjee, R.drawable.bond,R.drawable.randy_buchanan, R.drawable.chen,R.drawable.amer_dawoud,R.drawable.jeremy_graves,
                        R.drawable.rick_hawkins,R.drawable.koh, R.drawable.murali,
                        R.drawable.anton,R.drawable.kelly_robinson, R.drawable.sun, R.drawable.sung,
                        R.drawable.wang, R.drawable.zheng,R.drawable.connie_white, R.drawable.xu, R.drawable.zhang, R.drawable.zhou});
                bun.putString("department name","csc faculty");
                instructor_list.setArguments(bun);
                fragmentManager.beginTransaction().replace(R.id.container,instructor_list).addToBackStack("instructor list").commit();
                break;
            case 7:
                // scholarships
                fragmentManager.beginTransaction().replace(R.id.container,new Scholarship_Fragment()).addToBackStack("scholarships").commit();
                break;
            case 8:
                // student organization
                simple_web_view swv = new simple_web_view();
                bun.putString("html","<img src='acm.jpg' height='"+MainActivity.height+" width='"+MainActivity.width+"'/>");
                bun.putString("department name","ACM");
                swv.setArguments(bun);
                fragmentManager.beginTransaction().replace(R.id.container,swv).addToBackStack("student org").commit();
                break;
            case 9:
                //facilities
                fragmentManager.beginTransaction().replace(R.id.container,new Facilities_Fragment()).addToBackStack("facilities").commit();
                break;
            case 10:
                //how to apply
                fragmentManager.beginTransaction().replace(R.id.container,new How_To_Apply_Fragment()).addToBackStack("how to apply").commit();
                break;
        }

    }

    public void onSectionAttached(int number) {
        switch(number){
            case 0:
                mTitle = getString(R.string.app_name);
                break;
            case 1:
                mTitle = "Computer Science";
                break;
        }

    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((MainActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }

}
