package com.f.bigtalk.strategy;

public class CashRebate extends CashSuper {
    private double rebate = 0;

    public CashRebate() {}

    public CashRebate(String rebate) {
        this.rebate = Double.parseDouble(rebate);
    }

    @Override
    public double getResult(double money) {
        return money * rebate;
    }
}
