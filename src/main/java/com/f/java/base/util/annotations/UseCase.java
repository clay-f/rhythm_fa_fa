package com.f.java.base.util.annotations;

import java.lang.annotation.*;

@Target(value = {ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
@Inherited
/**
 * 注解元素不能有不确定的值。
 *
 * 必须要有默认值，或者确定的值，默认值不能为 null，为了绕开约束，给定 -1 或者 空字符串
 */
public @interface UseCase {
    int id() default -1;

    String des() default "";
}
