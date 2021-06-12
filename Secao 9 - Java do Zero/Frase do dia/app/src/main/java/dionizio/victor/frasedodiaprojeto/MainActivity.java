package dionizio.victor.frasedodiaprojeto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gerarNovaFrase(View view){
        String[] frases = {
                "O importante não é vencer todos os dias, mas lutar sempre.",
                "Maior que a tristeza de não haver vencido é a vergonha de não ter lutado!",
                "É melhor conquistar a si mesmo do que vencer mil batalhas",
                "Quem ousou conquistar e saiu pra lutar, chega mais longe!"
        };

        int numero = new Random().nextInt(4);

        TextView texto = findViewById(R.id.txtResultado);
        texto.setText(frases[numero]);
    }
}