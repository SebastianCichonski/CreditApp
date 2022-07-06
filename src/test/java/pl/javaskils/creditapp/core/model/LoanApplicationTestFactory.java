package pl.javaskils.creditapp.core.model;

public class LoanApplicationTestFactory {
    public static LoanApplication create(double expectedLoanAmount, PurposeOfLoanType expectedPurposeOfLoanType, byte expectedLoanPeriod){
        Person person = PersonTestFactory.create( 2,Education.MIDDLE, MartialStatus.SEPARATED);
        PurposeOfLoan purposeOfLoan = new PurposeOfLoan(expectedPurposeOfLoanType, expectedLoanAmount,expectedLoanPeriod);
        LoanApplication loanApplication = new LoanApplication(person,purposeOfLoan);

        return loanApplication;
    }

    public static LoanApplication create(){
        Person person = PersonTestFactory.create( 10000.00,2,Education.MIDDLE, MartialStatus.MARRIED);
        PurposeOfLoan purposeOfLoan = new PurposeOfLoan(PurposeOfLoanType.MORTGAGE, 50000.00,(byte) 30);
        LoanApplication loanApplication = new LoanApplication(person,purposeOfLoan);

        return loanApplication;
    }
}
