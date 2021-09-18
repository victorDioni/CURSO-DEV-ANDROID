package dionizio.victor.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ListView listLocais;
    private String [] itens = {
            "Austrália","França","Polinésia Francesa","Japão",
            "Peru","Inglaterra","Italia","EUA","Espanha","Brasil",
            "China","Egito","Caribe","Indonésia","Califórnia",
            "Argentina","Hungria"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listLocais = findViewById(R.id.lisLocais);

        //CRIAR ADAPTADOR PARA A LISTA
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
            getApplicationContext(),
            android.R.layout.simple_list_item_1,
            android.R.id.text1,
            itens
        );

        //ADICIONAR ADAPTADOR PARA A LISTA
        listLocais.setAdapter(adaptador);

        //ADICIONA CLIQUE NA LISTA
        listLocais.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String itemSelecionado = listLocais.getItemAtPosition(i).toString();
                Toast.makeText(getApplicationContext(), itemSelecionado,
                        Toast.LENGTH_LONG).show(); 
            }
        });
    }
}