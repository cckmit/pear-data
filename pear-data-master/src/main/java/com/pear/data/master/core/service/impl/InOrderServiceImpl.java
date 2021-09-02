package com.pear.data.master.core.service.impl;

import com.pear.data.master.core.common.dao.BaseDao;
import com.pear.data.master.core.common.service.impl.BaseServiceImpl;
import com.pear.data.master.core.mapper.InOrderMapper;
import com.pear.data.master.core.service.InOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName:
 * @Description: 代收订单的Service层的实现层
 * @Author: yoko
 * @Date: $
 * @Version: 1.0
 **/
@Service
public class InOrderServiceImpl<T> extends BaseServiceImpl<T> implements InOrderService<T> {
    /**
     * 5分钟.
     */
    public long FIVE_MIN = 300;

    public long TWO_HOUR = 2;

    @Autowired
    private InOrderMapper inOrderMapper;

    public BaseDao<T> getDao() {
        return inOrderMapper;
    }
}
