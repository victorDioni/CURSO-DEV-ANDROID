package dionizio.victor.componentesbasicos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private EditText campoNome;
    private TextView campoResultado;
    private TextInputEditText campoEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoNome = findViewById(R.id.txtNome);
        campoResultado = findViewById(R.id.txtResultado);
        campoEmail = findViewById(R.id.txtEmail);
    }

    public void enviar(View view){
        String nome = campoNome.getText().toString();
        String email = campoEmail.getText().toString();

        campoResultado.setText("nome: " + nome + " " + "email: " +email);
    }

    public void limpar(View view){
        campoNome.setText("");
        campoEmail.setText("");
        campoResultado.setText("");
    }
}