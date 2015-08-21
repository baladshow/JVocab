package jvocab.jixa.com.jvocab.View.Fragments;


import android.app.Activity;
import android.support.v4.app.Fragment;
import android.util.Log;

public abstract class SliderPageFragment extends Fragment {
    private static final String TAG = "****Slider Fragment";
    protected Activity mActivity;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = activity;
        Log.d(TAG, "get activity : " + activity);
    }

    public abstract void init();
}
