package in.pabreja.exercise.industrybuying.dataloaderbatch.stereotype;

import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Bean
public @interface IndustryBuyingBean {
    /**
     * Alias for {@link #name}.
     * <p>Intended to be used when no other attributes are needed, for example:
     * {@code @Bean("customBeanName")}.
     * @since 4.3.3
     * @see #name
     */
    @AliasFor("name")
    String[] value() default {};

    /**
     * The name of this bean, or if several names, a primary bean name plus aliases.
     * <p>If left unspecified, the name of the bean is the name of the annotated method.
     * If specified, the method name is ignored.
     * <p>The bean name and aliases may also be configured via the {@link #value}
     * attribute if no other attributes are declared.
     * @see #value
     */
    @AliasFor("value")
    String[] name() default {};
}
