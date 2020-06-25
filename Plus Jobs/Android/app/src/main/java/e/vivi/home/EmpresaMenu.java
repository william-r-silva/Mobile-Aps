package e.vivi.home;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import e.vivi.home.Fragments.Empresa_Menu_Comentarios;
import e.vivi.home.Fragments.Empresa_Menu_Informacoes;
import e.vivi.home.Fragments.Empresa_Menu_Enviar;

public class EmpresaMenu extends AppCompatActivity {


    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empresa_menu);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        bundle.get("Empresa_Nome");

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.addTab(tabLayout.newTab().setText("Informações"));
        tabLayout.addTab(tabLayout.newTab().setText("Comentarios"));
        SharedPreferences shared = getSharedPreferences("PlusJobs", MODE_PRIVATE);
        if(shared.getInt("ID_User", 0) != 0) {
            tabLayout.addTab(tabLayout.newTab().setText("Enviar"));
        }


        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);

        mViewPager = findViewById(R.id.container);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        private int contTab;

        public SectionsPagerAdapter(FragmentManager fm, int contTab) {
            super(fm);
            this.contTab = contTab;
        }

        @Override
        public Fragment getItem(int position) {

            switch (position){
                case 0:
                    Empresa_Menu_Informacoes tab1 = new Empresa_Menu_Informacoes();
                    return tab1;
                case 1:
                    Empresa_Menu_Comentarios tab2 = new Empresa_Menu_Comentarios();
                    return tab2;
                case 2:
                    Empresa_Menu_Enviar tab3 = new Empresa_Menu_Enviar();
                    return tab3;
                default:
                    Empresa_Menu_Informacoes tabDefault = new Empresa_Menu_Informacoes();
                    return tabDefault;
            }
        }

        @Override
        public int getCount() {
            return contTab;
        }
    }
}
