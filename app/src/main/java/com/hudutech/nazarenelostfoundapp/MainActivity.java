package com.hudutech.nazarenelostfoundapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private List<LostItem> lostItems;
    private LostItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Lost Items");

        lostItems = new ArrayList<>();

        adapter = new LostItemAdapter(this, lostItems);

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.lostitems_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(adapter);

        loadTestData();




        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PostItemActivity.class));
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);




    }

    private void loadTestData() {
        //HARDCODED DATA FOR THE PROTOTYPE . IN REAL APP WILL FETCH FROM DATABASE
        LostItem item1 = new LostItem(
                "Hand Bag",
                "Leather handbag black and light marroon in color",
                "Nairobi Campus",
                "Lecture Room 6",
                0d,
                0d,
                new Date(),
               R.drawable.item1,
                ""
        );


        LostItem item2 = new LostItem(
                "Wallet",
                "Brown leather wallet",
                "Around Nairobi Campus",
                "Lecture Room 7",
                0d,
                0d,
                new Date(),
               R.drawable.item2,
                ""
        );


        LostItem item3 = new LostItem(
                "Hp Laptop",
                "Black hp laptop core i3 500gb HDD",
                "Nairobi Campus",
                "Lecture Room 9",
                0d,
                0d,
                new Date(),
                R.drawable.item3,
                ""
        );

        LostItem item4 = new LostItem(
                "Car Keys",
                "Car keys a set of 3",
                "Nairobi Campus",
                "Lecture Room 10",
                0d,
                0d,
                new Date(),
                R.drawable.item4,
                ""
        );

        LostItem item5 = new LostItem(
                "Atm Card",
                "National back Atm Card. Acc Number 12345678",
                "Nairobi Campus",
                "Lecture Room 12",
                0d,
                0d,
                new Date(),
                R.drawable.item5,
                ""
        );

        LostItem item6 = new LostItem(
                "Iphone 6",
                "Iphone 6 white in color",
                "Nairobi Campus",
                "Lecture Room 4",
                0d,
                0d,
                new Date(),
                R.drawable.item6,
                ""
        );

        lostItems.add(item1);
        lostItems.add(item2);
        lostItems.add(item3);
        lostItems.add(item4);
        lostItems.add(item5);
        lostItems.add(item6);
        adapter.notifyDataSetChanged();

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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_lost_items) {

        } else if (id == R.id.nav_found_items) {
            Toast.makeText(this, "Coming soon", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_post_lost) {
            startActivity(new Intent(MainActivity.this, PostItemActivity.class));

        } else if (id == R.id.nav_report_found) {
            Toast.makeText(this, "Coming soon", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_logout) {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
