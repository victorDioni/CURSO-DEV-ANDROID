package dionizio.victor.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editAlcool, editGasolina;
    private TextView txtResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editAlcool      = findViewById(R.id.editAlcool);
        editGasolina    = findViewById(R.id.editGasolina);
        txtResultado    = findViewById(R.id.txtResultado);
    }

    public Boolean validarCampos(String pAlcool, String pGasolina){
        Boolean camposValidados = true;

        if(pAlcool == null || pAlcool.equals("")){
            camposValidados = false;
        } else if (pGasolina == null || pGasolina.equals("")) {
            camposValidados = false;
        }
        return camposValidados;
    }

    public void calcularPreco(View view){
        //RECUPERAR VALORES DIGITADOS
        String precoAlcool   = editAlcool.getText().toString();
        String precoGasolina = editGasolina.getText().toString();

        //VALIDAR OS CAMPOS DIGITADOS
        Boolean camposValidados = validarCampos(precoAlcool, precoGasolina);
        if(camposValidados){
            //CONVERTENDO STRING PARA NÚMEROS
            Double valorAlcool = Double.parseDouble(precoAlcool);
            Double valorGasolina = Double.parseDouble(precoGasolina);

            /*
            FAZER CÁLCULO DE MENOR PREÇO
            SE (VALOR DO ALCOOL / VALOR DA GASOLINA) >= 0.7 É MELHOR UTILIZAR GASOLINA
            SE NÃO É MELHOR UTILIZAR ÁLCOOL
             */

            Double resultado = valorAlcool / valorGasolina;
            if(resultado >= 0.7){
                txtResultado.setText("Melhor usar gasolina");
            }else{
                txtResultado.setText("Melhor usar álcool");
            }
        }else{
            txtResultado.setText("Prencha os preços primeiro!");
        }
    }


}