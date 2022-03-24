package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import ru.netology.domain.Movie;
import ru.netology.repository.MovieRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.doReturn;

class MovieManagerTest<expected> {
    @Mock
    private MovieRepository repository;
    @InjectMocks
    private MovieManager manager = new MovieManager(repository);
    private Movie first = new Movie(1, "Бладшот", "боевик");
    private Movie second = new Movie(2, "Вперёд", "мультфильм");
    private Movie third = new Movie(3, "Отель 'Белград'", "комедия");
    private Movie fourth = new Movie(4, "Джентельмены", "боевик");
    private Movie fifth = new Movie(5, "Человек-невидимка", "ужасы");
    private Movie sixth = new Movie(6, "Тролли. Мировой тур", "мультфильм");
    private Movie seventh = new Movie(7, "Номер один", "комедия");

    Movie[] expected = {seventh, sixth, fifth, fourth, third, second, first};

    @BeforeEach
    void shouldAdd() {
        manager.addNew(first);
        manager.addNew(second);
        manager.addNew(third);
        manager.addNew(fourth);
        manager.addNew(fifth);
        manager.addNew(sixth);
        manager.addNew(seventh);
    }

    @Test
    public void shouldAddMovie() {
        Movie[] returned = new Movie[]{first, second, third, fourth};
        doReturn(returned).when(repository).findAll();

        manager.addNew(fifth);

        Movie[] actual = manager.findLast();
        Movie[] expected = {first, second, third, fourth, fifth};

        assertArrayEquals(expected, actual);
    }
}