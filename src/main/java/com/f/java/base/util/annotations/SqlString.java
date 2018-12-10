package com.f.java.base.util.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
/**
 * 注解赋值快捷键方式: 若一个注解有一个元素为 value ，并在使用该注解的时候该元素是唯一需要使用的元素，那么只需要提供值
 */
public @interface SqlString {
    int value() default 0;

    Constraint constrints() default @Constraint;
}
