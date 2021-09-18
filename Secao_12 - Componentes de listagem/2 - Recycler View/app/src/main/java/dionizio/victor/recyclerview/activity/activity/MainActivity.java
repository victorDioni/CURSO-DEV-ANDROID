package dionizio.victor.recyclerview.activity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import dionizio.victor.recyclerview.R;
import dionizio.victor.recyclerview.activity.adapter.Adapter;
import dionizio.victor.recyclerview.activity.model.Filme;
import dionizio.victor.recyclerview.activity.model.RecyclerItemClickListener;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Filme> listasFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView    = findViewById(R.id.recyclerView);

        //LISTAGEM DE FILMES
        this.criarFilmes();

        //CONFIGURAR ADAPTER
        Adapter adapter = new Adapter(listasFilmes);

        //CONFIGURAR RECYCLERVIEW
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);

        //EVENTO DE CLICK
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Filme filme = listasFilmes.get(position);
                                Toast.makeText(
                                        getApplicationContext(),
                                        "Item pressionado: " + filme.getTituloFilme(),
                                        Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Filme filme = listasFilmes.get(position);
                                Toast.makeText(
                                        getApplicationContext(),
                                        "Click longo: " + filme.getTituloFilme(),
                                        Toast.LENGTH_LONG).show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            }
                        }
                )
        );
    }

    public void criarFilmes(){
        Filme filme = new Filme("Homem Aranha", "Aventura", "2017");
        this.listasFilmes.add(filme);

        filme = new Filme("Mulher Maravilha", "Fantansia", "2017");
        this.listasFilmes.add(filme);

        filme = new Filme("Capitão América", "Aventura/Ficção", "2016");
        this.listasFilmes.add(filme);

        filme = new Filme("It: A Coisa", "Drama/Terror", "2017");
        this.listasFilmes.add(filme);

        filme = new Filme("Pica-Pau", "Comédia/Animação", "2017");
        this.listasFilmes.add(filme);

        filme = new Filme("A Múmia", "Terror", "2017");
        this.listasFilmes.add(filme);

        filme = new Filme("A Bela e a Fera", "Romance", "2017");
        this.listasFilmes.add(filme);

        filme = new Filme("Meu malvado favorito", "Comédia", "2017");
        this.listasFilmes.add(filme);

        filme = new Filme("Carros 3", "Comédia", "2017");
        this.listasFilmes.add(filme);

        filme = new Filme("Pantera Negra", "Aventura/Ficção", "2017");
        this.listasFilmes.add(filme);

        filme = new Filme("Hulk", "Aventura/Ficção", "2014");
        this.listasFilmes.add(filme);

        filme = new Filme("Thor", "Aventura/Ficçã", "2014");
        this.listasFilmes.add(filme);
    }
}