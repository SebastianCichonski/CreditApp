package pl.javaskils.creditapp.core.model;

public enum Education {
    PRIMARY(-100),
    MIDDLE(0),
    SECONDARY(0),
    POST_SECONDARY(0),
    TERTIARY(100),
    NONE(-200);

    private int educationScoring;

    Education(int educationScoring) {
        this.educationScoring = educationScoring;
    }

    public int getEducationScoring() {
        return educationScoring;
    }

}
