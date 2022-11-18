package com.techgeek.sri;



interface A {
      default void func1() {
        System.out.println("this is sri");
    }
}
public class Practices implements A {
    A a;

    Practices(){

    }

    Practices(A a) {
        this.a = a;
        System.out.println("yello mate");
    }
    public void func1() {
        a.func1();
        System.out.println("This is not Sri");
    }
    public static void main(String[] args) {
        A a = new Practices(new B());
        a.func1();
        //a.a.func1();
    }
}

class B extends Practices {
    B() {
        System.out.println("B construct");
    }
    public void func1(){
        //super.func1();
        System.out.println("System is not right");
    }
}