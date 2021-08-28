package dionizio.victor.componentesbasicos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    //TEXTO
    private EditText campoNome;
    private TextView campoResultado;
    private TextInputEditText campoEmail;

    // CAIXA DE SELECAO
    private CheckBox checkVerde, checkBranco, checkVermelho;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoNome = findViewById(R.id.txtNome);
        campoResultado = findViewById(R.id.txtResultado);
        campoEmail = findViewById(R.id.txtEmail);

        checkVerde = findViewById(R.id.checkVerde);
        checkBranco = findViewById(R.id.checkBranco);
        checkVermelho = findViewById(R.id.checkVermelho);
    }

    public void checkbox(){
        String texto = "";
        if(checkVerde.isChecked()){
            texto = texto + "Verde selecionado -";
        }if(checkBranco.isChecked()){
            texto = texto + "Branco selecionado -";
        }if(checkVermelho.isChecked()){
            texto =  texto + "Vermelho selecionado -";
        }

        campoResultado.setText(texto);
    }

    public void enviar(View view){
        checkbox();
        /*
        String nome = campoNome.getText().toString();
        String email = campoEmail.getText().toString();

        campoResultado.setText("nome: " + nome + " " + "email: " +email);
        */
    }

    public void limpar(View view){
        campoNome.setText("");
        campoEmail.setText("");
        campoResultado.setText("");
    }
}