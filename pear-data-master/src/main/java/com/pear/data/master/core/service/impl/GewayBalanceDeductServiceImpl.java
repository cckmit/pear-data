package com.pear.data.master.core.service.impl;

import com.pear.data.master.core.common.dao.BaseDao;
import com.pear.data.master.core.common.service.impl.BaseServiceImpl;
import com.pear.data.master.core.mapper.ChannelBalanceDeductMapper;
import com.pear.data.master.core.service.GewayBalanceDeductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description 通道扣减余额流水表的Service层的实现层
 * @Author yoko
 * @Date 2020/10/31 16:26
 * @Version 1.0
 */
@Service
public class GewayBalanceDeductServiceImpl<T> extends BaseServiceImpl<T> implements GewayBalanceDeductService<T> {
    /**
     * 5分钟.
     */
    public long FIVE_MIN = 300;

    public long TWO_HOUR = 2;

    @Autowired
    private ChannelBalanceDeductMapper channelBalanceDeductMapper;


    public BaseDao<T> getDao() {
        return channelBalanceDeductMapper;
    }

}
