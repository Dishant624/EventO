package com.example.evento.Coordinator.Home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.evento.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EventFragment extends Fragment {
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    private EventAdapter adapter;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_event, container, false);
        ButterKnife.bind((Object) this, v);
        return v;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.adapter = new EventAdapter(getActivity());
        this.recyclerview.setItemAnimator(new DefaultItemAnimator());
        this.recyclerview.setAdapter(this.adapter);
    }
}
