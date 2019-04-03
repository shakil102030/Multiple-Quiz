package com.example.shakil.shakil;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class Fragmentone extends Fragment {
    View view;
    Button b;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragmentone_layout, container, false);

        b = (Button) view.findViewById(R.id.fragoneid);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Fragment one Displayed", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}