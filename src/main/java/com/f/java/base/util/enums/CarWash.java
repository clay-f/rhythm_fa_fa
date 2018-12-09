package com.f.java.base.util.enums;

import java.util.EnumSet;

/**
 * enum group and {@link EnumSet enumset} test
 *
 */
public class CarWash {
    public enum Cycle {
        BAISC {
            @Override
            void action() {
                System.out.println("basic");
            }
        },
        PREWASH {
            @Override
            void action() {
                System.out.println("prewash");
            }
        },
        HOTWAX {
            @Override
            void action() {
                System.out.println("hot wax");
            }
        };

        abstract void action();
    }

    EnumSet<Cycle> cycles = EnumSet.of(Cycle.BAISC, Cycle.PREWASH);

    public void add(Cycle cycle ) {
        cycles.add(cycle);
    }

    public void washCar() {
        cycles.stream()
                .forEach(Cycle::action);
    }
    public static void main(String[] args) {
        CarWash carWash = new CarWash();
        System.out.println(carWash.cycles);
        carWash.washCar();
        carWash.add(Cycle.HOTWAX);
        carWash.washCar();
    }
}
