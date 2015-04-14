package edu.schoolapp.usm.jon.schoolofcomputing;

import android.app.ActionBar;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

/**
 * Created by jon on 4/13/2015.
 */
public class simple_web_view extends Fragment{

    private WebView webview;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ActionBarActivity abv = (ActionBarActivity) getActivity();
        android.support.v7.app.ActionBar ab = abv.getSupportActionBar();
        ab.setTitle(getArguments().getString("department name"));

        Toast.makeText(getActivity(),"loading..",Toast.LENGTH_SHORT).show();

        webview = (WebView) inflater.inflate(R.layout.simple_web_view,container,false);
        webview.loadDataWithBaseURL("file:///android_res/drawable/",getArguments().getString("html"), "text/html", "utf-8", null);
        webview.getSettings().setBuiltInZoomControls(true);
        webview.setInitialScale(120);
        webview.setBackgroundColor(Color.BLACK);
        webview.getSettings().setNeedInitialFocus(true);



        return webview;
    }

}
