package com.slifers.sugar.DTO;

import com.orm.SugarRecord;

/**
 * Created by Don on 4/10/16.
 */
public class Person extends SugarRecord {
    private String name;
    private String age;

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getage() {
        return age;
    }

    public void setage(String age) {
        this.age = age;
    }

    public Person() {
    }

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }
}
