package e.isadora.telainicial.Retrofit;

import java.util.List;

import e.isadora.telainicial.Models.Avaliacao;
import e.isadora.telainicial.Models.Campanha;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface RetrofitAvaliacao {

    @POST("avaliacao/")
    Call<Avaliacao> cadastrar(@Body Avaliacao avaliacao);

    @PUT("avaliacao/")
    Call<Avaliacao> editar(@Body Avaliacao avaliacao);

    @GET("avaliacao/{id}")
    Call<Avaliacao> buscarPorId(@Path("id") Integer id);

    @GET("avaliacao/")
    Call<List<Avaliacao>> buscarTodas();

    @DELETE("avaliacao/{id}")
    Call<Avaliacao> excluir(@Path("id") Integer id);

}
