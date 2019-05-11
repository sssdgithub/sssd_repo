import com.sssd.mybatis.entity.User;
import com.sssd.mybatis.mapper.RoleMapper;
import com.sssd.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class Many2Many {
    private SqlSession session;
    private UserMapper userMapper;
    private RoleMapper roleMapper;
    @Before
    public void init() throws Exception{
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
        session = sessionFactory.openSession();
        userMapper = session.getMapper(UserMapper.class);
        roleMapper = session.getMapper(RoleMapper.class);
    }
    @After
    public void destory(){
        session.close();
    }
    @Test
    public void userFind(){
        List<User> userList = userMapper.findAll();
        for(User user:userList){
            System.out.println(user);
        }
    }
    @Test
    public void roleFind(){

    }
}
