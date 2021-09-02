package com.pear.data.master.core.service.impl;

import com.pear.data.master.core.common.dao.BaseDao;
import com.pear.data.master.core.common.service.impl.BaseServiceImpl;
import com.pear.data.master.core.mapper.InOrderResultMapper;
import com.pear.data.master.core.service.InOrderResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName:
 * @Description: 代收订单结果数据的Service层的实现层
 * @Author: yoko
 * @Date: $
 * @Version: 1.0
 **/
@Service
public class InOrderResultServiceImpl<T> extends BaseServiceImpl<T> implements InOrderResultService<T> {
    /**
     * 5分钟.
     */
    public long FIVE_MIN = 300;

    public long TWO_HOUR = 2;

    @Autowired
    private InOrderResultMapper inOrderResultMapper;

    public BaseDao<T> getDao() {
        return inOrderResultMapper;
    }
}
