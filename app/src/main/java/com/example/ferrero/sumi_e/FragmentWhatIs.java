package com.example.ferrero.sumi_e;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentWhatIs extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.v("FragmentLearn1b", "entrato in onCreateView");
        View myFragmentView = inflater.inflate(R.layout.fragment_what_layout, container, false);
        return myFragmentView;
    }


}