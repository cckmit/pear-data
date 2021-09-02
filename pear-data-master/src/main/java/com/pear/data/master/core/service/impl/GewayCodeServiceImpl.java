package com.pear.data.master.core.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.pear.data.master.core.common.dao.BaseDao;
import com.pear.data.master.core.common.service.impl.BaseServiceImpl;
import com.pear.data.master.core.common.utils.constant.CachedKeyUtils;
import com.pear.data.master.core.common.utils.constant.DtCacheKey;
import com.pear.data.master.core.common.utils.constant.ServerConstant;
import com.pear.data.master.core.mapper.GewayCodeMapper;
import com.pear.data.master.core.model.geway.GewayCodeModel;
import com.pear.data.master.core.service.GewayCodeService;
import com.pear.data.master.util.ComponentUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description 通道的支付类型的Service层的实现层
 * @Author yoko
 * @Date 2020/3/31 17:35
 * @Version 1.0
 */
@Service
public class GewayCodeServiceImpl<T> extends BaseServiceImpl<T> implements GewayCodeService<T> {
    /**
     * 5分钟.
     */
    public long FIVE_MIN = 300;

    public long TWO_HOUR = 2;

    @Autowired
    private GewayCodeMapper gewayCodeMapper;


    public BaseDao<T> getDao() {
        return gewayCodeMapper;
    }

    @Override
    public List<GewayCodeModel> getGewayCodeAndGeway(GewayCodeModel model) {
        return gewayCodeMapper.getGewayCodeAndGeway(model);
    }

    @Override
    public GewayCodeModel getGewayCodeAndGewayData(GewayCodeModel model) {
        return gewayCodeMapper.getGewayCodeAndGewayData(model);
    }


    @Override
    public GewayCodeModel getGewayCodeModel(GewayCodeModel model, int isCache) throws Exception {
        GewayCodeModel dataModel = null;
        if (isCache == ServerConstant.PUBLIC_CONSTANT.SIZE_VALUE_ZERO){
            String strKeyCache = CachedKeyUtils.getCacheKeyData(DtCacheKey.GEWAY_CODE, model.getId());
            String strCache = (String) ComponentUtil.redisService.get(strKeyCache);
            if (!StringUtils.isBlank(strCache)) {
                // 从缓存里面获取数据
                dataModel = JSON.parseObject(strCache, GewayCodeModel.class);
            } else {
                //查询数据库
                dataModel = (GewayCodeModel) gewayCodeMapper.findByObject(model);
                if (dataModel != null && dataModel.getId() != ServerConstant.PUBLIC_CONSTANT.SIZE_VALUE_ZERO) {
                    // 把数据存入缓存
                    ComponentUtil.redisService.set(strKeyCache, JSON.toJSONString(dataModel, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty), FIVE_MIN);
                }
            }
        }else {
            // 直接查数据库
            // 查询数据库
            dataModel = (GewayCodeModel) gewayCodeMapper.findByObject(model);
        }
        return dataModel;
    }

}
