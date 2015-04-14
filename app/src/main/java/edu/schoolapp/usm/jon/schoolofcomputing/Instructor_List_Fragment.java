package edu.schoolapp.usm.jon.schoolofcomputing;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by jon on 4/13/2015.
 */
public class Instructor_List_Fragment extends Fragment {
    private String[] array;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ActionBarActivity abv = (ActionBarActivity) getActivity();
        ActionBar ab = abv.getSupportActionBar();
        ab.setTitle(getArguments().getString("department name"));

        ListView list = (ListView) inflater.inflate(R.layout.custom_list_view,container,false);
        list.setAdapter(new instructor_list_adapter(getActivity(),getArguments().getStringArray("instructor"),getArguments().getIntArray("image")));
        array = getArguments().getStringArray("instructor");
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 Instructor_Info_Fragment iif = new Instructor_Info_Fragment();
                 Bundle bun = new Bundle();
                 bun.putString("in",array[position]);
                 iif.setArguments(bun);
                 getFragmentManager().beginTransaction().replace(R.id.container,iif).addToBackStack("instructor info").commit();
            }
        });

        return list;
    }

    private class instructor_list_adapter extends BaseAdapter{

        private ArrayList<instructRow> list;
        private Context context;

        public instructor_list_adapter(Context context,String[] title, int[] image){
            this.context = context;
            list = new ArrayList<instructRow>();
            for(int i = 0; i<title.length;i++)
                list.add(new instructRow(title[i],image[i]));
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;

            if(view == null){
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
                view = (View) inflater.inflate(R.layout.instructor_list,parent,false);
            }

            TextView tv = (TextView) view.findViewById(R.id.InstructorName);
            ImageView imageView = (ImageView)view.findViewById(R.id.instructorImage);

            instructRow ir = list.get(position);
            tv.setText(ir.title);
            imageView.setImageResource(ir.image);

            return view;
        }
    }

    private class instructRow{
        private String title;
        private int image;

        public instructRow(String title, int image){
            this.title = title;
            this.image = image;
        }

    }

}


