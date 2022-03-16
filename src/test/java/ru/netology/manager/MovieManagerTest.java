package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class MovieManagerTest {

    @Test
    public void shouldSaveNewMovieIfNotExists() {
        MovieManager manager = new MovieManager();
        Movie first = new Movie(1, "Бладшот", "боевик");

        manager.addNew(first);

        Movie[] actual = manager.findAll();
        Movie[] expected = {first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveNewMovieIfAlreadyContains() {
        MovieManager manager = new MovieManager();
        Movie first = new Movie(1, "Бладшот", "боевик");
        Movie second = new Movie(2, "Вперёд", "мультфильм");
        Movie third = new Movie(3, "Отель 'Белград'", "комедия");

        manager.addNew(first);
        manager.addNew(second);

        manager.addNew(third);

        Movie[] actual = manager.findAll();
        Movie[] expected = {first, second, third};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllMoviesIfNotExists() {
        MovieManager manager = new MovieManager();
        Movie[] actual = manager.findAll();
        Movie[] expected = {};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllMovies() {
        MovieManager manager = new MovieManager();
        Movie first = new Movie(1, "Бладшот", "боевик");
        Movie second = new Movie(2, "Вперёд", "мультфильм");
        Movie third = new Movie(3, "Отель 'Белград'", "комедия");
        Movie fourth = new Movie(4, "Джентельмены", "боевик");
        Movie fifth = new Movie(5, "Человек-невидимка", "ужасы");
        Movie sixth = new Movie(6, "Тролли. Мировой тур", "мультфильм");
        Movie seventh = new Movie(7, "Номер один", "комедия");

        manager.addNew(first);
        manager.addNew(second);
        manager.addNew(third);
        manager.addNew(fourth);
        manager.addNew(fifth);
        manager.addNew(sixth);
        manager.addNew(seventh);

        Movie[] actual = manager.findAll();
        Movie[] expected = {first, second, third, fourth, fifth, sixth, seventh};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllMoviesWithLimit5() {
        MovieManager manager = new MovieManager(5);

        Movie first = new Movie(1, "Бладшот", "боевик");
        Movie second = new Movie(2, "Вперёд", "мультфильм");
        Movie third = new Movie(3, "Отель 'Белград'", "комедия");
        Movie fourth = new Movie(4, "Джентельмены", "боевик");
        Movie fifth = new Movie(5, "Человек-невидимка", "ужасы");
        Movie sixth = new Movie(6, "Тролли. Мировой тур", "мультфильм");
        Movie seventh = new Movie(7, "Номер один", "комедия");

        manager.addNew(first);
        manager.addNew(second);
        manager.addNew(third);
        manager.addNew(fourth);
        manager.addNew(fifth);
        manager.addNew(sixth);
        manager.addNew(seventh);

        Movie[] actual = manager.findAll();
        Movie[] expected = {first, second, third, fourth, fifth};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastAdded() {
        MovieManager manager = new MovieManager();

        Movie first = new Movie(1, "Бладшот", "боевик");
        Movie second = new Movie(2, "Вперёд", "мультфильм");
        Movie third = new Movie(3, "Отель 'Белград'", "комедия");
        Movie fourth = new Movie(4, "Джентельмены", "боевик");
        Movie fifth = new Movie(5, "Человек-невидимка", "ужасы");
        Movie sixth = new Movie(6, "Тролли. Мировой тур", "мультфильм");
        Movie seventh = new Movie(7, "Номер один", "комедия");

        manager.addNew(first);
        manager.addNew(second);
        manager.addNew(third);
        manager.addNew(fourth);
        manager.addNew(fifth);
        manager.addNew(sixth);
        manager.addNew(seventh);

        Movie[] actual = manager.findLast();
        Movie[] expected = {seventh, sixth, fifth, fourth, third, second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastAddedWithLimit3() {
        MovieManager manager = new MovieManager(3);

        Movie first = new Movie(1, "Бладшот", "боевик");
        Movie second = new Movie(2, "Вперёд", "мультфильм");
        Movie third = new Movie(3, "Отель 'Белград'", "комедия");
        Movie fourth = new Movie(4, "Джентельмены", "боевик");
        Movie fifth = new Movie(5, "Человек-невидимка", "ужасы");
        Movie sixth = new Movie(6, "Тролли. Мировой тур", "мультфильм");
        Movie seventh = new Movie(7, "Номер один", "комедия");

        manager.addNew(first);
        manager.addNew(second);
        manager.addNew(third);
        manager.addNew(fourth);
        manager.addNew(fifth);
        manager.addNew(sixth);
        manager.addNew(seventh);

        Movie[] actual = manager.findLast();
        Movie[] expected = {seventh, sixth, fifth};

        assertArrayEquals(expected, actual);
    }

}