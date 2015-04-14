package edu.schoolapp.usm.jon.schoolofcomputing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by jon on 3/21/2015.
 */
public class custom_course_des_list extends BaseAdapter {
    private Context context;
    private ArrayList<customRow> list;

    public custom_course_des_list(Context context,int id){
        this.context = context;
        list = new ArrayList<customRow>();

        InputStream in = this.context.getResources().openRawResource(id);
        Scanner scan = new Scanner(in);
        scan.useDelimiter("=|\n");

        while(scan.hasNext()){

            list.add(new customRow(scan.next(),scan.next()));
        }

        scan.close();
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

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
        View v = convertView;

        if(v == null){
            LayoutInflater inflate = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            v = inflate.inflate(R.layout.course_descriptions, parent ,false);
        }

        TextView textTitle = (TextView) v.findViewById(R.id.courseTitle);
        TextView textDes = (TextView) v.findViewById(R.id.courseDes);

        customRow temp = list.get(position);
        textTitle.setText(temp.title);
        textDes.setText(temp.Description);

        return v;
    }
}

class customRow {
    String title;
    String Description;

    public customRow(String title, String Description) {
        this.title = title;
        this.Description = Description;
    }

}
