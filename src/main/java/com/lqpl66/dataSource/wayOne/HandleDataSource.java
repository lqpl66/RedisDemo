package com.lqpl66.dataSource.wayOne;

/*
 * @author  lqpl66
 * @date 创建时间：2018年3月14日 下午4:14:09 
 * @function     
 */
public class HandleDataSource {
	// 数据源名称线程池
	private static final ThreadLocal<String> holder = new ThreadLocal<String>();

	/**
	 * 设置数据源
	 * 
	 * @param datasource
	 *            数据源名称
	 */
	public static void setDataSource(String datasource) {
		holder.set(datasource);
	}

	/**
	 * 获取数据源
	 * 
	 * @return 数据源名称
	 */
	public static String getDataSource() {
		return holder.get();
	}

	/**
	 * 清空数据源
	 */
	public static void clearDataSource() {
		holder.remove();
	}
}
