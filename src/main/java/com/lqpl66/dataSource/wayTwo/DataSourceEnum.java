package com.lqpl66.dataSource.wayTwo;

/*
 * @author  lqpl66
 * @date 创建时间：2018年3月14日 下午4:29:12 
 * @function     
 */
public enum DataSourceEnum {
	// 主库
	MASTER("dataMasterSource", true),
	// 从库
	SLAVE("dataSlaveSource", false),;

	// 数据源名称
	private String name;
	// 是否是默认数据源
	private boolean master;

	DataSourceEnum(String name, boolean master) {
		this.name = name;
		this.master = master;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isMaster() {
		return master;
	}

	public void setMaster(boolean master) {
		this.master = master;
	}

	public String getDefault() {
		String defaultDataSource = "";
		for (DataSourceEnum dataSourceEnum : DataSourceEnum.values()) {
			if (!"".equals(defaultDataSource)) {
				break;
			}
			if (dataSourceEnum.master) {
				defaultDataSource = dataSourceEnum.getName();
			}
		}
		return defaultDataSource;
	}
}
