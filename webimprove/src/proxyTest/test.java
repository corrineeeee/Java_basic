package proxyTest;

import org.junit.Test;

public class test {
	
	@Test
	public void test1(){
		proxyy proxy = new real();
		proxy.hello();
	}
	
	@Test
	public void test2(){
		proxyy target = new real();
		proxyy proxy = new proxy(target);
		proxy.hello();
	}
}
