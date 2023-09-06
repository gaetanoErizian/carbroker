package com.techstone.carbroker.model.entities;

public enum PriceRange {
    UNDER_5K("5k-"),
    BETWEEN_5K_10K("5k10K"),
    ABOVE_10K("10K+");

    private final String label;

    PriceRange(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}