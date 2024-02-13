package com.bharat.cableoprator.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

import com.bharat.cableoprator.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class BroadbandConnection extends Fragment {

    LinearLayout calender,month,sortBY;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_broadband_connection, container, false);

        calender = view.findViewById(R.id.calender);
        month = view.findViewById(R.id.month);
        sortBY = view.findViewById(R.id.sortBY);

        calender.setOnClickListener(v -> {
            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(view.getContext());
            bottomSheetDialog.setContentView(R.layout.showcalendar);

            bottomSheetDialog.show();
        });

        month.setOnClickListener(v -> {
            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(view.getContext());
            bottomSheetDialog.setContentView(R.layout.showcalendar);

            bottomSheetDialog.show();
        });

        sortBY.setOnClickListener(v -> {
            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(view.getContext());
            bottomSheetDialog.setContentView(R.layout.showsortby);

            bottomSheetDialog.show();
        });

        return view;
    }
}