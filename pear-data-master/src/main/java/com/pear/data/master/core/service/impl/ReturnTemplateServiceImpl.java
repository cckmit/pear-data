package com.pear.data.master.core.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.pear.data.master.core.common.dao.BaseDao;
import com.pear.data.master.core.common.service.impl.BaseServiceImpl;
import com.pear.data.master.core.common.utils.constant.CacheKey;
import com.pear.data.master.core.common.utils.constant.CachedKeyUtils;
import com.pear.data.master.core.common.utils.constant.ServerConstant;
import com.pear.data.master.core.mapper.ReturnTemplateMapper;
import com.pear.data.master.core.model.template.ReturnTemplateModel;
import com.pear.data.master.core.service.ReturnTemplateService;
import com.pear.data.master.util.ComponentUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName:
 * @Description: 返回模板的Service层的实现层
 * @Author: yoko
 * @Date: $
 * @Version: 1.0
 **/
@Service
public class ReturnTemplateServiceImpl<T> extends BaseServiceImpl<T> implements ReturnTemplateService<T> {
    /**
     * 5分钟.
     */
    public long FIVE_MIN = 300;

    public long TWO_HOUR = 2;

    @Autowired
    private ReturnTemplateMapper returnTemplateMapper;


    public BaseDao<T> getDao() {
        return returnTemplateMapper;
    }

    @Override
    public ReturnTemplateModel getReturnTemplateModel(ReturnTemplateModel model, int isCache) throws Exception {
        ReturnTemplateModel dataModel = null;
        if (isCache == ServerConstant.PUBLIC_CONSTANT.SIZE_VALUE_ZERO){
            String strKeyCache = CachedKeyUtils.getCacheKey(CacheKey.RETURN_TEMPLATE, model.getGewayCodeId());
            String strCache = (String) ComponentUtil.redisService.get(strKeyCache);
            if (!StringUtils.isBlank(strCache)) {
                // 从缓存里面获取数据
                dataModel = JSON.parseObject(strCache, ReturnTemplateModel.class);
            } else {
                //查询数据库
                dataModel = (ReturnTemplateModel) returnTemplateMapper.findByObject(model);
                if (dataModel != null && dataModel.getId() != ServerConstant.PUBLIC_CONSTANT.SIZE_VALUE_ZERO) {
                    // 把数据存入缓存
                    ComponentUtil.redisService.set(strKeyCache, JSON.toJSONString(dataModel, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty), FIVE_MIN);
                }
            }
        }else {
            // 直接查数据库
            // 查询数据库
            dataModel = (ReturnTemplateModel) returnTemplateMapper.findByObject(model);
        }
        return dataModel;
    }
}
