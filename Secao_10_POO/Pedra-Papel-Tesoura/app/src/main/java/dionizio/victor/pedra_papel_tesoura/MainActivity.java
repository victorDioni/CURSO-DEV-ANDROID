package dionizio.victor.pedra_papel_tesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view){
        opcaoSelecionada("pedra");
    }

    public void selecionadoPapel(View view){
        opcaoSelecionada("papel");
    }

    public void selecionadoTesoura(View view){
        opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String escolhaUsuario){
        TextView txtResultado = findViewById(R.id.txtResultado);
        ImageView imgResultado = findViewById(R.id.imgPadrao);
        int numero = new Random().nextInt(3);
        String [] opcoes = {"pedra", "papel", "tesoura"};
        String escolhaApp = opcoes[numero];

        switch(escolhaApp){
            case "pedra":
                imgResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imgResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imgResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        //App ganhador
        if(escolhaApp == "pedra" && escolhaUsuario == "tesoura" ||
           escolhaApp == "papel" && escolhaUsuario == "pedra" ||
           escolhaApp == "tesoura" && escolhaUsuario == "papel"){

        txtResultado.setText("Você perdeu :(");
        //usuario ganhador
        }else if(escolhaUsuario == "pedra" && escolhaApp == "tesoura" ||
                escolhaUsuario == "papel" && escolhaApp == "pedra" ||
                escolhaUsuario == "tesoura" && escolhaApp == "papel"){
                txtResultado.setText("Você ganhou !!!!");

        }else{//empate
            txtResultado.setText("Deu empate !!!!");
        }


    }
}