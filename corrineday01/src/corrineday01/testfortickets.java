package corrineday01;

public class testfortickets {
	public static void main(String[] args) {
		ticketthread tt = new ticketthread(100);
		Thread t = new Thread(tt);
		t.setName("corrine-sale");
		Thread t1 = new Thread(tt);
		t1.setName("people-sale");
		t.start();
		t1.start();
	}
}
