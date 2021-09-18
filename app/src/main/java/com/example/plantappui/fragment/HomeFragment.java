package com.example.plantappui.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.plantappui.R;
import com.example.plantappui.adapter.GroupAdapter;
import com.example.plantappui.model.Group;
import com.example.plantappui.model.Plant;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {


    private Context mContext;
    private RecyclerView recyclerView;
    private GroupAdapter adapter;
    private List<Group> groupList;
    private List<Plant> featuredList;
    private List<Plant> recommendList;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setAdapterType(view);
        setAdapter();
    }

    private void setAdapter() {
        initGroupData();
        initPlantData();

        adapter = new GroupAdapter(mContext,groupList,featuredList,recommendList);
        recyclerView.setAdapter(adapter);
    }

    private void initPlantData() {
        recommendList = new ArrayList<>();
        featuredList = new ArrayList<>();

        recommendList.add(new Plant("Lily","China","$300",R.drawable.image_1));
        recommendList.add(new Plant("Lily","China","$300",R.drawable.image_2));
        recommendList.add(new Plant("Lily","China","$300",R.drawable.image_3));

        featuredList.add(new Plant("Lily","China","$300",R.drawable.bottom_img_1));
    }

    private void initGroupData() {

        groupList = new ArrayList<>();
        groupList.add(new Group("Recommend","More"));
        groupList.add(new Group("Featured","More"));
    }

    private void setAdapterType(View view) {
        recyclerView = view.findViewById(R.id.home_RV);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }
}