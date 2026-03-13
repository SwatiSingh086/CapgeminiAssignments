package cg.demo.jpaHibernate;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import cg.demo.jpaHibernate.entities.Employee;

public class EmployeeDAO {

    EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("JPA-PU");

    EntityManager em = emf.createEntityManager();

    // INSERT
    public Employee insertEmployee(Employee e) {

        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();

        return e;
    }

    // FETCH BY ID
    public Employee getEmployeeById(int id) {

        Employee e = em.find(Employee.class, id);
        return e;
    }

    // UPDATE SALARY
    public Employee updateSalary(int id, float newsal) {

        Employee e = em.find(Employee.class, id);

        if (e != null) {

            em.getTransaction().begin();
            e.setSalary(newsal);
            em.getTransaction().commit();
        }

        return e;
    }

    // DELETE without find 
    /*public Employee deleteEmployee(int id) {

        Employee e = new Employee();
        e.setId(id);   // set the ID you want to delete

        em.getTransaction().begin();

           // attach entity to persistence context
        em.remove(em.merge(e));      // delete it

        em.getTransaction().commit();

        return e;
    }*/
    
    public Employee deleteEmployee(int id) {

        Employee e = em.find(Employee.class, id);

        if(e != null){
            em.getTransaction().begin();
            em.remove(e);
            em.getTransaction().commit();
        }

        return e;
    }
    
 
//JPQL
    public List<Employee> getEmployee() {

        String jpql = "SELECT e FROM Employee e";

        List<Employee> list = em.createQuery(jpql, Employee.class)
                                .getResultList();

        return list;
    }
    
    
 //GET BY MOBILE PHONE= WE WILL USE JOIN   
    
    public List<Employee> getEmployeesBySalary(double sal) {

        String jpql = "SELECT e FROM Employee e WHERE e.salary = :sal";

        TypedQuery<Employee> query =
                em.createQuery(jpql, Employee.class);

        query.setParameter("sal", sal);

        return query.getResultList();
    }
    
    
    public Employee getEmployeeByPhone(String phone) {

        String jpql = "SELECT e FROM Employee e WHERE e.phone = :phone";

        TypedQuery<Employee> query =
                em.createQuery(jpql, Employee.class);

        query.setParameter("phone", phone);

        return query.getSingleResult();
    }
    
    
}