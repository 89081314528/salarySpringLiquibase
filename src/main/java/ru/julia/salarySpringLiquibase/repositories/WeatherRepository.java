package ru.julia.salarySpringLiquibase.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.julia.salarySpringLiquibase.entities.Weather;

public interface WeatherRepository extends JpaRepository<Weather, Integer> {
}
