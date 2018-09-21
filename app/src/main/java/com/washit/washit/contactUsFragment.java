package com.washit.washit;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * A simple {@link Fragment} subclass.
 */
public class contactUsFragment extends Fragment {

    EditText editText;
    Button buttonSend;

    DatabaseReference databaseReference;

    public contactUsFragment() {
        // Required empty public constructor
    }


   @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_contact_us, container, false);
       System.out.println("testing sout");

        databaseReference = FirebaseDatabase.getInstance().getReference("Complaints");

        editText = (EditText) view.findViewById(R.id.complaint);
        buttonSend = (Button) view.findViewById(R.id.btn_send);

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addComplaint();
                editText.setText("");
            }
        });

        // Inflate the layout for this fragment
        return view;
        //return inflater.inflate(R.layout.fragment_contact_us, container, false);


    }

    private void addComplaint(){

        String complaint = editText.getText().toString().trim();
        System.out.println(complaint);
        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
        String email = user.getEmail();
        if (!TextUtils.isEmpty(complaint)) {

            String id = databaseReference.push().getKey();
            Complaints comp = new Complaints(id,complaint ,email );

            databaseReference.child(id).setValue(comp);
            Toast.makeText(getActivity(),"Complaint sent",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(getActivity(), "please add your complaint", Toast.LENGTH_LONG ).show();
        }
    }

}
