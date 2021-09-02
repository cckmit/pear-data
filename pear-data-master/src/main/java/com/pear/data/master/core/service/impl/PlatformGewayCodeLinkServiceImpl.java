package com.pear.data.master.core.service.impl;

import com.pear.data.master.core.common.dao.BaseDao;
import com.pear.data.master.core.common.service.impl.BaseServiceImpl;
import com.pear.data.master.core.mapper.PlatformGewayCodeLinkMapper;
import com.pear.data.master.core.service.PlatformGewayCodeLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description 平台通道码与通道码关联Service层的实现层
 * @Author yoko
 * @Date 2020/10/31 15:36
 * @Version 1.0
 */
@Service
public class PlatformGewayCodeLinkServiceImpl<T> extends BaseServiceImpl<T> implements PlatformGewayCodeLinkService<T> {
    /**
     * 5分钟.
     */
    public long FIVE_MIN = 300;

    public long TWO_HOUR = 2;

    @Autowired
    private PlatformGewayCodeLinkMapper platformGewayCodeLinkMapper;


    public BaseDao<T> getDao() {
        return platformGewayCodeLinkMapper;
    }

}
