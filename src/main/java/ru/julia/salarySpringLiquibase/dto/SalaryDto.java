package ru.julia.salarySpringLiquibase.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data // создает геттеры и сеттеры
@RequiredArgsConstructor // создает конструктор для полей final
public class SalaryDto {

    private final String name;
    private final Long salaryAmount;
    private final Long kpi;
    private final Long id;
}


