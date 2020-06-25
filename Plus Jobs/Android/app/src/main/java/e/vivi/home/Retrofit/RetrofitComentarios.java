package e.vivi.home.Retrofit;

import java.util.List;

import e.vivi.home.Models.Comentario;
import e.vivi.home.Models.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface RetrofitComentarios {

    @POST("comentario/")
    Call<Comentario> cadastrar(@Body Comentario comentario);

    @PUT("comentario/")
    Call<Comentario> atualizarComentario(@Body Comentario comentario);

    @DELETE("comentario/{id}")
    Call<Comentario> deletaComentario(@Path("id") int idComentario);

    @GET("comentario/")
    Call<List<Comentario>> comentarios();

    @GET("comentario/{id}")
    Call<Comentario> buscarComentario(@Path("id") int idCometario);

    @GET("comentario/estado/{estado}")
    Call<List<Comentario>> ultimosComentariosEstado(@Path("estado") String estado);

    @GET("comentario/cidadeestado/{cidade}/{estado}")
    Call<List<Comentario>> ultimosComentariosCidade(@Path("estado") String estado, @Path("cidade") String cidade);

    @GET("comentario/empresa/{id}")
    Call<List<Comentario>> comentariosDaEmpresa(@Path("id") int idEmpresa);

    @GET("comentario/user/{id}")
    Call<List<Comentario>> comentariosDoUsuario(@Path("id") int idUsuario);

}
