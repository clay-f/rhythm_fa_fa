package com.f.bigtalk.simple_factory;

public class CalcFactory {
    public static Operatte createOperate(String opr, double a, double b) {
        Operatte operate = null;
        switch (opr) {
            case "-" :
                operate = new Operatte(a, b);
                break;
        }
        return operate;
    }
}
