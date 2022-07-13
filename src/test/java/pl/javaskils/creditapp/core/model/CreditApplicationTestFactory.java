package pl.javaskils.creditapp.core.model;

public class CreditApplicationTestFactory {
    public static CreditApplication create(double expectedLoanAmount, PurposeOfLoanType expectedPurposeOfLoanType, byte expectedLoanPeriod){
        NaturalPerson person = PersonTestFactory.create( 2,Education.MIDDLE, MartialStatus.SEPARATED);
        PurposeOfLoan purposeOfLoan = new PurposeOfLoan(expectedPurposeOfLoanType, expectedLoanAmount,expectedLoanPeriod);
        CreditApplication creditApplication = new CreditApplication(person,purposeOfLoan);

        return creditApplication;
    }

    public static CreditApplication create(int yearsSinceFounded,
                                           double expectedLoanAmount,
                                           PurposeOfLoanType expectedPurposeOfLoanType,
                                           byte expectedLoanPeriod,
                                           int numOfDependants,
                                           Education education,
                                           MartialStatus martialStatus,
                                           double netMonthlyIncome){
        SelfEmployed person = PersonTestFactory.create( yearsSinceFounded,netMonthlyIncome, numOfDependants,education, martialStatus);
        PurposeOfLoan purposeOfLoan = new PurposeOfLoan(expectedPurposeOfLoanType, expectedLoanAmount,expectedLoanPeriod);
        CreditApplication creditApplication = new CreditApplication(person,purposeOfLoan);

        return creditApplication;
    }

    public static CreditApplication create(){
        NaturalPerson person = PersonTestFactory.create( 10_000.00,2, Education.MIDDLE, MartialStatus.MARRIED);
        PurposeOfLoan purposeOfLoan = new PurposeOfLoan(PurposeOfLoanType.MORTGAGE, 50_000.00,(byte) 30);
        CreditApplication creditApplication = new CreditApplication(person,purposeOfLoan);

        return creditApplication;
    }
}
