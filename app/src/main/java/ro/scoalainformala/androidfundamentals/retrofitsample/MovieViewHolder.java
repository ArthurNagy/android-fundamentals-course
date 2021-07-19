package ro.scoalainformala.androidfundamentals.retrofitsample;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import ro.scoalainformala.androidfundamentals.R;

public class MovieViewHolder extends RecyclerView.ViewHolder {

    private final ImageView image;
    private final TextView title;
    private final TextView description;
    private final TextView releaseDate;
    private final TextView popularity;

    public MovieViewHolder(@NonNull View itemView) {
        super(itemView);

        image = itemView.findViewById(R.id.image);
        title = itemView.findViewById(R.id.title);
        description = itemView.findViewById(R.id.description);
        releaseDate = itemView.findViewById(R.id.release_date);
        popularity = itemView.findViewById(R.id.popularity);
    }

    public void bindMovie(Movie movie) {
        Glide.with(image)
                .load("https://image.tmdb.org/t/p/original" + movie.getBackdropImagePath())
                .into(image);
        title.setText(movie.getTitle());
        description.setText(movie.getDescription());
        releaseDate.setText(itemView.getContext().getString(R.string.release_date, movie.getReleaseDate()));
        popularity.setText(itemView.getContext().getString(R.string.popularity, movie.getPopularity()));
    }
}