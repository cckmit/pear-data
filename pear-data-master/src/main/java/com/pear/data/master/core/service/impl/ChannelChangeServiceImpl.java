package com.pear.data.master.core.service.impl;

import com.pear.data.master.core.common.dao.BaseDao;
import com.pear.data.master.core.common.service.impl.BaseServiceImpl;
import com.pear.data.master.core.mapper.ChannelChangeMapper;
import com.pear.data.master.core.service.ChannelChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description 渠道金额变更纪录的Service层的实现层
 * @Author yoko
 * @Date 2020/11/4 10:49
 * @Version 1.0
 */
@Service
public class ChannelChangeServiceImpl<T> extends BaseServiceImpl<T> implements ChannelChangeService<T> {
    /**
     * 5分钟.
     */
    public long FIVE_MIN = 300;

    public long TWO_HOUR = 2;

    @Autowired
    private ChannelChangeMapper channelChangeMapper;


    public BaseDao<T> getDao() {
        return channelChangeMapper;
    }
}
