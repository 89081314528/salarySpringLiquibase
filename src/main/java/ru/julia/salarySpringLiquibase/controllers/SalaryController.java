package ru.julia.salarySpringLiquibase.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.julia.salarySpringLiquibase.dto.SalaryDto;
import ru.julia.salarySpringLiquibase.services.SalaryService;

import java.util.List;

@RestController
public class SalaryController {
    @RequestMapping("/")
    public static String hello() {
        return "hello";
    }
    @RequestMapping("/{name}")
    public static String helloName(@PathVariable String name) {
        return "hello " + name;
    }

    private final SalaryService salaryService;

    public SalaryController(SalaryService salaryService) {
        this.salaryService = salaryService;
    }

    @RequestMapping("/findAll")
    public List<SalaryDto> findAll() {
        return salaryService.findAll();
    }

}
