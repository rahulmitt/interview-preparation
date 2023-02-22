package com.interviewpedia.preparation.dp.gof._1_creational.singleton;

public class SingletonPattern {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
    }

    private final static class Singleton {
        private static volatile Singleton instance;

        private Singleton() {
        }

        public static Singleton getInstance() {
            if (instance == null) {
                synchronized (Singleton.class) {
                    if (instance == null) instance = new Singleton();
                }
            }
            return instance;
        }
    }
}
