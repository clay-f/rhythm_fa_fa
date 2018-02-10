package com.f.bigtalk.abstruct_factory;

public class DataAccess {
    private static final String db = "sqlserver";

    public static User createUser() {
        User user = null;
        switch (db) {
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
