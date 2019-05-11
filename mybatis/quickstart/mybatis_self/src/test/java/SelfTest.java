import com.sssd.mybatis.entity.Menu;
import com.sssd.mybatis.mapper.MenuMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class SelfTest {
    private SqlSession session;
    private MenuMapper menuMapper;
    @Before
    public void init() throws Exception{
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
        session = sessionFactory.openSession();
        menuMapper = session.getMapper(MenuMapper.class);
    }
    @After
    public void destroy(){
        session.close();
    }
    @Test
    public void findAll(){
        List<Menu> menuList = menuMapper.findAll();
        for(Menu menu:menuList){
            System.out.println(menu);
        }
    }
}
