import com.sssd.mybatis.entity.Order;
import com.sssd.mybatis.entity.User;
import com.sssd.mybatis.mapper.OrderMapper;
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

public class MybatisAnnotationTest {
    private SqlSession session;
    private UserMapper userMapper;
    private OrderMapper orderMapper;
    @Before
    public void init() throws  Exception{
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
        session = sessionFactory.openSession();
        userMapper = session.getMapper(UserMapper.class);
        orderMapper = session.getMapper(OrderMapper.class);
    }
    @After
    public void destroy(){
        session.close();
    }
    @Test
    public void userFindAll(){
        List<User> userList = userMapper.findAll();
//        for(User user:userList){
//            System.out.println(user);
//        }
    }
    @Test
    public void userSave(){
        User user = new User();
        user.setUsername("console");
        user.setPassword("console");
        userMapper.save(user);
    }
    @Test
    public void userUpdate(){
        User user = new User();
        user.setUid(3);

        user.setUsername("mybatis udpate");
        userMapper.update(user);
    }
    @Test
    public void userDelete(){
        userMapper.delete(1);
    }
    @Test
    public void userFindCount(){
        Integer count = userMapper.findTotal();
        System.out.println(count);
    }
    @Test
    public void userFindByUsername(){
        List<User> userList = userMapper.findByUsername("%s%");
        for(User user:userList){
            System.out.println(user);
        }
    }
    @Test
    public void userFindById(){
        User user = userMapper.findById(2);
        System.out.println(user);
    }

    @Test
    public void orderFindAll(){
        List<Order> orderList = orderMapper.findAll();
        for(Order order:orderList){
            System.out.println(order);
        }
    }


}
