package org.mykhailotiutiun.agencyamazon.report.date.db;

import org.mykhailotiutiun.agencyamazon.report.date.DateReport;

public class DateReportJpaMapper {

    public static DateReportJpa dateReportJpa(DateReport dateReport){
            return DateReportJpa.builder()
                    .date(dateReport.getDate())
                    .sales(dateReport.getSales())
                    .traffic(dateReport.getTraffic())
                    .build();
    }

    public static DateReport dateReport(DateReportJpa dateReportJpa){
            return new DateReport.DateReportBuilder()
                    .date(dateReportJpa.getDate())
                    .sales(dateReportJpa.getSales())
                    .traffic(dateReportJpa.getTraffic())
                    .build();
    }
}
