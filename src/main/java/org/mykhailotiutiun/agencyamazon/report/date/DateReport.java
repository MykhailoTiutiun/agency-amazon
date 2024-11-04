package org.mykhailotiutiun.agencyamazon.report.date;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class DateReport implements Serializable {

    private LocalDate date;
    private DateSales sales;
    private DateTraffic traffic;

    public DateReport(DateReportBuilder builder) {
        date = builder.date;
        sales = builder.sales;
        traffic = builder.traffic;
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
        return traffic;
    }

    public void setTraffic(DateTraffic traffic) {
        this.traffic = traffic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateReport that = (DateReport) o;
        return Objects.equals(date, that.date) && Objects.equals(sales, that.sales) && Objects.equals(traffic, that.traffic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, sales, traffic);
    }

    public static class DateReportBuilder {

        private LocalDate date;
        private DateSales sales;
        private DateTraffic traffic;

        public DateReportBuilder date(LocalDate date) {
            this.date = date;
            return this;
        }

        public DateReportBuilder sales(DateSales sales) {
            this.sales = sales;
            return this;
        }

        public DateReportBuilder traffic(DateTraffic traffic) {
            this.traffic = traffic;
            return this;
        }

        public DateReport build(){
            return new DateReport(this);
        }
    }
}
