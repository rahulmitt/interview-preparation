package com.interviewpedia.preparation.corejava._3_multithreading;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class _1_DoubleCheckedLocking {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        singleton.put("name", "rahul");
        System.out.println(singleton.get("name"));

        EnumSingleton.INSTANCE.put("name", "rahul");
        System.out.println(EnumSingleton.INSTANCE.get("name"));
    }

    private static class Singleton implements Serializable {
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

        /*
            Using serialization/deserialization we can create many objects which leads to singleton failure.
            So to avoid this we have to implement the readResolve() JVM hook.
            During deserialization, Before giving the deserialized object JVM will invoke the readResolve() method.
            If you override and give your singleton instance then no new object will be created.
        */
        private Object readResolve() {
            return getInstance();
        }

        private final Map<String, String> cache = new HashMap<>();

        public void put(String key, String value) {
            cache.put(key, value);
        }

        public String get(String key) {
            return cache.get(key);
        }
    }

    private enum EnumSingleton {
        INSTANCE;

        private final Map<String, String> cache = new HashMap<>();

        public void put(String key, String value) {
            cache.put(key, value);
        }

        public String get(String key) {
            return cache.get(key);
        }
    }
}
