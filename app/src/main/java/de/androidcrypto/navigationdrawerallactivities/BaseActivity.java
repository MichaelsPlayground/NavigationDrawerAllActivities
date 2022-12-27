package de.androidcrypto.navigationdrawerallactivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

/*

android.support.design.widget.AppBarLayout
com.google.android.material.appbar.AppBarLayout

android.support.design.widget.BottomSheetDialog
com.google.android.material.bottomsheet.BottomSheetDialog

android.support.design.widget.TextInputLayout
com.google.android.material.textfield.TextInputLayout

android.support.design.widget.CoordinatorLayout
androidx.coordinatorlayout.widget.CoordinatorLayout

android.support.design.widget.NavigationView
com.google.android.material.navigation.NavigationView

androidx.core.view.ViewPager
androidx.viewpager.widget.ViewPager

android.support.design.widget.BottomSheetBehavior
com.google.android.material.bottomsheet.BottomSheetBehavior

android.support.v7.widget.Toolbar
androidx.appcompat.widget.Toolbar

android.support.design.internal.BottomNavigationItemView
com.google.android.material.bottomnavigation.BottomNavigationItemView

android.support.design.internal.BottomNavigationMenuView
com.google.android.material.bottomnavigation.BottomNavigationMenuView

androidx.appcompat.widget.CardView
androidx.cardview.widget.CardView

android.support.design.widget.BottomNavigationView
com.google.android.material.bottomnavigation.BottomNavigationView

androidx.core.view.ViewPager
androidx.viewpager.widget.ViewPager

importandroidx.core.widget.DrawerLayout
androidx.drawerlayout.widget.DrawerLayout

androidx.appcompat.widget.RecyclerView
androidx.recyclerview.widget.RecyclerView

androidx.core.view.PagerAdapter
androidx.viewpager.widget.PagerAdapter

importandroidx.core.app.FragmentManager
importandroidx.fragment.app.FragmentManager

android.support.v7.widget.AppCompatCheckBox
androidx.appcompat.widget.AppCompatCheckBox

android.support.design.R.id.snackbar_text
com.google.android.material.R.id.snackbar_text

android.support.design.widget.FloatingActionButton
com.google.android.material.floatingactionbutton.FloatingActionButton
 */

public class BaseActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawer;
    FloatingActionButton fab;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_activity1) {
            startAnimatedActivity(new Intent(getApplicationContext(), FirstActivity.class));
        } else if (id == R.id.nav_activity2) {
            startAnimatedActivity(new Intent(getApplicationContext(), SecondActivity.class));
        }

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    protected void startAnimatedActivity(Intent intent) {
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }
}
