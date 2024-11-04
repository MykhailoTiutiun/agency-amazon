package org.mykhailotiutiun.agencyamazon.report.asin;

import org.mykhailotiutiun.agencyamazon.report.date.DateSales;
import org.mykhailotiutiun.agencyamazon.report.date.DateTraffic;

import java.util.LinkedList;
import java.util.List;

public class AsinSummaryReportGeneratorImpl implements AsinSummaryReportGenerator {

    @Override
    public AsinSummaryReport getSummary(List<AsinReport> asinReports) {
        AsinSales summarySales = null;
        AsinTraffic summaryDateTraffic = null;
        List<String> asins = new LinkedList<>();
        for (AsinReport asinReport : asinReports) {
            asins.add(asinReport.getAsin());

            AsinSales sales = asinReport.getSales();
            if (summarySales == null) {
                summarySales = sales;
            } else {
                summarySales.getOrderedProductSales().setAmount(summarySales.getOrderedProductSales().getAmount() + sales.getOrderedProductSales().getAmount());
                summarySales.getOrderedProductSalesB2B().setAmount(summarySales.getOrderedProductSalesB2B().getAmount() + sales.getOrderedProductSalesB2B().getAmount());
                summarySales.setUnitsOrdered(summarySales.getUnitsOrdered() + sales.getUnitsOrdered());
                summarySales.setUnitsOrderedB2B(summarySales.getUnitsOrderedB2B() + sales.getUnitsOrderedB2B());
                summarySales.setTotalOrderItems(summarySales.getTotalOrderItems() + sales.getTotalOrderItems());
                summarySales.setTotalOrderItemsB2B(summarySales.getTotalOrderItemsB2B() + sales.getTotalOrderItemsB2B());
            }

            AsinTraffic traffic = asinReport.getTraffic();
            if (summaryDateTraffic == null) {
                summaryDateTraffic = traffic;
            } else {
                summaryDateTraffic.setBrowserPageViews(summaryDateTraffic.getBrowserPageViews() + traffic.getBrowserPageViews());
                summaryDateTraffic.setBrowserPageViewsB2B(summaryDateTraffic.getBrowserPageViewsB2B() + traffic.getBrowserPageViewsB2B());
                summaryDateTraffic.setMobileAppPageViews(summaryDateTraffic.getMobileAppPageViews() + traffic.getMobileAppPageViews());
                summaryDateTraffic.setMobileAppPageViewsB2B(summaryDateTraffic.getMobileAppPageViewsB2B() + traffic.getMobileAppPageViewsB2B());
                summaryDateTraffic.setPageViews(summaryDateTraffic.getPageViews() + traffic.getPageViews());
                summaryDateTraffic.setPageViewsB2B(summaryDateTraffic.getPageViewsB2B() + traffic.getPageViewsB2B());
                summaryDateTraffic.setBrowserSessions(summaryDateTraffic.getBrowserSessions() + traffic.getBrowserSessions());
                summaryDateTraffic.setBrowserSessionsB2B(summaryDateTraffic.getBrowserSessionsB2B() + traffic.getBrowserSessionsB2B());
                summaryDateTraffic.setMobileAppSessions(summaryDateTraffic.getMobileAppSessions() + traffic.getMobileAppSessions());
                summaryDateTraffic.setMobileAppSessionsB2B(summaryDateTraffic.getMobileAppSessionsB2B() + traffic.getMobileAppSessionsB2B());
                summaryDateTraffic.setSessions(summaryDateTraffic.getSessions() + traffic.getSessions());
                summaryDateTraffic.setSessionsB2B(summaryDateTraffic.getSessionsB2B() + traffic.getSessionsB2B());

                summaryDateTraffic.setBuyBoxPercentage(summaryDateTraffic.getBuyBoxPercentage() + traffic.getBuyBoxPercentage());
                summaryDateTraffic.setBuyBoxPercentageB2B(summaryDateTraffic.getBuyBoxPercentageB2B() + traffic.getBuyBoxPercentageB2B());
                summaryDateTraffic.setBrowserSessionPercentage(summaryDateTraffic.getBrowserSessionPercentage() + traffic.getBrowserSessionPercentage());
                summaryDateTraffic.setBrowserSessionPercentageB2B(summaryDateTraffic.getBrowserSessionPercentageB2B() + traffic.getBrowserSessionPercentageB2B());
                summaryDateTraffic.setMobileAppSessionPercentage(summaryDateTraffic.getMobileAppSessionPercentage() + traffic.getMobileAppSessionPercentage());
                summaryDateTraffic.setMobileAppSessionPercentageB2B(summaryDateTraffic.getMobileAppSessionPercentageB2B() + traffic.getMobileAppSessionPercentageB2B());
                summaryDateTraffic.setSessionPercentage(summaryDateTraffic.getSessionPercentage() + traffic.getSessionPercentage());
                summaryDateTraffic.setSessionPercentageB2B(summaryDateTraffic.getSessionPercentageB2B() + traffic.getSessionPercentageB2B());
                summaryDateTraffic.setBrowserPageViewsPercentage(summaryDateTraffic.getBrowserPageViewsPercentage() + traffic.getBrowserPageViewsPercentage());
                summaryDateTraffic.setBrowserPageViewsPercentageB2B(summaryDateTraffic.getBrowserPageViewsPercentageB2B() + traffic.getBrowserPageViewsPercentageB2B());
                summaryDateTraffic.setMobileAppPageViewsPercentage(summaryDateTraffic.getMobileAppPageViewsPercentage() + traffic.getMobileAppPageViewsPercentage());
                summaryDateTraffic.setMobileAppPageViewsPercentageB2B(summaryDateTraffic.getMobileAppPageViewsPercentageB2B() + traffic.getMobileAppPageViewsPercentageB2B());
                summaryDateTraffic.setPageViewsPercentage(summaryDateTraffic.getPageViewsPercentage() + traffic.getPageViewsPercentage());
                summaryDateTraffic.setPageViewsPercentageB2B(summaryDateTraffic.getPageViewsPercentageB2B() + traffic.getPageViewsPercentageB2B());

            }
        }

        summarySales.getOrderedProductSales().setAmount(roundTwoDigits(summarySales.getOrderedProductSales().getAmount()));
        summarySales.getOrderedProductSalesB2B().setAmount(roundTwoDigits(summarySales.getOrderedProductSalesB2B().getAmount()));

        summaryDateTraffic.setUnitSessionPercentage(roundTwoDigits((double) summarySales.getUnitsOrdered() / summaryDateTraffic.getSessions()));
        summaryDateTraffic.setUnitSessionPercentageB2B(roundTwoDigits((double) summarySales.getUnitsOrderedB2B() / summaryDateTraffic.getSessionsB2B()));

        summaryDateTraffic.setBuyBoxPercentage(roundTwoDigits(summaryDateTraffic.getBuyBoxPercentage() / asinReports.size()));
        summaryDateTraffic.setBuyBoxPercentageB2B(roundTwoDigits(summaryDateTraffic.getBuyBoxPercentageB2B() / asinReports.size()));
        summaryDateTraffic.setBrowserSessionPercentage(roundTwoDigits(summaryDateTraffic.getBrowserSessionPercentage() / asinReports.size()));
        summaryDateTraffic.setBrowserSessionPercentageB2B(roundTwoDigits(summaryDateTraffic.getBrowserSessionPercentageB2B() / asinReports.size()));
        summaryDateTraffic.setMobileAppSessionPercentage(roundTwoDigits(summaryDateTraffic.getMobileAppSessionPercentage() / asinReports.size()));
        summaryDateTraffic.setMobileAppSessionPercentageB2B(roundTwoDigits(summaryDateTraffic.getMobileAppSessionPercentageB2B() / asinReports.size()));
        summaryDateTraffic.setSessionPercentage(roundTwoDigits(summaryDateTraffic.getSessionPercentage() / asinReports.size()));
        summaryDateTraffic.setSessionPercentageB2B(roundTwoDigits(summaryDateTraffic.getSessionPercentageB2B() / asinReports.size()));
        summaryDateTraffic.setBrowserPageViewsPercentage(roundTwoDigits(summaryDateTraffic.getBrowserPageViewsPercentage() / asinReports.size()));
        summaryDateTraffic.setBrowserPageViewsPercentageB2B(roundTwoDigits(summaryDateTraffic.getBrowserPageViewsPercentageB2B() / asinReports.size()));
        summaryDateTraffic.setMobileAppPageViewsPercentage(roundTwoDigits(summaryDateTraffic.getMobileAppPageViewsPercentage() / asinReports.size()));
        summaryDateTraffic.setMobileAppPageViewsPercentageB2B(roundTwoDigits(summaryDateTraffic.getMobileAppPageViewsPercentageB2B() / asinReports.size()));
        summaryDateTraffic.setPageViewsPercentage(roundTwoDigits(summaryDateTraffic.getPageViewsPercentage() / asinReports.size()));
        summaryDateTraffic.setPageViewsPercentageB2B(roundTwoDigits(summaryDateTraffic.getPageViewsPercentageB2B() / asinReports.size()));

        return new AsinSummaryReport.AsinSummaryReportBuilder()
                .asins(asins)
                .sales(summarySales)
                .traffic(summaryDateTraffic)
                .build();
    }

    private double roundTwoDigits(double num) {
        return Math.round(num * 100) / 100D;
    }
}
