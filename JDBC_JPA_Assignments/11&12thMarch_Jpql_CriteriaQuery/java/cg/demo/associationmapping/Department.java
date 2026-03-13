package cg.demo.associationmapping;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


//JOIN TABLE JOIN COLUMN SEARCH KARNA 

@Entity
public class Department {
	
	@Id
	private int deptid;
	private String name;
	private String mgrname;
	
	@OneToMany(mappedBy="dept",cascade=CascadeType.ALL)
	private Set<Employee> employees;
	
	
	
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMgrname() {
		return mgrname;
	}
	public void setMgrname(String mgrname) {
		this.mgrname = mgrname;
	}
	
	
	

}
