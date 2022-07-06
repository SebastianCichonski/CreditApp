package pl.javaskils.creditapp.core.model;

public enum MartialStatus {
    DIVORCED(0),
    SEPARATED(100),
    SINGLE(0),
    WIDOWED(0),
    MARRIED(100);

    private int martialScoring;

    MartialStatus(int martialScoring) {
        this.martialScoring = martialScoring;
    }

    public int getMartialScoring() {
        return martialScoring;
    }
}
