package com.example.shakil.sujon;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class FragmentTextone extends Fragment {

    View v;
    Button button;

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_layout_one,container);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Fragment_one", Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }
}