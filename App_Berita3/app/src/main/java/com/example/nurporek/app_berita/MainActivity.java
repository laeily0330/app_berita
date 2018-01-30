package com.example.nurporek.app_berita;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nurporek.app_berita.adapter.IsiAdapter;
import com.example.nurporek.app_berita.generator.ServiceGenerator;
import com.example.nurporek.app_berita.halaman.LoginActivity;
import com.example.nurporek.app_berita.halaman.hal_about;
import com.example.nurporek.app_berita.halaman.hal_infotaiment;
import com.example.nurporek.app_berita.halaman.hal_movies;
import com.example.nurporek.app_berita.halaman.hal_politik;
import com.example.nurporek.app_berita.halaman.hal_sport;
import com.example.nurporek.app_berita.halaman.hal_teknologi;
import com.example.nurporek.app_berita.model.Isi;
import com.example.nurporek.app_berita.services.Services;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
        private Toolbar toolbar;
        private TabLayout tabLayout;
        private ViewPager viewPager;
        public int id_user, logged;
        public String nama, email;
        public TextView haha;
        Services gotService;
        RecyclerView rv;
        IsiAdapter mDataAdapter;
        int idp;
        List<Isi> isiList = new ArrayList<>();
        RecyclerView.LayoutManager mLayoutManager;
    //View a, out;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
        Intent i = getIntent();
        id_user = i.getIntExtra("id_user", 0);
        logged = i.getIntExtra("logged", 0);
        nama = i.getStringExtra("nama_user");
        email = i.getStringExtra("e_mail");
        //a = findViewById(R.id.nav_login);
        //out = findViewById(R.id.action_logout);
        if(i.getData()!= null){
            Log.d("Tidak null","id_user");
            haha = (TextView) findViewById(R.id.textView);
            haha.setText(i.getStringExtra("nama_user"));
        }else{
            Log.d("MBOH","WES"+nama+id_user); // iki gae ndelok lek onok id ne opo ora
        }
        //recycleview
        gotService = ServiceGenerator.createService(Services.class);
        reloadData();
        mDataAdapter = new IsiAdapter(getApplicationContext(), isiList, id_user, email, logged, nama);
        rv = (RecyclerView) findViewById(R.id.recyclerview);
        mLayoutManager = new LinearLayoutManager(this);
        rv.setAdapter(mDataAdapter);
        rv.setLayoutManager(mLayoutManager);

        //end recyclerview

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);



        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void reloadData() {
        Call<List<Isi>> call = gotService.getLatest();
        call.enqueue(new Callback<List<Isi>>() {
            @Override
            public void onResponse(Call<List<Isi>> call, Response<List<Isi>> response) {
                Log.d("SOKO", "SUKSES");
                isiList.clear();
                isiList.addAll(response.body());
                mDataAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Isi>> call, Throwable t) {
                Log.d("SOKO", "GAGAL");
            }
        });
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new OneeFragment(), "");
        adapter.addFragment(new TwoFragment(), "");
        adapter.addFragment(new ThreeFragment(), "");
        viewPager.setAdapter(adapter);
    }
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
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
        //getting the search view from the menu
        MenuItem searchViewItem = menu.findItem(R.id.menuSearch);

        //getting search manager from systemservice
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);

        //getting the search view
        final SearchView searchView = (SearchView) searchViewItem.getActionView();

        //you can put a hint for the search input field
        searchView.setQueryHint("Search Berita...");
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        //by setting it true we are making it iconified
        //so the search input will show up after taping the search iconified
        //if you want to make it visible all the time make it false
        searchView.setIconifiedByDefault(true);

        //here we will get the search query
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                //do the search here
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            if (logged==1){
                logged=0;
                Intent i = new Intent(MainActivity.this, MainActivity.class);
                //i.putExtra("id_user", id_user);
                //i.putExtra("nama_user", nama);
                //i.putExtra("e_mail", email);
                i.putExtra("logged", logged);
                startActivity(i);
                Toast.makeText(this, "You clicked logout", Toast.LENGTH_SHORT).show();
            }else{
                //out.setClickable(false);
            }


            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_politik) {
            Intent i = new Intent(MainActivity.this, hal_politik.class);
            i.putExtra("id_user", id_user);
            i.putExtra("nama_user", nama);
            i.putExtra("e_mail", email);
            i.putExtra("logged", logged);
            startActivity(i);

        } else if (id == R.id.nav_teknologi) {
            Intent i = new Intent(MainActivity.this, hal_teknologi.class);
            i.putExtra("id_user", id_user);
            i.putExtra("nama_user", nama);
            i.putExtra("e_mail", email);
            i.putExtra("logged", logged);
            startActivity(i);

        } else if (id == R.id.nav_sport) {
            Intent i = new Intent(MainActivity.this, hal_sport.class);
            i.putExtra("id_user", id_user);
            i.putExtra("nama_user", nama);
            i.putExtra("e_mail", email);
            i.putExtra("logged", logged);
            startActivity(i);

        } else if (id == R.id.nav_infotaiment) {
            Intent i = new Intent(MainActivity.this, hal_infotaiment.class);
            i.putExtra("id_user", id_user);
            i.putExtra("nama_user", nama);
            i.putExtra("e_mail", email);
            i.putExtra("logged", logged);
            startActivity(i);

        } else if (id == R.id.nav_movies) {
            Intent i = new Intent(MainActivity.this, hal_movies.class);
            i.putExtra("id_user", id_user);
            i.putExtra("nama_user", nama);
            i.putExtra("e_mail", email);
            i.putExtra("logged", logged);
            startActivity(i);

        } else if (id == R.id.nav_about_us) {
            Intent i = new Intent(MainActivity.this, hal_about.class);
            i.putExtra("id_user", id_user);
            i.putExtra("nama_user", nama);
            i.putExtra("e_mail", email);
            i.putExtra("logged", logged);
            startActivity(i);

        } else if (id == R.id.nav_login) {
            if(logged==0){
                Intent i = new Intent(MainActivity.this, LoginActivity.class);
                i.putExtra("id_user", id_user);
                i.putExtra("nama_user", nama);
                i.putExtra("e_mail", email);
                i.putExtra("logged", logged);
                startActivity(i);
            }else{

            }

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



}

