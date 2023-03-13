package dionizio.victor.retrofit.api;

import dionizio.victor.retrofit.model.CEP;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CEPService {

    @GET("{cep}/json/") // Recupear os dados, vai completar a baseURL com essa informacao
    Call<CEP> recupearCEP(@Path("cep") String cep);
}
