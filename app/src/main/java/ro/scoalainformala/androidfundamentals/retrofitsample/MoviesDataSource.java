package ro.scoalainformala.androidfundamentals.retrofitsample;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviesDataSource {

    public void getMovies(MoviesCallback callback) {
        TheMovieDBService service = RetrofitClient.getRetrofitInstance().create(TheMovieDBService.class);
        service.getTopRatedMovies(RetrofitClient.API_KEY).enqueue(new Callback<MoviesResult>() {
            @Override
            public void onResponse(Call<MoviesResult> call, Response<MoviesResult> response) {
                callback.onSuccess(response.body().getMovies());
            }

            @Override
            public void onFailure(Call<MoviesResult> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }

}
