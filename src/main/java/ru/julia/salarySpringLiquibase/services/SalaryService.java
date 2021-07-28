package ru.julia.salarySpringLiquibase.services;

import ru.julia.salarySpringLiquibase.dto.SalaryDto;

import java.util.List;

public interface SalaryService {
    public List<SalaryDto> findAll();
}
