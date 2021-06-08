package ro.scoalainformala.androidfundamentals;

import java.util.ArrayList;
import java.util.List;

public class MoviesDataSource {
    private final ArrayList<Movie> movies = new ArrayList<Movie>();

    public MoviesDataSource() {
        movies.add(new Movie("The Lord of the Rings: The Two Towers", "December 18, 2002", 8.8F, R.drawable.img_lotr_fellowship, "A meek Hobbit from the Shire and eight companions set out on a journey to destroy the powerful One Ring and save Middle-earth from the Dark Lord Sauron."));
        movies.add(new Movie("The Shawshank Redemption", "1994" , 9.2F, R.drawable.img_shawshank, "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency."));
        movies.add(new Movie("How I met your mother", "19/09/2005", 8.3F, R.drawable.img_himym,"A father recounts to his children - through a series of flashbacks - the journey he and his four best friends took leading up to him meeting their mother."));
        movies.add(new Movie("Ragnarok", "27/05/2021", 8.0F,R.drawable.img_ragnarok ,"A small Norwegian town experiencing warm winters and violent downpours seems to be headed for another Ragnarök -- unless someone intervenes in time."));
        movies.add(new Movie("The Silence of the Lambs", "February 14 1991", 8.6F, R.drawable.img_silenece_lambs,"A young F.B.I. cadet must receive the help of an incarcerated and manipulative cannibal killer to help catch another serial killer, a madman who skins his victims."));
        movies.add(new Movie("Another Round", " 18 December 2020", 7.8F, R.drawable.img_another_round, "Four high school teachers consume alcohol on a daily basis to see how it affects their social and professional lives."));
    }

    public List<Movie> getMovies() {
        return movies;
    }
}
