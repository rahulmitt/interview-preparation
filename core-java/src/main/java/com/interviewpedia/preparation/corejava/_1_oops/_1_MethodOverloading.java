package com.interviewpedia.preparation.corejava._1_oops;

/**
 * <p>Method overloading occurs when two or more methods in the same class have the exact same name but different parameters.</p>
 *
 * <p>1. Method name is same but the parameter list differs (in type, order or number)<br/>
 * 2. As return type is not a part of the method signature, having different return types is not enough to overload methods.<br/></p>
 *
 * <p>Overloading is a <b>compile-time polymorphism</b>. This just means that the compiler determines whether the given method is correctly overloaded, and if not a compiler error is returned.</p>
 */
public class _1_MethodOverloading {

    public static void main(String[] args) {
        A a = new A();
        a.compute();
        a.compute(10);
        a.compute(10, 10.5f);

        B b = new B();
        b.compute();
        b.compute(10);
        b.compute(10, 10.5f);

        //b.compute(null, null);      //Ambiguous method call. Cast some params to resolve ambiguity
    }

    private static class A {
        public void compute() {

        }

        public void compute(int i) {

        }

        public float compute(Integer i, Float j) {
            return i + j;
        }

        public float compute(int i, float j) {
            return i + j;
        }

        /*
        public Long compute(int i, float j) {
            return null;
        }
        */
    }

    private static class B extends A {
        public long compute(Long i, Long j) {
            return i + j;
        }
    }
}


