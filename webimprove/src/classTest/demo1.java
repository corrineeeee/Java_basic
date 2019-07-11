package classTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

public class demo1 {
	
	private static final Object String = null;

	@Test
	public void test1(){
		user user = new user();
		Class class1 = user.getClass();
		System.out.println(class1);
	}
	
	@Test
	public void test2(){
		Class class1 = user.class;
		System.out.println(class1);
	}
	
	@Test
	public void test3() throws ClassNotFoundException{
		Class class1 = Class.forName("classTest.user");
		System.out.println(class1);
	}
	//constructor
	@Test
	public void test4() throws Exception {
		Class clazz = Class.forName("classTest.user");
		Constructor constructor = clazz.getConstructor();
		System.out.println(constructor);
	}
	
	@Test
	public void test5() throws NoSuchMethodException, SecurityException{
		Class clazz = user.class;
		Constructor ct = clazz.getConstructor(String.class);
		System.out.println(ct);
	}
	
	@Test
	public void test6(){
		Class clazz = user.class;
		Constructor[] cts = clazz.getConstructors();
		for (Constructor constructor : cts) {
			System.out.println(constructor);
		}
	}
	//field
	@Test
	public void test7() throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		Class<?> clazz = Class.forName("classTest.user");
		Field field = clazz.getField("sex");
		System.out.println(field);
	}
	
	@Test
	public void test8() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		Class clazz = user.class;
		Field field = clazz.getDeclaredField("username");
		System.out.println(field);
		
	}
	
	@Test
	public void test9() throws IllegalArgumentException, IllegalAccessException{
		Class clazz = user.class;
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			System.out.println(field);
		}
	}
	//method
	@Test
	public void test10() throws NoSuchMethodException, SecurityException{
		Class clazz = user.class;
		Method method = clazz.getMethod("sayhello");
		System.out.println(method);
		Method[] methods = clazz.getMethods();
		for (Method method2 : methods) {
			System.out.println(method2);
		}
	}
	
	@Test
	public void test11() throws ClassNotFoundException{
		Class<?> clazz = Class.forName("classTest.user");
		Method[] methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println(method);
		}
	}
}
