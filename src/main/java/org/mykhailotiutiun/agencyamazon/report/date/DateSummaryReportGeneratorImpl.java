package org.mykhailotiutiun.agencyamazon.report.date;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class DateSummaryReportGeneratorImpl implements DateSummaryReportGenerator {

    @Override
    public DateSummaryReport getSummary(List<DateReport> dateReports) {
        DateSales summarySales = null;
        DateTraffic summaryDateTraffic = null;
        List<LocalDate> dates = new LinkedList<>();
        for (DateReport dateReport : dateReports) {
            dates.add(dateReport.getDate());

            DateSales dateSales = dateReport.getSales();
            if (summarySales == null) {
                summarySales = dateSales;
            } else {
                summarySales.getOrderedProductSales().setAmount(summarySales.getOrderedProductSales().getAmount() + dateSales.getOrderedProductSales().getAmount());
                summarySales.getOrderedProductSalesB2B().setAmount(summarySales.getOrderedProductSalesB2B().getAmount() + dateSales.getOrderedProductSalesB2B().getAmount());
                summarySales.setUnitsOrdered(summarySales.getUnitsOrdered() + dateSales.getUnitsOrdered());
                summarySales.setUnitsOrderedB2B(summarySales.getUnitsOrderedB2B() + dateSales.getUnitsOrderedB2B());
                summarySales.setTotalOrderItems(summarySales.getTotalOrderItems() + dateSales.getTotalOrderItems());
                summarySales.setTotalOrderItemsB2B(summarySales.getTotalOrderItemsB2B() + dateSales.getTotalOrderItemsB2B());
                summarySales.setUnitsRefunded(summarySales.getUnitsRefunded() + dateSales.getUnitsRefunded());
                summarySales.setClaimsGranted(summarySales.getClaimsGranted() + dateSales.getClaimsGranted());
                summarySales.getClaimsAmount().setAmount(summarySales.getClaimsAmount().getAmount() + dateSales.getClaimsAmount().getAmount());
                summarySales.getShippedProductSales().setAmount(summarySales.getShippedProductSales().getAmount() + dateSales.getShippedProductSales().getAmount());
                summarySales.setUnitsShipped(summarySales.getUnitsShipped() + dateSales.getUnitsShipped());
                summarySales.setOrdersShipped(summarySales.getOrdersShipped() + dateSales.getOrdersShipped());
            }

            DateTraffic dateTraffic = dateReport.getTraffic();
            if (summaryDateTraffic == null) {
                summaryDateTraffic = dateTraffic;
            } else {
                summaryDateTraffic.setBrowserPageViews(summaryDateTraffic.getBrowserPageViews() + dateTraffic.getBrowserPageViews());
                summaryDateTraffic.setBrowserPageViewsB2B(summaryDateTraffic.getBrowserPageViewsB2B() + dateTraffic.getBrowserPageViewsB2B());
                summaryDateTraffic.setMobileAppPageViews(summaryDateTraffic.getMobileAppPageViews() + dateTraffic.getMobileAppPageViews());
                summaryDateTraffic.setMobileAppPageViewsB2B(summaryDateTraffic.getMobileAppPageViewsB2B() + dateTraffic.getMobileAppPageViewsB2B());
                summaryDateTraffic.setPageViews(summaryDateTraffic.getPageViews() + dateTraffic.getPageViews());
                summaryDateTraffic.setPageViewsB2B(summaryDateTraffic.getPageViewsB2B() + dateTraffic.getPageViewsB2B());
                summaryDateTraffic.setBrowserSessions(summaryDateTraffic.getBrowserSessions() + dateTraffic.getBrowserSessions());
                summaryDateTraffic.setBrowserSessionsB2B(summaryDateTraffic.getBrowserSessionsB2B() + dateTraffic.getBrowserSessionsB2B());
                summaryDateTraffic.setMobileAppSessions(summaryDateTraffic.getMobileAppSessions() + dateTraffic.getMobileAppSessions());
                summaryDateTraffic.setMobileAppSessionsB2B(summaryDateTraffic.getMobileAppSessionsB2B() + dateTraffic.getMobileAppSessionsB2B());
                summaryDateTraffic.setSessions(summaryDateTraffic.getSessions() + dateTraffic.getSessions());
                summaryDateTraffic.setSessionsB2B(summaryDateTraffic.getSessionsB2B() + dateTraffic.getSessionsB2B());
                summaryDateTraffic.setFeedbackReceived(summaryDateTraffic.getFeedbackReceived() + dateTraffic.getFeedbackReceived());
                summaryDateTraffic.setNegativeFeedbackReceived(summaryDateTraffic.getNegativeFeedbackReceived() + dateTraffic.getNegativeFeedbackReceived());

                summaryDateTraffic.setBuyBoxPercentage(summaryDateTraffic.getBuyBoxPercentage() + dateTraffic.getBuyBoxPercentage());
                summaryDateTraffic.setBuyBoxPercentageB2B(summaryDateTraffic.getBuyBoxPercentageB2B() + dateTraffic.getBuyBoxPercentageB2B());
                summaryDateTraffic.setAverageOfferCount(summaryDateTraffic.getAverageOfferCount() + dateTraffic.getAverageOfferCount());
                summaryDateTraffic.setAverageParentItems(summaryDateTraffic.getAverageParentItems() + dateTraffic.getAverageParentItems());

            }
        }

        summarySales.getOrderedProductSales().setAmount(roundTwoDigits(summarySales.getOrderedProductSales().getAmount()));
        summarySales.getOrderedProductSalesB2B().setAmount(roundTwoDigits(summarySales.getOrderedProductSalesB2B().getAmount()));
        summarySales.getShippedProductSales().setAmount(roundTwoDigits(summarySales.getShippedProductSales().getAmount()));

        summarySales.getAverageSalesPerOrderItem().setAmount(roundTwoDigits(summarySales.getOrderedProductSales().getAmount() / summarySales.getTotalOrderItems()));
        summarySales.getAverageSalesPerOrderItemB2B().setAmount(roundTwoDigits(summarySales.getOrderedProductSalesB2B().getAmount() / summarySales.getTotalOrderItemsB2B()));
        summarySales.setAverageUnitsPerOrderItem(roundTwoDigits((double) summarySales.getUnitsOrdered() / summarySales.getTotalOrderItems()));
        summarySales.setAverageUnitsPerOrderItemB2B(roundTwoDigits((double) summarySales.getUnitsOrderedB2B() / summarySales.getTotalOrderItemsB2B()));
        summarySales.getAverageSellingPrice().setAmount(roundTwoDigits(summarySales.getOrderedProductSales().getAmount() / summarySales.getUnitsOrdered()));
        summarySales.getAverageSellingPriceB2B().setAmount(roundTwoDigits(summarySales.getOrderedProductSalesB2B().getAmount() / summarySales.getUnitsOrderedB2B()));
        summarySales.setRefundRate(roundTwoDigits((double) summarySales.getUnitsRefunded() / summarySales.getUnitsOrdered() * 100));

        summaryDateTraffic.setOrderItemSessionPercentage(roundTwoDigits((double) summarySales.getTotalOrderItems() / summaryDateTraffic.getSessions()));
        summaryDateTraffic.setOrderItemSessionPercentageB2B(roundTwoDigits((double) summarySales.getTotalOrderItemsB2B() / summaryDateTraffic.getSessionsB2B()));
        summaryDateTraffic.setUnitSessionPercentage(roundTwoDigits((double) summarySales.getUnitsOrdered() / summaryDateTraffic.getSessions()));
        summaryDateTraffic.setUnitSessionPercentageB2B(roundTwoDigits((double) summarySales.getUnitsOrderedB2B() / summaryDateTraffic.getSessionsB2B()));
        summaryDateTraffic.setReceivedNegativeFeedbackRate(roundTwoDigits((double) summaryDateTraffic.getNegativeFeedbackReceived() / summaryDateTraffic.getFeedbackReceived() * 100));

        summaryDateTraffic.setBuyBoxPercentage(roundTwoDigits(summaryDateTraffic.getBuyBoxPercentage() / dateReports.size()));
        summaryDateTraffic.setBuyBoxPercentageB2B(roundTwoDigits(summaryDateTraffic.getBuyBoxPercentageB2B() / dateReports.size()));

        summaryDateTraffic.setAverageOfferCount(summaryDateTraffic.getAverageOfferCount() / dateReports.size());
        summaryDateTraffic.setAverageParentItems(summaryDateTraffic.getAverageParentItems() / dateReports.size());

        return new DateSummaryReport.DateSummaryReportBuilder()
                .dates(dates)
                .sales(summarySales)
                .traffic(summaryDateTraffic)
                .build();
    }

    private double roundTwoDigits(double num) {
        return Math.round(num * 100) / 100D;
    }
}
