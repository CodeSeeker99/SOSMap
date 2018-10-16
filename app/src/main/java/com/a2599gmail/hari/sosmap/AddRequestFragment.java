package com.a2599gmail.hari.sosmap;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class AddRequestFragment extends Fragment {


    public AddRequestFragment() {
        // Required empty public constructor
    }
    public static AddRequestFragment newInstance() {
        AddRequestFragment fragment = new AddRequestFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_request, container, false);
    }

}
