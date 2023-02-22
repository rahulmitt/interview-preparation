package com.interviewpedia.preparation.corejava._1_oops;

/*
    https://stackoverflow.com/questions/40480/is-java-pass-by-reference-or-pass-by-value?rq=1
*/

/**
 * Java is always pass-by-value. In case of objects, the references are also pass-by-value
 */
public class _6_PassByValue {
    public static void main(String[] args) {
        System.out.println("Using primitives");
        int a = 10, b = 20;
        System.out.printf("a=%d :: b=%d%n", a, b);
        swap(a, b);
        System.out.printf("a=%d :: b=%d%n", a, b);

        System.out.println("------------------------------------------");

        System.out.println("Using holder class");
        IntHolder aa = new IntHolder(a);
        IntHolder bb = new IntHolder(b);
        System.out.printf("aa=%d :: bb=%d%n", aa.get(), bb.get());
        swap(aa, bb);
        System.out.printf("aa=%d :: bb=%d%n", aa.get(), bb.get());
    }

    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    public static void swap(IntHolder a, IntHolder b) {
        int temp = a.get();
        a.set(b.get());
        b.set(temp);
    }

    private static class IntHolder {
        int i;

        public IntHolder(int i) {
            this.i = i;
        }

        public int get() {
            return i;
        }

        public void set(int i) {
            this.i = i;
        }

    }
}
