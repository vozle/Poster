package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Movie;
import ru.netology.repository.MovieRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class MovieManagerTest {
    @Mock
    private MovieRepository repository;
    @InjectMocks
    private MovieManager manager;

    private Movie first = new Movie(1, "Бладшот", "боевик");
    private Movie second = new Movie(2, "Вперёд", "мультфильм");
    private Movie third = new Movie(3, "Отель 'Белград'", "комедия");
    private Movie fourth = new Movie(4, "Джентельмены", "боевик");
    private Movie fifth = new Movie(5, "Человек-невидимка", "ужасы");
    private Movie sixth = new Movie(6, "Тролли. Мировой тур", "мультфильм");
    private Movie seventh = new Movie(7, "Номер один", "комедия");

    @Test
    public void shouldFindAllMovies() {
        Movie[] returned = new Movie[]{first, second, third, fourth, fifth, sixth, seventh};
        doReturn(returned).when(repository).findAll();

        Movie[] actual = manager.findAll();
        Movie[] expected = {first, second, third, fourth, fifth, sixth, seventh};

        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

    @Test
    public void shouldSaveNewMovie() {
        Movie[] returned = new Movie[]{first, second, third, fourth};
        doReturn(returned).when(repository).findAll();

        manager.addNew(fourth);

        Movie[] actual = manager.findAll();
        Movie[] expected = {first, second, third, fourth};

        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }
}