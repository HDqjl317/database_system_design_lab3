package table;

public class Persons {
	
	private String userName;
	private String name;
	private String age;
	private String teleNo;
	
	public Persons() {
		this.userName = null;
		this.name = null;
		this.age = null;
		this.teleNo = null;
	}
	
	public Persons(String uName, String dname, String dage, String dteleNo) {
		this.userName = uName;
		this.name = dname;
		this.age = dage;
		this.teleNo = dteleNo;
	}
	
	public void setUserName(String uName) {
		this.userName = uName;
	}
	
	public String getUserName() {
		return this.userName;
	}
	
	public void setName(String pName) {
		this.name = pName;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setAge(String pAge) {
		this.age = pAge;
	}
	
	public String getAge() {
		return this.age;
	}
	
	public void setTeleNo(String tNo) {
		this.teleNo = tNo;
	}
	
	public String getTeleNo() {
		return this.teleNo;
	}
	
	public String getPersons() {
		
		String temp = "'" + this.userName + "','" + this.name + "'";
		
		if( this.getAge() != null ) {
			temp = temp + ",'" + this.getAge() + "'";
		}
		
		if( this.getTeleNo() != null ) {
			temp = temp + ",'" + this.getTeleNo() + "'";
		}
		
		return temp;
	}
	
}