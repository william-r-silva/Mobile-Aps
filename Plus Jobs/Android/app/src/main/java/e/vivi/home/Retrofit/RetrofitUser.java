package e.vivi.home.Retrofit;

import e.vivi.home.Models.User;
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

    @DELETE("user/{id}")
    Call<User> excluir(@Path("id") int idUsuario);

}
