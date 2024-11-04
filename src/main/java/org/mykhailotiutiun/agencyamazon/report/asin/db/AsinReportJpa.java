package org.mykhailotiutiun.agencyamazon.report.asin.db;

import org.mykhailotiutiun.agencyamazon.report.asin.AsinSales;
import org.mykhailotiutiun.agencyamazon.report.asin.AsinTraffic;
import org.mykhailotiutiun.agencyamazon.report.date.DateTraffic;
import org.mykhailotiutiun.agencyamazon.report.date.DateSales;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document("asin_report")
public class AsinReportJpa {

    @Id
    private String asin;
    private AsinSales sales;
    private AsinTraffic dateTraffic;

    public AsinReportJpa() {}

    public AsinReportJpa(AsinReportJpaBuilder builder) {
        asin = builder.asin;
        sales = builder.sales;
        dateTraffic = builder.dateTraffic;
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
        return dateTraffic;
    }

    public void setTraffic(AsinTraffic dateTraffic) {
        this.dateTraffic = dateTraffic;
    }

    public static AsinReportJpaBuilder builder(){
        return new AsinReportJpaBuilder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AsinReportJpa that = (AsinReportJpa) o;
        return Objects.equals(asin, that.asin) && Objects.equals(sales, that.sales) && Objects.equals(dateTraffic, that.dateTraffic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(asin, sales, dateTraffic);
    }

    public static class AsinReportJpaBuilder {

        private String asin;
        private AsinSales sales;
        private AsinTraffic dateTraffic;

        public AsinReportJpaBuilder date(String asin) {
            this.asin = asin;
            return this;
        }

        public AsinReportJpaBuilder sales(AsinSales sales) {
            this.sales = sales;
            return this;
        }

        public AsinReportJpaBuilder traffic(AsinTraffic dateTraffic) {
            this.dateTraffic = dateTraffic;
            return this;
        }

        public AsinReportJpa build(){
            return new AsinReportJpa(this);
        }
    }
}
