package cg.demo.associationmapping;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;
import jakarta.persistence.criteria.*;

//NOTE=====JPQL HAS BEEN COMMENTED DOWN BELOW

public class EmployeeDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
    EntityManager em = emf.createEntityManager();

    
    public void insertEmployee(Employee e, Department d) {

        em.getTransaction().begin();

        if(d.getEmployees() == null) {
            d.setEmployees(new HashSet<>());
        }

        d.getEmployees().add(e);
        e.setDept(d);

        em.persist(d);

        em.getTransaction().commit();
    }

    // 1 Fetch employee name + dept name + manager name
    public void fetchEmployeeDetails() {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);

        Root<Employee> emp = cq.from(Employee.class);
        Join<Employee, Department> dept = emp.join("dept");

        cq.multiselect(
                emp.get("empname"),
                dept.get("name"),
                dept.get("mgrname")
        );

        List<Object[]> list = em.createQuery(cq).getResultList();

        for(Object[] obj : list) {
            System.out.println(
                    "Employee : " + obj[0] +
                    " Dept : " + obj[1] +
                    " Manager : " + obj[2]);
        }
    }

    // 2 Count employees per department
    public void countEmployeesPerDept() {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);

        Root<Department> dept = cq.from(Department.class);
        Join<Department, Employee> emp = dept.join("employees", JoinType.LEFT);

        cq.multiselect(
                dept.get("name"),
                cb.count(emp)
        );

        cq.groupBy(dept.get("name"));

        List<Object[]> list = em.createQuery(cq).getResultList();

        for(Object[] obj : list) {
            System.out.println(
                    "Department : " + obj[0] +
                    " Employees : " + obj[1]);
        }
    }

    // 3 Fetch employees working in given department
    public void fetchEmployeesByDept(String deptName) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);

        Root<Employee> emp = cq.from(Employee.class);

        cq.select(emp)
          .where(cb.equal(emp.get("dept").get("name"), deptName));

        List<Employee> list = em.createQuery(cq).getResultList();

        for(Employee e : list) {
            System.out.println(e.getEmpid() + " " + e.getEmpname());
        }
    }

    // 4 Fetch department details using employee mobile number
    public void fetchDeptUsingMobile(long mobile) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);

        Root<Employee> emp = cq.from(Employee.class);

        Join<Employee, Department> dept = emp.join("dept");
        Join<Employee, Long> mob = emp.join("mobilenos");

        cq.multiselect(
                emp.get("empid"),
                emp.get("empname"),
                emp.get("salary"),
                dept.get("name"),
                dept.get("mgrname")
        );

        cq.where(cb.equal(mob, mobile));

        List<Object[]> list = em.createQuery(cq).getResultList();

        for(Object[] obj : list) {

            System.out.println(
                    "EmpID : " + obj[0] +
                    " Name : " + obj[1] +
                    " Salary : " + obj[2] +
                    " Dept : " + obj[3] +
                    " Manager : " + obj[4]);
        }
    }

    
    public void addMobile(int empId, long mobile) {

        em.getTransaction().begin();

        Employee e = em.find(Employee.class, empId);

        if(e != null) {

            if(e.getMobilenos() == null) {
                e.setMobilenos(new HashSet<>());
            }

            e.getMobilenos().add(mobile);
        }

        em.getTransaction().commit();
    }
}



//================   JPQL    ===========

/*public class EmployeeDAO {
	EntityManagerFactory emf= Persistence.createEntityManagerFactory("JPA-PU");
	EntityManager em= emf.createEntityManager();
	
	public void insertEmployee(Employee e, Department d) {
		em.getTransaction().begin();
		
		if(d.getEmployees() == null){
		    d.setEmployees(new HashSet<>());
		}
		d.getEmployees().add(e); //added emp in dept
		e.setDept(d);
		
		em.persist(d);
		
		em.getTransaction().commit();
	}
	
	public void fetchEmployeeDetails() {
		String jpql= "Select e.empname, d.name, d.mgrname from Employee e join e.dept d";
		  List<Object[]> list =
		            em.createQuery(jpql, Object[].class).getResultList();

		    for(Object[] obj : list) {
		        System.out.println(
		                "Employee : " + obj[0] +
		                " Dept : " + obj[1] +
		                " Manager : " + obj[2]);
		    	}
	
	
			}
	public void countEmployeesPerDept() {

	    String jpql =
	        "SELECT d.name, COUNT(e) " +
	        "FROM Department d LEFT JOIN d.employees e " +
	        "GROUP BY d.name";

	    List<Object[]> list =
	        em.createQuery(jpql, Object[].class).getResultList();

	    for(Object[] obj : list) {
	        System.out.println(
	            "Department : " + obj[0] +
	            " Employees : " + obj[1]);
	    }
	}
	
	public void fetchEmployeesByDept(String deptName) {

	    String jpql =
	        "SELECT e FROM Employee e WHERE e.dept.name = :dname";

	    List<Employee> list =
	        em.createQuery(jpql, Employee.class)
	          .setParameter("dname", deptName)
	          .getResultList();

	    for(Employee e : list) {
	        System.out.println(e.getEmpid() + " " + e.getEmpname());
	    }
	}
	public void fetchDeptUsingMobile(long mobile) {

	    String jpql =
	        "SELECT e.empid, e.empname, e.salary, d.name, d.mgrname " +
	        "FROM Employee e JOIN e.dept d JOIN e.mobilenos m " +
	        "WHERE m = :mob";

	    List<Object[]> list =
	        em.createQuery(jpql, Object[].class)
	          .setParameter("mob", mobile)
	          .getResultList();

	    for(Object[] obj : list) {

	        System.out.println(
	            "EmpID : " + obj[0] +
	            " Name : " + obj[1] +
	            " Salary : " + obj[2] +
	            " Dept : " + obj[3] +
	            " Manager : " + obj[4]);
	    }
	}
	
	public void addMobile(int empId, long mobile) {

	    em.getTransaction().begin();

	    Employee e = em.find(Employee.class, empId);

	    if(e != null) {
	        e.getMobilenos().add(mobile);
	    }

	    em.getTransaction().commit();
	}
	
	
	
	
	
	
	
}
*/