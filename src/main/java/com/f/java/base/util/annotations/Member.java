package com.f.java.base.util.annotations;


public class Member {
    @SqlString(30)
    public String firstname;
    @SqlString(value = 30, constrints = @Constraint(primaryKey = true, allowBlank = true))
    public String hanler;
}
