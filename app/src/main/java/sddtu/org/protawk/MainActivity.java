package sddtu.org.protawk;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by ASHISH KUMAR on 3/15/2017.
 */

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ImageView userImage;
    TextView nametv,emailtv;

    String[] data={"Doctors","Lawyers","Career Counselers","Property Counsultants","Brand Counsaltants","Software Counsultant"};

    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerAdapter;
    private RecyclerView.LayoutManager recyclerManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SharedPreferences sharedPreferences=getSharedPreferences("GoogleInt", Context.MODE_PRIVATE);
        int googleInt=sharedPreferences.getInt("GInt",0);

     recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerManager=new GridLayoutManager(MainActivity.this,2);
        recyclerView.setLayoutManager(recyclerManager);
        recyclerAdapter=new RecyclerAdapter(getDataSet());
        recyclerView.setAdapter(recyclerAdapter);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View view=navigationView.getHeaderView(0);
        nametv=(TextView)view.findViewById(R.id.nametv);
        emailtv=(TextView)view.findViewById(R.id.emailtv);
        userImage=(ImageView)view.findViewById(R.id.userimage);
        if(googleInt==1){
            nametv.setText(sharedPreferences.getString("GName","Protawk"));
            emailtv.setText(sharedPreferences.getString("GEmail","Protawk"));
            String image=sharedPreferences.getString("GPic","");
            Glide.with(this).load(image).into(userImage);
        }
        if(googleInt==2){
            String fName=sharedPreferences.getString("fbName","Protawk");
            String fEmail=sharedPreferences.getString("fbEmail","Protawk");
            String image=sharedPreferences.getString("fbPic","");
           nametv.setText(fName);
            emailtv.setText(fEmail);
            Glide.with(this).load(image).into(userImage);
        }
        navigationView.setNavigationItemSelectedListener(this);
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


    private ArrayList<CardData> getDataSet(){
        ArrayList<CardData> results=new ArrayList<CardData>();
        for(int i=0;i<data.length;i++){
            CardData cardData=new CardData(data[i]);
            results.add(i,cardData);
        }
        return results;
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

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
