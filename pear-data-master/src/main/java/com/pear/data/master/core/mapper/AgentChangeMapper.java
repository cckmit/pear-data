package com.pear.data.master.core.mapper;

import com.pear.data.master.core.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description 代理金额变更纪录的Dao层
 * @Author yoko
 * @Date 2020/11/4 10:47
 * @Version 1.0
 */
@Mapper
public interface AgentChangeMapper<T> extends BaseDao<T> {
}
