package ru.netology.manager;

import ru.netology.domain.Movie;

public class MovieManager {
    private Movie[] movies = new Movie[0];
    private int indexLimit = 10;

    public MovieManager(int indexLimit) {
        this.indexLimit = indexLimit;
    }

    public MovieManager() {
    }

    public void addNew(Movie movie) {
        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public Movie[] findAll() {
        int resultLength = movies.length;
        if (resultLength > indexLimit) {
            resultLength = indexLimit;
        } else {
            resultLength = movies.length;
        }
        Movie[] result = new Movie[resultLength];
        for (int i = 0; i < resultLength; i++) {
            result[i] = movies[i];
        }
        return result;
    }

    public Movie[] findLast() {
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
