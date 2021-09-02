package com.pear.data.master.core.service.impl;

import com.pear.data.master.core.common.dao.BaseDao;
import com.pear.data.master.core.common.service.impl.BaseServiceImpl;
import com.pear.data.master.core.mapper.AgentChangeMapper;
import com.pear.data.master.core.service.AgentChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description 代理金额变更纪录的Service层的实现层
 * @Author yoko
 * @Date 2020/3/24 16:01
 * @Version 1.0
 */
@Service
public class AgentChangeServiceImpl<T> extends BaseServiceImpl<T> implements AgentChangeService<T> {
    /**
     * 5分钟.
     */
    public long FIVE_MIN = 300;

    public long TWO_HOUR = 2;

    @Autowired
    private AgentChangeMapper agentChangeMapper;


    public BaseDao<T> getDao() {
        return agentChangeMapper;
    }
}
