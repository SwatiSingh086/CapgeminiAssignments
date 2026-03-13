package com.demos.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

class Employee {
    private int id;
    private String ename;
    private String dept;
    private float salary;
    private String phoneNO;
    
    public Employee() {
    	
    }

    public Employee(int id, String ename, String dept, float salary, String phoneNO) {
        this.id = id;
        this.ename = ename;
        this.dept = dept;
        this.salary = Math.round(salary * 100) / 100.0f;
        this.phoneNO = phoneNO;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return ename;
    }

    public String getDepartment() {
        return dept;
    }

    public float getSalary() {
        return salary;
    }

    public String getPhoneNO() {
        return phoneNO;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String ename) {
        this.ename = ename;
    }

    public void setDepartment(String dept) {
        this.dept = dept;
    }

    public void setSalary(float salary) {
        this.salary = Math.round(salary * 100) / 100.0f;
    }

    public void setPhoneNO(String string) {
        this.phoneNO = string;
    }

}