package dionizio.victor.passandodadosentreactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SegundaActivity2 extends AppCompatActivity {
    private TextView txtNome, txtIdade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda2);

        txtNome     = findViewById(R.id.txtNome);
        txtIdade    = findViewById(R.id.txtIdade);

        // RECUPERAR OS DADOS ENVIADOS
        Bundle dados = getIntent().getExtras();

        String nome = dados.getString("nome");
        int idade   = dados.getInt("idade");

        // RECUPERANDO OS DADOS DO OBJETO ENVIADO
        Usuario usuario = (Usuario) dados.getSerializable("usuario");

        // CONFIGURAR OS VALORES RECUPERADOS
        txtNome.setText(usuario.getEmail());
        txtIdade.setText(String.valueOf(idade));
    }
}