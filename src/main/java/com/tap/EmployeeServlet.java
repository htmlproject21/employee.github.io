package com.tap;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeServlet extends HttpServlet {
	
	public void service(HttpServletRequest req , HttpServletResponse resp) {
		int id = req.getParameter("id")!= null ? Integer.parseInt(req.getParameter("id")) : 0 ;
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String department = req.getParameter("department");
		int salary = req.getParameter("salary")!=null ? Integer.parseInt(req.getParameter("salary")) :0;
		
		Employee e = new Employee(id , name , email , department, salary);
		EmployeeBoImpl bo = new EmployeeBoImpl();
		
		int i1 = bo.save(e);
		int i2 = bo.update(e);
		int i3 = bo.delete(id);
		int i4 = bo.delete(e);
		
		try {
			PrintWriter out = resp.getWriter();
			if(i1 == 1)
			{
				out.println("Employee details saved successfully");
			}
			if(i2 == 1)
			{
				out.println("Employee details Updated successfully");
			}
			if(i3 == 1)
			{
				out.println("Employee details Deleted successfully");
			}
			if(i4 == 1)
			{
				out.println("Employee details Deleted successfully");
			}
			
		}
		catch (IOException e1) {
			
			e1.printStackTrace();
		}
	}

}
