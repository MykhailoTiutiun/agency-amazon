package org.mykhailotiutiun.agencyamazon.report.asin.web;

import org.mykhailotiutiun.agencyamazon.report.asin.AsinSales;
import org.mykhailotiutiun.agencyamazon.report.asin.AsinTraffic;
import org.mykhailotiutiun.agencyamazon.report.date.DateSales;
import org.mykhailotiutiun.agencyamazon.report.date.DateTraffic;

import java.util.List;

public record AsinSummaryReportDto(List<String> asins, AsinSales salesByAsin, AsinTraffic dateTrafficByAsin) {
}
