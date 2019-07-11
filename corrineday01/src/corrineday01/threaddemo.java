package corrineday01;

public class threaddemo {

	public static void main(String[] args) {
		mythread mt = new mythread();
		mt.setName("corrine");
		mt.start();
		
		mythread mt1 = new mythread();
		mt1.setName("people");
		mt1.start();
		
		
	}
}
