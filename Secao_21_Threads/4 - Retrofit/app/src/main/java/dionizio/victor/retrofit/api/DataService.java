package dionizio.victor.retrofit.api;

import java.util.List;

import dionizio.victor.retrofit.model.Foto;
import dionizio.victor.retrofit.model.Postagem;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface DataService {

    @GET("/photos")
    Call<List<Foto>> recupearFotos();

    @GET("/posts")
    Call<List<Postagem>> recupearPostagens();

    @POST("/posts")
    Call<Postagem>salvarPostagem(@Body Postagem postagem);

    //userId=1234&titke=Titulo postagem&body=Corpo postagem
    @FormUrlEncoded
    @POST("/posts")
    Call<Postagem> salvarPostagem(
            @Field("userId") String userId,
            @Field("title") String title,
            @Field("body") String body
    );
}
