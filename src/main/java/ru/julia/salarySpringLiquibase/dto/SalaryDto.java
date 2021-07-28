package ru.julia.salarySpringLiquibase.dto;
import java.math.BigDecimal;

public class SalaryDto {
    String name;
    BigDecimal fullSalaryGross;
    BigDecimal contractualSalaryGross;
    BigDecimal kpi;

    public SalaryDto(String name, BigDecimal fullSalaryGross, BigDecimal contractualSalaryGross, BigDecimal kpi) {
        this.name = name;
        this.fullSalaryGross = fullSalaryGross;
        this.contractualSalaryGross = contractualSalaryGross;
        this.kpi = kpi;
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
