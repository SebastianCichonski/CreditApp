package pl.javaskils.creditapp.core.model;

import java.util.Set;
import java.util.TreeSet;

public class CreditApplicationTestFactory {
    public static CreditApplication create(double expectedLoanAmount, PurposeOfLoanType expectedPurposeOfLoanType, byte expectedLoanPeriod){
        TreeSet<Guarantor> guarantors = new TreeSet<>();
        guarantors.add(new Guarantor("80011915096", 42));
        guarantors.add(new Guarantor("82050714908", 38));
        guarantors.add(new Guarantor("80011915096", 40));
        guarantors.add(new Guarantor("21210802635", 2));
        NaturalPerson person = PersonTestFactory.create( 2,Education.MIDDLE, MartialStatus.SEPARATED);
        PurposeOfLoan purposeOfLoan = new PurposeOfLoan(expectedPurposeOfLoanType, expectedLoanAmount,expectedLoanPeriod);
        CreditApplication creditApplication =
                CreditApplication.Buider
                .create()
                .withPerson(person)
                .withPurposeOfLoan(purposeOfLoan)
                        .withGuarantors(guarantors)
                        .build();

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
        TreeSet<Guarantor> guarantors = new TreeSet<>();
        guarantors.add(new Guarantor("80011915096", 42));
        guarantors.add(new Guarantor("82050714908", 38));
        guarantors.add(new Guarantor("80011915096", 40));
        guarantors.add(new Guarantor("21210802635", 2));
        SelfEmployed person = PersonTestFactory.create( yearsSinceFounded,netMonthlyIncome, numOfDependants,education, martialStatus);
        PurposeOfLoan purposeOfLoan = new PurposeOfLoan(expectedPurposeOfLoanType, expectedLoanAmount,expectedLoanPeriod);
        CreditApplication creditApplication =
                CreditApplication.Buider
                        .create()
                        .withPerson(person)
                        .withPurposeOfLoan(purposeOfLoan)
                        .withGuarantors(guarantors)
                        .build();

        return creditApplication;
    }

    public static CreditApplication create(){
        TreeSet<Guarantor> guarantors = new TreeSet<>();
        guarantors.add(new Guarantor("80011915096", 42));
        guarantors.add(new Guarantor("82050714908", 38));
        guarantors.add(new Guarantor("80011915096", 40));
        guarantors.add(new Guarantor("21210802635", 2));
        NaturalPerson person = PersonTestFactory.create( 10_000.00,2, Education.MIDDLE, MartialStatus.MARRIED);
        PurposeOfLoan purposeOfLoan = new PurposeOfLoan(PurposeOfLoanType.MORTGAGE, 50_000.00,(byte) 30);
        CreditApplication creditApplication =
                CreditApplication.Buider
                        .create()
                        .withPerson(person)
                        .withPurposeOfLoan(purposeOfLoan)
                        .withGuarantors(guarantors)
                        .build();

        return creditApplication;
    }

    public static CreditApplication create(int numOfDependants){
        TreeSet<Guarantor> guarantors = new TreeSet<>();
        guarantors.add(new Guarantor("80011915096", 42));
        guarantors.add(new Guarantor("82050714908", 38));
        guarantors.add(new Guarantor("80011915096", 40));
        guarantors.add(new Guarantor("21210802635", 2));
        SelfEmployed person =
                (SelfEmployed) PersonTestFactory.create(numOfDependants, new SourceOfIncome(IncomeType.SELF_EMPLOYMENT, 10_000),new SourceOfIncome(IncomeType.EMPLOYMENT_CONTRACT, 12_000));
        PurposeOfLoan purposeOfLoan = new PurposeOfLoan(PurposeOfLoanType.MORTGAGE, 100_000.00,(byte) 30);
        CreditApplication creditApplication =
                CreditApplication.Buider
                        .create()
                        .withPerson(person)
                        .withPurposeOfLoan(purposeOfLoan)
                        .withGuarantors(guarantors)
                        .build();

        return creditApplication;
    }
}
