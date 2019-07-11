package invacation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class invocationTest{
	//¶¯Ì¬´úÀí

		//private static Class<?>[] person;

		public static void main(String[] args) {
			
			person stu = new student("corrine");
			InvocationHandler invocation = new invocation(stu);
			//person instance = (invacation.person) Proxy.newProxyInstance(person.class.getClassLoader(), person, invocation);
			person instance = (invacation.person) Proxy.newProxyInstance(person.class.getClassLoader(),  new Class<?>[] {person.class}, invocation);
			
			instance.givemoney();
		

	}	
}
