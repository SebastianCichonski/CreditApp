package pl.javaskils.creditapp.core.model;

public class NaturalPerson extends Person{
    private final String pesel;
    private PersonalData personalData;
    private ContactData contactData;
    private FinanceData financeData;

    private NaturalPerson(PersonalData personalData, ContactData contactData, FinanceData financeData, String pesel) {
        super(personalData, contactData, financeData);
        this.pesel = pesel;
    }

    public static class Builder{
        private String pesel;
        private PersonalData personalData;
        private ContactData contactData;
        private FinanceData financeData;

        private Builder(){}

        public static Builder create(){
            return new Builder();
        }

        public NaturalPerson build(){
            return new NaturalPerson(personalData, contactData, financeData, pesel);
        }

        public Builder withPesel(String pesel){
            this.pesel = pesel;
            return this;
        }

        public Builder withPersonalData(PersonalData personalData){
            this.personalData = personalData;
            return this;
        }

        public Builder withContactData(ContactData contactData){
            this.contactData = contactData;
            return this;
        }

        public Builder withFinanceData(FinanceData financeData){
            this.financeData = financeData;
            return this;
        }
    }
}
