package ru.julia.salarySpringLiquibase.entities;

import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "salaries2")
public class Salary {
    @Column(name = "name")
    String name;
    @Column(name = "fullSalaryGross")
    BigDecimal fullSalaryGross;
    @Column(name = "contractualSalaryGross")
    BigDecimal contractualSalaryGross;
    @Column(name = "kpi")
    BigDecimal kpi;
    @Column(name = "id")
    @Id
    Integer id;

    public Salary(String name, BigDecimal fullSalaryGross, BigDecimal contractualSalaryGross, BigDecimal kpi, Integer id) {
        this.name = name;
        this.fullSalaryGross = fullSalaryGross;
        this.contractualSalaryGross = contractualSalaryGross;
        this.kpi = kpi;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getFullSalaryGross() {
        return fullSalaryGross;
    }

    public BigDecimal getContractualSalaryGross() {
        return contractualSalaryGross;
    }

    public BigDecimal getKpi() {
        return kpi;
    }
}
