package com.washit.washit;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private FrameLayout mMainFrame;
    //private TextView mTextMessage;
    private contactUsFragment contactUs;
    private HomeFragment homeFrag;
    private NotificationFragment notificationFragment;
    private ProfilFragment profilFragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    setFragment(homeFrag);
                    //mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    setFragment(contactUs);
                   // mTextMessage.setText(R.string.title_contact);
                    return true;
                case R.id.navigation_notifications:
                    setFragment(notificationFragment);
                    //mTextMessage.setText(R.string.title_notifications);
                    return true;
                case R.id.navigation_profil:
                    setFragment(profilFragment);
                   // mTextMessage.setText("profil");
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainFrame = (FrameLayout) findViewById(R.id.main_frame);
        contactUs = new contactUsFragment();
        homeFrag = new HomeFragment();
        notificationFragment = new NotificationFragment();
        profilFragment = new ProfilFragment();

        setFragment(homeFrag);
        // do this line after creation the home fragment so the first fragment to load is the home by default .
       // mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }


    private void setFragment (Fragment fragment) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace( R.id.main_frame, fragment);
        fragmentTransaction.commit();

    }
}
