package ru.julia.salarySpringLiquibase.entities;
import com.opencsv.bean.CsvBindByName;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "weather")
@Data
public class Weather {
    @CsvBindByName(column = "date")
    @Column(name = "date")
    @Id
    private Integer date;
    @CsvBindByName(column = "abkhazia")
    @Column(name = "abkhazia")
    private Integer abkhazia;
    @CsvBindByName(column = "crimea")
    @Column(name = "crimea")
    private Integer crimea;
    @CsvBindByName(column = "difference")
    @Column(name = "difference")
    private Integer difference;
    public String toString() {
        return date + " " + abkhazia + " " + crimea + " " + difference;
    }

    public Weather() {
    }
}
