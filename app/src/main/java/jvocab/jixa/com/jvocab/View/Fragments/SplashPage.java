package jvocab.jixa.com.jvocab.View.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import jvocab.jixa.com.jvocab.R;


public class SplashPage extends Fragment {
    static final int RESOURCE = R.layout.splash_page_layout;
    TextView textView;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(RESOURCE , container ,false);
        textView = (TextView) view.findViewById(R.id.splash_page_text);
        return  view;

    }

    protected  void initialize (){

    }



}
