package iih.ci.ord.s.tag;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)   //,ElementType.PARAMETER
public @interface DmEnumDesc {  // extends  java.lang.annotation.Annotation
    String name() default "";
    String description() default "";
}
