package com.chameleon.selenium.web.by.angular;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Deprecated
public @interface FindByNG {
    HowNG howNG() default HowNG.ID;

    String using() default "";

    String ngController() default "";

    String ngModel() default "";

    String ngRepeater() default "";

    String ngShow() default "";
}
