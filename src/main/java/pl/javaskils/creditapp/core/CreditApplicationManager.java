package pl.javaskils.creditapp.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import pl.javaskils.creditapp.core.model.CreditApplication;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class CreditApplicationManager {
    private static final Logger LOG = LoggerFactory.getLogger(CreditApplicationManager.class);
    private final CreditApplicationService creditApplicationService;
    private final Deque<CreditApplication> queueCreditApplications = new ArrayDeque<>();

    public CreditApplicationManager(CreditApplicationService creditApplicationService) {
        this.creditApplicationService = creditApplicationService;
    }

    public void add(CreditApplication creditApplication){
        LOG.info(String.format("Application %s is added to queue.",creditApplication.getId()));
        queueCreditApplications.addFirst(creditApplication);
    }
    public void startProcessing(){
        while(!queueCreditApplications.isEmpty()){
            CreditApplication creditApplication = queueCreditApplications.pollLast();
            LOG.info(String.format("Starting processing application with id %s.",creditApplication.getId()));
            CreditApplicationDecision service = creditApplicationService.getDecision(creditApplication);
            LOG.info(service.getDecision());
            MDC.remove("id");
        }
    }
}
