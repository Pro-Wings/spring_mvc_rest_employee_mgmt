package com.prowings.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prowings.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public long save(Employee employee) {
		//sessionFactory.getCurrentSession().save(employee);
		
		sessionFactory.openSession().save(employee);
		
		return employee.getId();
	}

	@Override
	public Employee get(long id) {
		return sessionFactory.openSession().get(Employee.class, id);
	}

	@Override
	public List<Employee> list() {
	      Session session = sessionFactory.openSession();
	      CriteriaBuilder cb = session.getCriteriaBuilder();
	      CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
	      Root<Employee> root = cq.from(Employee.class);
	      cq.select(root);
	      Query<Employee> query = session.createQuery(cq);
	      return query.getResultList();

	}

	@Override
	public void update(long id, Employee employee) {
	      Session session = sessionFactory.openSession();
	      session.beginTransaction();
	      Employee emp3 = session.get(Employee.class, id);
	    		  
//	      Employee emp2 = session.byId(Employee.class).load(id); //need transaction for this
	      emp3.setName(employee.getName());
	      emp3.setAddress(employee.getAddress());
	      session.update(emp3);
	      session.getTransaction().commit();
	}

	@Override
	public void delete(long id) {
	      Session session = sessionFactory.openSession();
	      session.beginTransaction();
	      Employee emp = session.get(Employee.class, id);
//	      Employee emp = session.byId(Employee.class).load(id); //need transaction for this
	      session.delete(emp);
	      session.getTransaction().commit();
	}

}
