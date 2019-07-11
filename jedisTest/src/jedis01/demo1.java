package jedis01;

import redis.clients.jedis.Jedis;

public class demo1 {
	
	public static void main(String[] args) {
		Jedis jedis = new Jedis("192.168.153.128");
		jedis.set("name", "corrine");
		System.out.println(jedis.get("name"));
		
	}
}
