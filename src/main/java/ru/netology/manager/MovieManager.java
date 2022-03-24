package ru.netology.manager;

import ru.netology.domain.Movie;
import ru.netology.repository.MovieRepository;

public class MovieManager {
    private MovieRepository repository;
    private int indexLimit = 10;

    public MovieManager(MovieRepository repository) {
        this.repository = repository;
    }

    public void addNew(Movie movie) {
        repository.save(movie);
    }


    public Movie[] findLast() {
        Movie[] movies = repository.findAll();
        int resultLength = movies.length;
        if (resultLength > indexLimit) {
            resultLength = indexLimit;
        } else {
            resultLength = movies.length;
        }
        Movie[] result = new Movie[resultLength];
        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }
}
