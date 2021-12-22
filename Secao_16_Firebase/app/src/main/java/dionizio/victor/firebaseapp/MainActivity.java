package dionizio.victor.firebaseapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    // Permite salvar dados no firebase
    private DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

    //Permite gerenciar usuarios
    private FirebaseAuth usuario = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseReference usuarios = reference.child("usuarios");

//        DatabaseReference usuarioPesquisa = usuarios.child("-MrYkfWv77eMWHqhtvbO");
//        Query usuarioPesquisa = usuarios.orderByChild("nome").equalTo("Victor");
//        Query usuarioPesquisa = usuarios.orderByKey().limitToFirst(2);
        Query usuarioPesquisa = usuarios.orderByKey().limitToLast(2);
        usuarioPesquisa.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                Usuario dadosUsuario = snapshot.getValue(Usuario.class);
//                Log.i("Dados usuarios", "nome: " + dadosUsuario.getNome());
                Log.i("Dados usuarios", snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



//        Usuario usuario = new Usuario();
//        usuario.setNome("Paula");
//        usuario.setSobrenome("Lima");
//        usuario.setIdade(20);

        //Gerando identificador unico
//        usuarios.push().setValue(usuario);

        // Deslogar usuario
//        usuario.signOut();

        //Logar usuario
//        usuario.signInWithEmailAndPassword(
//                "victor2@gmail.com", "vic12345")
//                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if(task.isSuccessful()){
//                            Log.i("signIn", "Sucesso ao logar usuário");
//                                }else{
//                                    Log.i("signIn", "Erro ao logar usuário");
//                                }
//                    }
//                });

        // Verifica usuario logado
//        if(usuario.getCurrentUser() != null){
//            Log.i("CurrentUser", "Usuário logado!");
//        }else{
//            Log.i("CurrentUser", "Usuário não logado!");
//        }

        // Cadastro de usuario
//        usuario.createUserWithEmailAndPassword(
//                "victor2@gmail.com", "vic12345")
//                .addOnCompleteListener(MainActivity.this,
//                        new OnCompleteListener<AuthResult>() {
//                            @Override
//                            public void onComplete(@NonNull Task<AuthResult> task) {
//                                if(task.isSuccessful()){
//                                    Log.i("CREATE USER", "Sucesso ao cadastrar usuário");
//                                }else{
//                                    Log.i("CREATE USER", "Erro ao cadastrar usuário");
//                                }
//                            }
//                        });

        // Recuperar dados
//        DatabaseReference usuarios = reference.child("usuarios");
//        DatabaseReference produtos = reference.child("produtos");
//
//        usuarios.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                // se tiver qualquer mudança na tabela usuarios, esse método ira nos informar
//                Log.i("FIREBASE", snapshot.getValue().toString());
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                // tratar erros ao tentar atualizar
//            }
//        });

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