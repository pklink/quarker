package net.einself.quarker.comment.validation;

import net.einself.quarker.comment.client.ThreadClient;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@ApplicationScoped
public class ThreadExistsValidator implements ConstraintValidator<ThreadExists, Long> {

    @Inject
    @RestClient
    ThreadClient threadClient;

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        return threadClient.getById(value) != null;
    }

}
