package e.vivi.home.Retrofit;

import java.util.List;

import e.vivi.home.Models.Empresa;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface RetrofitEmpresa {

    @POST("empresa/")
    Call<Empresa> adicionarEmpresa(@Body Empresa empresa);

    @PUT("empresa/{id}")
    Call<Empresa> editarEmpresa(@Path ("id") int idEmpresa,@Body Empresa empresa);

    @DELETE("empresa/{id}")
    Call<Empresa> deletaEmpresa(@Path ("id") int idEmpresa);

    @GET("empresa/{id}")
    Call<Empresa> buscarEmpresa(@Path ("id") int idEmpresa);

    @GET("empresa/autorizado" +
            "")
    Call<List<Empresa>> listarEmpresa();

    @GET("empresa/nome/{nome}")
    Call<List<Empresa>> buscarEmpresaPorNome(@Path("nome") String nome);


}
