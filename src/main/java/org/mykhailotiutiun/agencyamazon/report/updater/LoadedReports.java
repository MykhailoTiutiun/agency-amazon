package org.mykhailotiutiun.agencyamazon.report.updater;

import org.mykhailotiutiun.agencyamazon.report.asin.AsinReport;
import org.mykhailotiutiun.agencyamazon.report.date.DateReport;

import java.util.List;

public class LoadedReports {

    private List<DateReport> dateReport;
    private List<AsinReport> asinReport;

    public LoadedReports(List<DateReport> dateReport, List<AsinReport> asinReport) {
        this.dateReport = dateReport;
        this.asinReport = asinReport;
    }

    public List<DateReport> getDateReport() {
        return dateReport;
    }

    public void setDateReport(List<DateReport> dateReport) {
        this.dateReport = dateReport;
    }

    public List<AsinReport> getAsinReport() {
        return asinReport;
    }

    public void setAsinReport(List<AsinReport> asinReport) {
        this.asinReport = asinReport;
    }


}
