package pl.coderslab.validator;

import pl.coderslab.model.Cage;
import pl.coderslab.model.Section;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

public class SectionValidator implements ConstraintValidator<CageListNotEmpty, List<Cage>> {


    @Override
    public void initialize(CageListNotEmpty constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(List<Cage> cages, ConstraintValidatorContext context) {
       if(cages.get(0) != null || cages.get(1) != null || cages.get(2) != null || cages.get(3) != null){
           return true;
       }
        return false;
    }

}
