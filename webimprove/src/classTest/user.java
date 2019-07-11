package classTest;

public class user {
	
	public user() {
		super();
	}
	public user(String username) {
		super();
		this.username = username;
		//this.password = password;
	}
	private String username;
	private String password;
	public String sex;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void sayhello(){
		System.out.println("hellocorrine");
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	
}
