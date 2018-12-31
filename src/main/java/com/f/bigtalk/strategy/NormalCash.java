package com.f.bigtalk.strategy;

public class NormalCash extends CashSuper {
    @Override
    public double getResult(double money) {
        return money;
    }
}
