package jvocab.jixa.com.jvocab.View.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import jvocab.jixa.com.jvocab.R;


public class FirstSplashPageFragment extends Fragment {
    static final int RESOURCE = R.layout.fragment_splash_page;
    TextView textView;
    ImageView imageView;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(RESOURCE , container ,false);
        textView = (TextView) view.findViewById(R.id.splash_page_text);
//        imageView = (ImageView) view.findViewById(R.id.splash_page_image);
        textView.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy");
//        imageView.setImageResource(R.drawable.master);
        return  view;

    }



}
