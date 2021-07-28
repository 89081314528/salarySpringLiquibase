package ru.julia.salarySpringLiquibase.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.julia.salarySpringLiquibase.entities.Salary;

public interface SalaryRepository extends JpaRepository<Salary, Integer> {
}
