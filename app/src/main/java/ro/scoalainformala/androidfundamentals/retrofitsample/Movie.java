package ro.scoalainformala.androidfundamentals.retrofitsample;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 *     {
 *
 *       "poster_path": "/9O7gLzmreU0nGkIB6K3BsJbzvNv.jpg",
 *       "adult": false,
 *       "overview": "Framed in the 1940s for the double murder of his wife and her lover, upstanding banker Andy Dufresne begins a new life at the Shawshank prison, where he puts his accounting skills to work for an amoral warden. During his long stretch in prison, Dufresne comes to be admired by the other inmates -- including an older prisoner named Red -- for his integrity and unquenchable sense of hope.",
 *       "release_date": "1994-09-10",
 *       "genre_ids": [
 *         18,
 *         80
 *       ],
 *       "id": 278,
 *       "original_title": "The Shawshank Redemption",
 *       "original_language": "en",
 *       "title": "The Shawshank Redemption",
 *       "backdrop_path": "/xBKGJQsAIeweesB79KC89FpBrVr.jpg",
 *       "popularity": 6.741296,
 *       "vote_count": 5238,
 *       "video": false,
 *       "vote_average": 8.32
 *     },
 */
public class Movie {

    @SerializedName("poster_path")
    private String posterImagePath;
    @SerializedName("overview")
    private String description;
    @SerializedName("release_date")
    private String releaseDate;
    @SerializedName("id")
    private int id;
    @SerializedName("title")
    private String title;
    @SerializedName("backdrop_path")
    private String backdropImagePath;
    @SerializedName("popularity")
    private double popularity;
    @SerializedName("vote_count")
    private int voteCount;
    @SerializedName("vote_average")
    private double voteAverage;

    public String getPosterImagePath() {
        return posterImagePath;
    }

    public void setPosterImagePath(String posterImagePath) {
        this.posterImagePath = posterImagePath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBackdropImagePath() {
        return backdropImagePath;
    }

    public void setBackdropImagePath(String backdropImagePath) {
        this.backdropImagePath = backdropImagePath;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id == movie.id &&
                Double.compare(movie.popularity, popularity) == 0 &&
                voteCount == movie.voteCount &&
                voteAverage == movie.voteAverage &&
                posterImagePath.equals(movie.posterImagePath) &&
                description.equals(movie.description) &&
                releaseDate.equals(movie.releaseDate) &&
                title.equals(movie.title) &&
                backdropImagePath.equals(movie.backdropImagePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(posterImagePath, description, releaseDate, id, title, backdropImagePath, popularity, voteCount, voteAverage);
    }
}
