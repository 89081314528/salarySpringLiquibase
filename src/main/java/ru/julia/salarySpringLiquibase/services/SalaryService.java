package ru.julia.salarySpringLiquibase.services;

import ru.julia.salarySpringLiquibase.dto.SalaryDto;

import java.util.List;

public interface SalaryService  {
    public List<SalaryDto> findAll();
    public void addSalary(String name, Long salaryAmount, Long kpi, Long id);
    public List<SalaryDto> findSalaryInInterval(Long min, Long max);
    public void deleteSalaryById(Long id);
}
