package com.tap;

import java.util.List;

    public interface EmployeeBo {
	public int save(Employee e);
	public int update(Employee e);
	public int delete(int id);
	public int delete(Employee e);
	public Employee get(Employee e);
	public List<Employee> getAll();

}
