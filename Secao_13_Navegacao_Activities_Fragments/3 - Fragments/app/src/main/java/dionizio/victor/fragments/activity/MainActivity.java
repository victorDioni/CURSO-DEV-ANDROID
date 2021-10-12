package dionizio.victor.fragments.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import dionizio.victor.fragments.R;
import dionizio.victor.fragments.fragments.ContatosFragment;
import dionizio.victor.fragments.fragments.ConversasFragment;

public class MainActivity extends AppCompatActivity {
    private Button btnConversas, btnContatos;
    private ConversasFragment conversasFragment;
    private ContatosFragment contatosFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnContatos     = findViewById(R.id.btnContatos);
        btnConversas     = findViewById(R.id.btnConversas);

        // REMOVER SOMBRA DA ACTIONBAR
        getSupportActionBar().setElevation(0);

        conversasFragment = new ConversasFragment();

        // CONFIGURAR OBJETO PARA O FRAGMENTO
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameConteudo, conversasFragment);
        transaction.commit();

        btnContatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contatosFragment = new ContatosFragment();

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameConteudo, contatosFragment);
                transaction.commit();
            }
        });

        btnConversas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                conversasFragment = new ConversasFragment();
                
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameConteudo, conversasFragment);
                transaction.commit();

            }
        });


    }
}