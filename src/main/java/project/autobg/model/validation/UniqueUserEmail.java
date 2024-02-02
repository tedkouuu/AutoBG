package project.autobg.model.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The annotation `UniqueUserName` is used for validating the uniqueness of emails.
 */
@Retention(RetentionPolicy.RUNTIME) // Retains the annotation at runtime
@Target(ElementType.FIELD) // Applicable only to fields (member variables) in classes
@Constraint(validatedBy = UniqueEmailValidator.class)

public @interface UniqueUserEmail {
    /**
     * The message returned upon a violation of the validation rules.
     */
    String message() default "Invalid Email ";

    /**
     * Groups to which the annotation belongs.
     */
    Class<?>[] groups() default {};

    /**
     * Data that can be attached to the annotation.
     */
    Class<? extends Payload>[] payload() default {};
}
