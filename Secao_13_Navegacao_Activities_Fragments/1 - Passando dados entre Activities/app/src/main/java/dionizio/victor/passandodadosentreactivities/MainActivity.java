package dionizio.victor.passandodadosentreactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEnviar   = findViewById(R.id.btnEnviar);

        // PASSAR DADOS PARA OUTRA ACTIVITY

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SegundaActivity2.class);

                // ENVIANDO DADOS DE UM OBJETO PARA OUTRA ACTIVITY
                Usuario usuario = new Usuario("Viutabala", "vitubala@gmai.com");

                intent.putExtra("nome", "Vitubala");
                intent.putExtra("idade", 23);
                intent.putExtra("usuario", usuario);

                startActivity(intent);
            }
        });
    }
}