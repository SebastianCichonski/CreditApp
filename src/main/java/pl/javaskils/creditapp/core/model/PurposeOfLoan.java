package pl.javaskils.creditapp.core.model;

public class PurposeOfLoan {

    private final PurposeOfLoanType purposeOfLoanType;
    private final double amount;
    private final byte period;

    public PurposeOfLoan(PurposeOfLoanType purposeOfLoanType, double amount, byte period) {
        this.purposeOfLoanType = purposeOfLoanType;
        this.amount = amount;
        this.period = period;
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
