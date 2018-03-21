package com.lqpl66.dataSource.wayOne;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/*
 * @author  lqpl66
 * @date 创建时间：2018年3月14日 下午4:13:05 
 * @function     
 */
public class DataSourceRouter extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		return HandleDataSource.getDataSource();
	}

}
