package com.moviecatalogue.server.repositories;

import com.moviecatalogue.server.models.Movie;
import com.moviecatalogue.server.repositories.base.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MoviesRepository implements BaseRepository<Movie> {
    private List<Movie> movies;

    public MoviesRepository() {
        movies = new ArrayList<>();
        movies.add(new Movie(1, "Fast and furious",
                "https://vignette.wikia.nocookie.net/fastandfurious/images/0/04/" +
                        "The_Fast_and_the_Furious_%28DVD_Cover%29.jpeg/revision/latest?cb=20150501043627",
                "Vin Diesel, Paul Walker, Michelle Rodriguez",
                "The Fast and the Furious is an American media franchise based on a series of action" +
                        " films that is largely concerned with illegal street racing, heists and espionage, " +
                        "and includes material in various other media that " +
                        "depicts characters and situations from the films. ", "Action"));

        movies.add(new Movie(2, "The Conjuring",
                "https://upload.wikimedia.org/wikipedia/en/1/1f/Conjuring_poster.jpg",
                "Patrick Wilson, Vera Farmiga, Ron Livingston",
                "The Conjuring is a 2013 American supernatural horror film directed by James Wan " +
                        "and written by Chad Hayes and Carey W. Hayes. It is the first installment in The Conjuring" +
                        " Universe.[3] Patrick Wilson and Vera Farmiga star as Ed and Lorraine Warren, paranormal " +
                        "investigators and authors associated with prominent cases of haunting.", "Horror"));

        movies.add(new Movie(3, "GoodFellas",
                "https://upload.wikimedia.org/wikipedia/en/7/7b/Goodfellas.jpg" ,
                " Robert De Niro, Ray Liotta, Joe Pesci",
                "Goodfellas (stylized as GoodFellas) is a 1990 American crime film directed by Martin" +
                        " Scorsese. It is an adaptation of the 1986 non-fiction book Wiseguy by Nicholas Pileggi, " +
                        "who co-wrote the screenplay with Scorsese. The film narrates the rise and fall of mob " +
                        "associate Henry Hill and his friends and family from 1955 to 1980. ", "Crime"));

        movies.add(new Movie(4, "The Godfather",
                "https://static.posters.cz/image/1300/%D0%BF%D0%BB%D0%B0%D0%BA%D0%B0%D1%82/the-godfather-colour-cat-i8602.jpg",
                "Marlon Brando, Al Pacino, James Caan",
                "The Godfather is a 1972 American crime film directed by Francis Ford Coppola and produced " +
                        "by Albert S. Ruddy, based on Mario Puzo's best-selling novel of the same name. It stars Marlon" +
                        " Brando and Al Pacino as the leaders of a fictional New York crime family. The story, " +
                        "spanning 1945 to 1955, chronicles the family under the patriarch Vito Corleone (Brando), " +
                        "focusing on the transformation of Michael Corleone (Pacino) from reluctant family outsider to " +
                        "ruthless mafia boss. ", "Crime"));

        movies.add(new Movie(5, "Rush Hour",
                "https://upload.wikimedia.org/wikipedia/en/thumb/5/55/Rush_hour_ver2.jpg/220px-Rush_hour_ver2.jpg",
                "Jackie Chan, Chris Tucker, Ken Leung",
                "Rush Hour is a 1998 American action comedy film directed by Brett Ratner and written by Jim Kouf " +
                        "and Ross LaManna from a story by LaManna. It stars Jackie Chan and Chris Tucker as mismatched" +
                        " police officers who must rescue the Chinese consul's kidnapped daughter. Tom Wilkinson, Chris " +
                        "Penn, and Elizabeth Peña play supporting roles. Released on September 18, 1998, the film " +
                        "grossed over $244 million worldwide. The film's success led to two sequels: Rush Hour 2 (2001)" +
                        "and Rush Hour 3 (2007).", "Comedy"));

        movies.add(new Movie(6, "The Italian Job",
                "https://images-na.ssl-images-amazon.com/images/I/71-ErxbNPKL._SY445_.jpg",
                "Donald Sutherland, Mark Wahlberg, Edward Norton",
                "The Italian Job is a 2003 American heist film directed by F. Gary Gray, written by Wayne" +
                        " and Donna Powers and produced by Donald DeLine. The film stars Mark Wahlberg, Charlize " +
                        "Theron, Edward Norton, Jason Statham, Seth Green, Mos Def and Donald Sutherland. It is" +
                        " an American remake of the 1969 British film of the same name, and is about a team of thieves" +
                        " who plan to steal gold from a former associate who double-crossed them.", "Action"));

        movies.add(new Movie(7, "Ocean's Eleven",
                "https://m.media-amazon.com/images/M/MV5BYzVmYzVkMmUtOGRhMi00MTNmLThlMmUtZTljYjlkMjNkMjJkXkEyXkFqcGdeQXVyNDk3NzU2MTQ@._V1_.jpg",
                "George Clooney, Brad Pitt, Julia Roberts",
                "Danny Ocean wants to score the biggest heist in history. He combines an eleven member team, " +
                        "including Frank Catton, Rusty Ryan and Linus Caldwell. Their target? The Bellagio, the Mirage" +
                        " and the MGM Grand. All casinos owned by Terry Benedict. It's not going to be easy, as they plan " +
                        "to get in secretly and out with $150 million.", "Comedy"));

        movies.add(new Movie(8, "Tag",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSLDFVMkh_Wf9zf8EwbUlJhGZfUxIc-F9s9o5Y1ehaNXF8va9Ot",
                "Jeremy Renner, Ed Helms, Jake Johnson",
                "One month every year, five highly competitive friends hit the ground running in a no-holds- barred game " +
                        "of tag they’ve been playing since the first grade—risking their necks, their jobs and their relationships to " +
                        "take each other down with the battle cry “You’re It!” This year, the game coincides with the wedding of their " +
                        "only undefeated player, which should finally make him an easy target. But he knows they’re coming...and he’s ready." +
                        " Based on a true story, “Tag” shows how far some guys will go to be the last man standing.", "Comedy"));

        movies.add(new Movie(9,"Mission: Impossible - Fallout",
                "https://m.media-amazon.com/images/M/MV5BMTk3NDY5MTU0NV5BMl5BanBnXkFtZTgwNDI3MDE1NTM@._V1_.jpg",
                "Tom Cruise, Henry Cavill, Ving Rhames",
                "The best intentions often come back to haunt you. \"Mission: Impossible - Fallout\" finds Ethan Hunt (Tom Cruise)" +
                        " and his IMF team (Alec Baldwin, Simon Pegg, Ving Rhames) along with some familiar allies (Rebecca Ferguson, Michelle Monaghan)" +
                        " in a race against time after a mission gone wrong. Henry Cavill, Angela Bassett, and Vanessa Kirby also join the dynamic cast " +
                        "with filmmaker Christopher McQuarrie returning to the helm.", "Action"));

        movies.add(new Movie(10, "Halloween",
                "https://upload.wikimedia.org/wikipedia/en/thumb/b/b1/Halloween_%282018%29_poster.jpg/220px-Halloween_%282018%29_poster.jpg",
                "Judy Greer, Jamie Lee Curtis, Virginia Gardner",
                "Jamie Lee Curtis returns to her iconic role as Laurie Strode, who comes to her final confrontation with Michael Myers, " +
                        "the masked figure who has haunted her since she narrowly escaped his killing spree on Halloween night four decades ago. " +
                        "Greer would play Karen Strode, the daughter of Curtis’ character.\n" +
                        "Master of horror John Carpenter will executive produce and serve as creative consultant on this film, joining forces with " +
                        "cinema’s current leading producer of horror, Jason Blum (\"Get Out,\" \"Split,\" \"The Purge,\" \"Paranormal Activity\")." +
                        " Inspired by Carpenter’s classic, filmmakers David Gordon Green and Danny McBride crafted a story that carves a new path from " +
                        "the events in the landmark 1978 film, and Green also directs.", "Horror"));

        movies.add(new Movie(11, "Split",
                "https://m.media-amazon.com/images/M/MV5BZTJiNGM2NjItNDRiYy00ZjY0LTgwNTItZDBmZGRlODQ4YThkL2ltYWdlXkEyXkFqcGdeQXVyMjY5ODI4NDk@._V1_UX182_CR0,0,182,268_AL_.jpg",
                "James McAvoy, Anya Taylor-Joy, Haley Lu Richardson",
                "Though Kevin (James McAvoy) has evidenced 23 personalities to his trusted psychiatrist, Dr. Fletcher (Betty Buckley), " +
                        "there remains one still submerged who is set to materialize and dominate all the others. Compelled to abduct three teenage " +
                        "girls led by the willful, observant Casey (Anya Taylor-Joy, The Witch), Kevin reaches a war for survival among all of those " +
                        "contained within him—as well as everyone around him—as the walls between his compartments shatter apart.\n" +
                        "For \"Split,\" Shyamalan and Blum reassemble their core team from \"The Visit,\" the No. 1-grossing horror film of 2015. " +
                        "Their fellow collaborators include producer Marc Bienstock and executive producers Ashwin Rajan and Steven Schneider.", "Horror"));

        movies.add(new Movie(12, "John Wick",
                "https://m.media-amazon.com/images/M/MV5BMTU2NjA1ODgzMF5BMl5BanBnXkFtZTgwMTM2MTI4MjE@._V1_.jpg",
                "Keanu Reeves, Michael Nyqvist, Alfie Allen",
                "An ex-hitman comes out of retirement to track down the gangsters that took everything from him. With New York City as " +
                        "his bullet-riddled playground, \"John Wick\" (Keanu Reeves) is a fresh and stylized take on the \"assassin genre\".", "Crime"));

        movies.add(new Movie(13,"Avengers: Infinity War",
                "https://m.media-amazon.com/images/M/MV5BMjMxNjY2MDU1OV5BMl5BanBnXkFtZTgwNzY1MTUwNTM@._V1_.jpg",
                "Robert Downey Jr., Chris Hemsworth, Mark Ruffalo",
                "An unprecedented cinematic journey ten years in the making and spanning the entire Marvel Cinematic Universe, Marvel Studios' " +
                        "\"Avengers: Infinity War\" brings to the screen the ultimate, deadliest showdown of all time. The Avengers and their Super Hero " +
                        "allies must be willing to sacrifice all in an attempt to defeat the powerful Thanos before his blitz of devastation and ruin puts " +
                        "an end to the universe.", "Action"));

        movies.add(new Movie(14, "Ocean's Eight",
                "https://m.media-amazon.com/images/M/MV5BMjAyNDEyMzc4Ml5BMl5BanBnXkFtZTgwMjEzNjM0NTM@._V1_.jpg",
                " Sandra Bullock, Cate Blanchett, Anne Hathaway",
                "The tide has turned and it’s a whole new “Ocean’s” when eight women plan and execute a heist in New York. Oscar winner Sandra " +
                        "Bullock stars in the title role, alongside Oscar winners Cate Blanchett and Anne Hathaway, Mindy Kaling, Sarah Paulson, Awkwafina, " +
                        "with Rihanna and Oscar nominee Helena Bonham Carter. Oscar-nominated filmmaker Gary Ross is directing.", "Crime"));

        movies.add(new Movie(15, "It",
                "https://m.media-amazon.com/images/M/MV5BZDVkZmI0YzAtNzdjYi00ZjhhLWE1ODEtMWMzMWMzNDA0NmQ4XkEyXkFqcGdeQXVyNzYzODM3Mzg@._V1_.jpg",
                "Bill Skarsgård, Jaeden Lieberher, Finn Wolfhard",
                "T is long, but IT‘s long in a good way. IT lets us spend time with these characters, as we grow to care for them and worry for them. " +
                        "Pennywise is a formidable monster, and the best scary movies make us feel fear for characters we care about. There are only a few films " +
                        "that get Stephen King so intrinsically perfect – that rich tapestry of emotion, fear, humor, and power that has kept us reading him for more " +
                        "than forty years. In that time, some filmmakers have hit that elusive mark, while others miss wildly. IT feels like Stephen King, that sheer" +
                        " pleasure of cracking open one of his books for the first time, and falling into his world.", "Horror"));

        movies.add(new Movie(16, "Jumanji: Welcome to the Jungle",
                "https://is4-ssl.mzstatic.com/image/thumb/Video115/v4/f9/f0/8d/f9f08de5-cdbe-de2a-05dc-f09662a1c203/pr_source.lsr/268x0w.png",
                "Dwayne Johnson, Karen Gillan, Kevin Hart",
                "Genre:Action, Fantasy, Adventure\n" +
                        "\n" +
                        "Plot Summary:\n" +
                        "In the brand new adventure \"Jumanji: Welcome to the Jungle,\" the tables are turned as four teenagers in detention are sucked into " +
                        "the world of Jumanji. When they discover an old video game console with a game they’ve never heard of, they are immediately thrust into" +
                        " the game’s jungle setting, into the bodies of their avatars, played by Dwayne Johnson, Jack Black, Kevin Hart, and Karen Gillan. " +
                        "What they discover is that you don’t just play Jumanji – Jumanji plays you. They’ll have to go on the most dangerous adventure of their lives," +
                        " or they’ll be stuck in the game forever…", "Comedy"));
    }

    @Override
    public List<Movie> getAll() {
        return movies;
    }

    @Override
    public Movie getById(int id) {
        return movies.get(id);
    }

    @Override
    public Movie add(Movie movie) {
        movie.setId(movies.size() + 1);
        movie.setImageUrl("http://hdphonewallpapers.com/content/hZJzObX6qrqF7lyC9xWpUuvHoc44Jgbwx1XMyQf66YAj9kMT8Xeh9XAvmBKugdvJ.jpg");

        movies.add(movie);
        return movie;
    }

    @Override
    public Movie update(int id, Movie object) {
        movies.get(id).setRating(object.getRating());

        return movies.get(id);
    }


}
