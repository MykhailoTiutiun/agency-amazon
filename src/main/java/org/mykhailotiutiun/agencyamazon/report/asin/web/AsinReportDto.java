package org.mykhailotiutiun.agencyamazon.report.asin.web;

import org.mykhailotiutiun.agencyamazon.report.asin.AsinSales;
import org.mykhailotiutiun.agencyamazon.report.asin.AsinTraffic;
import org.mykhailotiutiun.agencyamazon.report.date.DateTraffic;
import org.mykhailotiutiun.agencyamazon.report.date.DateSales;

public record AsinReportDto(String asins, AsinSales salesByAsin, AsinTraffic dateTrafficByAsin) {
}
