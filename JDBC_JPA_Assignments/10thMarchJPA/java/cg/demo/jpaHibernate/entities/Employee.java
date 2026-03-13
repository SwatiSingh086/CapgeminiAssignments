package cg.demo.jpaHibernate.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @Column(name = "eid")
    private int id;

    @Column(name = "ename")
    private String ename;

    @Column(name = "salary")
    private float salary;

    @Column(name = "dept")
    private String dept;

    @Column(name = "phoneno")
    private int phoneNO;

    public Employee(int id2, String dept2, String name, long phone, float sal) {
        this.id = id2;
        this.dept = dept2;
        this.ename = name;
        this.phoneNO = (int) phone;
        this.salary = sal;
    }
    
    public Employee() {
    	
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public int getPhoneNO() {
        return phoneNO;
    }

    public void setPhoneNO(int phoneNO) {
        this.phoneNO = phoneNO;
    }
}