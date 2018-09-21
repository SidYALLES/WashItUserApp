package com.washit.washit;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class NotificationFragment extends Fragment {

    RecyclerView mRecyclerView;

    View view;
    List<Notification> notificationList = Arrays.asList(
            new Notification("Loundary state", "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                    NotificationTypes.INFORMATION, new Date(2018, 9, 17, 10, 38), Status.Unseen),
            new Notification("New Offer", "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
            NotificationTypes.OFFER, new Date(2018, 8, 17, 10, 38), Status.Seen),
            new Notification("Warning", "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                    NotificationTypes.WARNING, new Date(2018, 8, 18, 11, 25), Status.Unseen),
            new Notification("Loundary state", "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                    NotificationTypes.INFORMATION, new Date(2018, 9, 17, 10, 38), Status.Unseen),
            new Notification("New Offer", "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
            NotificationTypes.OFFER, new Date(2018, 8, 17, 10, 38), Status.Seen),
            new Notification("Warning", "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                    NotificationTypes.WARNING, new Date(2018, 8, 18, 11, 25), Status.Unseen)
            );

    public NotificationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        if (view==null)
            view = inflater.inflate(R.layout.fragment_notification, container, false);

        mRecyclerView = view.findViewById(R.id.notifications_list);
        NotificationsCutomAdapter camerasCustomAdapter = new NotificationsCutomAdapter(getActivity(), notificationList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 1);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        itemAnimator.setAddDuration(1000);
        itemAnimator.setRemoveDuration(1000);
        mRecyclerView.setItemAnimator(itemAnimator);
        mRecyclerView.setAdapter(camerasCustomAdapter);

        return view;
    }

}
