package com.dao;

public enum TypeSorting {

    BY_ARRIVAL_DATE("arrivaldate"),
    BY_DEPARTURE_DATE("departuredate"),
    BY_DATE("date"),
    BY_COST("cost"),
    BY_STARS("stars"),
    BY_STATUS("status"),
    BY_ID("id"),
    BY_CAPACITY("capacity"),
    BY_NAME("name"),
    BY_SURNAME("surname"),
    NO_SORTING("no_sorting");

    private String type;

     TypeSorting(String type){
        this.type=type;
    }

    public String getType() {
        return type;
    }
}
