package ru.julia.salarySpringLiquibase.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "salaries2")
@Data // делает геттеры и сеттеры
public class Salary {
    @Column(name = "name")
    String name;
    @Column(name = "salary_amount")
    Long salaryAmount;
    @Column(name = "kpi")
    Long kpi;
    @Column(name = "id")
    @Id
    Long id;

    public Salary() {
    }

}
