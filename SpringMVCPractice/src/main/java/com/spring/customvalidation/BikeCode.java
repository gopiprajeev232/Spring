package com.spring.customvalidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = BikeCodeConstraintValidator.class)
@Target( {ElementType.METHOD, ElementType.FIELD} )
@Retention(RetentionPolicy.RUNTIME)
public @interface BikeCode {
    public String value() default "INT";

    public String message() default "must start with INT";

    public Class<?>[] groups() default  {};

    public Class<? extends Payload>[] payload() default {};
}
