package com.pear.data.master.core.service.impl;

import com.pear.data.master.core.common.dao.BaseDao;
import com.pear.data.master.core.common.service.impl.BaseServiceImpl;
import com.pear.data.master.core.mapper.ChannelBankMapper;
import com.pear.data.master.core.service.ChannelBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description 渠道银行卡的Service层的实现层
 * @Author yoko
 * @Date 2020/3/24 16:01
 * @Version 1.0
 */
@Service
public class ChannelBankServiceImpl<T> extends BaseServiceImpl<T> implements ChannelBankService<T> {
    /**
     * 5分钟.
     */
    public long FIVE_MIN = 300;

    public long TWO_HOUR = 2;

    @Autowired
    private ChannelBankMapper channelBankMapper;


    public BaseDao<T> getDao() {
        return channelBankMapper;
    }
}
