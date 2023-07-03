package com.indice.gezgin.constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlaceConstants {

    private static class PlaceTypeConstants {

        private static final String PARK = "Park";
        private static final String ENTERTAINMENT = "Əyləncə mərkəzi";
        private static final String RESTAURANTS = "Restoran";
        private static final String COFFEES = "Kafe";
        private static final String PLAYSTATION = "Playstation";
        private static final String INTERNETCAFE = "İnternet kafe";
        private static final String MUSEUM = "Muzey";
        private static final String HOBIE_CENTER = "Hobbi mərkəzi";
        private static final String COURSES = "Kurs";
        private static final String STATION = "Stadion";
        private static final String FITNESS = "Trenajor";
        private static final String SPORT_CENTER = "İdman mərkəzi";
        private static final String SIGHTSEEING = "Gəzməli yerlər";

    }

    private static class PlaceAuraConstants {
        private static final String ROMANTIC = "Romantik";
        private static final String ENTERTAINMENT = "Əyləncə";
        private static final String CREATICE = "Qurucu ruh";
        private static final String MELANCHOLIC = "Melanxolik";
        private static final String NORMAL = "Normal";
        private static final String SADNESS = "Qəmgin";
        private static final String NOSTALJİ = "Nostalji";
    }

    private static class PlaceThemeConstants {
        private static final String FAMILTY = "Ailə";
        private static final String NORMAL = "Normal";
        private static final String SPORT = "İdman";
        private static final String FOOTBALL = "Futbol";
        private static final String CHESS = "Şahmat";
        private static final String LOVE = "Sevgi";
    }

    private static class PlaceArchitectureConstants {
        private static final String ANCIENT = "Qədimi";
        private static final String SEA = "Dənizdə";
        private static final String HIGH_FLOOR = "Yüksəkdə";
        private static final String NORMAL = "Normal";
        private static final String NATURE = "Təbiət";
    }

    ///////////////////////////////////////////////////

    public List<String> getPlaceTypes() {
        return new ArrayList<>(Arrays.asList(
                PlaceTypeConstants.PARK, PlaceTypeConstants.COFFEES, PlaceTypeConstants.ENTERTAINMENT, PlaceTypeConstants.RESTAURANTS, PlaceTypeConstants.COURSES,
                PlaceTypeConstants.PLAYSTATION, PlaceTypeConstants.MUSEUM, PlaceTypeConstants.HOBIE_CENTER, PlaceTypeConstants.STATION,
                PlaceTypeConstants.FITNESS, PlaceTypeConstants.SPORT_CENTER, PlaceTypeConstants.SIGHTSEEING, PlaceTypeConstants.INTERNETCAFE
        ));
    }

    public List<String> getPlaceAuras() {
        return new ArrayList<>(Arrays.asList(
                PlaceAuraConstants.ROMANTIC, PlaceAuraConstants.ENTERTAINMENT, PlaceAuraConstants.CREATICE, PlaceAuraConstants.MELANCHOLIC, PlaceAuraConstants.NORMAL,
                PlaceAuraConstants.SADNESS, PlaceAuraConstants.NOSTALJİ
        ));
    }

    public List<String> getPlaceThemes() {
        return new ArrayList<>(Arrays.asList(
                PlaceThemeConstants.FAMILTY, PlaceThemeConstants.NORMAL, PlaceThemeConstants.SPORT, PlaceThemeConstants.FOOTBALL, PlaceThemeConstants.CHESS,
                PlaceThemeConstants.LOVE
        ));
    }

    public List<String> getPlaceArchitectures() {
        return new ArrayList<>(Arrays.asList(
                PlaceArchitectureConstants.ANCIENT, PlaceArchitectureConstants.SEA, PlaceArchitectureConstants.HIGH_FLOOR, PlaceArchitectureConstants.NORMAL,
                PlaceArchitectureConstants.NATURE
        ));
    }

}
