package com.example.ferrero.sumi_e;

import android.content.Intent;
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

    /*
    * Methods to manage the menu
    *
    */

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation in the menu
        int id = item.getItemId();
        Fragment fragment = null;
        Class fragmentClass;

        // Get the class of the fragment of the section selected
        switch (id) {
            case R.id.nav_whatIs:
                fragmentClass = FragmentWhatIs.class;
                break;
            case R.id.nav_gallery:
                fragmentClass = FragmentGallery.class;
                break;
            case R.id.nav_learn:
                fragmentClass = FragmentLearnStep0.class;
                break;
            case R.id.nav_share:
                // Launch intent to send a message for sharing
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,
                        "If you want to read the code of this app, follow this link: https://github.com/cinzia-ferrero/Sumi-e-app");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
                // Close menu
                item.setChecked(false);
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                return true;
            default:
                fragmentClass = FragmentWhatIs.class;
        }

        // Get the fragment
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit();

        // Highlight the selected item in the navigation menu
        item.setChecked(true);
        // Set the title in the toolbar
        setTitle(item.getTitle());
        // Close the navigation drawer
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /*
    * Methods to manage the buttons Back and Continue in the pages of the Learn section
    *
    */

    public void button0continue(View view) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        FragmentLearnStep1 thisFragment = new FragmentLearnStep1();
        transaction.replace(R.id.fragment_container, thisFragment);
        transaction.addToBackStack(thisFragment.getClass().getName());
        transaction.commit();
    }

    public void button1continue(View view) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        FragmentLearnStep2a thisFragment = new FragmentLearnStep2a();
        transaction.replace(R.id.fragment_container, thisFragment);
        transaction.addToBackStack(thisFragment.getClass().getName());
        transaction.commit();
    }

    public void button1back(View view) {
        getSupportFragmentManager().popBackStack();
    }

    public void button2Acontinue(View view) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        FragmentLearnStep2b thisFragment = new FragmentLearnStep2b();
        transaction.replace(R.id.fragment_container, thisFragment);
        transaction.addToBackStack(thisFragment.getClass().getName());
        transaction.commit();
    }

    public void button2Aback(View view) {
        getSupportFragmentManager().popBackStack();
    }

    public void button2Bcontinue(View view) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        FragmentLearnStep3a thisFragment = new FragmentLearnStep3a();
        transaction.replace(R.id.fragment_container, thisFragment);
        transaction.addToBackStack(thisFragment.getClass().getName());
        transaction.commit();
    }

    public void button2Bback(View view) {
        getSupportFragmentManager().popBackStack();
    }

    public void button3Acontinue(View view) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        FragmentLearnStep3b thisFragment = new FragmentLearnStep3b();
        transaction.replace(R.id.fragment_container, thisFragment);
        transaction.addToBackStack(thisFragment.getClass().getName());
        transaction.commit();
    }

    public void button3Aback(View view) {
        getSupportFragmentManager().popBackStack();
    }

    public void button3Bcontinue(View view) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        FragmentLearnStep4a thisFragment = new FragmentLearnStep4a();
        transaction.replace(R.id.fragment_container, thisFragment);
        transaction.addToBackStack(thisFragment.getClass().getName());
        transaction.commit();
    }

    public void button3Bback(View view) {
        getSupportFragmentManager().popBackStack();
    }

    public void button4Acontinue(View view) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        FragmentLearnStep4b thisFragment = new FragmentLearnStep4b();
        transaction.replace(R.id.fragment_container, thisFragment);
        transaction.addToBackStack(thisFragment.getClass().getName());
        transaction.commit();
    }

    public void button4Aback(View view) {
        getSupportFragmentManager().popBackStack();
    }

    public void button4Bcontinue(View view) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        FragmentLearnStep5a thisFragment = new FragmentLearnStep5a();
        transaction.replace(R.id.fragment_container, thisFragment);
        transaction.addToBackStack(thisFragment.getClass().getName());
        transaction.commit();
    }

    public void button4Bback(View view) {
        getSupportFragmentManager().popBackStack();
    }

    public void button5Acontinue(View view) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        FragmentLearnStep5b thisFragment = new FragmentLearnStep5b();
        transaction.replace(R.id.fragment_container, thisFragment);
        transaction.addToBackStack(thisFragment.getClass().getName());
        transaction.commit();
    }

    public void button5Aback(View view) {
        getSupportFragmentManager().popBackStack();
    }

    public void button5Bcontinue(View view) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        FragmentLearnStep6 thisFragment = new FragmentLearnStep6();
        transaction.replace(R.id.fragment_container, thisFragment);
        transaction.addToBackStack(thisFragment.getClass().getName());
        transaction.commit();
    }

    public void button5Bback(View view) {
        getSupportFragmentManager().popBackStack();
    }

    public void button6back(View view) {
        getSupportFragmentManager().popBackStack();
    }




}
