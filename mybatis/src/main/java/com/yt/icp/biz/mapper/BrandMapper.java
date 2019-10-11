package com.yt.icp.biz.mapper;

import com.yt.icp.biz.domain.entity.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * .
 *
 * @author wuzheng.yk
 * @since 16/6/21
 */
public interface BrandMapper {

    int insert(Brand brand);

    int updateBrand(Brand brand);

    int deleteBrand(Brand brand);

    /**
     * Author xiaoshami
     * Description 删除B类品牌
     * Date 下午8:44 2018/9/25
     * Param [id, operator]
     * return int
     **/
    int deleteBrandB(@Param("id") Long id, @Param("operator") String operator);

    /**
     * 默认的查询 包含所有的字段
     *
     * @param id
     * @param needArea
     * @return
     */
    Brand getBrandById(@Param("id") Long id, @Param("needArea") int needArea);

    /**
     * @param brandIdList idList
     * @param needArea    是否需要area
     * @return
     */
    List<Brand> queryBrandByIdList(@Param("list") List<Long> brandIdList, @Param("needArea") int needArea);

    /**
     * 查询所有的品牌
     *
     * @param needArea
     * @return
     */
    List<Brand> queryBrandAll(@Param("needArea") int needArea, @Param("includeHide") int includeHide);

    /**
     * @param offset
     * @param pageSize
     * @param needArea
     * @return
     */
    List<Brand> queryBrandList(@Param("offset") Integer offset, @Param("pageSize") Integer pageSize,
                               @Param("needArea") int needArea);

    /**
     * 根据名称查询区域
     *
     * @param name
     * @param needArea
     * @return
     */
    Brand getBrandByName(@Param("name") String name, @Param("needArea") int needArea);

    /**
     * 批量更新回流的数据，目前包括商品数量，商品销量
     *
     * @param brandList
     * @return
     */
    int batchUpdateBackflow(List<Brand> brandList);

    /**
     * @return
     */
    Date queryMaxEditTime();

    /**
     * @Description 根据品牌编号进行查询
     * @Param [brandNoList]
     **/
    List<Brand> queryBrandByNoList(@Param("brandNoList") List<String> brandNoList, @Param("needArea") int needArea);

    /**
     * 设置品牌主营类目
     *
     * @param id
     * @param categoryId 主营类目 （需为一级类目）
     * @param editor     操作人
     * @return
     */
    int updatePrimarySellCategory(@Param("id") Long id, @Param("categoryId") Long categoryId,
                                  @Param("editor") String editor);

    /**
     * 更新品牌调性信息审核状态
     *
     * @param id
     * @param checkStatus 审核状态
     * @param operator
     * @return
     */
    int updateBrandLayerInfoCheckStatus(@Param("id") Long id, @Param("checkStatus") Integer checkStatus,
                                        @Param("editor") String operator);

    /*
     *  批量更新主营类目
     * */
    int batchUpdatePrimaryCategory(@Param("brandList") List<Brand> brandList);
}
