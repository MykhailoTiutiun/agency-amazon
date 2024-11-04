package org.mykhailotiutiun.agencyamazon.report.date.web;

import org.mykhailotiutiun.agencyamazon.report.date.DateTraffic;
import org.mykhailotiutiun.agencyamazon.report.date.DateSales;

public record DateReportDto(String date, DateSales salesByDate, DateTraffic trafficByDate) {
}
