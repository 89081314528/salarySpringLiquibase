package ru.julia.salarySpringLiquibase.services;

import ru.julia.salarySpringLiquibase.dto.SalaryDto;

import java.io.FileNotFoundException;
import java.util.List;

public interface SalaryService  {
    public List<SalaryDto> findAll();
    public void addSalary(String name, Long salaryAmount, Long kpi, Integer id);
    public List<SalaryDto> findSalaryInInterval(Long min, Long max);
    public void deleteSalaryById(Integer id);
    public void rewriteSalaryById(String name, Long salaryAmount, Long kpi, Integer id);
    public void rewriteKpiById(Long kpi, Integer id);
    public void doCsvFileSalary(String fileName) throws FileNotFoundException;

}
