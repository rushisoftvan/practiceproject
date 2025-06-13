package com.rm.basic_thing.annotationreflaction.annotation;

import java.lang.reflect.Method;

public class RestrictionEnforcer {


    public static void invokeIfAllowed(Object service, String methodName, Class<?>[] paramTypes, Object[] args) throws Exception {
        Method method = service.getClass().getMethod(methodName, paramTypes);

        if (method.isAnnotationPresent(RestrictedFor.class)) {
            RestrictedFor restriction = method.getAnnotation(RestrictedFor.class);

            PatientDetails patient = null;
            for (Object arg : args) {
                if (arg instanceof PatientDetails) {
                    patient = (PatientDetails) arg;
                    break;
                }
            }

            if (patient == null) {
                throw new IllegalArgumentException("No PatientDetails argument provided.");
            }

            if (patient.getAge() < restriction.minAge()) {
                throw new IllegalAccessException("Too young. Minimum age: " + restriction.minAge());
            }
            if (patient.getAge() > restriction.maxAge()) {
                throw new IllegalAccessException("Too old. Maximum age: " + restriction.maxAge());
            }
            for (String condition : restriction.forbiddenConditions()) {
                if (patient.hasCondition(condition)) {
                    throw new IllegalAccessException("Restricted due to condition: " + condition);
                }
            }
            if (restriction.noPregnancy() && patient.hasCondition("Pregnancy")) {
                throw new IllegalAccessException("Restricted due to pregnancy");
            }
        }
        method.invoke(service, args);
    }
}
