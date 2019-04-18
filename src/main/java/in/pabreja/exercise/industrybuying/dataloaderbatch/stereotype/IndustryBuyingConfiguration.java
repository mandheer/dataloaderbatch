package in.pabreja.exercise.industrybuying.dataloaderbatch.stereotype;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Configuration
public @interface IndustryBuyingConfiguration {

    @AliasFor(annotation = Configuration.class)
    String value() default "";
}
