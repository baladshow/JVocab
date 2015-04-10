package jvocab.jixa.com.jvocab.View.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import jvocab.jixa.com.jvocab.R;


public class FirstSplashPage extends  SplashPage {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        textView.setText(R.string.first_splash_text);
        return null;
    }

}
