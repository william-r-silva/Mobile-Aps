package e.vivi.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import e.vivi.home.Fragments.ProcurarEmpresas;
import e.vivi.home.Fragments.UltimosComentarios;

public class MainAnonimus extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_anonimus);
        Toolbar toolbar = findViewById(R.id.toolbar_A);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout_A);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view_A);
        navigationView.setNavigationItemSelectedListener(this);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_content_anonimo
                    , new UltimosComentarios()).commit();
            navigationView.setCheckedItem(R.id.NVA_Ultimos_Comentarios);
            setTitle("Útimos Comentários");
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout_A);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        Fragment fragment = new Fragment();
        int id = item.getItemId();

        if (id == R.id.NVA_Ultimos_Comentarios) {
            setTitle("Útimos Comentários");
            fragment = new UltimosComentarios();
        }else if (id == R.id.NVA_Procurar_Empresas) {
            setTitle("Procurar Empresas");
            fragment = new ProcurarEmpresas();
        }


        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_content_anonimo, fragment).addToBackStack(null).commit();
        DrawerLayout drawer = findViewById(R.id.drawer_layout_A);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
