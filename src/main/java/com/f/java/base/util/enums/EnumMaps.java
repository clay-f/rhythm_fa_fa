package com.f.java.base.util.enums;

import java.util.EnumMap;

public class EnumMaps {
    public static void main(String[] args) {
        EnumMap<Flowers, Command> em = new EnumMap<>(Flowers.class);
        em.put(Flowers.LILY, () -> System.out.println("hello"));
        em.entrySet().forEach(p1 -> {
            System.out.println(p1.getKey());
            p1.getValue().run();
        });
    }
}
