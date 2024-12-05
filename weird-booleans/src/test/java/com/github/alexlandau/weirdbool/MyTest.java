package com.github.alexlandau.weirdbool;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicBoolean;

public class MyTest {
    public static class BooleanHolder {
        public boolean b;
    }
    @Test
    public void test() {
        BooleanHolder holder = new BooleanHolder();
        AtomicBoolean atomicHolder = new AtomicBoolean();
        BooleanConsumer consumer = b -> {
            System.out.println("           b: " + b);
            if (b) {
                System.out.println("        if b: true");
            } else {
                System.out.println("        if b: false");
            }
            System.out.println("   b == true: " + (b == true));
            System.out.println("  b != false: " + (b != false));
            System.out.println("   b && true: " + (b && true));
            System.out.println("    b & true: " + (b & true));
            holder.b = b;
            atomicHolder.set(b);
        };
        WeirdBooleans.injectTralse(consumer);
        System.out.println("    holder.b: " + holder.b);
        System.out.println("atomic.get(): " + atomicHolder.get());
    }
}
