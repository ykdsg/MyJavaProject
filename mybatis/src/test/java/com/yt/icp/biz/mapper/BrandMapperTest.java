package com.yt.icp.biz.mapper;

import com.google.common.collect.Lists;
import com.yt.icp.biz.domain.entity.Brand;
import io.github.benas.jpopulator.impl.PopulatorBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * .
 *
 * @author wuzheng.yk
 * @since 16/6/21
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-context.xml" })
public class BrandMapperTest {

    @Autowired
    BrandMapper brandMapper;

    private Brand brand = new PopulatorBuilder().build().populateBean(Brand.class);

    {
        brand.setId(null);
        brand.setIsDeleted(0);
        brand.setSort(0);
        brand.setIsHide(1);
        brand.setIsSelfJoin(0);
        brand.setIsSupportReturn(0);
    }

    @Test
    public void testInsert() {
        int result = brandMapper.insert(brand);
        Assert.assertEquals(1, result);
        Assert.assertNotNull(brand.getId());
        System.out.println("=============brandId=" + brand.getId());

    }

    @Test
    public void testupdateBrand() {
        int result = brandMapper.insert(brand);
        Assert.assertEquals(1, result);

        brand.setEditor("putiupdate");
        brand.setName("putiBrand");
        int updateResult = brandMapper.updateBrand(brand);
        Assert.assertEquals(1, updateResult);
    }

    @Test
    public void testDeleteBrand() {

        int result = brandMapper.insert(brand);
        Assert.assertEquals(1, result);

        brand.setEditor("putidelete");
        int updateResult = brandMapper.deleteBrand(brand);
        Assert.assertEquals(1, updateResult);

    }

    @Test
    public void testGetBrandById() {
        //int result = brandMapper.insert(brand);
        //Assert.assertEquals(1, result);
        //Assert.assertNotNull(brand.getId());

        Brand brandQueryResult = brandMapper.getBrandById(brand.getId(), 1);
        Assert.assertEquals(brand.getId(), brandQueryResult.getId());
        Assert.assertEquals(brand.getName(), brandQueryResult.getName());

    }

    @Test
    public void testGetBrandByIdList() {

        int result = brandMapper.insert(brand);
        Assert.assertEquals(1, result);
        Assert.assertNotNull(brand.getId());

        List<Brand> brandList = brandMapper.queryBrandByIdList(Lists.newArrayList(brand.getId()), 1);
        Assert.assertNotNull(brandList);
        Assert.assertEquals(brand.getId(), brandList.get(0).getId());
        Assert.assertEquals(brand.getName(), brandList.get(0).getName());

    }

    @Test
    public void testQueryBrandAll() {

        int result = brandMapper.insert(brand);
        Assert.assertEquals(1, result);
        Assert.assertNotNull(brand.getId());

        List<Brand> brandList = brandMapper.queryBrandAll(1, 1);
        Assert.assertNotNull(brandList);
        Assert.assertNotEquals(0, brandList.size());

    }

    @Test
    public void testGetBrandByNam() {

        int result = brandMapper.insert(brand);
        Assert.assertEquals(1, result);
        Assert.assertNotNull(brand.getId());

        Brand brand1 = brandMapper.getBrandByName(brand.getName(), 1);
        Assert.assertNotNull(brand1);
        Assert.assertEquals(brand1.getName(), brand.getName());
    }

}
