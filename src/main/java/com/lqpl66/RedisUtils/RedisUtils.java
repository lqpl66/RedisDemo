package com.lqpl66.RedisUtils;

import java.io.Serializable;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/*
 * @author  lqpl66
 * @date 创建时间：2018年3月8日 上午10:12:01 
 * @function     
 */
@Service
public class RedisUtils {
	private static final Logger logger = Logger.getLogger(RedisUtils.class.getName());
	@Resource
	protected RedisTemplate<Serializable, Serializable> redisTemplate;

	/**
	 * 
	 * @description 根据key存储object
	 * @param key键
	 *            value 存储的对象
	 * @return boolean 存储成功或失败的标志
	 */
	public boolean saveObject(String key, Object value) {
		return false;
	}

	/**
	 * 
	 * @description 根据key获取object
	 * @param key键
	 * @return Object 与key对应的object
	 */
	public Object getObject(String key) {
		return null;
	}

	/**
	 * 
	 * @description 根据key删除数据
	 * @param key键
	 * @return boolean 删除成功或失败的标志
	 */
	public boolean deleteKey(String key) {
		return false;
	}
}
