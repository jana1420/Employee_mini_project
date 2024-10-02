package employeeproject;

public class employee_details {
	
	private int id;
	private String name;
	private String emailid;
	private long contact;
	

    employee_details(int id,String name,String emailid,long contact) {
    	
    	this.id=id;
		this.name=name;
		this.emailid=emailid;
		this.contact=contact;
	}
    
    int getid()
    {
    	return id;
    }
     String getname()
    {
    	return name;
    }
    String getemailid()
    {
    	return emailid;
    }
    long getcontact()
    {
    	return contact;
    }
    
    void setid(int id)
    {
    	this.id=id;
    }
    void setname(String name)
    {
    	this.name=name;
    }
    void setemail(String emailid)
    {
    	this.emailid=emailid;
    }
    void setcontact(long contact)
    {
    	this.contact=contact;
    }

	@Override
	public String toString() {
		return "employee_details [id=" + id + ", name=" + name + ", emailid=" + emailid + ", contact=" + contact + "]";
	}
    
}
