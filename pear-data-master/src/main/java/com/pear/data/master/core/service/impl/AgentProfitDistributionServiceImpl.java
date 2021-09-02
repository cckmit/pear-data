package com.pear.data.master.core.service.impl;

import com.pear.data.master.core.common.dao.BaseDao;
import com.pear.data.master.core.common.service.impl.BaseServiceImpl;
import com.pear.data.master.core.mapper.AgentProfitDistributionMapper;
import com.pear.data.master.core.service.AgentProfitDistributionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description 代理利益分配的Service层的实现层
 * @Author yoko
 * @Date 2021/1/20 16:23
 * @Version 1.0
 */
@Service
public class AgentProfitDistributionServiceImpl<T> extends BaseServiceImpl<T> implements AgentProfitDistributionService<T> {
    /**
     * 5分钟.
     */
    public long FIVE_MIN = 300;

    public long TWO_HOUR = 2;

    @Autowired
    private AgentProfitDistributionMapper agentProfitDistributionMapper;


    public BaseDao<T> getDao() {
        return agentProfitDistributionMapper;
    }
}
