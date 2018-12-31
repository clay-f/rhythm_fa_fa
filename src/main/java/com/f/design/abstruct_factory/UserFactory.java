package com.f.design.abstruct_factory;

public class UserFactory implements AbstractUser {
    private String userType = "sqlserver";

    @Override
    public User createUser() {
        User user = null;
        switch (userType) {
            case "sqlserver":
                user = new SqlServerUser();
                break;
            case "access":
                user = new AccessUser();
                break;
        }
        return user;
    }
}
