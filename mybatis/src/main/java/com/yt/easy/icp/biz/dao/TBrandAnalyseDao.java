package com.yt.easy.icp.biz.dao;

import com.yt.easy.icp.biz.entity.TBrandAnalyse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (TBrandAnalyse)表数据库访问层
 *
 * @author makejava
 * @since 2020-12-17 22:34:08
 */
public interface TBrandAnalyseDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TBrandAnalyse queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TBrandAnalyse> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param tBrandAnalyse 实例对象
     * @return 对象列表
     */
    List<TBrandAnalyse> queryAll(TBrandAnalyse tBrandAnalyse);

    /**
     * 新增数据
     *
     * @param tBrandAnalyse 实例对象
     * @return 影响行数
     */
    int insert(TBrandAnalyse tBrandAnalyse);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TBrandAnalyse> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TBrandAnalyse> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TBrandAnalyse> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<TBrandAnalyse> entities);

    /**
     * 修改数据
     *
     * @param tBrandAnalyse 实例对象
     * @return 影响行数
     */
    int update(TBrandAnalyse tBrandAnalyse);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}
