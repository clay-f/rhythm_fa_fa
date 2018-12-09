package com.f.java.base.util.enums;

public interface Food {
    enum MEAL implements Food {
        ONE, TWO, THREE;
    }

    enum HOT_POT implements Food {
        FOUR, FIVE;
    }

    enum Congee implements Food {
        CONGEE1,
        CONGEE2;
    }

    enum COFFEE implements Food {
        BLACK_COFFEE,
        RED_COFFEE;
    }

    default Food[] getValues() {
        return MEAL.values();
    }
}
