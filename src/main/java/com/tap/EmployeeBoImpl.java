package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeBoImpl implements EmployeeBo {
	static Connection con;
	static PreparedStatement pst;
	static Statement statement;
	static ResultSet res;
	
	String url = "jdbc:mysql://localhost:3306/jdbc";
	String username = "root";
	String password = "root";
	
	ArrayList<Employee> list = new ArrayList<Employee>();
	
	public EmployeeBoImpl()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url , username ,password);
				
			} 
		catch (SQLException e) {
				
				e.printStackTrace();
			}
		
		catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}
	
	@Override
	public int save(Employee e) {
		String INSERT_QUERY = "INSERT into `employee`(`id` ,`name` , `email` ,`department`, `salary`) values(?,?,?,?,?)";
		try {
			pst = con.prepareStatement(INSERT_QUERY);
			pst.setInt(1, e.getId());
			pst.setString(2, e.getName());
			pst.setString(3,e.getEmail());
			pst.setString(4, e.getDepartment());
			pst.setInt(5, e.getSalary());
			
			return pst.executeUpdate();
		}
		catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(Employee e) {
		String UPDATE_QUERY = "UPDATE `employee` SET `salary`=? WHERE `id`=?";
		try {
			pst = con.prepareStatement(UPDATE_QUERY);
			pst.setInt(1, e.getSalary());
			pst.setInt(2, e.getId());
			
			return pst.executeUpdate();
		} 
		catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(int id) {
		String DELETE_QUERY = "DELETE from `employee` WHERE `id`=?";
		try {
			pst = con.prepareStatement(DELETE_QUERY);
			pst.setInt(1, id);
			
			return pst.executeUpdate();
		} 
		catch (SQLException e) {
		
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(Employee e) {
		
		return delete(e.getId());
		
	}

	@Override
	public Employee get(Employee e) {
		String SELECT_QUERY = "SELECT * from `employee`";
		try {
			statement = con.createStatement();
			res = statement.executeQuery(SELECT_QUERY);
			
			while(res.next())
			{
				int id = res.getInt(e.getId());
				String name = res.getString(e.getName());
				String email = res.getString(e.getEmail());
				String department = res.getString(e.getDepartment());
				int salary = res.getInt(e.getSalary());
				
				Employee e1 = new Employee();
				return e1;
			}
		} 
		catch (SQLException e1) {
			
			e1.printStackTrace();
		}
	return null;
	}

	@Override
	public List<Employee> getAll() {
		String SELECT_QUERY = "SELECT * from `employee`";
		try {
			statement = con.createStatement();
			res = statement.executeQuery(SELECT_QUERY);
			
			while(res.next())
			{
				int id = res.getInt("id");
				String name = res.getString("name");
				String email = res.getString("email");
				String department = res.getString("department");
				int salary = res.getInt("salary");
				
				Employee e1 = new Employee(id , name,email,department,salary);
				list.add(e1);
			
			}
			
		} 
		catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		return list;
	}

}
