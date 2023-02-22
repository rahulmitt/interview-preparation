package com.interviewpedia.preparation.corejava._3_multithreading;

import sun.misc.Unsafe;

public class _7_MyAtomicInteger {
    private volatile int value;
    private static final Unsafe unsafe = Unsafe.getUnsafe();
    private static final long offset;

    static {
        try {
            offset = unsafe.objectFieldOffset(_7_MyAtomicInteger.class.getDeclaredField("value"));
        } catch (Exception exception) {
            throw new Error(exception);
        }
    }

    public _7_MyAtomicInteger() {
    }

    public _7_MyAtomicInteger(int value) {
        this.value = value;
    }

    public final int get() {
        return value;
    }

    public final void set(int value) {
        this.value = value;
    }

    public final boolean compareAndSet(int expected, int updated) {
        // invoke a NATIVE method of sun.misc.Unsafe class
        // If the value at offset is 'expected', then change the value to 'updated'
        return unsafe.compareAndSwapInt(this, offset, expected, updated);
    }

    public final int getAndSet(int newValue) {
        for (; ; ) {
            int current = get();
            if (compareAndSet(current, newValue)) {
                return current;							// return the OLD value
            }
        }
    }


}
