package com.kulswaminitech.sanjivanimentormeet;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity  {
//    implements NavigationView.OnNavigationItemSelectedListener
        BottomNavigationView bottom_navigation;
    TextView profilename, enrollmentNo, loggedInStatus;
    ImageButton noticationBtn;
    DrawerLayout drawerLayout;  //maindrawer
    Toolbar toolbar;     //toolbar
    NavigationView navigationView;   //nDrawer
    // Make sure to be using androidx.appcompat.app.ActionBarDrawerToggle version.
    ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noticationBtn = (ImageButton) findViewById(R.id.noticationBtn);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        toolbar = findViewById(R.id.toolbar);
//header Details
        View header = LayoutInflater.from(getApplicationContext()).inflate(R.layout.header,null);
        navigationView.addHeaderView(header);
//        navigationView.getHeaderView(R.layout.header);
        profilename = (TextView) header.findViewById(R.id.header_username);
        enrollmentNo = (TextView) header.findViewById(R.id.header_enrollment_no);
        loggedInStatus = (TextView) header.findViewById(R.id.header_login_Status);

        String selUser = getIntent().getExtras().getString("User");
        String Enrollment_No = getIntent().getExtras().getString("Enrollment");
        enrollmentNo.setText(Enrollment_No);
        loggedInStatus.setText(selUser);

//        bottom_navigation = findViewById(R.id.bottom_navigation);
        //step1
        setSupportActionBar(toolbar);
        drawerToggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.drawerOpen, R.string.drawerClose);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        loadFragment(new HomeFragment());

//        navigationView.setNavigationItemSelectedListener(this);
//        bottom_navigation.setBackground(null);
//        bottom navigation
//        bottom_navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                int id= item.getItemId();
//                if (id == R.id.bottom_home_menu) {
//                    MainActivity.this.loadFragment(new HomeFragment());
//                } else if (id == R.id.bottom_notification_menu) {
//                    MainActivity.this.loadFragment(new HomeFragment());
//                } else {
//                    MainActivity.this.loadFragment(new HomeFragment());
//                }
//                return true;
//            }
//        });
//        drawer navigation
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.profile_menu) {
                    loadFragment(new ProfileFragment());
                } else if (id == R.id.rate_menu) {
                    //loadFragment(new RateFragment());
                } else if (id == R.id.reset_password_menu) {
                    Toast.makeText(MainActivity.this, "You are not able to change Password..!", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.share_menu) {
                    //loadFragment(new ShareFragment());
                } else if (id == R.id.logout_menu) {
                    Intent intent = new Intent(MainActivity.this, SelectUserActivity.class);
                    startActivity(intent);
                    finish();
                    Toast toast = Toast.makeText(MainActivity.this, "Logged Out...!", Toast.LENGTH_SHORT);
                    toast.show();
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        noticationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Notifications are not yet avilable..!",Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    //fragment loading via method
    private void loadFragment(Fragment fragment) {
        FrameLayout frameLayout = findViewById(R.id.container);
        frameLayout.removeAllViews();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.container, fragment);
        ft.commit();
    }
}