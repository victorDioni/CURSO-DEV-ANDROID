package dionizio.victor.frasedodia;

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

    public void gerarFrase(View view){
        TextView texto = findViewById(R.id.txtTexto);
        String frases[] = {"Tudo o que um sonho precisa para ser realizado é alguém que acredite que ele possa ser realizado.",
                            "Imagine uma nova história para sua vida e acredite nela",
                            "O importante não é vencer todos os dias, mas lutar sempre.",
                            "Maior que a tristeza de não haver vencido é a vergonha de não ter lutado!",
                            "É melhor conquistar a si mesmo do que vencer mil batalhas."};

        int num = new Random().nextInt(4);

        texto.setText(frases[num]);
    }
}