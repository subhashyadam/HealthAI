package com.ihub.www;

public class HealthService {

    public String predictDisease(String symptoms) {
        if (symptoms == null || symptoms.isEmpty()) {
            return "No symptoms provided";
        }

        symptoms = symptoms.toLowerCase();

        if (symptoms.contains("cold")) {
            return "Common Cold";
        } else if (symptoms.contains("headache")) {
            return "Migraine";
        } else if (symptoms.contains("fever")) {
            return "Common Fever";
        }
        return "Unknown Disease";
    }

    public String getHomeRemedy(String disease) {
        switch (disease) {
            case "Common Cold":
                return "Drink warm water and take rest.";
            case "Migraine":
                return "Apply peppermint oil and rest in a dark room.";
            case "Viral Fever":
                return "Stay hydrated and take paracetamol.";
            default:
                return "Consult a doctor.";
        }
    }
}

/*
 package com.ihub.www;

public class HealthService {

    // Predict disease based on keyword matching
    public String predictDisease(String symptoms) {
        if (symptoms == null || symptoms.trim().isEmpty()) {
            return "No symptoms provided";
        }

        symptoms = symptoms.toLowerCase();

        if (symptoms.contains("cold")) {
            return "Common Cold";
        } else if (symptoms.contains("fever")) {
            return "Viral Fever";
        } else if (symptoms.contains("headache")) {
            return "Migraine";
        } else if (symptoms.contains("cough")) {
            return "Dry Cough";
        }

        return "Unknown Disease";
    }

    // Suggest home remedy based on disease name
    public String getHomeRemedy(String disease) {
        if (disease.equals("Common Cold")) {
            return "Drink warm water and rest well.";
        } else if (disease.equals("Viral Fever")) {
            return "Take paracetamol and stay hydrated.";
        } else if (disease.equals("Migraine")) {
            return "Apply a cold pack and rest in a quiet room.";
        } else if (disease.equals("Dry Cough")) {
            return "Use honey with warm water and avoid cold drinks.";
        }

        return "No remedy available. Please consult a doctor.";
    }
}
*/
