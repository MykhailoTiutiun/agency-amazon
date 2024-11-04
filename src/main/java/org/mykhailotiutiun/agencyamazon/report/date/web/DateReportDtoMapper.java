package org.mykhailotiutiun.agencyamazon.report.date.web;

import org.mykhailotiutiun.agencyamazon.report.date.DateReport;
import org.mykhailotiutiun.agencyamazon.report.date.DateSummaryReport;

import java.time.format.DateTimeFormatter;

public class DateReportDtoMapper {

    public static DateReportDto dateReportDto(DateReport dateReport){
        return new DateReportDto(dateReport.getDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), dateReport.getSales(), dateReport.getTraffic());
    }

    public static DateSummaryReportDto reportSummaryDto(DateSummaryReport report){
        return new DateSummaryReportDto(report.getDates(), report.getSales(), report.getTraffic());
    }

}
