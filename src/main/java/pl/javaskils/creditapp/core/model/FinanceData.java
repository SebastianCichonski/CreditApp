package pl.javaskils.creditapp.core.model;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FinanceData {
    private SourceOfIncome[] sourceOfIncomes;


    public FinanceData(SourceOfIncome... sourceOfIncomes) {
        this.sourceOfIncomes = sourceOfIncomes;
    }

    public SourceOfIncome[] getSourceOfIncomes() {
        return sourceOfIncomes;
    }
}
