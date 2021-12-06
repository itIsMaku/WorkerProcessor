package cz.maku.mommons.worker.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Plugin {

    String name();

    String description() default "Another mommons-based plugin";

    String main();

    String[] authors();

    String version() default "1.0";

    String apiVersion() default "1.17";

    String[] softDepends() default {};

    String[] depends() default {};

    String website() default "www.maku.website";
}

