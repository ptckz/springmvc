package com.example.springmvc.validations;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

import org.springframework.stereotype.Component;

import com.example.springmvc.repositories.ProductRepository;

@Target({FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = com.example.springmvc.validations.ProductExistsValidator.class)
@Documented
public @interface ProductExists {

    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
	
}

@Component
class ProductExistsValidator implements ConstraintValidator<com.example.springmvc.validations.ProductExists, String> {

	private final ProductRepository productRepository;
	
    public ProductExistsValidator(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
	
	@Override
	public void initialize(com.example.springmvc.validations.ProductExists constraintAnnotation) {
		
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return !productRepository.exists(value);
	}
	
}
