package DBUtils;

public class user {
	private Integer age ;
	private String name ;
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public user(Integer age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	public user() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return age+name;
}
	
	
}
