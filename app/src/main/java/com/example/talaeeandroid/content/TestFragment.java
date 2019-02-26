package com.example.talaeeandroid.content;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.talaeeandroid.FragmentActivity;
import com.example.talaeeandroid.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TestFragment extends Fragment {

    public static TestFragment fragmentA;

    public static TestFragment newInstance() {
        if (fragmentA == null)
            fragmentA = new TestFragment();
        return fragmentA;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_layout, container, false);
        TextView tv = v.findViewById(R.id.tv);
        tv.setText("Test Fragment");

        Button btnToast = v.findViewById(R.id.btnToast);
        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"HI",Toast.LENGTH_LONG).show();
            }
        });
        return v;
    }
}
