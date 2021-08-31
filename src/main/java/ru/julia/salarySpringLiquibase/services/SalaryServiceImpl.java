package ru.julia.salarySpringLiquibase.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.julia.salarySpringLiquibase.dto.SalaryDto;
import ru.julia.salarySpringLiquibase.entities.Salary;
import ru.julia.salarySpringLiquibase.repositories.SalaryRepository;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SalaryServiceImpl implements SalaryService {
    private final SalaryRepository salaryRepository;

//    public SalaryServiceImpl(SalaryRepository salaryRepository) {
//        this.salaryRepository = salaryRepository;
//    }

    @Override
    public List<SalaryDto> findAll() {
        List<SalaryDto> salaryDtoList = new ArrayList<>();
        List<Salary> salaryList = salaryRepository.findAll();
        for (Salary salary : salaryList) {
            salaryDtoList.add(new SalaryDto(salary.getName(), salary.getSalaryAmount(),
                    salary.getKpi(), salary.getId()));
        }
        return salaryDtoList;
    }

    @Override
    public void addSalary(String name, Long salaryAmount, Long kpi, Integer id) {
        Salary salary = new Salary();
        salary.setName(name);
        salary.setSalaryAmount(salaryAmount);
        salary.setKpi(kpi);
        salary.setId(id);
        salaryRepository.save(salary);
    }

    @Override
    public List<SalaryDto> findSalaryInInterval(Long min, Long max) {
        List<SalaryDto> salaryDtoList = new ArrayList<>();
        List<Salary> salaryList = salaryRepository.findAll();
        if (min < 0 || max < 0 || min > max) {
            for (Salary salary : salaryList) {
                salaryDtoList.add(new SalaryDto("Неверно внесены границы интервала", salary.getSalaryAmount()*(-1),
                        salary.getKpi(), salary.getId()));
            }
        } else {
            for (Salary salary : salaryList) {
                if (salary.getSalaryAmount() >= min && salary.getSalaryAmount() <= max) {
                    salaryDtoList.add(new SalaryDto(salary.getName(), salary.getSalaryAmount(),
                            salary.getKpi(), salary.getId()));
                }
            }
        }
        return salaryDtoList;
    }

    @Override
    public void deleteSalaryById(Integer id) {
        Salary salary = salaryRepository.findById(id).orElseThrow();
                salaryRepository.delete(salary);
    }

    @Override // перезаписать Salary по id все равно, что добавить нового с тем же id
    public void rewriteSalaryById(String name, Long salaryAmount, Long kpi, Integer id) {
        Salary salary = new Salary();
        salary.setName(name);
        salary.setSalaryAmount(salaryAmount);
        salary.setKpi(kpi);
        salary.setId(id);
        salaryRepository.save(salary);
    }

    @Override
    public void rewriteKpiById(Long kpi, Integer id) {
        Salary salary = salaryRepository.findById(id).orElseThrow();
        salary.setKpi(kpi);
        salaryRepository.save(salary);
    }

    @Override
    public void doCsvFileSalary(String fileName) throws FileNotFoundException {
        List<Salary> salaryList = salaryRepository.findAll();
        PrintStream csv = new PrintStream(fileName);
        csv.println(
                "name" + ";" + "salaryAmount" + ";" + "kpi" + ";" + "id"
        );
        for (Salary salary : salaryList) {
            csv.println(
                    salary.getName() + ";" +
                            salary.getSalaryAmount() + ";" +
                            salary.getKpi() + ";" +
                            salary.getId()
            );
        }
    }

}
