package com.f.java.base.util.enums;

import com.f.java.base.util.Generator;

import java.util.concurrent.ThreadLocalRandom;

public enum Flowers implements Generator<Flowers> {
    PEONY {
        String getInfo() {
          return "peony";
        };
    },
    ROSE {
        String getInfo() {
            return "rose";
        }
    },
    LILY {
        String getInfo() {
            return "lily";
        }
    },
    CLUBS {
        String getInfo() {
            return "clubs";
        }
    },
    PEACH_BLOSSOM {
        String getInfo() {
            return "peach blossom";
        }
    };

    private Flowers() {
    }

    abstract String getInfo();


    @Override
    public String toString() {
        var firstChar = name();
        var lower = firstChar.substring(1).toLowerCase();
        return firstChar.charAt(0) + lower;
    }

    public static void main(String... args) {
        for (Flowers item : Flowers.values()) {
            System.out.println(item.getInfo());
            System.out.println(item.next());
        }

        System.out.println(Enums.random(Flowers.class));

        System.out.println(Flowers.nextStatic());

    }

    @Override
    public Flowers next() {
        return values()[ThreadLocalRandom.current().nextInt(0, values().length)];
    }

    static Flowers nextStatic() {
        return values()[ThreadLocalRandom.current().nextInt(0, values().length)];
    }
}
