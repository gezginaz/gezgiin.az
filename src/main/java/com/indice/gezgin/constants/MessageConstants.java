package com.indice.gezgin.constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MessageConstants {

    public static final String typeBusiness = "business";
    public static final String typeCareer = "career";
    public static final String typeQuestion = "question";
    public static final String typeSuggestion = "suggestion";


    public static List<String> getMessageTypes() {
        return new ArrayList<>(Arrays.asList(
                typeBusiness, typeCareer, typeQuestion, typeSuggestion
        ));
    }

}
