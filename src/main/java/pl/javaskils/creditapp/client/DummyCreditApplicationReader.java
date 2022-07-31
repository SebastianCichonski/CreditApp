package pl.javaskils.creditapp.client;

import pl.javaskils.creditapp.core.model.CreditApplication;
import pl.javaskils.creditapp.core.model.NaturalPerson;
import pl.javaskils.creditapp.core.model.PurposeOfLoan;
import pl.javaskils.creditapp.core.model.PurposeOfLoanType;

public class DummyCreditApplicationReader implements CreditApplicationReader{
    @Override
    public CreditApplication read(){
        return new CreditApplication(NaturalPerson.Builder.create().build(),
        new PurposeOfLoan(PurposeOfLoanType.MORTGAGE,(double) 10000, (byte) 30));
    }
}
