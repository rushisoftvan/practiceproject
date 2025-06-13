package com.rm.basic_thing.annotationreflaction.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RestrictedFor {

    int minAge() default 0 ;
    int maxAge() default Integer.MAX_VALUE;

    String[] forbiddenConditions() default {};

    boolean noPregnancy() default false;
}
