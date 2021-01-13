package com.yt.easy.icp.biz.service;

import com.yt.easy.icp.biz.entity.TBrandAnalyse;

import java.util.List;

/**
 * (TBrandAnalyse)表服务接口
 *
 * @author makejava
 * @since 2020-12-17 22:34:11
 */
public interface TBrandAnalyseService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TBrandAnalyse queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TBrandAnalyse> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tBrandAnalyse 实例对象
     * @return 实例对象
     */
    TBrandAnalyse insert(TBrandAnalyse tBrandAnalyse);

    /**
     * 修改数据
     *
     * @param tBrandAnalyse 实例对象
     * @return 实例对象
     */
    TBrandAnalyse update(TBrandAnalyse tBrandAnalyse);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
