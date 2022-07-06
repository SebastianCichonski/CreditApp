package pl.javaskils.creditapp.core.model;

public class PersonalData {
    private final String name;
    private final String lastName;
    private final String mothersMaidenName;
    private MartialStatus martialStatus;
    private Education education;
    private int numOfFamilyDependants;

    private PersonalData(String name, String lastName, String mothersMaidenName, MartialStatus martialStatus, Education education, int numOfFamilyDependants) {
        this.name = name;
        this.lastName = lastName;
        this.mothersMaidenName = mothersMaidenName;
        this.martialStatus = martialStatus;
        this.education = education;
        this.numOfFamilyDependants = numOfFamilyDependants;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMothersMaidenName() {
        return mothersMaidenName;
    }

    public MartialStatus getMartialStatus() {
        return martialStatus;
    }

    public Education getEducation() {
        return education;
    }

    public int getNumOfFamilyDependants() {
        return numOfFamilyDependants;
    }

    public static class Builder{
        private String name;
        private String lastName;
        private String mothersMaidenName;
        private MartialStatus martialStatus;
        private Education education;
        private int numOfFamilyDependants;

        private Builder(){}

        public static Builder create(){
            return new Builder();
        }

        public Builder withName(String name){
            this.name = name;
            return this;
        }

        public Builder withLastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public Builder withMothersMaidenName(String mothersMaidenName){
            this.mothersMaidenName = mothersMaidenName;
            return this;
        }

        public Builder withMartialStatus(MartialStatus martialStatus){
            this.martialStatus = martialStatus;
            return this;
        }

        public Builder withEducation(Education education){
            this.education = education;
            return this;
        }

        public Builder withNumOfFamilyDependants(int numOfFamilyDependants){
            this.numOfFamilyDependants = numOfFamilyDependants;
            return this;
        }

        public PersonalData build(){
            return new PersonalData(name,lastName,mothersMaidenName,martialStatus,education,numOfFamilyDependants);
        }
    }

}
