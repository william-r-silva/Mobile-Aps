package e.isadora.telainicial.Retrofit;

import java.util.List;

import e.isadora.telainicial.Models.Avaliacao;
import e.isadora.telainicial.Models.Campanha;
import e.isadora.telainicial.Models.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface RetrofitUser {

    @POST("user/")
    Call<User> cadastrar(@Body User user);

    @PUT("user/")
    Call<User> editar( @Body User user);

    @GET("user/{id}")
    Call<User> buscarPorId(@Path("id") int id);

    @GET("user/{email}/{senha}")
    Call<User> logar(@Path("email") String email, @Path("senha") String senha);

    @GET("user/")
    Call<List<User>> buscarTodos();

    @GET("user/campanhassemrelacao/{id}")
    Call<List<Campanha>> buscarSemRelacao(@Path("id") Integer id);

    @GET("user/criadas/{id}")
    Call<List<Campanha>> buscarCriadas(@Path("id") Integer id);

    @GET("user/participadas/{id}")
    Call<List<Campanha>> buscarParticipadas(@Path("id") Integer id);

    @GET("user/avaliacao/{id}")
    Call<List<Avaliacao>> buscarAvaliadas(@Path("id") Integer id);

    @DELETE("user/{id}")
    Call<User> excluir(@Path("id") int idUsuario);

}
