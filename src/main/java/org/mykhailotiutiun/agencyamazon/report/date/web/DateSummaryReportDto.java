package org.mykhailotiutiun.agencyamazon.report.date.web;

import org.mykhailotiutiun.agencyamazon.report.date.DateTraffic;
import org.mykhailotiutiun.agencyamazon.report.date.DateSales;

import java.time.LocalDate;
import java.util.List;

public record DateSummaryReportDto(List<LocalDate> dates, DateSales salesByDate, DateTraffic trafficByDate) {
}
