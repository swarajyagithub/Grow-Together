package com.example.nevihationapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link network#newInstance} factory method to
 * create an instance of this fragment.
 */
public class network extends Fragment {
    TabLayout tabAR;
    TabItem tab1AR;
    TabItem tab2AR;
    ViewPager viewpgrARN;
    PageAdapterNei pageAdapterARN;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public network() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment network.
     */
    // TODO: Rename and change types and number of parameters
    public static network newInstance(String param1, String param2) {
        network fragment = new network();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_network, container, false);
        tabAR=(TabLayout)view. findViewById(R.id.tablayoutAR);
        tab1AR=(TabItem)view. findViewById(R.id.tabitem1AR);
        tab2AR=(TabItem)view. findViewById(R.id.tabitem2AR);
        viewpgrARN=(ViewPager)view. findViewById(R.id.viewPagerARNB);
        pageAdapterARN = new PageAdapterNei(getFragmentManager(), tabAR.getTabCount());
        viewpgrARN.setAdapter(pageAdapterARN);
        tabAR.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                viewpgrARN.setCurrentItem(tab.getPosition());
                if(tab.getPosition()==0||tab.getPosition()==1)
                {
                    pageAdapterARN.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewpgrARN.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabAR));


        return view;
    }
}
