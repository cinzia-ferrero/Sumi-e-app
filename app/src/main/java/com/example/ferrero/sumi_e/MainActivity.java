package com.example.ferrero.sumi_e;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(null);
        toolbar.getMenu().clear();
        setSupportActionBar(toolbar);

        /*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        // Check that the activity is using the layout version with
        // the fragment_container FrameLayout
        if (findViewById(R.id.fragment_container) != null) {
            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }
        }

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        // Create a new Fragment to be placed in the activity layout
        FragmentHome homeFragment = new FragmentHome();

        // In case this activity was started with special instructions from an
        // Intent, pass the Intent's extras to the fragment as arguments
        homeFragment.setArguments(getIntent().getExtras());

        // Add the fragment to the 'fragment_container' FrameLayout
        transaction.add(R.id.fragment_container, homeFragment);
        transaction.addToBackStack(homeFragment.getClass().getName());
        transaction.commit();
    }

    public void button0continue(View view) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        FragmentLearn1 firstFragment = new FragmentLearn1();
        transaction.replace(R.id.fragment_container, firstFragment);
        transaction.addToBackStack(firstFragment.getClass().getName());
        transaction.commit();
    }

    public void button1continue(View view) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        FragmentLearn2a secondAFragment = new FragmentLearn2a();
        transaction.replace(R.id.fragment_container, secondAFragment);
        transaction.addToBackStack(secondAFragment.getClass().getName());
        transaction.commit();
    }

    public void button1back(View view) {
        getSupportFragmentManager().popBackStack();
    }

    public void button2acontinue(View view) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        FragmentLearn2 secondFragment = new FragmentLearn2();
        transaction.replace(R.id.fragment_container, secondFragment);
        transaction.addToBackStack(secondFragment.getClass().getName());
        transaction.commit();
    }

    public void button2aback(View view) {
        getSupportFragmentManager().popBackStack();
    }

    public void button2continue(View view) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        FragmentLearn3a thirdAFragment = new FragmentLearn3a();
        transaction.replace(R.id.fragment_container, thirdAFragment);
        transaction.addToBackStack(thirdAFragment.getClass().getName());
        transaction.commit();
    }

    public void button2back(View view) {
        getSupportFragmentManager().popBackStack();
    }

    public void button3acontinue(View view) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        FragmentLearn3 thirdFragment = new FragmentLearn3();
        transaction.replace(R.id.fragment_container, thirdFragment);
        transaction.addToBackStack(thirdFragment.getClass().getName());
        transaction.commit();
    }

    public void button3aback(View view) {
        getSupportFragmentManager().popBackStack();
    }

    public void button3continue(View view) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        FragmentLearn4a fourthAFragment = new FragmentLearn4a();
        transaction.replace(R.id.fragment_container, fourthAFragment);
        transaction.addToBackStack(fourthAFragment.getClass().getName());
        transaction.commit();
    }

    public void button3back(View view) {
        getSupportFragmentManager().popBackStack();
    }

    public void button4acontinue(View view) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        FragmentLearn4 fourthFragment = new FragmentLearn4();
        transaction.replace(R.id.fragment_container, fourthFragment);
        transaction.addToBackStack(fourthFragment.getClass().getName());
        transaction.commit();
    }

    public void button4aback(View view) {
        getSupportFragmentManager().popBackStack();
    }

    public void button4continue(View view) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        FragmentLearn5a fifthAFragment = new FragmentLearn5a();
        transaction.replace(R.id.fragment_container, fifthAFragment);
        transaction.addToBackStack(fifthAFragment.getClass().getName());
        transaction.commit();
    }

    public void button4back(View view) {
        getSupportFragmentManager().popBackStack();
    }

    public void button5acontinue(View view) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        FragmentLearn5 fifthFragment = new FragmentLearn5();
        transaction.replace(R.id.fragment_container, fifthFragment);
        transaction.addToBackStack(fifthFragment.getClass().getName());
        transaction.commit();
    }

    public void button5aback(View view) {
        getSupportFragmentManager().popBackStack();
    }

    public void button5continue(View view) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        FragmentLearn6 sixthFragment = new FragmentLearn6();
        transaction.replace(R.id.fragment_container, sixthFragment);
        transaction.addToBackStack(sixthFragment.getClass().getName());
        transaction.commit();
    }

    public void button5back(View view) {
        getSupportFragmentManager().popBackStack();
    }

    public void button6back(View view) {
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    */

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment = null;
        Class fragmentClass;

        switch (id) {
            case R.id.nav_whatIs:
                fragmentClass = FragmentWhatIs.class;
                break;
            case R.id.nav_gallery:
                fragmentClass = FragmentGallery.class;
                break;
            case R.id.nav_learn:
                fragmentClass = FragmentLearn0.class;
                break;
            case R.id.nav_share:
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,
                        "We're keeping a kitten hostage. Share this app with your friends if you don't want the kitten to suffer. Link: https://github.com/cinzia-ferrero/Sumi-e-app  \np.s. Think about the kitten");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
                return false;


            default:
                fragmentClass = FragmentWhatIs.class;
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit();

        // Highlight the selected item has been done by NavigationView
        item.setChecked(true);
        // Set action bar title
        setTitle(item.getTitle());
        // Close the navigation drawer
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
