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
        //Person person = loanApplication.getPerson();
       // PersonScoringCalculator calculator = new PersonScoringCalculator();
      //  int scoring = calculator.calculateScoring(person);
      //  double rating = CreditRatingCalculator.calculateCreditRating(loanApplication);

        //System.out.println("Czesc " + person.getPersonalData().getName() + " " + person.getPersonalData().getLastName() + " "
          //      + person.getPersonalData().getNumOfFamilyDependants() + " " + person.getPersonalData().getTotalMonthlyIncomeInPln());
        //System.out.println("Education scoring is: " + person.getPersonalData().getEducation().getEducationScoring());
        //System.out.println("Martial scoring is: " + person.getPersonalData().getMartialStatus().getMartialScoring());
        //System.out.println("Yours scoring is: " + scoring);
      //  System.out.println("Credit rating: " + rating);
        System.out.println(service.getDecision(loanApplication).getDecision());
    }

}
