package pl.javaskils.creditapp.core.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Person {
    private static final Logger LOG = LoggerFactory.getLogger(FinanceData.class);
    private PersonalData personalData;
    private ContactData contactData;
    private FinanceData financeData;

    private Person(PersonalData personalData, ContactData contactData, FinanceData financeData) {
        this.personalData = personalData;
        this.contactData = contactData;
        this.financeData = financeData;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }

    public ContactData getContactData() {
        return contactData;
    }

    public FinanceData getFinanceData() {
        return financeData;
    }

    public static class Builder{
        private PersonalData personalData;
        private ContactData contactData;
        private FinanceData financeData;

        private Builder(){}

        public static Builder create(){
            return new Builder();
        }

        public Person build(){
            return new Person(personalData,contactData,financeData);
        }

        public Builder withPersonalData(PersonalData personalData){
            this.personalData = personalData;
            return this;
        }

        public Builder withContactData(ContactData contactData){
            this.contactData = contactData;
            return this;
        }

        public Builder withFinanceData(FinanceData FinanceData){
            this.financeData = financeData;
            return this;
        }
    }

    public double sumOfIncome(){
        double totalMonthlyIncom = 0;

        for(SourceOfIncome sourceOfIncome : financeData.getSourceOfIncomes() ){
            totalMonthlyIncom += sourceOfIncome.getNetMonthlyIncome();
        }
        LOG.info("Sum of income: " + totalMonthlyIncom);
        return totalMonthlyIncom;
    }
}
