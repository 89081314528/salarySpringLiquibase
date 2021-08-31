package ru.julia.salarySpringLiquibase.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.julia.salarySpringLiquibase.dto.SalaryDto;
import ru.julia.salarySpringLiquibase.entities.Weather;
import ru.julia.salarySpringLiquibase.services.SalaryService;
import ru.julia.salarySpringLiquibase.services.WeatherService;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * 6) метод, в который передаю название csv файла - weather. Метод перекладывает файл в таблицу в БД. Использовать OpenCsv
 * нормально, что я создаю тут репозитории, сервисы, проще можно сделать? или в спринге только так?
 */
@RestController
@RequiredArgsConstructor
public class WeatherController {
    private final WeatherService weatherService;

    @RequestMapping("/findAllWeather")
    public List<Weather> findAll() {
        return weatherService.findAll();
    }
    @RequestMapping("/createTable/{fileName}")
    public void createTableFromCsv(@PathVariable String fileName) throws FileNotFoundException {
        weatherService.createTableFromCsv(fileName);
    }

}
