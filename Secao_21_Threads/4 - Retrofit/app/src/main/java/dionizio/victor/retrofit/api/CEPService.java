package dionizio.victor.retrofit.api;

import dionizio.victor.retrofit.model.CEP;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CEPService {

    @GET("01310100/json/") // Recupear os dados, vai completar a baseURL com essa informacao
    Call<CEP> recupearCEP();
}
