package com.pear.data.master.core.service.impl;

import com.pear.data.master.core.common.dao.BaseDao;
import com.pear.data.master.core.common.service.impl.BaseServiceImpl;
import com.pear.data.master.core.mapper.ChannelPlatformGewayCodeLinkMapper;
import com.pear.data.master.core.service.ChannelPlatformGewayCodeLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName:
 * @Description: 渠道与平台通道码关联的Service层的实现层
 * @Author: yoko
 * @Date: $
 * @Version: 1.0
 **/
@Service
public class ChannelPlatformGewayCodeLinkServiceImpl<T> extends BaseServiceImpl<T> implements ChannelPlatformGewayCodeLinkService<T> {
    /**
     * 5分钟.
     */
    public long FIVE_MIN = 300;

    public long TWO_HOUR = 2;

    @Autowired
    private ChannelPlatformGewayCodeLinkMapper channelPlatformGewayCodeLinkMapper;


    public BaseDao<T> getDao() {
        return channelPlatformGewayCodeLinkMapper;
    }
}
