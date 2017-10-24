package com.scraperJava.elements;

import java.lang.annotation.*;

/**
 * Created by Ilya Loshchinin on 14.10.2017.
 */
@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Bind {

  String value();
}
