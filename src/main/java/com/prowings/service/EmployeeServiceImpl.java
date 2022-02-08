package com.prowings.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prowings.dao.EmployeeDao;
import com.prowings.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeDao employeeDao;
	
//	@Transactional
	@Override
	public long save(Employee employee) {
		return employeeDao.save(employee);
	}

	@Override
	public Employee get(long id) {
		return employeeDao.get(id);
	}

	@Override
	public List<Employee> list() {
		return employeeDao.list();
	}

	@Override
	public void update(long id, Employee employee) {
		employeeDao.update(id, employee);
	}

	@Override
	public void delete(long id) {
		employeeDao.delete(id);
	}

}
