package org.mykhailotiutiun.agencyamazon.report.date.web;

import org.mykhailotiutiun.agencyamazon.report.date.DateReport;
import org.mykhailotiutiun.agencyamazon.report.date.DateReportService;
import org.mykhailotiutiun.agencyamazon.report.date.DateSummaryReport;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/v1/report/date")
public class DateReportController {

    private final DateReportService dateReportService;

    public DateReportController(DateReportService dateReportService) {
        this.dateReportService = dateReportService;
    }

    @GetMapping(params = {"date"})
    public ResponseEntity<DateReportDto> getByDate(@RequestParam("date") String date){
        DateReport dateReport = dateReportService.getByDate(LocalDate.parse(date));
        return ResponseEntity.ok(DateReportDtoMapper.dateReportDto(dateReport));
    }

    @GetMapping(params = {"begin", "end"})
    public ResponseEntity<List<DateReportDto>> getByDateBetween(@RequestParam("begin") String begin, @RequestParam("end") String end){
        LocalDate beginDate = LocalDate.parse(begin).minusDays(1);
        LocalDate endDate = LocalDate.parse(end).plusDays(1);
        List<DateReport> dateReports = dateReportService.getByDateBetween(beginDate, endDate);
        return ResponseEntity.ok(dateReports.stream().map(DateReportDtoMapper::dateReportDto).toList());
    }

    @GetMapping
    public ResponseEntity<DateSummaryReportDto> getSummary(){
        DateSummaryReport report = dateReportService.getSummary();
        return ResponseEntity.ok(DateReportDtoMapper.reportSummaryDto(report));
    }
}
