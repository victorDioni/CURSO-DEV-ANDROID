package dionizio.victor.navigationdrawer;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import dionizio.victor.navigationdrawer.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);

        //CRIA REFERENCIA PARA TODA A AREA DO NAVIGATIONDRAWER
        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        //CRICA REFERENCIA PARA A AREA DE NAVEGAÇÃO
        NavigationView navigationView = findViewById(R.id.nav_view);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        //DEFINE CONFIGURAÇÕES DO NAVIGATIONDRAWER
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow, R.id.nav_tools,
                R.id.nav_contacts, R.id.nav_share, R.id.nav_send)
                .setOpenableLayout(drawer)
                .build();

        // CONFIGURA A AREA QUE IRA CARREGAR OS FRAGMENTS
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);

        // EXIBE O MENU SUPERIOR DE NAVEFAÇÃO - MENU HAMBURGUER
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);

        // CONFIGURA A NAVEGAÇÃO PARA O NAVIGATIONVIEW - CARREGA OS ITENS DE MENU QUE SÃO SELECIONADOS
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}