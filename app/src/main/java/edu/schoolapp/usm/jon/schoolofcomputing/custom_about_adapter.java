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
public class custom_about_adapter extends BaseAdapter {

    private ArrayList<custom_text_row> list;
    private Context context;

    public custom_about_adapter(Context context, String[] title){
        this.context = context;
        list = new ArrayList<custom_text_row>();
        for(int i = 0; i< title.length; i++)
            list.add(new custom_text_row(title[i]));
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
             view = inflater.inflate(R.layout.about_menu_list,parent,false);
         }

        TextView tv = (TextView) view.findViewById(R.id.aboutMenuItem);
        custom_text_row ctr = list.get(position);
        tv.setText(ctr.title);

        return view;
    }

    private class custom_text_row{
        public String title;
        custom_text_row(String title){
            this.title = title;
        }
    }

}
