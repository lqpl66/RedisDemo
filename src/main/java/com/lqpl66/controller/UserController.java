package com.lqpl66.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.lqpl66.bean.User;
import com.lqpl66.dataSource.wayTwo.DynamicDataSource;
import com.lqpl66.mapper.UserMapper;

/*
 * @author  lqpl66
 * @date 创建时间：2018年3月1日 下午3:04:03 
 * @function     
 */
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserMapper userMapper;
	@Resource(name = "redisTemplate")
	private RedisTemplate<String, Object> template;
	private Logger log = Logger.getLogger(UserController.class);

	@RequestMapping("/getUser")
	@ResponseBody
	public String getUser() {
		return "ddd";

	}

	/**
	 * 
	 * @description  数据源手动切换，默认加载dataMasterSource
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/getUserList")
	@ResponseBody
	public JSONArray getUserList() {
		DynamicDataSource.setDataSource("dataMasterSource");
		List<User> list = userMapper.selectAll();
		DynamicDataSource.clearDataSource();
		DynamicDataSource.setDataSource("dataSlaveSource");
		List<User> list2 = userMapper.selectAll();
		DynamicDataSource.clearDataSource();
		JSONArray result = new JSONArray();
		result.addAll(list);
		result.addAll(list2);
		return result;
	}

	@RequestMapping("/saveUser")
	@ResponseBody
	public JSONArray saveUser() {
		List<User> list = userMapper.selectAll();
		User u = new User();
		u.setAge(list.size() + 1);
		u.setUsername("44");
		userMapper.insert(u);
		JSONArray result = new JSONArray();
		List<User> list1 = userMapper.selectAll();
		result.addAll(list1);
		return result;
	}

	@RequestMapping(value = "/getUserListByCache")
	@ResponseBody
	public JSONArray getUserListByCache() {
		List<User> list = new ArrayList<User>();
		JSONArray result = new JSONArray();
		if (template.hasKey("userList")) {
			result = JSONArray.parseArray(template.opsForValue().get("userList").toString());
		} else {
			list = userMapper.selectAll();
			result.addAll(list);
			template.opsForValue().set("userList", result.toString());
		}
		return result;
	}
	
	@RequestMapping(value = "/getUserListBy")
	@ResponseBody
	public JSONArray getUserListBy() {
		List<User> list = new ArrayList<User>();
		JSONArray result = new JSONArray();
		if (template.hasKey("userList")) {
			result = JSONArray.parseArray(template.opsForValue().get("userList").toString());
		} else {
			list = userMapper.selectAll();
			result.addAll(list);
			template.opsForValue().set("userList", result.toString());
		}
		return result;
	}
}
