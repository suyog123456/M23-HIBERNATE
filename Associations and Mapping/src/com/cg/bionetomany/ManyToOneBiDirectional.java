package com.cg.bionetomany;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ManyToOneBiDirectional {

	public static void main(String[] args) {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em=factory.createEntityManager();
		em.getTransaction().begin();
		
		Department d=new Department();
		d.setId(12129);
		d.setDeptName("Finance");
		
		
		Employee e=new Employee();
		e.setEmpId(121);
		e.setEname("SUYOG");
		e.setSalary(35000.50f);
		
		
		Employee e1=new Employee();
		e1.setEmpId(122);
		e1.setEname("PRATIK");
		e1.setSalary(65000.50f);
		
		
		
		
		e.setDept(d);
		e1.setDept(d);
		
		em.persist(e);
		em.persist(e1);
		
		System.out.println("Rows is inserted");
		
		em.getTransaction().commit();
		em.close();
		factory.close();


	}

}