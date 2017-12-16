package com.f.bigtalk.strategy;


public class CashReturn extends CashSuper {
    private double monneyCondition = -1;
    private double moneyReturn = -1;

    public CashReturn() {}

    public CashReturn(String moneyCondition, String moneyReturn) {
        this.moneyReturn = Double.parseDouble(moneyReturn);
        this.monneyCondition = Double.parseDouble(moneyCondition);
    }

    @Override
    public double getResult(double money) {
        double result = money;
        if (money > monneyCondition) {
            result = money - Math.floor(money / monneyCondition) * moneyReturn;
        }
        return result;
    }
}
