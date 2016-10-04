package com.slifers.sugar.DTO;

import com.orm.SugarRecord;

/**
 * Created by Don on 4/10/16.
 */
public class SinhVien extends SugarRecord {
    private String mssv;
    private String hoTen;
    private Person Person;

    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Person getPerson() {
        return Person;
    }

    public void setPerson(Person Person) {
        this.Person = Person;
    }

    public SinhVien() {
    }

    public SinhVien(String mssv, String hoTen, Person Person) {
        this.mssv = mssv;
        this.hoTen = hoTen;
        this.Person = Person;
    }
}
