package dionizio.victor.componentesbasicos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private EditText campoNome;
    private TextInputEditText campoEmail;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoNome = findViewById(R.id.inpName);
        campoEmail = findViewById(R.id.inpEmail);
        resultado = findViewById(R.id.txtResultado);
    }

    public void enviar(View view){
        String nome = campoNome.getText().toString();
        String email = campoEmail.getText().toString();

        resultado.setText("nome: " + nome + " email: " + email);

    }

    public void limpar(View view){
        campoNome.setText("");
        campoEmail.setText("");
    }
}