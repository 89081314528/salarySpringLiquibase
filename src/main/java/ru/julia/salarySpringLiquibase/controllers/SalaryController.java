package ru.julia.salarySpringLiquibase.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.julia.salarySpringLiquibase.dto.SalaryDto;
import ru.julia.salarySpringLiquibase.services.SalaryService;

import java.util.List;

/**
 * 1) создать метод add, который добавляет Salary из строки в браузере
 * 2) найти всех с зарплатой больше 10 и меньше 20 и включить условие, что нижняя граница меньше верхней, а если она
 * больше, то показать отрицательную зарплату и сообщение вместо имени
 * 3) удалить всего Salary по id
 * 4) перезаписать всего Salary по id
 * 5) перезаписать кпи по id
 * 6) метод, в который передаю название csv файла - weather. Метод перекладывает файл в таблицу в БД. Использовать OpenCsv
 * нормально, что я создаю тут репозитории, сервисы, проще можно сделать? или в спринге только так?
 * 7) Метод принимает имя файла, в этот момент в директории должен появиться файл с этим именем, который содержит все
 * зарплаты из БД
 */
@RestController
@RequiredArgsConstructor // аннотация для создания конструктора
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

//    public SalaryController(SalaryService salaryService) {
//        this.salaryService = salaryService;
//    }

    @RequestMapping("/findAll")
    public List<SalaryDto> findAll() {
        return salaryService.findAll();
    }

    @RequestMapping("/add")
    public void addSalary(@RequestParam("name") String name, @RequestParam(name = "salaryAmount") Long salaryAmount,
                          @RequestParam(name = "kpi") Long kpi, @RequestParam(name = "id") Integer id) {
        salaryService.addSalary(name, salaryAmount, kpi, id);
    }

    @RequestMapping("/interval")
    public List<SalaryDto> interval(@RequestParam("min") Long min, @RequestParam("max") Long max) {
        return salaryService.findSalaryInInterval(min, max);
    }
    @RequestMapping("/delete")
    public void deleteSalaryById(@RequestParam("id") Integer id) {
    salaryService.deleteSalaryById(id);
    }

    @RequestMapping("/rewriteSalaryById")
    public void rewriteSalaryById(@RequestParam("name") String name, @RequestParam(name = "salaryAmount") Long salaryAmount,
                                  @RequestParam(name = "kpi") Long kpi, @RequestParam(name = "id") Integer id) {
        salaryService.rewriteSalaryById(name, salaryAmount, kpi, id);
    }
    @RequestMapping("/rewriteKpiById")
    public void rewriteKpiById(@RequestParam(name = "kpi") Long kpi, @RequestParam(name = "id") Integer id) {
        salaryService.rewriteKpiById(kpi, id);
    }
}
