package com.mostafaabdel_fatah.navigationdrawerdemo2;

import android.app.FragmentTransaction;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    FragmentTransaction fragmentTransaction;
    ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.DrawerOpen
                ,R.string.DrawerClose);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.container,new HomeFragment());
        fragmentTransaction.commit();
        getSupportActionBar().setTitle("Home Fragment");

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                fragmentTransaction = getFragmentManager().beginTransaction();
                switch (item.getItemId()){
                    case R.id.home_ic:
                        fragmentTransaction.replace(R.id.container,new HomeFragment());
                        getSupportActionBar().setTitle("Home Fragment");
                        drawerLayout.closeDrawers();
                        item.setChecked(true);
                        break;
                    case R.id.message_ic:
                        fragmentTransaction.replace(R.id.container,new MessageFragment());
                        getSupportActionBar().setTitle("Message Fragment");
                        drawerLayout.closeDrawers();
                        item.setChecked(true);
                        break;
                    case R.id.setting_ic:
                        fragmentTransaction.replace(R.id.container,new SettingFragment());
                        getSupportActionBar().setTitle("Setting Fragment");
                        drawerLayout.closeDrawers();
                        item.setChecked(true);
                        break;
                    case R.id.addtogroup_ic:
                        fragmentTransaction.replace(R.id.container,new AddToGroupFragment());
                        getSupportActionBar().setTitle("Add To Group Fragment");
                        drawerLayout.closeDrawers();
                        item.setChecked(true);
                        break;
                    case R.id.group_ic:
                        fragmentTransaction.replace(R.id.container,new GroupAddFragment());
                        getSupportActionBar().setTitle("Group Fragment");
                        drawerLayout.closeDrawers();
                        item.setChecked(true);
                        break;
                    case R.id.Share_ic:
                        fragmentTransaction.replace(R.id.container,new ShareFragment());
                        getSupportActionBar().setTitle("Share Fragment");
                        drawerLayout.closeDrawers();
                        item.setChecked(true);
                        break;
                    default:
                        return  false;
                }
                fragmentTransaction.commit();
                return true;
            }
        });
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }
}
