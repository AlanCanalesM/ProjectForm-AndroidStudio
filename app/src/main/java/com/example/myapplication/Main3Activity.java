package com.example.myapplication;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.myapplication.Fragments1_sem.FalgFragment;
import com.example.myapplication.Fragments1_sem.FinFragment;
import com.example.myapplication.Fragments1_sem.FlecFragment;
import com.example.myapplication.Fragments1_sem.FqFragment;
import com.example.myapplication.Fragments1_sem.VideosalgFragment;
import com.example.myapplication.Fragments1_sem.VideosinFragment;
import com.example.myapplication.Fragments1_sem.VideoslecFragment;
import com.example.myapplication.Fragments1_sem.VideosqFragment;
import com.example.myapplication.clases.Utilidades;
import com.example.myapplication.contenedores.AlgebraFragment;
import com.example.myapplication.contenedores.ContenedorFragment;
import com.example.myapplication.contenedores.ContenedorFragment2;
import com.example.myapplication.contenedores.ContenedorFragment3;
import com.example.myapplication.contenedores.ContenedorFragment4;


public class Main3Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, RedFragment.OnFragmentInteractionListener, GreenFragment.OnFragmentInteractionListener, QuimicaFragment.OnFragmentInteractionListener, DesaFragment.OnFragmentInteractionListener, ContenedorFragment.OnFragmentInteractionListener, ContenedorFragment2.OnFragmentInteractionListener, ContenedorFragment3.OnFragmentInteractionListener, ContenedorFragment4.OnFragmentInteractionListener, VideosqFragment.OnFragmentInteractionListener, FqFragment.OnFragmentInteractionListener, VideosinFragment.OnFragmentInteractionListener, FinFragment.OnFragmentInteractionListener, VideoslecFragment.OnFragmentInteractionListener, FlecFragment.OnFragmentInteractionListener, AlgebraFragment.OnFragmentInteractionListener, VideosalgFragment.OnFragmentInteractionListener, FalgFragment.OnFragmentInteractionListener {

    TextView tvnombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);





        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


if (Utilidades.validapantalla=true){

    Fragment fragment= new ContenedorFragment();
    getSupportFragmentManager().beginTransaction().replace(R.id.content_main3, fragment).commit();
    Utilidades.validapantalla=false;
}





        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);

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
        getMenuInflater().inflate(R.menu.main3, menu);
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

        Fragment miFragment =null;
        boolean fragmentSeleccionado=false;

        if (id == R.id.nav_camera) {
            miFragment=new ContenedorFragment();
            fragmentSeleccionado=true;
        } else if (id == R.id.nav_gallery) {

            miFragment=new ContenedorFragment2();
            fragmentSeleccionado=true;

        } else if (id == R.id.nav_slideshow) {

            miFragment=new ContenedorFragment3();
            fragmentSeleccionado=true;

        } else if (id == R.id.nav_manage) {

miFragment=new ContenedorFragment4();
fragmentSeleccionado=true;
        } else if (id == R.id.nav_share) {

miFragment=new DesaFragment();
fragmentSeleccionado=true;

        } else if (id == R.id.nav_send) {

        }

        if (fragmentSeleccionado==true){
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main3, miFragment).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
