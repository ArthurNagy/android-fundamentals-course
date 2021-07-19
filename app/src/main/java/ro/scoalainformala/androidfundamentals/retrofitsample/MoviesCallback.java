package ro.scoalainformala.androidfundamentals.retrofitsample;

import java.util.List;

public interface MoviesCallback {
    void onSuccess(List<Movie> movies);

    void onFailure(Throwable throwable);
}
