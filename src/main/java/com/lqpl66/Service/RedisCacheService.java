package com.lqpl66.Service;

import org.springframework.stereotype.Service;

/*
 * @author  lqpl66
 * @date 创建时间：2018年3月8日 上午10:06:38 
 * @function     
 */
@Service
public class RedisCacheService {
	/**
	 * 
	 * @description 根据id缓存数据
	 * @param id和sessionObject不允许为null或空值。
	 *            数据库若已存在同名键，则会覆盖掉
	 * @return
	 */
	public boolean putCaCheObject(String id, Object CacheObject) {
		return false;
	}

	/**
	 * 
	 * @description 根据id删除已缓存的数据
	 * @param id不允许为null和空值
	 * @return
	 */
	public boolean clearSessionObject(String id) {
		return false;
	}

	/**
	 * 
	 * @description 根据id获取已缓存的缓存数据
	 * @param id不允许为null和空值
	 * @return
	 */
	public Object getsessionObject(String id) {
		return null;
	}
}
