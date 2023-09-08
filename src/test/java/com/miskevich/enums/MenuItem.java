package com.miskevich.enums;

public enum MenuItem {


    SUMMARY("Summary"),

    GRID_AND_CHAT("Grid & chart"),

    HISTOGRAM("Histogram"),

    SCATTER_PLOT("Scatter-plot"),

    REPORTS("Report");

    private String value;

    MenuItem(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    }
