
package com.baizhi.jbc.Action;
/*
abstract class BaseClass {
    int i;
    int j;

    BaseClass() {
        System.out.println("BO");
    }

    abstract void out();

}

class FatherClass extends BaseClass {
    int i = 0;
    int j = 3;

    FatherClass() {
        System.out.println("FO");
    }

    void out() {
        System.out.println(i + " " + j);
    }

    static {
        System.out.println("F1");
    }

    {
        System.out.println("F2");
    }
}

class ChildClass extends FatherClass {
    int i = 3;
    int j = 0;

    {
        System.out.println("C0");
    }

    ChildClass() {
        System.out.println("C1");
    }

    void out() {
        System.out.println(i + " " + j);

    }

    static {
        System.out.println("C2");
    }

    {
        System.out.println("C3");
    }

    public static void main(String[] args) {
        FatherClass s = new ChildClass();
        s.out();
        System.out.println(s.i + "--" + s.j);
    }
}
*/
class aa{
    public static void main(String[] args) {
        Integer i=5;
        String j="5";
        System.out.println(i.equals(j));
    }
}
