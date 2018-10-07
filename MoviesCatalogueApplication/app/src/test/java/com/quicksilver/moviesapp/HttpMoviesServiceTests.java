package com.quicksilver.moviesapp;

import com.quicksilver.moviesapp.models.Movie;
import com.quicksilver.moviesapp.models.MovieRating;
import com.quicksilver.moviesapp.repositories.HttpRepository;
import com.quicksilver.moviesapp.services.HttpMoviesService;
import com.quicksilver.moviesapp.validators.MovieValidator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class HttpMoviesServiceTests {
    private static List<Movie> defaultMovies;

    @Mock
    HttpRepository mockRepository;

    @Mock
    MovieValidator mockValidator;

    @InjectMocks
    HttpMoviesService service = new HttpMoviesService(mockRepository, mockValidator);

    static {
        Movie firstMovie = new Movie("Fast and furious",
                "Vin Diesel, Paul Walker, Michelle Rodriguez",
                "The Fast and the Furious is an American media franchise based on a series of action" +
                        " films that is largely concerned with illegal street racing, heists and espionage, " +
                        "and includes material in various other media that " +
                        "depicts characters and situations from the films. ", "Action",
                new byte[]{}, new MovieRating());


        firstMovie.setId(1);

        Movie secondMovie = new Movie("The conjuring",
                "Patrick Wilson, Vera Farmiga, Ron Livingston",
                "The Conjuring is a 2013 American supernatural horror film directed by James Wan " +
                        "and written by Chad Hayes and Carey W. Hayes. It is the first installment in The Conjuring " +
                        "Universe.[3] Patrick Wilson and Vera Farmiga star as Ed and Lorraine Warren, paranormal " +
                        "investigators and authors associated with prominent cases of haunting.", "Horror",
                new byte[]{}, new MovieRating());

        secondMovie.setId(2);

        Movie thirdMovie = new Movie("GoodFellas",
                "Robert De Niro, Ray Liotta, Joe Pesci",
                "Goodfellas (stylized as GoodFellas) is a 1990 American crime film directed by Martin" +
                        "Scorsese. It is an adaptation of the 1986 non-fiction book Wiseguy by Nicholas Pileggi," +
                        "who co-wrote the screenplay with Scorsese. The film narrates the rise and fall of mob " +
                        "associate Henry Hill and his friends and family from 1955 to 1980.", "Crime",
                new byte[]{}, new MovieRating());

        thirdMovie.setId(3);

        defaultMovies = Arrays.asList(firstMovie, secondMovie, thirdMovie);
    }

    @Test
    public void getAllMovies_shouldReturnAllMovies() throws IOException {
        // Arrange
        Mockito.when(mockRepository.getAll())
                .thenReturn(defaultMovies);

        // Act
        List<Movie> result = service.getAllMovies();

        // Assert
        Assert.assertEquals(3, result.size());
    }

    @Test
    public void getMovieById_shouldReturnMatchingMovie() throws IOException {
        // Arrange
        Mockito.when(mockRepository.getById(2))
                .thenReturn(defaultMovies.get(1));

        // Act
        Movie movie = service.getDetailById(2);

        // Assert
        Assert.assertEquals(2, movie.getId());
    }

    @Test
    public void getFilteredMovies_shouldReturnMatchingMovies() throws IOException {
        // Arrange
        Mockito.when(mockRepository.getAll())
                .thenReturn(defaultMovies);

        // Act
        List<Movie> filteredMovies = service.getFilteredMovies("Horror");

        // Assert
        Assert.assertEquals(1, filteredMovies.size());
        Assert.assertEquals("Horror", filteredMovies.get(0).getCategory());
    }

    @Test
    public void getLatestMovies_shouldReturnMatchingMovies() throws IOException {
        // Arrange
        Mockito.when(mockRepository.getAll())
                .thenReturn(defaultMovies);

        // Act
        List<Movie> latestMovies = service.getLatestMovies();

        // Assert
        Assert.assertEquals(3, latestMovies.size());
    }
}
