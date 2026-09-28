package com.greenhouse.hydrothermal.controller;

import com.greenhouse.hydrothermal.service.ReportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    private final ReportService service;

    public ReportController(ReportService service) {
        this.service = service;
    }


    // Balance Sheet
    @GetMapping("/balance-sheet")
    public Map<String, Object> getBalanceSheet() {

        return service.getBalanceSheet();
    }


    // Profit and Loss
    @GetMapping("/profit-loss")
    public Map<String, Object> getProfitAndLoss() {

        return service.getProfitAndLoss();
    }


    // Greenhouse Zone Budget Report
    @GetMapping("/zone-budget")
    public List<Map<String, Object>> getZoneBudgetReport() {

        return service.getZoneBudgetReport();
    }
}