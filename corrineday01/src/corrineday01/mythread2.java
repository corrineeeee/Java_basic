package corrineday01;

public class mythread2 implements Runnable{
	int num;
	
	public mythread2(int num) {
		this.num = num;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName()+i);
		}
	}
	
}
