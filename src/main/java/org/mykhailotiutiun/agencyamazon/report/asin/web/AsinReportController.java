package org.mykhailotiutiun.agencyamazon.report.asin.web;

import org.mykhailotiutiun.agencyamazon.report.asin.AsinReport;
import org.mykhailotiutiun.agencyamazon.report.asin.AsinReportService;
import org.mykhailotiutiun.agencyamazon.report.asin.AsinSummaryReport;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/report/asin")
public class AsinReportController {

    private final AsinReportService asinReportService;

    public AsinReportController(AsinReportService asinReportService) {
        this.asinReportService = asinReportService;
    }

    @GetMapping(params = {"asin"})
    public ResponseEntity<AsinReportDto> getByDate(@RequestParam("asin") String asin){
        AsinReport asinReport = asinReportService.getByAsin(asin);
        return ResponseEntity.ok(AsinReportDtoMapper.asinReportDto(asinReport));
    }

    @GetMapping(params = {"asins"})
    public ResponseEntity<List<AsinReportDto>> getByDateBetween(@RequestParam("asins") List<String> asins){
        List<AsinReport> asinReports = asinReportService.getAllByAsinIn(asins);
        return ResponseEntity.ok(asinReports.stream().map(AsinReportDtoMapper::asinReportDto).toList());
    }

    @GetMapping
    public ResponseEntity<AsinSummaryReportDto> getSummary(){
        AsinSummaryReport report = asinReportService.getSummary();
        return ResponseEntity.ok(AsinReportDtoMapper.asinSummaryReportDto(report));
    }
}
