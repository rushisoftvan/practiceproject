package com.rm.basic_thing.annotationreflaction.annotation;

import java.util.Arrays;

public class PatientDetails {

    private String name;
    private Integer  age;

    private String[] conditions;

    public PatientDetails(String name, Integer age, String[] conditions) {
        this.name = name;
        this.age = age;
        this.conditions = conditions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String[] getConditions() {
        return conditions;
    }

    public void setConditions(String[] conditions) {
        this.conditions = conditions;
    }

    public boolean hasCondition(String condition) {
        return Arrays.asList(conditions).contains(condition);
    }

}
