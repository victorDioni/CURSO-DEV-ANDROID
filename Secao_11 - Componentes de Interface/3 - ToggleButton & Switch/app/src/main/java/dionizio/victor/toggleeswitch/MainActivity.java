package dionizio.victor.toggleeswitch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private ToggleButton toggleSenha;
    private Switch switchSenha;
    private TextView textResultado;
    private CheckBox checkSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleSenha     = findViewById(R.id.toggleSenha);
        switchSenha     = findViewById(R.id.switchSenha);
        textResultado   = findViewById(R.id.txtResultado);
        checkSenha      = findViewById(R.id.checkSenha);

        adicionarMonitoramento();
    }

    public void enviar(View view){
        if(checkSenha.isChecked()){
            textResultado.setText("check ligado");
        }else{
            textResultado.setText("check desligado");
        }
    }

    public void adicionarMonitoramento(){
        switchSenha.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    textResultado.setText("ligado");
                }else{
                    textResultado.setText("desligado");
                }
            }
        });
    }
}