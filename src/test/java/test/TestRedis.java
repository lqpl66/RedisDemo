package test;
/*
 * @author  lqpl66
 * @date 创建时间：2018年3月13日 下午1:07:07 
 * @function     
 */

import redis.clients.jedis.Jedis;

public class TestRedis {
	public static void main(String[] args) {
		Jedis je = new Jedis("101.200.53.139", 6379);
		System.out.println(je.get("k1"));
	}
}
