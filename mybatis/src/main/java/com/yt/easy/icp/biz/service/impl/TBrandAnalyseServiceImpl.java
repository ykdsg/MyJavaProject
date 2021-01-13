package com.yt.easy.icp.biz.service.impl;

import com.yt.easy.icp.biz.dao.TBrandAnalyseDao;
import com.yt.easy.icp.biz.entity.TBrandAnalyse;
import com.yt.easy.icp.biz.service.TBrandAnalyseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TBrandAnalyse)表服务实现类
 *
 * @author makejava
 * @since 2020-12-17 22:34:12
 */
@Service("tBrandAnalyseService")
public class TBrandAnalyseServiceImpl implements TBrandAnalyseService {

    @Resource
    private TBrandAnalyseDao tBrandAnalyseDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TBrandAnalyse queryById(Integer id) {
        return this.tBrandAnalyseDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<TBrandAnalyse> queryAllByLimit(int offset, int limit) {
        return this.tBrandAnalyseDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tBrandAnalyse 实例对象
     * @return 实例对象
     */
    @Override
    public TBrandAnalyse insert(TBrandAnalyse tBrandAnalyse) {
        this.tBrandAnalyseDao.insert(tBrandAnalyse);
        return tBrandAnalyse;
    }

    /**
     * 修改数据
     *
     * @param tBrandAnalyse 实例对象
     * @return 实例对象
     */
    @Override
    public TBrandAnalyse update(TBrandAnalyse tBrandAnalyse) {
        this.tBrandAnalyseDao.update(tBrandAnalyse);
        return this.queryById(tBrandAnalyse.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tBrandAnalyseDao.deleteById(id) > 0;
    }
}
