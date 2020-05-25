package com.example.evento.Coordinator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.example.evento.Coordinator.Home.EventFragment;
import com.example.evento.R;
import com.example.evento.utils.Tools;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CoordinatorMain extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.main_content)
    LinearLayout mainContent;
    @BindView(R.id.floating_action_button)
    FloatingActionButton floatingActionButton;
    @BindView(R.id.bottom_nav)
    BottomNavigationView bottomNav;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    private ActionBar actionBar;
    private DrawerLayout drawer;

    private Menu menu_navigation;
    private View navigation_header;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_coordinator);
        ButterKnife.bind((Activity) this);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add((int) R.id.main_content, (Fragment) new EventFragment()).commit();
        }
        initToolbar();
        initNavigationMenu();
        this.floatingActionButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                CoordinatorMain.this.startActivity(new Intent(CoordinatorMain.this, AddEvent.class));
            }
        });
    }

    private void initToolbar() {
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.toolbar.setBackgroundColor(getResources().getColor(R.color.grey_90));
        setSupportActionBar(this.toolbar);
        this.actionBar = getSupportActionBar();
        this.actionBar.setDisplayHomeAsUpEnabled(true);
        this.actionBar.setHomeButtonEnabled(true);
        this.actionBar.setTitle((CharSequence) "Home");
        Tools.setSystemBarColor(this, R.color.grey_90);
    }

    private void initNavigationMenu() {
        NavigationView nav_view = (NavigationView) findViewById(R.id.nav_view);
        this.drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle r2 = new ActionBarDrawerToggle(this, this.drawer, this.toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close) {
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        this.drawer.setDrawerListener(r2);
        r2.syncState();
        nav_view.setNavigationItemSelectedListener(new OnNavigationItemSelectedListener() {
            public boolean onNavigationItemSelected(MenuItem item) {
                CoordinatorMain.this.onItemNavigationClicked(item);
                return true;
            }
        });
        this.menu_navigation = nav_view.getMenu();
        this.navigation_header = nav_view.getHeaderView(0);
    }

    /* access modifiers changed from: private */
    public void onItemNavigationClicked(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.nav_home) {
            return;
        }
        if (itemId != R.id.nav_profile) {
            Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_LONG).show();
        } else {
            startActivity(new Intent(this, CoordinatorProfile.class));
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.demo_drawer, menu);
        return true;
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }

    private void hideSystemUI() {
        getWindow().getDecorView().setSystemUiVisibility(3846);
    }

    private void showSystemUI() {
        getWindow().getDecorView().setSystemUiVisibility(1792);
    }
}
