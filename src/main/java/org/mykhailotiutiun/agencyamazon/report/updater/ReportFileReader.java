package org.mykhailotiutiun.agencyamazon.report.updater;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mykhailotiutiun.agencyamazon.report.asin.AsinSales;
import org.mykhailotiutiun.agencyamazon.report.asin.AsinTraffic;
import org.mykhailotiutiun.agencyamazon.report.date.DateSales;
import org.mykhailotiutiun.agencyamazon.report.date.DateTraffic;
import org.mykhailotiutiun.agencyamazon.report.asin.AsinReport;
import org.mykhailotiutiun.agencyamazon.report.date.DateReport;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class ReportFileReader implements ReportReader{

    private final String filePath;

    public ReportFileReader(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public LoadedReports load() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(new File(filePath));
            JsonNode dateReportList = jsonNode.get("salesAndTrafficByDate");
            JsonNode asinReportList = jsonNode.get("salesAndTrafficByAsin");

            List<DateReport> dateReports = new LinkedList<>();
            for (JsonNode dateReportJson : dateReportList){
                dateReports.add(new DateReport.DateReportBuilder()
                        .date(LocalDate.parse(dateReportJson.get("date").asText()))
                        .sales(objectMapper.readValue(dateReportJson.get("salesByDate").toString(), DateSales.class))
                        .traffic(objectMapper.readValue(dateReportJson.get("trafficByDate").toString(), DateTraffic.class))
                        .build());
            }
            List<AsinReport> asinReports = new LinkedList<>();
            for (JsonNode asinReportJson : asinReportList){
                asinReports.add(new AsinReport.AsinReportBuilder()
                        .asin(asinReportJson.get("parentAsin").asText())
                        .sales(objectMapper.readValue(asinReportJson.get("salesByAsin").toString(), AsinSales.class))
                        .traffic(objectMapper.readValue(asinReportJson.get("trafficByAsin").toString(), AsinTraffic.class))
                        .build());
            }
            return new LoadedReports(dateReports, asinReports);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
