package proxyTest;

public class proxy implements proxyy {

	private proxyy target;
	
	public proxy (proxyy target){
		this.target=target;
	}
	
	@Override
	public void hello() {
		target.hello();
	}
	
}
