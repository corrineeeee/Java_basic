package jedis01;





import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class demo2 {
	
	Jedis jedis = new Jedis("192.168.153.128");
	private String Map;
	//HASH
	@Test
	public void test1(){
		jedis.set("name", "corrine");
		System.out.println(jedis.get("name"));
	}
	
	@Test
	public void test2(){
		jedis.mset("name","corrine","pswd","0616");
		List<String> list = jedis.mget("name","pswd");
		System.out.println(list);
		}
	
	@Test
	public void test3(){
		jedis.hset("map", "name", "corrine");
		String string = jedis.hget("map", "name");
		System.out.println(string);
	}
	
	@Test
	public void test4(){
		Long long1 = jedis.hsetnx("map", "name", "corrine");
		jedis.hsetnx("map", "age", "21");
		System.out.println(long1);
		Boolean boolean1 = jedis.hexists("map", "name");
		System.out.println(boolean1);
		Long long2 = jedis.hlen("map");
		System.out.println(long2);
		//Long long3 = jedis.hdel("map", "age");
		//System.out.println(long3);
		Set<String> set = jedis.hkeys("map");
		System.out.println(set);
		List<String> list = jedis.hvals("map");
		System.out.println(list);
		List<String> list2 = jedis.hmget("map", "name");
		System.out.println(list2);
	}
	
	//SET
	@Test
	public void test5(){
		Long sadd = jedis.sadd("set01", "corrine","puffy","cora");
		System.out.println(sadd);
		jedis.sadd("set02", "corrine","ff");
		Long scard = jedis.scard("set01");
		System.out.println(scard);
		Boolean boolean1 = jedis.sismember("set01", "corrine");
		System.out.println(boolean1);
		Set<String> set = jedis.smembers("set01");
		System.out.println(set);
		//String string = jedis.spop("set01");
		//System.out.println(string);
		//String string2 = jedis.srandmember("set01");
		//System.out.println(string2);
		//Long long1 = jedis.srem("set01", "puffy");
		//System.out.println(long1);
		Set<String> sdiff = jedis.sdiff("set01","set02");
		System.out.println(sdiff);
		Long long1 = jedis.sdiffstore("set01", "set02");
		System.out.println(long1);
		Set<String> sinter = jedis.sinter("set01","set02");
		System.out.println(sinter);
		Set<String> sunion = jedis.sunion("set01","set02");
		System.out.println(sunion);
	}
	
	//SORTEDSET
	@Test
	public void test6(){
		Map<String,Double> map2 = new HashMap<String, Double>();
		map2.put("puffy", 80.0);
		map2.put("cora", 90.0);
		Long zadd = jedis.zadd("ss01", 90.0,"corrine");
		jedis.zadd("ss01", map2);
		System.out.println(zadd);
		Double zincrby = jedis.zincrby("ss02", 10, "puffy");
		System.out.println(zincrby);
	}
	
}
