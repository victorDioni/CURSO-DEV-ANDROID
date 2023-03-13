package dionizio.victor.retrofit.api;

import java.util.List;

import dionizio.victor.retrofit.model.Foto;
import dionizio.victor.retrofit.model.Postagem;
import retrofit2.Call;
import retrofit2.http.GET;

public interface DataService {

    @GET("/photos")
    Call<List<Foto>> recupearFotos();

    @GET("/posts")
    Call<List<Postagem>> recupearPostagens();
}
