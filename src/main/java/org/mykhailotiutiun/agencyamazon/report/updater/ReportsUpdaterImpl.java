package org.mykhailotiutiun.agencyamazon.report.updater;

import org.mykhailotiutiun.agencyamazon.report.asin.AsinReportService;
import org.mykhailotiutiun.agencyamazon.report.date.DateReportService;

public class ReportsUpdaterImpl implements ReportsUpdater {

    private final ReportReader reportReader;
    private final DateReportService reportService;
    private final AsinReportService asinReportService;

    public ReportsUpdaterImpl(ReportReader reportReader, DateReportService reportService, AsinReportService asinReportService) {
        this.reportReader = reportReader;
        this.reportService = reportService;
        this.asinReportService = asinReportService;
    }

    @Override
    public void update(){
        LoadedReports loadedReports = reportReader.load();
        reportService.update(loadedReports.getDateReport());
        asinReportService.update(loadedReports.getAsinReport());
    }
}
