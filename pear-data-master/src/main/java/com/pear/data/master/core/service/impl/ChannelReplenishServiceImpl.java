package com.pear.data.master.core.service.impl;

import com.pear.data.master.core.common.dao.BaseDao;
import com.pear.data.master.core.common.service.impl.BaseServiceImpl;
import com.pear.data.master.core.mapper.ChannelReplenishMapper;
import com.pear.data.master.core.service.ChannelReplenishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName:
 * @Description: 渠道补单申请表的Service层的实现层
 * @Author: yoko
 * @Date: $
 * @Version: 1.0
 **/
@Service
public class ChannelReplenishServiceImpl<T> extends BaseServiceImpl<T> implements ChannelReplenishService<T> {
    /**
     * 5分钟.
     */
    public long FIVE_MIN = 300;

    public long TWO_HOUR = 2;

    @Autowired
    private ChannelReplenishMapper channelReplenishMapper;


    public BaseDao<T> getDao() {
        return channelReplenishMapper;
    }
}
