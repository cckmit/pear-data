package com.pear.data.master.util;


import com.pear.data.master.core.common.redis.RedisIdService;
import com.pear.data.master.core.common.redis.RedisService;
import com.pear.data.master.core.common.utils.constant.LoadConstant;
import com.pear.data.master.core.service.*;

/**
 * 工具类
 */
public class ComponentUtil {
    public static RedisIdService redisIdService;
    public static RedisService redisService;
    public static LoadConstant loadConstant;
    public static RegionService regionService;
    public static StrategyService strategyService;


    public static InOrderService inOrderService;
    public static InOrderResultService inOrderResultService;
    public static ChannelService channelService;
    public static ChannelBankService channelBankService;
    public static ChannelWithdrawService channelWithdrawService;
    public static ChannelChangeService channelChangeService;
    public static ChannelBalanceDeductService channelBalanceDeductService;
    public static ChannelProfitService channelProfitService;
    public static ChannelPlatformGewayCodeLinkService channelPlatformGewayCodeLinkService;
    public static ChannelReplenishService channelReplenishService;
    public static GewayService gewayService;
    public static GewayCodeService gewayCodeService;
    public static PlatformGewayCodeService platformGewayCodeService;
    public static PlatformGewayCodeLinkService platformGewayCodeLinkService;
    public static GewayChangeService gewayChangeService;
    public static GewayBalanceDeductService gewayBalanceDeductService;
    public static GewayProfitService gewayProfitService;
    public static AgentService agentService;
    public static AgentBankService agentBankService;
    public static AgentWithdrawService agentWithdrawService;
    public static AgentChangeService agentChangeService;
    public static AgentBalanceDeductService agentBalanceDeductService;
    public static AgentProfitService agentProfitService;
    public static AgentProfitDistributionService agentProfitDistributionService;
    public static ReplenishService replenishService;
    public static SendTemplateService sendTemplateService;
    public static SendFieldService sendFieldService;
    public static ReturnTemplateService returnTemplateService;
    public static ReturnFieldService returnFieldService;
    public static NotifyTemplateService notifyTemplateService;
    public static NotifyFieldService notifyFieldService;

}
