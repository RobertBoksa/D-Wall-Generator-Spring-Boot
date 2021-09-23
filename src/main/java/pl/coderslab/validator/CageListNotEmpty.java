package pl.coderslab.validator;




import pl.coderslab.model.Section;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ TYPE, ANNOTATION_TYPE, FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = SectionValidator.class)
@Documented
public @interface CageListNotEmpty {
    String message() default "{cageListNotEmpty.error.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
