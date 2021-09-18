package dionizio.victor.cardview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import dionizio.victor.cardview.R;
import dionizio.victor.cardview.adapter.PostagemAdapter;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerPostagem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerPostagem    = findViewById(R.id.recyclerPostagem);

        //DEFINIR LAYOUT
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerPostagem.setLayoutManager(layoutManager);

        //DEFINIR ADAPTER
        PostagemAdapter adapter = new PostagemAdapter();
        recyclerPostagem.setAdapter(adapter);
    }
}