package com.pear.data.master.core.service.impl;

import com.pear.data.master.core.common.dao.BaseDao;
import com.pear.data.master.core.common.service.impl.BaseServiceImpl;
import com.pear.data.master.core.mapper.ReplenishMapper;
import com.pear.data.master.core.service.ReplenishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description 运营人员补单表的Service层的实现层
 * @Author yoko
 * @Date 2020/3/2 17:30
 * @Version 1.0
 */
@Service
public class ReplenishServiceImpl<T> extends BaseServiceImpl<T> implements ReplenishService<T> {
    /**
     * 5分钟.
     */
    public long FIVE_MIN = 300;

    public long TWO_HOUR = 2;

    @Autowired
    private ReplenishMapper replenishMapper;


    public BaseDao<T> getDao() {
        return replenishMapper;
    }

}
