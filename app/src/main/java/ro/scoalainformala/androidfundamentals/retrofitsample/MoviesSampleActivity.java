package ro.scoalainformala.androidfundamentals.retrofitsample;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import ro.scoalainformala.androidfundamentals.R;

public class MoviesSampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_sample);

        MoviesAdapter adapter = new MoviesAdapter();

        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        MoviesDataSource dataSource = new MoviesDataSource();

        dataSource.getMovies(new MoviesCallback() {
            @Override
            public void onSuccess(List<Movie> movies) {
                adapter.setMovies(movies);
            }

            @Override
            public void onFailure(Throwable throwable) {
                Snackbar.make(recyclerView, "Movies request failed with: " + throwable.getMessage(), Snackbar.LENGTH_LONG)
                        .show();
            }
        });
    }
}
