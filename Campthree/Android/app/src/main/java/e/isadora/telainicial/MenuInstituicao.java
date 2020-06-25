package e.isadora.telainicial;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import e.isadora.telainicial.Fragments.Instituicao.EditarInstituicao;
import e.isadora.telainicial.Fragments.Instituicao.ListarCampanhasInstituicao;
import e.isadora.telainicial.Fragments.Instituicao.ListarValidarCampanhasInstituicao;
import e.isadora.telainicial.Fragments.Voluntario.ListarCampanhas;

public class MenuInstituicao extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_instituicao);
        Toolbar toolbar = findViewById(R.id.i_toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.i_drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = findViewById(R.id.i_nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        if (savedInstanceState == null) {
            navigationView.setCheckedItem(R.id.navi_campanhas);
            setTitle("Campanhas");
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.Menu_Instituicao_Frag, new ListarCampanhasInstituicao()).addToBackStack(null).commit();
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.i_drawer_layout);
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

        if (id == R.id.navi_campanhas) {
            setTitle("Campanhas");
            fragment = new ListarCampanhasInstituicao();
        }else if (id == R.id.navi_editar) {
            setTitle("Editar");
            fragment = new EditarInstituicao();
        }else if (id == R.id.navi_campanhas_validacao) {
            setTitle("Validar campanhas");
            fragment = new ListarValidarCampanhasInstituicao();
        }else  if (id == R.id.navi_sair) {
            Intent intent = new Intent(MenuInstituicao.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }else{
            setTitle("Campanhas");
            fragment = new ListarCampanhasInstituicao();
        }

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.Menu_Instituicao_Frag, fragment).addToBackStack(null).commit();
        DrawerLayout drawer = findViewById(R.id.i_drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}