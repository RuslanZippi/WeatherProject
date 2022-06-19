package com.example.myapplication.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.service.InsertInBd;


public class MainFragment extends Fragment {
    TextView textViewTemp;
    TextView textViewHum;
    Button button;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        button = getActivity().findViewById(R.id.button);
        textViewTemp = getActivity().findViewById(R.id.textViewTemp);
        textViewHum = getActivity().findViewById(R.id.textViewHum);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsertInBd insertInBd = new InsertInBd(textViewTemp, textViewHum);
                insertInBd.execute();
            }
        });
    }
}