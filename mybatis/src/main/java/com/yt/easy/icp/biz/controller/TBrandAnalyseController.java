package com.yt.easy.icp.biz.controller;

import com.yt.easy.icp.biz.entity.TBrandAnalyse;
import com.yt.easy.icp.biz.service.TBrandAnalyseService;

import javax.annotation.Resource;

/**
 * (TBrandAnalyse)表控制层
 *
 * @author makejava
 * @since 2020-12-17 22:34:14
 */
@RestController
@RequestMapping("tBrandAnalyse")
public class TBrandAnalyseController {

    /**
     * 服务对象
     */
    @Resource
    private TBrandAnalyseService tBrandAnalyseService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TBrandAnalyse selectOne(Integer id) {
        return this.tBrandAnalyseService.queryById(id);
    }

}
