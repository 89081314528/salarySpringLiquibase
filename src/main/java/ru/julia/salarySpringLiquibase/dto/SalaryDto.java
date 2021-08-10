package ru.julia.salarySpringLiquibase.dto;

public class SalaryDto {

    String name;
    Long salaryAmount;
    Long kpi;
    Long id;

    public void setName(String name) {
        this.name = name;
    }

    public void setSalaryAmount(Long salaryAmount) {
        this.salaryAmount = salaryAmount;
    }

    public void setKpi(Long kpi) {
        this.kpi = kpi;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getSalaryAmount() {
        return salaryAmount;
    }

    public Long getKpi() {
        return kpi;
    }

    public SalaryDto(String name, Long salaryAmount, Long kpi, Long id) {
        this.name = name;
        this.salaryAmount = salaryAmount;
        this.kpi = kpi;
        this.id = id;
    }
}


