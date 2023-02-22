package com.interviewpedia.preparation.corejava._1_oops;

/**
 * <p>Method overriding occurs when a sub-class requires a different definition for an inherited method from the super-class, then that method can be redefined in the derived class.</p>
 *
 * <p>The new method definition:</p>
 *
 *     <p>1. Must have the same <b>method signature</b> (method name + parameters) and the same <b>return type</b>.<br/>
 *      2. Cannot narrow the <b>accessibility</b> of the method, but it can widen it.<br/>
 *      3. Can only specify <b>all or none (or a subset) of the exception</b> classes (including their sub-classes) specified in the throws clause of the overridden method in the super-class.<br/></p>
 *
 * <p>Method overriding is a <b>runtime polymorphism</b> as opposed to method overloading. Adding the annotation <b>@Override</b> to the overriding method tells the compiler that this method is intended to override another.</p>
 *
 *
 * <p>If a subclass defines a static method with the same signature as a static method in the superclass, then the method in the subclass <b>hides</b> the one in the superclass.</p>
 *
 *     <p>1. The version of the <b>overridden instance method</b> that gets invoked is the one in the <b>subclass</b>.<br/>
 *      2. The version of the <b>hidden static method</b> that gets invoked depends on the <b>reference</b> — whether the static method is invoked from the superclass or the subclass.<br/></p>
 *
 *  <p><b>Overriding</b> supports <b>late binding</b>. Therefore, which method will be invoked is decided at runtime. It is for <b>instance methods</b> only.</p>
 *  <p><b>Hiding</b> is for all other members — <b>static methods, instance variables, static variables</b>. It is based on the <b>early binding</b>. The method or member to be called or used is decided during compile time.</p>
 */
public class _2_MethodOverridingHiding {

    public static void main(String[] args) {

        Parent parentRef = new Child();
        System.out.println("parentRef.publicInstanceVariable: " + parentRef.publicInstanceVariable);
        System.out.println("parentRef.protectedInstanceVariable: " + parentRef.protectedInstanceVariable);
        System.out.println("parentRef.defaultInstanceVariable: " + parentRef.defaultInstanceVariable);
        System.out.println("parentRef.privateInstanceVariable: " + parentRef.privateInstanceVariable);

        System.out.println();

        System.out.println("parentRef.publicStaticVariable: " + parentRef.publicStaticVariable);
        System.out.println("parentRef.protectedStaticVariable: " + parentRef.protectedStaticVariable);
        System.out.println("parentRef.defaultStaticVariable: " + parentRef.defaultStaticVariable);
        System.out.println("parentRef.privateStaticVariable: " + parentRef.privateStaticVariable);

        System.out.println();

        parentRef.publicInstanceMethod();
        parentRef.protectedInstanceMethod();
        parentRef.defaultInstanceMethod();
        parentRef.privateInstanceMethod();
        parentRef.publicStaticMethod();
        parentRef.protectedStaticMethod();
        parentRef.defaultStaticMethod();
        parentRef.privatStaticMethod();
        parentRef.staticMethodNotHiddenByChild();

        System.out.println("-------------------------------------------------------------------------------");

        Child childRef = new Child();
        System.out.println("childRef.publicInstanceVariable: " + childRef.publicInstanceVariable);
        System.out.println("childRef.protectedInstanceVariable: " + childRef.protectedInstanceVariable);
        System.out.println("childRef.defaultInstanceVariable: " + childRef.defaultInstanceVariable);
        System.out.println("childRef.privateInstanceVariable: " + childRef.privateInstanceVariable);

        System.out.println();

        System.out.println("childRef.publicStaticVariable: " + childRef.publicStaticVariable);
        System.out.println("childRef.protectedStaticVariable: " + childRef.protectedStaticVariable);
        System.out.println("childRef.defaultStaticVariable: " + childRef.defaultStaticVariable);
        System.out.println("childRef.privateStaticVariable: " + childRef.privateStaticVariable);

        System.out.println();

        childRef.publicInstanceMethod();
        childRef.protectedInstanceMethod();
        childRef.defaultInstanceMethod();
        childRef.privateInstanceMethod();
        childRef.publicStaticMethod();
        childRef.protectedStaticMethod();
        childRef.defaultStaticMethod();
        childRef.privatStaticMethod();
        childRef.staticMethodNotHiddenByChild();
    }

    private static class Parent {

        public String publicInstanceVariable = "Parent - publicInstanceVariable";
        protected String protectedInstanceVariable = "Parent - protectedInstanceVariable";
        String defaultInstanceVariable = "Parent - defaultInstanceVariable";
        private String privateInstanceVariable = "Parent - privateInstanceVariable";

        public static String publicStaticVariable = "Parent - publicStaticVariable";
        protected static String protectedStaticVariable = "Parent - protectedStaticVariable";
        static String defaultStaticVariable = "Parent - defaultStaticVariable";
        private static String privateStaticVariable = "Parent - privateStaticVariable";


        public void publicInstanceMethod() {
            System.out.println("Parent - publicInstanceMethod");
        }

        public static void publicStaticMethod() {
            System.out.println("Parent - publicStaticMethod");
        }

        protected void protectedInstanceMethod() {
            System.out.println("Parent - protectedInstanceMethod");
        }

        protected static void protectedStaticMethod() {
            System.out.println("Parent - protectedStaticMethod");
        }

        void defaultInstanceMethod() {
            System.out.println("Parent - defaultInstanceMethod");
        }

        static void defaultStaticMethod() {
            System.out.println("Parent - defaultStaticMethod");
        }

        // private methods cannot be overridden
        private void privateInstanceMethod() {
            System.out.println("Parent - privateInstanceMethod");
        }

        private static void privatStaticMethod() {
            System.out.println("Parent - privatStaticMethod");
        }

        static void staticMethodNotHiddenByChild() {
            System.out.println("Parent - staticMethodNotHiddenByChild");
        }

        void eat(){}
    }

    private static class Child extends Parent {

        // public --> protected --> default --> private

        public String publicInstanceVariable = "Child - publicInstanceVariable";
        protected String protectedInstanceVariable = "Child - protectedInstanceVariable";
        String defaultInstanceVariable = "Child - defaultInstanceVariable";
        private String privateInstanceVariable = "Child - privateInstanceVariable";

        public static String publicStaticVariable = "Child - publicStaticVariable";
        protected static String protectedStaticVariable = "Child - protectedStaticVariable";
        static String defaultStaticVariable = "Child - defaultStaticVariable";
        private static String privateStaticVariable = "Child - privateStaticVariable";

        // This has to be public. Any attempt to assign a weaker access-modifier will give compile-time exception
        public void publicInstanceMethod() {
            System.out.println("Child - publicInstanceMethod");
        }

        // This has to be public. Any attempt to assign a weaker access-modifier will give compile-time exception
        public static void publicStaticMethod() {
            System.out.println("Child - publicStaticMethod");
        }

        // This has to be either public/protected. Any attempt to assign a weaker access-modifier will give compile-time exception
        protected void protectedInstanceMethod() {
            System.out.println("Child - protectedInstanceMethod");
        }

        // This has to be either public/protected. Any attempt to assign a weaker access-modifier will give compile-time exception
        protected static void protectedStaticMethod() {
            System.out.println("Child - protectedStaticMethod");
        }

        // This cannot be private. Any attempt to assign a weaker access-modifier will give compile-time exception
        void defaultInstanceMethod() {
            System.out.println("Child - defaultInstanceMethod");
        }

        // This cannot be private. Any attempt to assign a weaker access-modifier will give compile-time exception
        static void defaultStaticMethod() {
            System.out.println("Child - defaultStaticMethod");
        }

        // private methods are be overridden
        private void privateInstanceMethod() {
            System.out.println("Child - privateInstanceMethod");
        }

        private static void privatStaticMethod() {
            System.out.println("Child - privatStaticMethod");
        }

        // Compilation error: instance method in sub-class cannot override a static method in parent-class
//        public void staticMethodNotHiddenByChild() {}

        // Compilation error: static method in sub-class cannot override an instance method in parent-class
//        static void eat() {}
    }
}
