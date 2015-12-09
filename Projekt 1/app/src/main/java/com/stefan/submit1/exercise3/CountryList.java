package com.stefan.submit1.exercise3;

import java.util.ArrayList;
import java.util.List;

public class CountryList {
    private static List<Visit> countryList = new ArrayList<Visit>();

    public static List<Visit> getCountryList() {
        return countryList;
    }

    public static void addVisit(Visit visit) {
        countryList.add(visit);
    }
}

