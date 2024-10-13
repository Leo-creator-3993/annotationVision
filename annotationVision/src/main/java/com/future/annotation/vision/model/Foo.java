package com.future.annotation.vision.model;

import com.future.annotation.vision.anno.MyCustomAnno;

@MyCustomAnno(greet = "hello, I am foo class.")
public class Foo {

    @MyCustomAnno(greet = "hello, I am no arg CONSTRUCTOR.")
    public Foo() {
    }

    @MyCustomAnno(greet = "hello, I am arg CONSTRUCTOR.")
    public Foo(int id) {
        this.id = id;
    }

    @MyCustomAnno(greet = "hello, I am field(id).")
    private int id;

    @MyCustomAnno(greet = "hello, I am getId method.")
    public int getId() {
        return id;
    }

    @MyCustomAnno(greet = "hello, I am setId method.")
    public void setId(int id) {
        this.id = id;
    }

    @MyCustomAnno(greet = "hello, I am tell method.")
    public void tell() {
        System.out.println("I am foo:" + id);
    }

    @MyCustomAnno(greet = "hello, I am greet method.")
    public String greet(@MyCustomAnno("hello, I am parameter(msg).") String msg) {
        return String.format("Hello,%s.", msg);
    }

    @Override
    @MyCustomAnno(greet = "hello, I am toString method.")
    public String toString() {
        return String.valueOf(id);
    }
}
