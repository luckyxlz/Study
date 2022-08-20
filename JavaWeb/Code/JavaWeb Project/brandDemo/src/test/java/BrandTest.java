import com.lucky.mapper.BrandMapper;
import com.lucky.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrandTest {
    @Test
    public void selectAllTest() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = mapper.selectAll();

        System.out.println(brands);
        //释放资源
        sqlSession.close();
    }
    @Test
    public void selectByCondition() throws IOException {
        int status = 1;
        String brandName = "华为";
        String companyName = "华为";
        brandName = "%"+brandName+"%";
        companyName = "%"+companyName+"%";



        //封装对象
//        Brand brand = new Brand();
//        brand.setBrandName(brandName);
//        brand.setStatus(status);
//        brand.setCompanyName(companyName);

        //map传参
        Map map = new HashMap();
//        map.put("status",status);
        map.put("companyName",companyName);
        map.put("brandName",brandName);

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //散装函数
//        List<Brand> brands = mapper.selectByCondition(status,companyName,brandName);
        //对象传参
//        List<Brand> brands = mapper.selectByCondition(brand);
        //map参数
        List<Brand> brands = mapper.selectByCondition(map);


        System.out.println(brands);
        //释放资源
        sqlSession.close();
    }

    @Test
    public void selectByConditionSingle() throws IOException {
        int status = 1;
        String brandName = "华为";
        String companyName = "华为";
        brandName = "%"+brandName+"%";
        companyName = "%"+companyName+"%";



//        封装对象
        Brand brand = new Brand();
//        brand.setBrandName(brandName);
//        brand.setStatus(status);
//        brand.setCompanyName(companyName);

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
//        对象传参
        List<Brand> brands = mapper.selectByConditionSingle(brand);

        System.out.println(brands);
        //释放资源
        sqlSession.close();
    }

    @Test
    public void Add() throws IOException {
        int status = 1;
        String brandName = "波导";
        String companyName = "波导手机";
        String description = "手机中的战斗机";
        int ordered = 100;




//        封装对象
        Brand brand = new Brand();
        brand.setBrandName(brandName);
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setOrdered(ordered);
        brand.setDescription(description);

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //执行SQL
        mapper.add(brand);
        Integer id = brand.getId();
        System.out.println(id);

        //释放资源
        sqlSession.close();
    }


    @Test
    public void Update() throws IOException {
        int status = 0;
        String brandName = "波导";
        String companyName = "波导手机";
        String description = "波导手机，手机中的战斗机";
        int ordered = 100;
        int id = 9;




//        封装对象
        Brand brand = new Brand();
//        brand.setBrandName(brandName);
        brand.setStatus(status);
//        brand.setCompanyName(companyName);
//        brand.setOrdered(ordered);
//        brand.setDescription(description);
        brand.setId(id);

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //执行SQL
        int count = mapper.update(brand);
        System.out.println(count);

        //释放资源
        sqlSession.close();
    }

    @Test
    public void DeleteById() throws IOException {

        int id = 9;

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //执行SQL
        mapper.deleteById(id);

        //释放资源
        sqlSession.close();
    }

    @Test
    public void DeleteByIds() throws IOException {

        int [] ids = {10,11,12};

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //执行SQL
        System.out.println(mapper.deleteByIds(ids));

        //释放资源
        sqlSession.close();
    }
}
