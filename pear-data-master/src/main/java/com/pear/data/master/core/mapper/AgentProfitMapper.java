package com.pear.data.master.core.mapper;

import com.pear.data.master.core.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description 代理收益数据：收益的详情，成功订单要进行余额累加的流水表的Dao层
 * @Author yoko
 * @Date 2020/10/31 16:22
 * @Version 1.0
 */
@Mapper
public interface AgentProfitMapper<T> extends BaseDao<T> {


}
