package com.f.java.base.util.annotations;

public class PasswordUtils {
    @UseCase(id =  1, des = "validate passwd")
    public boolean validatePass() {
        return true;
    }

    @UseCase(id = 2, des = "validate length")
    public boolean validateLeng() {
        return false;
    }
}
