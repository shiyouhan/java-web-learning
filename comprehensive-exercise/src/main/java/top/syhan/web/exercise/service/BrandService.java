package top.syhan.web.exercise.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import top.syhan.web.exercise.entity.Brand;
import top.syhan.web.exercise.mapper.BrandMapper;
import top.syhan.web.exercise.util.SqlSessionFactoryUtil;

import java.util.List;

/**
* @program: java-web-learning
*
* @description:
*
* @author: SYH
*
* @create: 2022-03-01 13:10
**/public class BrandService {
    SqlSessionFactory factory = SqlSessionFactoryUtil.getSqlSessionFactory();

    /**
     * 查询所有
     *
     * @return List<Brand>
     */
    public List<Brand> selectAll() {
        //1. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //2. 获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //3. 调用方法
        List<Brand> brands = mapper.selectAll();
        sqlSession.close();
        return brands;
    }

    /**
     * 添加
     *
     * @param brand brand对象
     */
    public void add(Brand brand) {
        //1. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //2. 获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //3. 调用方法
        mapper.add(brand);
        //4. 提交事务
        sqlSession.commit();
        //5. 释放资源
        sqlSession.close();
    }

    /**
     * 根据id查询
     *
     * @return Brand
     */
    public Brand selectById(int id) {
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = mapper.selectById(id);
        sqlSession.close();
        return brand;
    }

    /**
     * 修改
     *
     * @param brand brand对象
     */
    public void update(Brand brand) {
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.update(brand);
        sqlSession.commit();
        sqlSession.close();
    }

    public void deleteById(int id) {
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.deleteById(id);
        sqlSession.commit();
        sqlSession.close();
    }
}
