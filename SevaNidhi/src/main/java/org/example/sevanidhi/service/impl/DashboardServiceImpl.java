package org.example.sevanidhi.service.impl;

import org.example.sevanidhi.entity.ApplicationStatus;
import org.example.sevanidhi.repository.ApplicationRepository;
import org.example.sevanidhi.repository.SchemeRepository;
import org.example.sevanidhi.repository.TransactionRepository;
import org.example.sevanidhi.service.DashboardService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class DashboardServiceImpl implements DashboardService {

    private final SchemeRepository schemeRepository;
    private final ApplicationRepository applicationRepository;
    private final TransactionRepository transactionRepository;

    public DashboardServiceImpl(SchemeRepository schemeRepository,
                                ApplicationRepository applicationRepository,
                                TransactionRepository transactionRepository) {
        this.schemeRepository = schemeRepository;
        this.applicationRepository = applicationRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Map<String, Object> getAdminStats() {

        Map<String, Object> stats = new HashMap<>();

        BigDecimal totalFunds = schemeRepository.sumTotalBudget();
        if (totalFunds == null) totalFunds = BigDecimal.ZERO;

        BigDecimal fundsDistributed = transactionRepository.sumAmount();
        if (fundsDistributed == null) fundsDistributed = BigDecimal.ZERO;

        stats.put("totalFunds", totalFunds);
        stats.put("fundsDistributed", fundsDistributed);
        stats.put("pendingApplications",
                applicationRepository.countByStatus(ApplicationStatus.PENDING));
        stats.put("approvedBeneficiaries",
                applicationRepository.countByStatus(ApplicationStatus.APPROVED));

        return stats;
    }
}