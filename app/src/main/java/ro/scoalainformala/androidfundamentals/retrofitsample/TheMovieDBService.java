package ro.scoalainformala.androidfundamentals.retrofitsample;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TheMovieDBService {

    @GET("/3/movie/top_rated")
    Call<MoviesResult> getTopRatedMovies(@Query("api_key") String apiKey);

}
