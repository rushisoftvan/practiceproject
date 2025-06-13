package com.rm.basic_thing.annotationreflaction.annotation;

import org.springframework.stereotype.Service;

@Service
public class MedicationService {

    @RestrictedFor(minAge = 18, forbiddenConditions = {"Asthma"}, noPregnancy = true)
    public void prescribeStrongPainkiller(PatientDetails patient) {
        System.out.println("Prescribing strong painkiller to: " + patient.getName());
    }

    @RestrictedFor(minAge = 0)
    public void prescribeVitaminSupplement(PatientDetails patient) {
        System.out.println("Prescribing vitamin supplement to: " + patient.getName());
    }
}
