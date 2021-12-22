package dionizio.victor.firebaseapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    // Permite salvar dados no firebase
    private DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseReference usuarios = reference.child("usuarios");
        DatabaseReference produtos = reference.child("produtos");

        usuarios.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // se tiver qualquer mudança na tabela usuarios, esse método ira nos informar
                Log.i("FIREBASE", snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // tratar erros ao tentar atualizar
            }
        });

        // Salvando dados no Firebase
//        reference.child("pontos").setValue("100");
//
//        DatabaseReference usuarios = reference.child("usuarios");
//        DatabaseReference produtos = reference.child("produtos");
//
//        Usuario usuario = new Usuario();
//        usuario.setNome("Victor");
//        usuario.setSobrenome("Dionizio");
//        usuario.setIdade(23);
//
//        usuarios.child("001").setValue(usuario);
//
//        Produtos produto = new Produtos();
//        produto.setDescricao("Redmi note 10");
//        produto.setMarca("Xiaomi");
//        produto.setPreco(1800.00);
//
//        produtos.child("001").setValue(produto);
    }
}