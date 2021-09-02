package com.pear.data.master.core.mapper;

import com.pear.data.master.core.common.dao.BaseDao;
import com.pear.data.master.core.model.geway.GewayCodeModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description 通道的支付类型的Dao层
 * @Author yoko
 * @Date 2020/4/7 14:15
 * @Version 1.0
 */
@Mapper
public interface GewayCodeMapper<T> extends BaseDao<T> {

    /**
     * @Description: 获取通道码以及通道的信息-集合
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
}
