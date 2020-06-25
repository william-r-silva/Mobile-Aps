package e.isadora.telainicial.Retrofit;

import java.util.List;

import e.isadora.telainicial.Models.Campanha;
import e.isadora.telainicial.Models.Instituicao;
import e.isadora.telainicial.Models.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface RetrofitInstituicao {

    @POST("institutos/")
    Call<Instituicao> cadastrar(@Body Instituicao instituicao);

    @PUT("institutos/")
    Call<Instituicao> editar(@Body Instituicao instituicao);

    @GET("institutos/{id}")
    Call<Instituicao> buscarPorId(@Path("id") Integer id);

    @GET("institutos/{email}/{senha}")
    Call<Instituicao> logar(@Path("email") String email, @Path("senha") String senha);

    @GET("institutos/")
    Call<List<Instituicao>> buscarTodas();

    @GET("institutos/autorizada/{id}")
    Call<List<Campanha>> buscarAutorizadas(@Path("id") Integer id);

    @GET("institutos/naoautorizada/{id}")
    Call<List<Campanha>> buscarNaoAutorizadas(@Path("id") Integer id);

    @DELETE("institutos/{id}")
    Call<Instituicao> excluir(@Path("id") Integer id);

}
