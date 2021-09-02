package com.pear.data.master.core.service;


import com.pear.data.master.core.common.service.BaseService;
import com.pear.data.master.core.model.geway.GewayCodeModel;

import java.util.List;

/**
 * @Description 通道的支付类型的Service层
 * @Author yoko
 * @Date 2020/3/31 17:34
 * @Version 1.0
 */
public interface GewayCodeService<T> extends BaseService<T> {

    /**
     * @Description: 获取通道码以及通道的信息
     * @param model
     * @return
     * @Author: yoko
     * @Date 2021/8/7 15:46
     */
    public List<GewayCodeModel> getGewayCodeAndGeway(GewayCodeModel model);

    /**
     * @Description: 获取通道码以及通道的信息
     * @param model
     * @return
     * @Author: yoko
     * @Date 2021/8/7 16:52
     */
    public GewayCodeModel getGewayCodeAndGewayData(GewayCodeModel model);

    /**
     * @Description: 根据条件查询通道码数据
     * @param model - 查询条件
     * @param isCache - 是否通过缓存查询：0需要通过缓存查询，1直接查询数据库
     * @return
     * @author yoko
     * @date 2019/11/21 19:26
     */
    public GewayCodeModel getGewayCodeModel(GewayCodeModel model, int isCache) throws Exception;
}
