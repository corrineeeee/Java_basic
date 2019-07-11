package reflectTest;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class demo {

	@Test
	public void test1() throws ClassNotFoundException, InstantiationException,
			IllegalAccessException {

		Class<?> clazz = Class.forName("reflectTest.person");

		Object user = clazz.newInstance();

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("username", "corrine");
		map.put("nickname", "pam");
		map.put("age", 21);
		map.put("address", "…Ó€⁄");

		Field[] fields = clazz.getDeclaredFields();

		Set<String> key = map.keySet();

		for (Field field : fields) {
			String name = field.getName();
			if (key.contains(name)) {
				field.setAccessible(true);
				field.set(user, map.get(name));
			}
		}

		System.out.println(user.toString());
	}

	@Test
	public void test2() throws Exception {
		Class<?> clazz = Class.forName("reflectTest.person");

		Object user = clazz.newInstance();

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("username", "corrine");
		map.put("nickname", "pam");
		map.put("age", 21);
		map.put("address", "…Ó€⁄");
		
		Method[] methods = clazz.getDeclaredMethods();
		for (String key : map.keySet()) {
			String methodname = "set"+key;
			for (Method method : methods) {
				String name = method.getName();
				if(name.equalsIgnoreCase(methodname)){
					method.invoke(user, map.get(key));
				}
			}
		}
		System.out.println(user.toString());
	}
}
