package table;

public class Users {
	
	private String userName;
	private String pass;
	
	public Users(){
		this.userName = null;
		this.pass = null;
	}
	
	public Users(String uName, String password) {
		this.userName = uName;
		this.pass = password;
	}
	
	public void setUserName(String uName) {
		this.userName = uName;
	}
	
	public String getUserName() {
		return this.pass;
	}
	
	public void setPass(String passWord) {
		this.pass = passWord;
	}
	
	public String getPass() {
		return this.pass;
	}
	
	public String getUser() {
		String temp = "'" + this.userName + "','" + this.pass + "'";
		return temp;
	}
}