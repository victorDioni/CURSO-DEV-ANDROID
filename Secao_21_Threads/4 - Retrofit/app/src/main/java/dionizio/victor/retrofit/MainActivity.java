package dionizio.victor.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import dionizio.victor.retrofit.api.CEPService;
import dionizio.victor.retrofit.api.DataService;
import dionizio.victor.retrofit.model.CEP;
import dionizio.victor.retrofit.model.Foto;
import dionizio.victor.retrofit.model.Postagem;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Button btnRecuperar;
    private TextView txtResultado;
    private Retrofit retrofit;
    private List<Foto> listaFotos = new ArrayList<>();
    private DataService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRecuperar = findViewById(R.id.btnRecuperar);
        txtResultado = findViewById(R.id.txtResultado);

        retrofit = new Retrofit.Builder()
//                .baseUrl("https://viacep.com.br/ws/")
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(DataService.class);

        btnRecuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                recupearCEPRetrofit();
//                recupearListaRetrofit();
//                salvarPostagem(); -> Método post
//                atualizarPostagem();
                removerPostagem();

            }
        });
    }

    private void removerPostagem(){
        Call<Void> call = service.removerPostagem(2);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(response.isSuccessful()){
                    txtResultado.setText(
                            "Status code: " + response.code()
                    );
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }

    private void atualizarPostagem(){
        //Configura objeto postagem
        Postagem postagem = new Postagem(
                "1234", null, "Corpo postagem");

        Call<Postagem> call = service.atualizarPostagemPatch(2, postagem);
        call.enqueue(new Callback<Postagem>() {
            @Override
            public void onResponse(Call<Postagem> call, Response<Postagem> response) {
                if(response.isSuccessful()){
                    Postagem postagemResposta = response.body();
                    txtResultado.setText(
                                    "Status code: " + response.code() +
                                    " id: " + postagemResposta.getId() +
                                    " userId: " + postagemResposta.getUserId() +
                                    " titulo: " + postagemResposta.getTitle() +
                                    " body: " + postagemResposta.getBody()
                    );
                }
            }

            @Override
            public void onFailure(Call<Postagem> call, Throwable t) {

            }
        });
    }

    private void salvarPostagem(){

        //Configura objeto postagem
        Postagem postagem = new Postagem(
                "1234", "Titulo postagem!", "Corpo postagem");


        // Recupera o serviço e salva postagem
        Call<Postagem> call = service.salvarPostagem(postagem);

        call.enqueue(new Callback<Postagem>() {
            @Override
            public void onResponse(Call<Postagem> call, Response<Postagem> response) {
                if(response.isSuccessful()){
                    Postagem postagemResposta = response.body();
                    txtResultado.setText(
                            "Código: " + response.code() +
                            " id: " + postagemResposta.getId() +
                            " titulo: " + postagemResposta.getTitle()
                    );
                }
            }

            @Override
            public void onFailure(Call<Postagem> call, Throwable t) {

            }
        });

    }

    private void recupearListaRetrofit(){

        DataService service = retrofit.create(DataService.class);
        Call<List<Foto>> call = service.recupearFotos();

        call.enqueue(new Callback<List<Foto>>() {
            @Override
            public void onResponse(Call<List<Foto>> call, Response<List<Foto>> response) {
                if(response.isSuccessful()){
                    listaFotos = response.body();

                    for (int i = 0; i < listaFotos.size(); i++){
                        Foto foto = listaFotos.get(i);
                        Log.d("Resultado", "Resultado: " + foto.getId()
                        + " / " + foto.getTitle());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Foto>> call, Throwable t) {

            }
        });
    }

    private void recupearCEPRetrofit(){

        CEPService cepService = retrofit.create(CEPService.class);
        Call<CEP> call = cepService.recupearCEP("01310100");

        call.enqueue(new Callback<CEP>() {
            @Override
            public void onResponse(Call<CEP> call, Response<CEP> response) {
                if(response.isSuccessful()){
                    CEP cep = response.body();
                    txtResultado.setText(cep.getLogradouro() + " / " + cep.getBairro());
                }
            }

            @Override
            public void onFailure(Call<CEP> call, Throwable t) {

            }
        });

    }
}