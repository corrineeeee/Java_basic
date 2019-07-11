package corrineday01;

public class ticketthread implements Runnable{
	int tickets = 100;

	public ticketthread(int tickets) {
		super();
		this.tickets = tickets;
	}

	@Override
	public void run() {
		while(true){
			if(tickets>0){
				System.out.println(Thread.currentThread().getName()+tickets--);
			}
		}
		
	}
	
	
}
