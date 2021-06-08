package ro.scoalainformala.androidfundamentals;

import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MovieViewHolder extends RecyclerView.ViewHolder {

    private final ImageView thumbnail;
    private final TextView title;
    private final TextView description;
    private final RatingBar ratingBar;
    private final TextView releaseDate;

    public MovieViewHolder(@NonNull View itemView) {
        super(itemView);

        thumbnail = itemView.findViewById(R.id.thumbnail);
        title = itemView.findViewById(R.id.title);
        description = itemView.findViewById(R.id.description);
        ratingBar = itemView.findViewById(R.id.rating);
        releaseDate = itemView.findViewById(R.id.release_date);
    }

    public void bindMovie(Movie movie) {
        thumbnail.setImageResource(movie.getThumbnail());
        title.setText(movie.getTitle());
        description.setText(movie.getDescription());
        ratingBar.setRating(movie.getRating());
        releaseDate.setText(movie.getReleaseDate());
    }
}
