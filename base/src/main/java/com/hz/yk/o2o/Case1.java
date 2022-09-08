package com.hz.yk.o2o;

import org.jetbrains.annotations.NotNull;

/**
 * @author wuzheng.yk
 * @date 2022/8/16
 */
public class Case1 {
    
    public DemoDTO create(@NotNull DemoDO demoDO) {
        if (demoDO == null) {
            return null;
        }
        DemoDTO demoDTO = new DemoDTO();
        demoDTO.setName(demoDO.getName());
        demoDTO.setAge(demoDO.getAge());
        demoDTO.setTxt(demoDO.getTxt());
        return demoDTO;
    }

}
