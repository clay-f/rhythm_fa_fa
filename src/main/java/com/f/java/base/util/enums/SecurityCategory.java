package com.f.java.base.util.enums;

public enum SecurityCategory {
    STOCK(Security.Bond.class),
    BOND(Security.Stock.class);

    Security[] values;

    SecurityCategory(Class<? extends Security> clazz) {
        values = clazz.getEnumConstants();
    }

    public Security randomSelection() {
        return Enums.random(values);
    }

    interface Security {
        enum Stock implements Security {
            ONE, TWO;
        }

        enum Bond implements Security {
            THREE,
            FOUR;
        }
    }


}
