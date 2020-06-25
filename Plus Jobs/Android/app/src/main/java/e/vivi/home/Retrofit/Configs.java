package e.vivi.home.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Configs {
        public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://192.168.100.26:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
