package invacation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class invocation<T> implements InvocationHandler{
	//动态代理类
	private T target;
	
	
	
	public invocation(T target) {
		this.target = target;
	}



	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("代理执行"+method.getName()+"方法");
		long timestart = System.currentTimeMillis();
		Object result = method.invoke(target, args);
		long timeout = System.currentTimeMillis();
		System.out.println(timeout-timestart);
		return result;
	}

}
