package com.interviewpedia.preparation;

public class CollaboratorForPartialMocking {

    private void privateMethod() {

    }

    public final String finalMethod(int a) {
        return "I am a final mock method.";
    }

    public static String staticMethod(int a) {
        return "I am a static mock method.";
    }

    public String publicMethod() {
        return "Hello World";
    }
}
