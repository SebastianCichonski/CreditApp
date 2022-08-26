package pl.javaskils.creditapp.core.model;

import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;

public class CreditApplication {
    private final UUID id;
    private final Person person;
    private final PurposeOfLoan purposeOfLoan;
    private TreeSet<Guarantor> guarantors;

    private CreditApplication(Person person, PurposeOfLoan purposeOfLoan, TreeSet<Guarantor> guarantors) {
        id = UUID.randomUUID();
        this.purposeOfLoan = purposeOfLoan;
        this.person = person;
        this.guarantors = guarantors;
    }

    public TreeSet<Guarantor> getGuarantors() {
        return guarantors;
    }

    public PurposeOfLoan getPurposeOfLoan() {
        return purposeOfLoan;
    }

    public Person getPerson(){
        return person;
    }

    public UUID getId() {
        return id;
    }

    public static class Buider{
       // private UUID id;
        private Person person;
        private PurposeOfLoan purposeOfLoan;
        private TreeSet<Guarantor> guarantors;

        private Buider(){}

        public static Buider create(){
            return new Buider();
        }

//        public Buider withUUID(){
//            id = UUID.randomUUID();
//            return this;
//        }

        public Buider withPerson(Person person){
            this.person = person;
            return this;
        }

        public Buider withPurposeOfLoan(PurposeOfLoan purposeOfLoan){
            this.purposeOfLoan = purposeOfLoan;
            return this;
        }

        public Buider withGuarantors(TreeSet<Guarantor> guarantors){
            this.guarantors = guarantors;
            return this;
        }

        public CreditApplication build(){
            return  new CreditApplication(person,purposeOfLoan,guarantors);
        }
    }
}
