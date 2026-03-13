package cg.demo.associationmapping;

import java.util.Set;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Employee {
	@Id
	@GeneratedValue
	private int empid;
	private String empname;
	private int salary;
	
	@ElementCollection
	private Set<Long> mobilenos;
	
	public Set<Long> getMobilenos() {
	    return mobilenos;
	}

	public void setMobilenos(Set<Long> mobiles) {
	    this.mobilenos = mobiles;
	}
	
	//UNIDIRECTIONAL
	//LEARNING- dont use cascade for insertion because for every employee that has same dept
	//			that dept ID will be inserted again, which will violate primary key value for this table
	// 			persist dept first and then the employees
	
	
	//0NE TO MANY- many side is owning,
	//			   in unidirectional- 3 tables are created,
	//			   3rd is created with primary keys to create a foreign key
	
	
	@ManyToOne
	@JoinColumn(name="deptid")
	private Department dept;
	
	
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empname=" + empname + ", salary=" + salary + ", mobilenos=" + mobilenos
				+ ", dept=" + dept + "]";
	}
	
	

}
