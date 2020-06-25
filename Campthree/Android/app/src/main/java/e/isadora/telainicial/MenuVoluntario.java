package e.isadora.telainicial;

import android.content.Intent;
import android.os.Bundle;

import e.isadora.telainicial.Fragments.Voluntario.AdicionaCampanha;
import e.isadora.telainicial.Fragments.Voluntario.EditarVoluntario;
import e.isadora.telainicial.Fragments.Voluntario.ListarAcompanhadas;
import e.isadora.telainicial.Fragments.Voluntario.ListarCampanhas;
import e.isadora.telainicial.Fragments.Voluntario.ListarMinhasCampanhas;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MenuVoluntario extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = findViewById(R.id.nav_view);

        if (savedInstanceState == null) {
            navigationView.setCheckedItem(R.id.nav_campanhas);
            setTitle("Campanhas");
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.Menu_Frag, new ListarCampanhas()).addToBackStack(null).commit();
        }

        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        Fragment fragment = new Fragment();
        int id = item.getItemId();

        if (id == R.id.nav_campanhas) {
            setTitle("Campanhas");
            fragment = new ListarCampanhas();
        }else if (id == R.id.nav_editar) {
            setTitle("Editar");
            fragment = new EditarVoluntario();
        }else if (id == R.id.nav_add_campanha) {
            setTitle("Adicionar campanha");
            fragment = new AdicionaCampanha();
        }else if (id == R.id.nav_sair) {
            Intent intent = new Intent(MenuVoluntario.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }else if (id == R.id.nav_campanhas_participadas) {
            setTitle("Campanhas acompanhadas");
            fragment = new ListarAcompanhadas();
        }else if (id == R.id.nav_minhas_campanhas) {
            setTitle("Minhas campanhas");
            fragment = new ListarMinhasCampanhas();
        }else{
            setTitle("Campanhas");
            fragment = new ListarCampanhas();
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.Menu_Frag, fragment).addToBackStack(null).commit();
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}