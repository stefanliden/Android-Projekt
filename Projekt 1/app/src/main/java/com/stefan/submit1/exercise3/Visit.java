package com.stefan.submit1.exercise3;

public class Visit {
    private int year;
    private String country;

    public Visit(int year, String country) {
        this.year = year;
        this.country = country;
    }

    public int getYear() {
        return year;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        String str = Integer.toString(year) + " " + country;
        return str;
    }
}
