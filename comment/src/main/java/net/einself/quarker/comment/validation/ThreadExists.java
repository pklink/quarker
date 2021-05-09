package net.einself.quarker.comment.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ThreadExistsValidator.class)
public @interface ThreadExists {

    String message() default "{net.einself.quarker.constraints.threadexists}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
