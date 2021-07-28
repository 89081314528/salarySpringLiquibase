package ru.julia.salarySpringLiquibase.services;

import org.springframework.stereotype.Service;
import ru.julia.salarySpringLiquibase.dto.SalaryDto;
import ru.julia.salarySpringLiquibase.entities.Salary;
import ru.julia.salarySpringLiquibase.repositories.SalaryRepository;

import java.util.ArrayList;
import java.util.List;
@Service
public class SalaryServiceImpl implements SalaryService{
    private final SalaryRepository salaryRepository;

    public SalaryServiceImpl(SalaryRepository salaryRepository) {
        this.salaryRepository = salaryRepository;
    }

    @Override
    public List<SalaryDto> findAll() {
        List<SalaryDto> salaryDtoList = new ArrayList<>();
        List <Salary> salaryList = salaryRepository.findAll();
        for (Salary salary : salaryList) {
            salaryDtoList.add (new SalaryDto(salary.getName(),salary.getFullSalaryGross(),salary.getContractualSalaryGross(),
                    salary.getKpi()));
        }
        return salaryDtoList;
    }
}
