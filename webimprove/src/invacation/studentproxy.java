package invacation;

public class studentproxy implements person{

	//person stu = new student();
	
	private person stu;
	
	

	public  studentproxy(person stu){
		this.stu = stu;
	}
	
	@Override
	public void givemoney() {
		stu.givemoney();
	}
	
}
