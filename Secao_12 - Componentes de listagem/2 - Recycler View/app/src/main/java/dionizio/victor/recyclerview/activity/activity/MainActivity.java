package dionizio.victor.recyclerview.activity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import dionizio.victor.recyclerview.R;
import dionizio.victor.recyclerview.activity.adapter.Adapter;
import dionizio.victor.recyclerview.activity.model.Filme;

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
        Adapter adapter = new Adapter();

        //CONFIGURAR RECYCLERVIEW
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
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
    }
}