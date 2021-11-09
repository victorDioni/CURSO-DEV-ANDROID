package dionizio.victor.minhasanotacoes;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.EditText;


import dionizio.victor.minhasanotacoes.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    private AnotacaoPreferencias preferencias;
    private EditText editAnotacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        editAnotacao = findViewById(R.id.editAnotacao);
        preferencias = new AnotacaoPreferencias(getApplicationContext());

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoRecuperado = editAnotacao.getText().toString();
                if(textoRecuperado.equals("")){
                    Snackbar.make(view, "Preencha a anotação!", Snackbar.LENGTH_LONG).show();
                }else{
                    preferencias.salvarAnatacao(textoRecuperado);
                    Snackbar.make(view, "Anotação salva com sucesso!", Snackbar.LENGTH_LONG).show();
                }

            }
        });

        // Recuperar anotação
        String anotacao = preferencias.recuperarAnatacao();
        if(!anotacao.equals("")){
            editAnotacao.setText(anotacao);
        }
    }
}