package org.mykhailotiutiun.agencyamazon.report.asin.db;

import org.mykhailotiutiun.agencyamazon.report.asin.AsinReport;

public class AsinReportJpaMapper {

    public static AsinReportJpa dateReportJpa(AsinReport asinReport){
            return AsinReportJpa.builder()
                    .date(asinReport.getAsin())
                    .sales(asinReport.getSales())
                    .traffic(asinReport.getTraffic())
                    .build();
    }

    public static AsinReport dateReport(AsinReportJpa asinReportJpa){
            return new AsinReport.AsinReportBuilder()
                    .asin(asinReportJpa.getAsin())
                    .sales(asinReportJpa.getSales())
                    .traffic(asinReportJpa.getTraffic())
                    .build();
    }
}
