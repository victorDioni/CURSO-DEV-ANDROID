package dionizio.victor.preferenciasdousuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private Button btnSalvar;
    private TextInputEditText editNome;
    private TextView txtResultado;
    private static final String ARQUIVO_PREFERENCIA = "ArquivoPreferencia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSalvar       = findViewById(R.id.btnSalvar);
        editNome        = findViewById(R.id.editNome);
        txtResultado    = findViewById(R.id.txtResultado);


        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA, MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();

                // Validar o nome
                if(editNome.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),
                            "Preencha o nome", Toast.LENGTH_LONG).show();
                }else{
                    // Salvando dado
                    String nome = editNome.getText().toString();
                    editor.putString("nome", nome);
                    editor.commit();
                    txtResultado.setText("Olá " + nome);

                }
            }
        });

        // Recuperar dados salvos
        SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA, MODE_PRIVATE);

        // Valida se temos o nome em preferencias
        if(preferences.contains("nome")){
            String nome = preferences.getString("nome", "usuário não definido");
            txtResultado.setText("Olá " + nome);
        }else{
            txtResultado.setText("Usuário não definido");
        }
    }
}