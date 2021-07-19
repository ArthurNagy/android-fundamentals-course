package ro.scoalainformala.androidfundamentals.retrofitsample;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit RETROFIT;
    public static String BASE_URL = "https://api.themoviedb.org/";
    // TODO: Your TheMovieDB Key here:
    public static String API_KEY = "";

    public static Retrofit getRetrofitInstance() {
        if (RETROFIT == null) {
            RETROFIT = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return RETROFIT;
    }

}
