package pl.javaskils.creditapp.core.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.javaskils.creditapp.core.scoring.IncomeCalculator;

public class PurposeOfLoan {
    private static final Logger LOG = LoggerFactory.getLogger(PurposeOfLoan.class);

    private final PurposeOfLoanType purposeOfLoanType;
    private final double amount;
    private final byte period;

    public PurposeOfLoan(PurposeOfLoanType purposeOfLoanType, double amount, byte period) {
        this.purposeOfLoanType = purposeOfLoanType;
        this.amount = amount;
        this.period = period;
        LOG.info("Purpose of loan: " + purposeOfLoanType + " Amount: " + amount + " Period: " + period);
    }

    public PurposeOfLoanType getType() {
        return purposeOfLoanType;
    }

    public double getAmount() {
        return amount;
    }

    public byte getPeriod() {
        return period;
    }
}
