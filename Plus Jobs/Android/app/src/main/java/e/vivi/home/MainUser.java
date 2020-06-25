package e.vivi.home;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import e.vivi.home.Fragments.ProcurarEmpresas;
import e.vivi.home.Fragments.MeusComentarios;
import e.vivi.home.Fragments.UltimosComentarios;
import e.vivi.home.Fragments.addEmpresa;
import e.vivi.home.Fragments.editar;

public class MainUser extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_user);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new UltimosComentarios()).commit();
            navigationView.setCheckedItem(R.id.NV_Ultimos_Comentarios);
            setTitle("Útimos Comentários");
        }
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

        if (id == R.id.NV_Ultimos_Comentarios) {
            setTitle("Útimos Comentários");
            fragment = new UltimosComentarios();
        }else if (id == R.id.NV_Meus_Comentarios) {
            setTitle("Meus Comentários");
            fragment = new MeusComentarios();
        } else if (id == R.id.NV_Procurar_Empresas) {
            setTitle("Procurar Empresas");
            fragment = new ProcurarEmpresas();
        } else if (id == R.id.NV_Add_Empresa) {
            setTitle("Adicionar Empresa");
            fragment = new addEmpresa();
        } else if (id == R.id.NV_Editar) {
            setTitle("Editar");
            fragment = new editar();
        }else if (id == R.id.NV_Sair) {
            Intent intent = new Intent(MainUser.this, MainActivity.class);
            SharedPreferences pref= getSharedPreferences("PlusJobs", MODE_PRIVATE);
            SharedPreferences.Editor editor;
            editor = pref.edit();
            editor.putInt("ID_User", 0);
            editor.commit();
            startActivity(intent);
        }


        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_content, fragment).addToBackStack(null).commit();
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
