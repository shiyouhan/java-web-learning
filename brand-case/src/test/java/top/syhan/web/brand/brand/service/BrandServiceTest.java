package top.syhan.web.brand.brand.service;

import org.junit.jupiter.api.Test;
import top.syhan.web.brand.pojo.Brand;
import top.syhan.web.brand.service.BrandService;
import top.syhan.web.brand.service.impl.BrandServiceImpl;
import top.syhan.web.brand.pojo.PageBean;

import java.util.List;

/**
 * @program: java-web-learning
 * @description:
 * @author: SYH
 * @create: 2022-03-04 19:48
 **/
class BrandServiceTest {
    private final BrandService brandService  = new BrandServiceImpl();

    @Test
    void selectAll() {
        List<Brand> brands = brandService.selectAll();
        brands.forEach(System.out::println);
    }

    @Test
    void add() {
        Brand brand = new Brand();
        brand.setBrandName("测试品牌");
        brand.setCompanyName("测试品牌公司");
        brand.setDescription("测试品牌");
        brand.setOrdered(111);
        brand.setStatus(1);
        brandService.add(brand);
    }

    @Test
    void deleteByIds() {
        int[] ids = {1, 2, 3};
        brandService.deleteByIds(ids);
    }

    @Test
    void selectByPage() {
        PageBean<Brand> brandPageBean = brandService.selectByPage(2, 6);
        List<Brand> brands = brandPageBean.getRows();
        brands.forEach(System.out::println);
    }

    @Test
    void selectByPageAndCondition() {
        Brand brand = new Brand();
        brand.setBrandName("小米");
        PageBean<Brand> brandPageBean = brandService.selectByPageAndCondition(2, 10, brand);
        List<Brand> brands = brandPageBean.getRows();
        brands.forEach(System.out::println);
    }
}
