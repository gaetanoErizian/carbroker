package com.techstone.carbroker.model.entities;

public enum Age {
    ONE(1),
    THREE(3),
    FIVE(5);

    private final int years;

    Age(int years) {
        this.years = years;
    }

    public int getYears() {
        return years;
    }
}