package com.example.viktoria_cseke_assignment2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class BreadFragment extends Fragment {
    private RecyclerView myRecycleV;
    View v;

    String name[]={"Artisan bread","Olive bread","Tiger bread"};
    String code[]={"b000","b001","b002"};
    Double price[]={1.70,2.00,1.90};
    int images[]={R.drawable.bread,R.drawable.olive_bread,R.drawable.tiger_bread_roll};


//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";


//    private String mParam1;
//    private String mParam2;

    public BreadFragment() {
        // Required empty public constructor
    }

//    recyclerViewBread = findViewById(R.id.breadRecycle);
//    MyRecycleViewAdapter myRecycleViewAdapter = new MyRecycleViewAdapter(this,name,code,price,images);

//    public static BreadFragment newInstance(String param1, String param2) {
//        BreadFragment fragment = new BreadFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v= inflater.inflate(R.layout.fragment_bread, container, false);
        myRecycleV = (RecyclerView) v.findViewById(R.id.breadRecycle);
        MyRecycleViewAdapter myRecycleViewAdapter = new MyRecycleViewAdapter(getContext(), name,code,price,images);
        myRecycleV.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecycleV.setAdapter(myRecycleViewAdapter);

        return v;
    }
}