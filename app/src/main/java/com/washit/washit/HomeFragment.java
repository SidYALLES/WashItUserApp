package com.washit.washit;


import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;


import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;



/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private RecyclerView mPackagesList;
    private DatabaseReference mDatabaseReference;
    private View view;
    FirebaseRecyclerAdapter<Package,PackageViewHolder> firebaseRecyclerAdapter;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view= inflater.inflate(R.layout.fragment_home, container, false);
        mDatabaseReference=FirebaseDatabase.getInstance().getReference().child("Packages");
        mDatabaseReference.keepSynced(true);
        mPackagesList=view.findViewById(R.id.packages_list);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 1);
       mPackagesList.setLayoutManager(gridLayoutManager);
        FirebaseRecyclerOptions<Package> options =
                new FirebaseRecyclerOptions.Builder<Package>()
                        .setQuery(mDatabaseReference, Package.class)
                        .build();
        firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<Package, PackageViewHolder>
                (options) {

          /*  protected void populateViewHolder(PackageViewHolder viewHolder, Package model, int position){


            }*/

            @Override
            protected void onBindViewHolder( PackageViewHolder holder, int position,  Package model) {
                holder.setTitle(model.getTitle());
                holder.setDescription(model.getDescription());
                holder.setDate(model.getDate());


            }

            @NonNull
            @Override
            public PackageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View viewItem = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.package_list_item,parent, false);
                return new PackageViewHolder(viewItem);
            }
        };
        mPackagesList.setAdapter(firebaseRecyclerAdapter);



                return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        firebaseRecyclerAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        firebaseRecyclerAdapter.stopListening();

    }

    public static class PackageViewHolder extends RecyclerView.ViewHolder{
        View mView;
        public PackageViewHolder (View itemView){
            super(itemView);
            mView=itemView;

        }
        public void setTitle(String title){
            TextView package_title=(TextView)mView.findViewById(R.id.package_title);
            package_title.setText(title);
        }
        public void setDescription(String description){
            TextView package_description=(TextView)mView.findViewById(R.id.package_description);
            package_description.setText(description);
        }
        public void setDate(String date){
            TextView package_date=(TextView)mView.findViewById(R.id.package_date);
            package_date.setText(date);
        }


    }

    }


}
