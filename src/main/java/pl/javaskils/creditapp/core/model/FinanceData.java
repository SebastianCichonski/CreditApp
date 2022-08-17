package pl.javaskils.creditapp.core.model;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FinanceData {

    private List<SourceOfIncome> sourceOfIncomes;

    public FinanceData(SourceOfIncome... sourceOfIncomes) {
        this.sourceOfIncomes = Arrays.asList(sourceOfIncomes);
    }

    public List<SourceOfIncome> getSourceOfIncomes() {
        return sourceOfIncomes;
    }
}
