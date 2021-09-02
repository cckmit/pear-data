package com.pear.data.master.core.mapper;

import com.pear.data.master.core.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description 通道收益数据：收益的详情，成功订单要进行余额累加的流水表的Dao层
 * @Author yoko
 * @Date 2021/1/20 16:20
 * @Version 1.0
 */
@Mapper
public interface GewayProfitMapper<T> extends BaseDao<T> {
}
