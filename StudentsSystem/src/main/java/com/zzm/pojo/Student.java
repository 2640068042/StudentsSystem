package com.zzm.pojo;

/**
 * @author ZZM
 * @creatTime 2022-09-06  21:46
 */
public class Student {
    Integer id;
    String name;
    Integer studentNumber;
    String gender;
    String homeAddress;
    Integer telephoneNumber;

    public Student() {
    }

    public Student(Integer id, String name, Integer studentNumber, String gender, String homeAddress, Integer telephoneNumber) {
        this.id = id;
        this.name = name;
        this.studentNumber = studentNumber;
        this.gender = gender;
        this.homeAddress = homeAddress;
        this.telephoneNumber = telephoneNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(Integer studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Integer getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(Integer telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", studentNumber=" + studentNumber +
                ", gender='" + gender + '\'' +
                ", homeAddress='" + homeAddress + '\'' +
                ", telephoneNumber=" + telephoneNumber +
                '}';
    }
}
