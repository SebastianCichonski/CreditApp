package pl.javaskils.creditapp.core.model;

public class SelfEmployed extends Person{
    private final String nip;
    private final String regon;

    public SelfEmployed(String nip, String regon, PersonalData personalData, ContactData contactData, FinanceData financeData) {
        super(personalData, contactData, financeData);
        this.nip = nip;
        this.regon = regon;
    }

    public static class Builder{
        private String nip;
        private String regon;
        private PersonalData personalData;
        private ContactData contactData;
        private FinanceData financeData;

        private Builder(){}

        public Builder create(){
            return new Builder();
        }

        public SelfEmployed build(){
            return new SelfEmployed(nip, regon, personalData, contactData, financeData);
        }

        public Builder withNip(String nip){
            this.nip = nip;
            return this;
        }

        public Builder withRegon(String regon){
            this.regon = regon;
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
