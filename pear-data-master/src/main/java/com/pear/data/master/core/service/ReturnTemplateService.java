package com.pear.data.master.core.service;

import com.pear.data.master.core.common.service.BaseService;
import com.pear.data.master.core.model.template.ReturnTemplateModel;

/**
 * @ClassName:
 * @Description: 返回模板的Service层
 * @Author: yoko
 * @Date: $
 * @Version: 1.0
 **/
public interface ReturnTemplateService<T> extends BaseService<T> {

    /**
     * @Description: 根据条件查询返回模板数据
     * @param model - 查询条件
     * @param isCache - 是否通过缓存查询：0需要通过缓存查询，1直接查询数据库
     * @return
     * @author yoko
     * @date 2019/11/21 19:26
     */
    public ReturnTemplateModel getReturnTemplateModel(ReturnTemplateModel model, int isCache) throws Exception;
}
