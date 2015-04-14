package edu.schoolapp.usm.jon.schoolofcomputing;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by jon on 4/13/2015.
 */
public class Instructor_Info_Fragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = (View) inflater.inflate(R.layout.instructor_info,container,false);
        TextView tv1 = (TextView)view.findViewById(R.id.CurrentCourseInfo);
        TextView tv2 = (TextView)view.findViewById(R.id.researchIntrestInfo);
        TextView tv3 = (TextView)view.findViewById(R.id.recentPublicationsInfo);
        ImageView iv = (ImageView)view.findViewById(R.id.instructorsPic);

        ActionBarActivity abv = (ActionBarActivity)getActivity();
        ActionBar ab = abv.getSupportActionBar();
        ab.setTitle(getArguments().getString("in"));

        file_reader fr = new file_reader();

        switch(getArguments().getString("in")){
            case "Dia Ali":
                  tv1.setText(fr.line_reader(getActivity(),R.raw.dia_ali_courses_taught));
                  tv2.setText(fr.line_reader(getActivity(),R.raw.dia_ali_research_intrest));
                  tv3.setText(fr.line_reader(getActivity(),R.raw.dia_ali_recent_publications));
                  iv.setImageResource(R.drawable.dia);
                break;
            case "Bikramjit Banerjee":
                 tv1.setText(fr.line_reader(getActivity(),R.raw.bikramjit_banerjee_courses_taught));
                 tv2.setText(fr.line_reader(getActivity(),R.raw.bikramjit_banerjee_research_intrest));
                 tv3.setText(fr.line_reader(getActivity(),R.raw.bikramjit_banerjee_recent_publications));
                 iv.setImageResource(R.drawable.banerjee);
                break;
            case "Glenn Bond":
                 tv1.setText(fr.line_reader(getActivity(),R.raw.glenn_bond_courses_taught));
                 tv2.setText(fr.line_reader(getActivity(),R.raw.glenn_bond_research_intrest));
                 tv3.setText(fr.line_reader(getActivity(),R.raw.glenn_bond_recent_publications));
                 iv.setImageResource(R.drawable.bond);
                break;
            case "Kuo Chen":
                 tv1.setText(fr.line_reader(getActivity(),R.raw.kuo_chen_courses_taught));
                 tv2.setText(fr.line_reader(getActivity(),R.raw.kuo_chen_research_intrest));
                 tv3.setText(fr.line_reader(getActivity(),R.raw.kuo_chen_recent_publications));
                 iv.setImageResource(R.drawable.chen);
                break;
            case "Wonryull Koh":
                 tv1.setText(fr.line_reader(getActivity(),R.raw.wonryull_koh_courses_taught));
                 tv2.setText(fr.line_reader(getActivity(),R.raw.wonryull_koh_research_interest));
                 tv3.setText(fr.line_reader(getActivity(),R.raw.wonryull_koh_recent_publications));
                 iv.setImageResource(R.drawable.koh);
                break;
            case "Beddhu Murali":
                 tv1.setText(fr.line_reader(getActivity(),R.raw.beddhu_murali_courses_taught));
                 tv2.setText(fr.line_reader(getActivity(),R.raw.beddhu_murali_research_intrest));
                 tv3.setText(fr.line_reader(getActivity(),R.raw.beddhu_murali_recent_publications));
                 iv.setImageResource(R.drawable.murali);
                break;
            case "Anton Netchaev":
                 tv1.setText(fr.line_reader(getActivity(),R.raw.anton_netchaev_courses_taught));
                 tv2.setText(fr.line_reader(getActivity(),R.raw.anton_netchaev_research_intrest));
                 tv3.setText(fr.line_reader(getActivity(),R.raw.anton_netchaev_recent_publications));
                 iv.setImageResource(R.drawable.anton);
                break;
            case "Jonathan Sun":
                tv1.setText(fr.line_reader(getActivity(),R.raw.jonathan_sun_courses));
                tv2.setText(fr.line_reader(getActivity(),R.raw.jonathan_sun_research_intrest));
                tv3.setText(fr.line_reader(getActivity(),R.raw.jonathan_sun_recent_publications));
                iv.setImageResource(R.drawable.sun);
                break;
            case "Andrew H. Sung":
                tv1.setText(fr.line_reader(getActivity(),R.raw.andrew_h_sung_courses_taught));
                tv2.setText(fr.line_reader(getActivity(),R.raw.andrew_h_sung_research_intrest));
                tv3.setText(fr.line_reader(getActivity(),R.raw.anton_netchaev_recent_publications));
                iv.setImageResource(R.drawable.sung);
                break;
            case "Nan Wang":
                tv1.setText(fr.line_reader(getActivity(),R.raw.nan_wang_courses_taught));
                tv2.setText(fr.line_reader(getActivity(),R.raw.nan_wang_research_intrest));
                tv3.setText(fr.line_reader(getActivity(),R.raw.nan_wang_recent_publications));
                iv.setImageResource(R.drawable.wang);
                break;
            case "Zheng Wang":
                tv1.setText(fr.line_reader(getActivity(),R.raw.zheng_wang_course_taught));
                tv2.setText(fr.line_reader(getActivity(),R.raw.zheng_wang_research_intrest));
                tv3.setText(fr.line_reader(getActivity(),R.raw.zheng_wang_recent_publications));
                iv.setImageResource(R.drawable.zheng);
                break;
            case "Kebin Xu":
                tv1.setText(fr.line_reader(getActivity(),R.raw.kebbin_xu_course_taught));
                tv2.setText(fr.line_reader(getActivity(),R.raw.kebbin_xu_research_intrest));
                tv3.setText(fr.line_reader(getActivity(),R.raw.kebbin_xu_recent_publications));
                iv.setImageResource(R.drawable.xu);
                break;
            case "Chaoyang (Joe) Zhang":
                tv1.setText(fr.line_reader(getActivity(),R.raw.joe_zhang_course_taught));
                tv2.setText(fr.line_reader(getActivity(),R.raw.joe_zhang_research_intrest));
                tv3.setText(fr.line_reader(getActivity(),R.raw.joe_zhang_recent_publications));
                iv.setImageResource(R.drawable.zhang);
                break;
            case "Zhaoxian Zhou":
                tv1.setText(fr.line_reader(getActivity(),R.raw.zhaoxian_zhou_courses_taught));
                tv2.setText(fr.line_reader(getActivity(),R.raw.zhaoxian_zhou_research_intrest));
                tv3.setText(fr.line_reader(getActivity(),R.raw.zhaoxian_zhou_recent_publications));
                iv.setImageResource(R.drawable.zhou);
                break;
        }// add more instructor if needed.

        return view;
    }
}
