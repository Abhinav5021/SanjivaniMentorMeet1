package com.kulswaminitech.sanjivanimentormeet;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;


public class HomeFragment extends Fragment {
    AppCompatButton addBatch;
    public HomeFragment() {
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_home, container, false);
         addBatch=v.findViewById(R.id.addBatch);
         addBatch.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent i=new Intent(getActivity(),AddBatchActivity.class);
                 startActivity(i);

             }
         });
        return v;
    }
}