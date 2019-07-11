package invacation;

public class proxyTest {
	//¾²Ì¬´úÀí
	public static void main(String[] args) {
		
		person stu = new student("corrine ");
		person proxymonitor = new studentproxy(stu);
		proxymonitor.givemoney();
		
		
	}
}
