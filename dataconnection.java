package employeeproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class dataconnection {
	
	
	Connection getconnection() throws ClassNotFoundException, SQLException
	{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/newdatabase","root","root");
	}
	
	int insertdata(employee_details e1 ) throws ClassNotFoundException, SQLException
	{
		Connection con=getconnection();
		PreparedStatement pst=con.prepareStatement("insert into employee values(?,?,?,?)");
		pst.setInt(1,e1.getid());
		pst.setString(2, e1.getname());
		pst.setString(3, e1.getemailid());
		pst.setLong(4, e1.getcontact());
		
		return pst.executeUpdate();
	}
	int deletedata(int id) throws ClassNotFoundException, SQLException
	{
		Connection con=getconnection();
		PreparedStatement pst=con.prepareStatement("delete from employee where id=?");
		pst.setInt(1, id);
	
		return pst.executeUpdate();
	}
	
	employee_details fetchbyid(int id) throws ClassNotFoundException, SQLException
	{
		Connection con=getconnection();
		PreparedStatement pst=con.prepareStatement("select * from employee where id=?");
		pst.setInt(1,id);
		ResultSet rs=pst.executeQuery();
		
		rs.next();
		return new employee_details(rs.getInt("id"),rs.getString("name"),rs.getString("emailid"),rs.getLong("contact"));
		
		
	}
	ArrayList<employee_details> feachall() throws ClassNotFoundException, SQLException
	{
		ArrayList<employee_details> a1=new ArrayList<employee_details>();
		Connection con=getconnection();
		PreparedStatement pst =con.prepareStatement("select * from employee");
		ResultSet rs=pst.executeQuery();
		
		while(rs.next())
		{
			a1.add(new employee_details(rs.getInt("id"), rs.getString("name"), rs.getString("emailid"), rs.getLong("contact")));
			
		}
		
		return a1;
		
	}

}
