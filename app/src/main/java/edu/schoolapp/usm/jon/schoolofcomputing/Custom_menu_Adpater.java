package edu.schoolapp.usm.jon.schoolofcomputing;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by jon on 4/13/2015.
 */
public class Custom_menu_Adpater extends BaseAdapter {
    Context context;
    ArrayList<single_row> list;

    Custom_menu_Adpater(Context context, String[] title_list){
        this.context = context;
        list =  new ArrayList<single_row>();
        for(int i = 0; i < title_list.length; i++)
            list.add(new single_row(title_list[i]));
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
             LayoutInflater inflate = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
             view = inflate.inflate(R.layout.custom_menu_list,parent,false);
         }

        TextView tv = (TextView) view.findViewById(R.id.menuItem);
        single_row sr = list.get(position);
        tv.setText(sr.title);

        return view;

    }

    private class single_row{
        public String title;

        single_row(String title) {
            this.title = title;
        }
    }
}




