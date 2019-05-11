import com.sssd.mybatis.entity.Card;
import com.sssd.mybatis.entity.User;
import com.sssd.mybatis.mapper.CardMapper;
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

public class One2OneTest {
    private SqlSession session;
    private UserMapper userMapper;
    private CardMapper cardMapper;

    @Before
    public void init()throws Exception{
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
        session = sessionFactory.openSession();
        userMapper = session.getMapper(UserMapper.class);
        cardMapper = session.getMapper(CardMapper.class);
    }
    @After
    public void destroy(){
        session.close();
    }
    @Test
    public void userFindAll(){
        List<User> userList = userMapper.findAll();
        for(User user:userList){
            System.out.println(user);
        }
    }
    @Test
    public void userFindById(){
        User user = userMapper.findById(3);
        System.out.println(user);
    }
    @Test
    public void cardFindAll(){
        List<Card> cardList = cardMapper.findAll();
//        for(Card card:cardList){
//            System.out.println(card);
//        }
    }
}
