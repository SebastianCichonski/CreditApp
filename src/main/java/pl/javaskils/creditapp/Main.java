package pl.javaskils.creditapp;

import pl.javaskils.creditapp.client.ConsoleReader;
import pl.javaskils.creditapp.core.CreditApplicationService;
import pl.javaskils.creditapp.core.CreditRatingCalculator;
import pl.javaskils.creditapp.core.PersonScoringCalculator;
import pl.javaskils.creditapp.core.model.LoanApplication;
import pl.javaskils.creditapp.core.model.Person;
import pl.javaskils.creditapp.core.scoring.EducationCalculator;
import pl.javaskils.creditapp.core.scoring.IncomeCalculator;
import pl.javaskils.creditapp.core.scoring.MartialCalculator;

public class Main {
    public static void main(String[] args){

        LoanApplication loanApplication = new ConsoleReader().readInputParameters();
        CreditApplicationService service = new CreditApplicationService(new PersonScoringCalculator(new IncomeCalculator(), new MartialCalculator(), new EducationCalculator()));
        System.out.println(service.getDecision(loanApplication).getDecision());
    }

}
