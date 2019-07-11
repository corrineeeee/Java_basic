package invacation;

public class student implements person{
	
	private String studentname;
	
	
	public student(String studentname) {
		super();
		this.studentname = studentname;
	}


	public student() {
		super();
	}

	
	public String getStudentname() {
		return studentname;
	}


	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}


	@Override
	public void givemoney() {
	 	System.out.println(studentname+"give money");
	}

}
