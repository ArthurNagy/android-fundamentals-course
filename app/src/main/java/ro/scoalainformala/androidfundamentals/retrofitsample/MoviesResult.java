package ro.scoalainformala.androidfundamentals.retrofitsample;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

public class MoviesResult {

    @SerializedName("page")
    private int page;
    @SerializedName("results")
    private List<Movie> movies;
    @SerializedName("total_results")
    private int totalResults;
    @SerializedName("total_pages")
    private int totalPages;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoviesResult that = (MoviesResult) o;
        return page == that.page &&
                totalResults == that.totalResults &&
                totalPages == that.totalPages &&
                movies.equals(that.movies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(page, movies, totalResults, totalPages);
    }
}
