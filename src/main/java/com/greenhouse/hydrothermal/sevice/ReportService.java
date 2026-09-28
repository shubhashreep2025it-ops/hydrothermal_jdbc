package com.greenhouse.hydrothermal.service;

import com.greenhouse.hydrothermal.entity.ChartOfAccount;
import com.greenhouse.hydrothermal.entity.SeasonalZoneBudget;
import com.greenhouse.hydrothermal.entity.BudgetLine;
import com.greenhouse.hydrothermal.repository.ChartOfAccountRepository;
import com.greenhouse.hydrothermal.repository.JournalEntryLineRepository;
import com.greenhouse.hydrothermal.repository.SeasonalZoneBudgetRepository;
import com.greenhouse.hydrothermal.repository.BudgetLineRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ReportService {

    private final ChartOfAccountRepository accountRepository;
    private final JournalEntryLineRepository journalEntryLineRepository;
    private final SeasonalZoneBudgetRepository budgetRepository;
    private final BudgetLineRepository budgetLineRepository;

    public ReportService(
            ChartOfAccountRepository accountRepository,
            JournalEntryLineRepository journalEntryLineRepository,
            SeasonalZoneBudgetRepository budgetRepository,
            BudgetLineRepository budgetLineRepository) {

        this.accountRepository = accountRepository;
        this.journalEntryLineRepository = journalEntryLineRepository;
        this.budgetRepository = budgetRepository;
        this.budgetLineRepository = budgetLineRepository;
    }


    // ============================================================
    // 1. BALANCE SHEET
    // ============================================================

    public Map<String, Object> getBalanceSheet() {

        double totalAssets = 0;
        double totalLiabilities = 0;

        List<Map<String, Object>> assets = new ArrayList<>();
        List<Map<String, Object>> liabilities = new ArrayList<>();

        for (ChartOfAccount account : accountRepository.findAll()) {

            double balance = calculateAccountBalance(account.getId());

            Map<String, Object> data = new LinkedHashMap<>();

            data.put("accountName", account.getAccountName());
            data.put("amount", balance);

            if ("ASSET".equalsIgnoreCase(account.getAccountType())) {

                assets.add(data);
                totalAssets += balance;

            } else if ("LIABILITY".equalsIgnoreCase(account.getAccountType())) {

                liabilities.add(data);
                totalLiabilities += balance;
            }
        }

        Map<String, Object> report = new LinkedHashMap<>();

        report.put("reportName", "Balance Sheet");
        report.put("assets", assets);
        report.put("totalAssets", totalAssets);
        report.put("liabilities", liabilities);
        report.put("totalLiabilities", totalLiabilities);

        return report;
    }


    // ============================================================
    // 2. PROFIT AND LOSS
    // ============================================================

    public Map<String, Object> getProfitAndLoss() {

        double totalIncome = 0;
        double totalExpenses = 0;

        List<Map<String, Object>> income = new ArrayList<>();
        List<Map<String, Object>> expenses = new ArrayList<>();

        for (ChartOfAccount account : accountRepository.findAll()) {

            double balance = calculateAccountBalance(account.getId());

            Map<String, Object> data = new LinkedHashMap<>();

            data.put("accountName", account.getAccountName());
            data.put("amount", balance);

            if ("INCOME".equalsIgnoreCase(account.getAccountType())) {

                income.add(data);
                totalIncome += balance;

            } else if ("EXPENSE".equalsIgnoreCase(account.getAccountType())) {

                expenses.add(data);
                totalExpenses += balance;
            }
        }

        double profit = totalIncome - totalExpenses;

        Map<String, Object> report = new LinkedHashMap<>();

        report.put("reportName", "Profit and Loss");
        report.put("income", income);
        report.put("totalIncome", totalIncome);
        report.put("expenses", expenses);
        report.put("totalExpenses", totalExpenses);
        report.put("profit", profit);

        return report;
    }


    // ============================================================
    // 3. GREENHOUSE ZONE BUDGET REPORT
    // ============================================================

    public List<Map<String, Object>> getZoneBudgetReport() {

        List<Map<String, Object>> report = new ArrayList<>();

        List<SeasonalZoneBudget> budgets =
                budgetRepository.findAll();

        List<BudgetLine> budgetLines =
                budgetLineRepository.findAll();

        for (SeasonalZoneBudget budget : budgets) {

            Map<String, Object> data = new LinkedHashMap<>();

            data.put("budgetId", budget.getId());
            data.put("zoneId", budget.getZoneId());
            data.put("season", budget.getSeason());
            data.put("plannedHeatKwh", budget.getPlannedHeatKwh());
            data.put("plannedRevenue", budget.getPlannedRevenue());
            data.put("plannedExpense", budget.getPlannedExpense());
            data.put("status", budget.getStatus());

            double totalActualAmount = 0;

            for (BudgetLine line : budgetLines) {

                if (Objects.equals(
                        line.getBudgetId(),
                        budget.getId())) {

                    totalActualAmount += line.getActualAmount();
                }
            }

            data.put("actualAmount", totalActualAmount);

            double variance =
                    budget.getPlannedExpense()
                            - totalActualAmount;

            data.put("variance", variance);

            report.add(data);
        }

        return report;
    }


    // ============================================================
    // ACCOUNT BALANCE CALCULATION
    // ============================================================

    private double calculateAccountBalance(Long accountId) {

        double debit = 0;
        double credit = 0;

        var lines = journalEntryLineRepository.findAll();

        for (var line : lines) {

            if (Objects.equals(
                    line.getAccountId(),
                    accountId)) {

                debit += line.getDebitAmount();
                credit += line.getCreditAmount();
            }
        }

        return debit - credit;
    }
}