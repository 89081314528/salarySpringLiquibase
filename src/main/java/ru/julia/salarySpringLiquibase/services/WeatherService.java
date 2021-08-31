package ru.julia.salarySpringLiquibase.services;

import ru.julia.salarySpringLiquibase.entities.Weather;

import java.io.FileNotFoundException;
import java.util.List;

public interface WeatherService {
    public List<Weather> findAll();
    public void createTableFromCsv(String fileName) throws FileNotFoundException;
}
