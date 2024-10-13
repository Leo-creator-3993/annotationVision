package com.future.annotation.vision;

import com.future.annotation.vision.anno.AnnoTest;
import com.future.annotation.vision.anno.MyCustomAnno;
import com.future.annotation.vision.model.AnnoInstance;
import com.future.annotation.vision.model.Foo;
import org.junit.Test;
import org.springframework.core.annotation.AnnotatedElementUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Set;

public class AnnotationMain {

    @Test
    public void test0() {
        System.out.println("hi");
    }

    // 解析Foo类上的注解(类、构造方法、属性字段、方法、方法参数)
    @Test
    public void test1() {
        // 获取类上注解
        Set<MyCustomAnno> myCustomAnnoSet =  AnnotatedElementUtils.findAllMergedAnnotations(Foo.class, MyCustomAnno.class);
        System.out.println(myCustomAnnoSet);
        myCustomAnnoSet.forEach(e -> System.out.printf("value:%s, greet:%s%n", e.value(), e.greet()));

        // 构造函数
        for(Constructor<?> constructor : Foo.class.getDeclaredConstructors()) {
            Set<MyCustomAnno> constructorAnnoSet = AnnotatedElementUtils.findAllMergedAnnotations(constructor, MyCustomAnno.class);
            constructorAnnoSet.forEach(e -> System.out.println(e.greet()));
        }

        // 方法
        for(Method method : Foo.class.getDeclaredMethods()) {
            Set<MyCustomAnno> methodAnnoSet = AnnotatedElementUtils.findAllMergedAnnotations(method, MyCustomAnno.class);
            methodAnnoSet.forEach(e -> System.out.println(e.greet()));

            // 方法参数
            for(Parameter parameter : method.getParameters()) {
                Set<MyCustomAnno> parameterSet = AnnotatedElementUtils.findAllMergedAnnotations(parameter, MyCustomAnno.class);
                parameterSet.forEach(e -> System.out.println(e.greet()));
            }
        }

        // 属性
        for(Field field : Foo.class.getDeclaredFields()) {
            Set<MyCustomAnno> fieldAnnoSet = AnnotatedElementUtils.findAllMergedAnnotations(field, MyCustomAnno.class);
            fieldAnnoSet.forEach(e -> System.out.println(e.greet()));
        }
    }

    @Test
    public void test2() {
        Set<MyCustomAnno> myCustomAnnoSet = AnnotatedElementUtils.findAllMergedAnnotations(AnnoInstance.class, MyCustomAnno.class);
        myCustomAnnoSet.forEach(e -> System.out.println(e.greet() + "," + e.value()));

        Set<AnnoTest> myCustomAnnoSet2 = AnnotatedElementUtils.findAllMergedAnnotations(AnnoInstance.class, AnnoTest.class);
        myCustomAnnoSet2.forEach(e -> System.out.println(e.name()));
    }
}
