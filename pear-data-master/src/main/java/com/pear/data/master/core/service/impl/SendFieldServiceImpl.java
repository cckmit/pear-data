package com.pear.data.master.core.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.pear.data.master.core.common.dao.BaseDao;
import com.pear.data.master.core.common.service.impl.BaseServiceImpl;
import com.pear.data.master.core.common.utils.constant.CacheKey;
import com.pear.data.master.core.common.utils.constant.CachedKeyUtils;
import com.pear.data.master.core.common.utils.constant.ServerConstant;
import com.pear.data.master.core.mapper.SendFieldMapper;
import com.pear.data.master.core.model.template.SendFieldModel;
import com.pear.data.master.core.service.SendFieldService;
import com.pear.data.master.util.ComponentUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName:
 * @Description: 请求字段的Service层的实现层
 * @Author: yoko
 * @Date: $
 * @Version: 1.0
 **/
@Service
public class SendFieldServiceImpl<T> extends BaseServiceImpl<T> implements SendFieldService<T> {
    /**
     * 5分钟.
     */
    public long FIVE_MIN = 300;

    public long TWO_HOUR = 2;

    @Autowired
    private SendFieldMapper sendFieldMapper;


    public BaseDao<T> getDao() {
        return sendFieldMapper;
    }


    @Override
    public SendFieldModel getSendFieldModel(SendFieldModel model, int isCache) throws Exception {
        SendFieldModel dataModel = null;
        if (isCache == ServerConstant.PUBLIC_CONSTANT.SIZE_VALUE_ZERO){
            String strKeyCache = CachedKeyUtils.getCacheKey(CacheKey.SEND_FIELD, model.getSendTemplateId());
            String strCache = (String) ComponentUtil.redisService.get(strKeyCache);
            if (!StringUtils.isBlank(strCache)) {
                // 从缓存里面获取数据
                dataModel = JSON.parseObject(strCache, SendFieldModel.class);
            } else {
                //查询数据库
                dataModel = (SendFieldModel) sendFieldMapper.findByObject(model);
                if (dataModel != null && dataModel.getId() != ServerConstant.PUBLIC_CONSTANT.SIZE_VALUE_ZERO) {
                    // 把数据存入缓存
                    ComponentUtil.redisService.set(strKeyCache, JSON.toJSONString(dataModel, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty), FIVE_MIN);
                }
            }
        }else {
            // 直接查数据库
            // 查询数据库
            dataModel = (SendFieldModel) sendFieldMapper.findByObject(model);
        }
        return dataModel;
    }

    @Override
    public List<SendFieldModel> getSendFieldList(SendFieldModel model, int isCache) throws Exception {
        List<SendFieldModel> dataList = null;
        if (isCache == ServerConstant.PUBLIC_CONSTANT.SIZE_VALUE_ZERO){
            String strKeyCache = CachedKeyUtils.getCacheKey(CacheKey.SEND_FIELD_LIST, model.getSendTemplateId());
            String strCache = (String) ComponentUtil.redisService.get(strKeyCache);
            if (!StringUtils.isBlank(strCache)) {
                // 从缓存里面获取数据
                dataList = JSON.parseArray(strCache, SendFieldModel.class);
            } else {
                //查询数据库
                dataList = sendFieldMapper.findByCondition(model);
                if (dataList != null && dataList.size() != ServerConstant.PUBLIC_CONSTANT.SIZE_VALUE_ZERO) {
                    // 把数据存入缓存
                    ComponentUtil.redisService.set(strKeyCache, JSON.toJSONString(dataList, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty), FIVE_MIN);
                }
            }
        }else {
            // 直接查数据库
            // 查询数据库
            dataList = sendFieldMapper.findByCondition(model);
        }
        return dataList;
    }
}
