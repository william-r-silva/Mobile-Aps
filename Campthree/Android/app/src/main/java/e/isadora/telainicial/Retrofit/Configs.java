package e.isadora.telainicial.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Configs {
    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://192.168.100.11:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    public static final String PAYPAL_CLIENT_ID="AYx8TfrY2SAZfFCp_202kiKRsDr3h4NgPJubrnMD0uvtu9Ie0CB-E8J9rs7AKXV9DYnC9LFu36jo0LpI";
}
