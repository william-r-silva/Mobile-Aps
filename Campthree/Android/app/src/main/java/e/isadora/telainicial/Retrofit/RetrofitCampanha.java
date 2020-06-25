package e.isadora.telainicial.Retrofit;

import android.support.annotation.Nullable;

import java.util.List;

import e.isadora.telainicial.Models.Avaliacao;
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

public interface RetrofitCampanha {

    @POST("campanha/")
    Call<Campanha> cadastrar(@Body Campanha campanha);

    @PUT("campanha/")
    Call<Campanha> editar(@Body Campanha campanha);

    @PUT("campanha/{id}")
    Call<Campanha> addInstituicao(@Body Instituicao instituicao, @Path("id") Integer id);

    @GET("campanha/instituicao/{id}")
    Call<Instituicao> instCampanha(@Path("id") Integer id);

    @PUT("campanha/acompanhar/{id}")
    Call<Campanha> acompanhar(@Body Campanha campanha,@Path("id") Integer id);

    @PUT("campanha/desistir/{id}")
    Call<Campanha> desistir(@Body Campanha campanha,@Path("id") Integer id);

    @DELETE("campanha/{id}")
    Call<Campanha> excluir(@Path("id") Integer id);


}
