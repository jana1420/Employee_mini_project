package employeeproject;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/employee1")
public class employeeservelt extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		res.getWriter().print("------------------------------------------");
		int id=Integer.parseInt(req.getParameter("eid"));
		String name=req.getParameter("ename");
		String email=req.getParameter("eemail");
		long contact=Long.parseLong(req.getParameter("econtact"));
		
		employee_details e1=new employee_details(id, name, email, contact);
		dataconnection d1=new dataconnection();
		
		try {
			int a=d1.insertdata(e1);
			res.getWriter().print(a+"row inserted");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
