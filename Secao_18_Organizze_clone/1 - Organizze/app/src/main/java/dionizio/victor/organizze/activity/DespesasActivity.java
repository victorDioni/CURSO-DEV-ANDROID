package dionizio.victor.organizze.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

import dionizio.victor.organizze.R;
import dionizio.victor.organizze.helper.DateCustom;

public class DespesasActivity extends AppCompatActivity {

    private TextInputEditText campoData, campoCategoria, campoDescricao;
    private EditText campoValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_despesas);

        campoValor  = findViewById(R.id.editValor);
        campoData  = findViewById(R.id.editData);
        campoCategoria  = findViewById(R.id.editCategoria);
        campoDescricao  = findViewById(R.id.editDescricao);

        //Preenche o campo data com a data atual
        campoData.setText(DateCustom.dataAtual());


    }
}