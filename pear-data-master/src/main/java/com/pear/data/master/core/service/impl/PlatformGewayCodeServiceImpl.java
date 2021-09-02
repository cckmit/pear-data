package com.pear.data.master.core.service.impl;

import com.pear.data.master.core.common.dao.BaseDao;
import com.pear.data.master.core.common.service.impl.BaseServiceImpl;
import com.pear.data.master.core.mapper.PlatformGewayCodeMapper;
import com.pear.data.master.core.service.PlatformGewayCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description 平台通道码的Service层的实现层
 * @Author yoko
 * @Date 2020/10/31 15:36
 * @Version 1.0
 */
@Service
public class PlatformGewayCodeServiceImpl<T> extends BaseServiceImpl<T> implements PlatformGewayCodeService<T> {
    /**
     * 5分钟.
     */
    public long FIVE_MIN = 300;

    public long TWO_HOUR = 2;

    @Autowired
    private PlatformGewayCodeMapper platformGewayCodeMapper;


    public BaseDao<T> getDao() {
        return platformGewayCodeMapper;
    }

}
