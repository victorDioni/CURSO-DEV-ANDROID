package dionizio.victor.calculadoradegorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editValor;
    private TextView txtPorcentagem, txtGorjeta, txtTotal;
    private SeekBar seekBarGorjeta;

    private double porcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editValor       = findViewById(R.id.editValor);
        txtGorjeta      = findViewById(R.id.txtGorjeta);
        txtPorcentagem  = findViewById(R.id.txtPorcentagem);
        txtTotal        = findViewById(R.id.txtTotal);
        seekBarGorjeta  = findViewById(R.id.seekBarGorjeta);

        seekBarGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                porcentagem = i;
                txtPorcentagem.setText(Math.round(porcentagem) + " %");
                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void calcular(){
        String valorRecuperado = editValor.getText().toString();
        if(valorRecuperado == null || valorRecuperado.equals("")){
            Toast.makeText(getApplicationContext(),
        "DIGITE UM VALOR PRIMEIRO!!",
            Toast.LENGTH_LONG).show();
        }else{
            //CONVERTER STRING PARA DOUBLE
            double valorDigitado = Double.parseDouble(valorRecuperado);

            //CALCULAR A GORJETA TOTAL
            double gorjeta  = valorDigitado * (porcentagem/100);
            double total    = (valorDigitado + gorjeta);

            txtGorjeta.setText("R$ " + Math.round(gorjeta));
            txtTotal.setText("R$ " + Math.round(total));
        }
    }

}