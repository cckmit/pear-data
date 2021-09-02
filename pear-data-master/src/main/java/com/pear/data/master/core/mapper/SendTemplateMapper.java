package com.pear.data.master.core.mapper;

import com.pear.data.master.core.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName:
 * @Description: 请求模板的Dao层
 * @Author: yoko
 * @Date: $
 * @Version: 1.0
 **/
@Mapper
public interface SendTemplateMapper<T> extends BaseDao<T> {
}
