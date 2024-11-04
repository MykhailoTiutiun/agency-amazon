package org.mykhailotiutiun.agencyamazon.report.date.db;

import org.mykhailotiutiun.agencyamazon.report.date.DateTraffic;
import org.mykhailotiutiun.agencyamazon.report.date.DateSales;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Objects;

@Document("date_report")
public class DateReportJpa {

    @Id
    private LocalDate date;
    private DateSales sales;
    private DateTraffic dateTraffic;

    public DateReportJpa() {}

    public DateReportJpa(DateReportJpaBuilder builder) {
        date = builder.date;
        sales = builder.sales;
        dateTraffic = builder.dateTraffic;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public DateSales getSales() {
        return sales;
    }

    public void setSales(DateSales sales) {
        this.sales = sales;
    }

    public DateTraffic getTraffic() {
        return dateTraffic;
    }

    public void setTraffic(DateTraffic dateTraffic) {
        this.dateTraffic = dateTraffic;
    }

    public static DateReportJpaBuilder builder(){
        return new DateReportJpaBuilder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateReportJpa that = (DateReportJpa) o;
        return Objects.equals(date, that.date) && Objects.equals(sales, that.sales) && Objects.equals(dateTraffic, that.dateTraffic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, sales, dateTraffic);
    }

    public static class DateReportJpaBuilder {

        private LocalDate date;
        private DateSales sales;
        private DateTraffic dateTraffic;

        public DateReportJpaBuilder date(LocalDate date) {
            this.date = date;
            return this;
        }

        public DateReportJpaBuilder sales(DateSales sales) {
            this.sales = sales;
            return this;
        }

        public DateReportJpaBuilder traffic(DateTraffic dateTraffic) {
            this.dateTraffic = dateTraffic;
            return this;
        }

        public DateReportJpa build(){
            return new DateReportJpa(this);
        }
    }
}
