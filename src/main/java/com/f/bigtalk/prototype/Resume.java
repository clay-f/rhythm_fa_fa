package com.f.bigtalk.prototype;

public class Resume implements Cloneable {
    private String name;
    private String age;
    private String sex;
    private String workTime;
    private String compley;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public String getCompley() {
        return compley;
    }

    public void setCompley(String compley) {
        this.compley = compley;
    }
}
