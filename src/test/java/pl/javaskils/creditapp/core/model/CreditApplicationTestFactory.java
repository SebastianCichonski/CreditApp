package pl.javaskils.creditapp.core.model;

public class CreditApplicationTestFactory {
    public static CreditApplication create(double expectedLoanAmount, PurposeOfLoanType expectedPurposeOfLoanType, byte expectedLoanPeriod){
        NaturalPerson person = PersonTestFactory.create( 2,Education.MIDDLE, MartialStatus.SEPARATED);
        PurposeOfLoan purposeOfLoan = new PurposeOfLoan(expectedPurposeOfLoanType, expectedLoanAmount,expectedLoanPeriod);
        CreditApplication creditApplication = new CreditApplication(person,purposeOfLoan);

        return creditApplication;
    }

    public static CreditApplication create(){
        NaturalPerson person = PersonTestFactory.create( 10000.00,2,Education.MIDDLE, MartialStatus.MARRIED);
        PurposeOfLoan purposeOfLoan = new PurposeOfLoan(PurposeOfLoanType.MORTGAGE, 50000.00,(byte) 30);
        CreditApplication creditApplication = new CreditApplication(person,purposeOfLoan);

        return creditApplication;
    }
}
