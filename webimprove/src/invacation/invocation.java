package invacation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class invocation<T> implements InvocationHandler{
	//��̬������
	private T target;
	
	
	
	public invocation(T target) {
		this.target = target;
	}



	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("����ִ��"+method.getName()+"����");
		long timestart = System.currentTimeMillis();
		Object result = method.invoke(target, args);
		long timeout = System.currentTimeMillis();
		System.out.println(timeout-timestart);
		return result;
	}

}
