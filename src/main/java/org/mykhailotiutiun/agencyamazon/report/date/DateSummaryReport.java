package org.mykhailotiutiun.agencyamazon.report.date;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class DateSummaryReport implements Serializable {
    private List<LocalDate> dates;
    private DateSales sales;
    private DateTraffic traffic;

    public DateSummaryReport(DateSummaryReportBuilder builder) {
        dates = builder.dates;
        sales = builder.sales;
        traffic = builder.traffic;
    }

    public List<LocalDate> getDates() {
        return dates;
    }

    public void setDates(List<LocalDate> dates) {
        this.dates = dates;
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
        DateSummaryReport that = (DateSummaryReport) o;
        return Objects.equals(dates, that.dates) && Objects.equals(sales, that.sales) && Objects.equals(traffic, that.traffic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dates, sales, traffic);
    }

    public static class DateSummaryReportBuilder {

        private List<LocalDate> dates;
        private DateSales sales;
        private DateTraffic traffic;

        public DateSummaryReportBuilder dates(List<LocalDate> dates) {
            this.dates = dates;
            return this;
        }

        public DateSummaryReportBuilder sales(DateSales sales) {
            this.sales = sales;
            return this;
        }

        public DateSummaryReportBuilder traffic(DateTraffic traffic) {
            this.traffic = traffic;
            return this;
        }

        public DateSummaryReport build(){
            return new DateSummaryReport(this);
        }
    }
}
