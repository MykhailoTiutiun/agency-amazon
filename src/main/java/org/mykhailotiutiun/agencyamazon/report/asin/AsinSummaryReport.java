package org.mykhailotiutiun.agencyamazon.report.asin;

import org.mykhailotiutiun.agencyamazon.report.date.DateTraffic;
import org.mykhailotiutiun.agencyamazon.report.date.DateSales;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class AsinSummaryReport implements Serializable {
    private List<String> asins;
    private AsinSales sales;
    private AsinTraffic traffic;

    public AsinSummaryReport(AsinSummaryReportBuilder builder) {
        asins = builder.asins;
        sales = builder.sales;
        traffic = builder.traffic;
    }

    public List<String> getAsins() {
        return asins;
    }

    public void setAsins(List<String> asins) {
        this.asins = asins;
    }

    public AsinSales getSales() {
        return sales;
    }

    public void setSales(AsinSales sales) {
        this.sales = sales;
    }

    public AsinTraffic getTraffic() {
        return traffic;
    }

    public void setTraffic(AsinTraffic traffic) {
        this.traffic = traffic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AsinSummaryReport that = (AsinSummaryReport) o;
        return Objects.equals(asins, that.asins) && Objects.equals(sales, that.sales) && Objects.equals(traffic, that.traffic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(asins, sales, traffic);
    }

    public static class AsinSummaryReportBuilder {

        private List<String> asins;
        private AsinSales sales;
        private AsinTraffic traffic;

        public AsinSummaryReportBuilder asins(List<String> asins) {
            this.asins = asins;
            return this;
        }

        public AsinSummaryReportBuilder sales(AsinSales sales) {
            this.sales = sales;
            return this;
        }

        public AsinSummaryReportBuilder traffic(AsinTraffic traffic) {
            this.traffic = traffic;
            return this;
        }

        public AsinSummaryReport build(){
            return new AsinSummaryReport(this);
        }
    }
}
