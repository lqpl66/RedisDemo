package test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import com.alibaba.fastjson.JSONArray;
import com.lqpl66.bean.User;
import com.lqpl66.mapper.UserMapper;

/*
 * @author  lqpl66
 * @date 创建时间：2018年3月21日 下午2:28:15 
 * @function     
 */
public class TestAche {
	public SqlSessionFactory getSqlSessionFactory() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream);
	}
	@Test
	public void getStudentById() throws Exception {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
//        SqlSession sqlSession = factory.openSession(true); // 自动提交事务
		SqlSession openSession = sqlSessionFactory.openSession();
        UserMapper userMapper = openSession.getMapper(UserMapper.class);
        List<User> list = userMapper.selectAll();
		JSONArray result = new JSONArray();
		result.addAll(list);
        System.out.println(result.toString());
    }
}
