package org.androidtown.signalapplication.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.androidtown.signalapplication.Activities.SearchActivity;
import org.androidtown.signalapplication.Adapter.RecyclerAdapter;
import org.androidtown.signalapplication.CircleImageView;
import org.androidtown.signalapplication.DataSetting.CardItem;
import org.androidtown.signalapplication.R;
import org.androidtown.signalapplication.Server.Models.Meeting;
import org.androidtown.signalapplication.Server.Models.User;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmConfiguration;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import io.realm.Sort;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    Realm realm;

    private RecyclerView.Adapter mRecyclerAdapter;

    private RealmQuery<User> queryUser;
    private RealmResults<User> resultsUser;

    private RealmQuery<Meeting> queryMeeting;
    private RealmResults<Meeting> resultsMeeting;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (container == null) {
            return null;
        }
        Realm.init(getActivity());
        //RealmConfiguration realmConfiguration = new RealmConfiguration.Builder().build();
        //Realm.setDefaultConfiguration(realmConfiguration);
        realm = Realm.getDefaultInstance();
        queryUser = realm.where(User.class);
        resultsUser = queryUser.findAll();
        resultsUser = resultsUser.sort("id", Sort.DESCENDING);

        queryMeeting = realm.where(Meeting.class);
        resultsMeeting = queryMeeting.findAll();
        resultsMeeting = resultsMeeting.sort("id", Sort.DESCENDING);

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        SearchView mSearchView = (SearchView) view.findViewById(R.id.search_view);
        mSearchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
            }
        });

        //cardview 처럼 adapter에 값 불러오는 것으로 수정하기
        CircleImageView recImgView1 = (CircleImageView) view.findViewById(R.id.reccommend_img_1);
        CircleImageView recImgView2 = (CircleImageView) view.findViewById(R.id.reccommend_img_2);
        CircleImageView recImgView3 = (CircleImageView) view.findViewById(R.id.reccommend_img_3);
        CircleImageView recImgView4 = (CircleImageView) view.findViewById(R.id.reccommend_img_4);


        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.HomeRecyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        resultsMeeting.addChangeListener(new RealmChangeListener<RealmResults<Meeting>>() {
            @Override
            public void onChange(RealmResults<Meeting> element) {
                mRecyclerAdapter = new RecyclerAdapter(resultsMeeting, R.layout.fragment_home);
                recyclerView.setAdapter(mRecyclerAdapter);
            }
        });

        return view;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}