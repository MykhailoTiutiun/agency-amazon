package org.mykhailotiutiun.agencyamazon.report.asin;

import org.mykhailotiutiun.agencyamazon.report.date.DateSales;
import org.mykhailotiutiun.agencyamazon.report.date.DateTraffic;

import java.io.Serializable;
import java.util.Objects;

public class AsinReport implements Serializable {

    private String asin;
    private AsinSales sales;
    private AsinTraffic traffic;

    public AsinReport(AsinReportBuilder builder) {
        asin = builder.asin;
        sales = builder.sales;
        traffic = builder.traffic;
    }

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
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
        AsinReport that = (AsinReport) o;
        return Objects.equals(asin, that.asin) && Objects.equals(sales, that.sales) && Objects.equals(traffic, that.traffic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(asin, sales, traffic);
    }

    public static class AsinReportBuilder {

        private String asin;
        private AsinSales sales;
        private AsinTraffic traffic;

        public AsinReportBuilder asin(String asin) {
            this.asin = asin;
            return this;
        }

        public AsinReportBuilder sales(AsinSales sales) {
            this.sales = sales;
            return this;
        }

        public AsinReportBuilder traffic(AsinTraffic traffic) {
            this.traffic = traffic;
            return this;
        }

        public AsinReport build(){
            return new AsinReport(this);
        }
    }
}
