package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data

public class Movie {
    private int id;
    private String title;
    private String genre;
}

