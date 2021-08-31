package ru.julia.salarySpringLiquibase.services;

import com.opencsv.bean.CsvToBeanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.julia.salarySpringLiquibase.entities.Salary;
import ru.julia.salarySpringLiquibase.entities.Weather;
import ru.julia.salarySpringLiquibase.repositories.WeatherRepository;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService{
    private final WeatherRepository weatherRepository;
    @Override
    public List<Weather> findAll() {
        return weatherRepository.findAll();
    }

    @Override
    public void createTableFromCsv(String fileName) throws FileNotFoundException {
        FileReader fileReader = new FileReader(fileName);
        List<Weather> result = new CsvToBeanBuilder(fileReader).
                withType(Weather.class).
                withSeparator(';').
                build().parse();
        for (Weather weather : result) {
            weatherRepository.save(weather);
        }
    }
}
