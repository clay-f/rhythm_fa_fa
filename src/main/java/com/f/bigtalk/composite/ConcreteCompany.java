package com.f.bigtalk.composite;


import java.util.ArrayList;
import java.util.List;

public class ConcreteCompany extends Company {
    private List<Company> children = new ArrayList<>();

    public ConcreteCompany(String name) {
        super(name);
    }

    @Override
    public void add(Company company) {
        children.add(company);
    }

    @Override
    public void remove(Company company) {
        children.remove(company);
    }

    @Override
    public void display(int depth) {
        System.out.println(new String(new char[depth]).replace("\0", "-"));
    }

    @Override
    public void lineOfDuty(int depth) {
        for (Company item
                : children) {
            item.display(depth + 1);
        }
    }
}
