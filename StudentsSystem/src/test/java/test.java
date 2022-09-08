import com.zzm.mapper.ScoreMapper;
import com.zzm.mapper.StudentMapper;
import com.zzm.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author ZZM
 * @creatTime 2022-09-07  16:38
 */
public class test {
    static SqlSession sqlSession=null;
    static {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession
        sqlSession=sqlSessionFactory.openSession();
    }
    static ScoreMapper scoreMapper=sqlSession.getMapper(ScoreMapper.class);
    static StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
    @Test
    public void testSelectByStudentNumber(){
        Student student = studentMapper.selectByStudentNumber(3);
        System.out.println(student);
    }

}
