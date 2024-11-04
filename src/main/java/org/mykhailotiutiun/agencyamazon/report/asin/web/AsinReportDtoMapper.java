package org.mykhailotiutiun.agencyamazon.report.asin.web;

import org.mykhailotiutiun.agencyamazon.report.asin.AsinReport;
import org.mykhailotiutiun.agencyamazon.report.asin.AsinSummaryReport;

public class AsinReportDtoMapper {

    public static AsinReportDto asinReportDto(AsinReport asinReport){
        return new AsinReportDto(asinReport.getAsin(), asinReport.getSales(), asinReport.getTraffic());
    }

    public static AsinSummaryReportDto asinSummaryReportDto(AsinSummaryReport asinSummaryReport){
        return new AsinSummaryReportDto(asinSummaryReport.getAsins(), asinSummaryReport.getSales(), asinSummaryReport.getTraffic());
    }

}
