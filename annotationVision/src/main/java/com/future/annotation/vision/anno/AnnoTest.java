package com.future.annotation.vision.anno;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@MyCustomAnno
public @interface AnnoTest {

    @AliasFor(attribute = "greet", annotation = MyCustomAnno.class)
    String name();
}
