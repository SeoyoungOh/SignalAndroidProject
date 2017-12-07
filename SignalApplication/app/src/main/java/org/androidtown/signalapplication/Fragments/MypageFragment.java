package org.androidtown.signalapplication.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.androidtown.signalapplication.Activities.CheckSignalActivity;
import org.androidtown.signalapplication.Activities.MakeMeetingActivity;
import org.androidtown.signalapplication.Adapter.RecyclerAdapter;
import org.androidtown.signalapplication.R;
import org.androidtown.signalapplication.Server.Models.Meeting;
import org.androidtown.signalapplication.Server.Models.User;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import io.realm.Sort;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MypageFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MypageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MypageFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    Realm realm;
    private RecyclerView.Adapter mRecyclerAdapter;
    private RealmQuery<User> queryUser;
    private RealmResults<User> resultsUser;
    private RealmQuery<Meeting> queryMeeting;
    private RealmResults<Meeting> resultsMeeting;

    public MypageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MyPageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MypageFragment newInstance(String param1, String param2) {
        MypageFragment fragment = new MypageFragment();
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
        if (container == null) {
            return null;
        }
        View view = inflater.inflate(R.layout.fragment_mypage, container, false);

        Button makeMeetingButton = (Button) view.findViewById(R.id.make_meeting_button);
        Button checkSignalButton = (Button) view.findViewById(R.id.signal_check_button);

        Realm.init(getActivity());
        //RealmConfiguration realmConfiguration = new RealmConfiguration.Builder().build();
        //Realm.setDefaultConfiguration(realmConfiguration);
        realm = Realm.getDefaultInstance();
        queryUser = realm.where(User.class);
        resultsUser = queryUser.findAll();
        resultsUser = resultsUser.sort("id",Sort.DESCENDING);


        queryMeeting = realm.where(Meeting.class);
        resultsMeeting = queryMeeting.findAll();
        resultsMeeting = resultsMeeting.sort("id", Sort.DESCENDING);

        makeMeetingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Fragment에서는 this 사용 불가능
                //context 받아오는 getActivity() 사용
                Intent i = new Intent(getActivity(), MakeMeetingActivity.class);
                startActivity(i);

            }
        });

        checkSignalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), CheckSignalActivity.class);
                startActivity(i);
            }
        });


        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.myPageFragmentRecyclerView);

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

    // TODO: Rename method, update argument and hook method into UI event
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
