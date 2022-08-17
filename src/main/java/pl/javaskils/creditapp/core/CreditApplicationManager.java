package pl.javaskils.creditapp.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.javaskils.creditapp.core.model.CreditApplication;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class CreditApplicationManager {
    private static final Logger LOG = LoggerFactory.getLogger(CreditApplicationManager.class);
    Deque<CreditApplication> queueCreditApplications = new ArrayDeque<>();

    public void add(CreditApplication creditApplication){}
    public void startProcessing(){}
}
