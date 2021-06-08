package ro.scoalainformala.androidfundamentals;

import androidx.annotation.DrawableRes;

import java.util.Objects;

public class Movie {
    private final String title;
    private final String releaseDate;
    private final float rating;
    @DrawableRes
    private final int thumbnail;
    private final String description;

    public Movie(String title, String releaseDate, float rating, int thumbnail, String description) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.rating = rating;
        this.thumbnail = thumbnail;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public float getRating() {
        return rating;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movies = (Movie) o;
        return Float.compare(movies.rating, rating) == 0 &&
                thumbnail == movies.thumbnail &&
                title.equals(movies.title) &&
                releaseDate.equals(movies.releaseDate) &&
                description.equals(movies.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, releaseDate, rating, thumbnail, description);
    }
}
