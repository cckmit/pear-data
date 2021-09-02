package com.pear.data.master.core.runner;

import com.pear.data.master.core.common.redis.RedisIdService;
import com.pear.data.master.core.common.redis.RedisService;
import com.pear.data.master.core.common.utils.constant.LoadConstant;
import com.pear.data.master.core.service.*;
import com.pear.data.master.util.ComponentUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component
@Order(0)
public class AutowireRunner implements ApplicationRunner {
    private final static Logger log = LoggerFactory.getLogger(AutowireRunner.class);

    /**
     * 5分钟.
     */
    public long FIVE_MIN = 300;


    Thread runThread = null;

    @Autowired
    private RedisIdService redisIdService;
    @Autowired
    private RedisService redisService;

    @Resource
    private LoadConstant loadConstant;

    @Autowired
    private RegionService regionService;

    @Autowired
    private StrategyService strategyService;



    @Autowired
    private InOrderService inOrderService;

    @Autowired
    private InOrderResultService inOrderResultService;

    @Autowired
    private ChannelService channelService;

    @Autowired
    private ChannelBankService channelBankService;

    @Autowired
    private ChannelWithdrawService channelWithdrawService;

    @Autowired
    private ChannelChangeService channelChangeService;

    @Autowired
    private ChannelBalanceDeductService channelBalanceDeductService;

    @Autowired
    private ChannelProfitService channelProfitService;

    @Autowired
    private ChannelPlatformGewayCodeLinkService channelPlatformGewayCodeLinkService;

    @Autowired
    private ChannelReplenishService channelReplenishService;

    @Autowired
    private GewayService gewayService;

    @Autowired
    private GewayCodeService gewayCodeService;

    @Autowired
    private PlatformGewayCodeService platformGewayCodeService;

    @Autowired
    private PlatformGewayCodeLinkService platformGewayCodeLinkService;

    @Autowired
    private GewayChangeService gewayChangeService;

    @Autowired
    private GewayBalanceDeductService gewayBalanceDeductService;

    @Autowired
    private GewayProfitService gewayProfitService;

    @Autowired
    private AgentService agentService;

    @Autowired
    private AgentBankService agentBankService;

    @Autowired
    private AgentWithdrawService agentWithdrawService;

    @Autowired
    private AgentChangeService agentChangeService;

    @Autowired
    private AgentBalanceDeductService agentBalanceDeductService;

    @Autowired
    private AgentProfitService agentProfitService;

    @Autowired
    private AgentProfitDistributionService agentProfitDistributionService;

    @Autowired
    private ReplenishService replenishService;

    @Autowired
    private SendTemplateService sendTemplateService;

    @Autowired
    private SendFieldService sendFieldService;

    @Autowired
    private ReturnTemplateService returnTemplateService;

    @Autowired
    private ReturnFieldService returnFieldService;

    @Autowired
    private NotifyTemplateService notifyTemplateService;

    @Autowired
    private NotifyFieldService notifyFieldService;



    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("AutowireRunner ...");
        ComponentUtil.redisIdService = redisIdService;
        ComponentUtil.redisService = redisService;
        ComponentUtil.loadConstant = loadConstant;
        ComponentUtil.regionService = regionService;
        ComponentUtil.strategyService = strategyService;


        ComponentUtil.inOrderService = inOrderService;
        ComponentUtil.inOrderResultService = inOrderResultService;
        ComponentUtil.channelService = channelService;
        ComponentUtil.channelBankService = channelBankService;
        ComponentUtil.channelWithdrawService = channelWithdrawService;
        ComponentUtil.channelChangeService = channelChangeService;
        ComponentUtil.channelBalanceDeductService = channelBalanceDeductService;
        ComponentUtil.channelProfitService = channelProfitService;
        ComponentUtil.channelPlatformGewayCodeLinkService = channelPlatformGewayCodeLinkService;
        ComponentUtil.channelReplenishService = channelReplenishService;
        ComponentUtil.gewayService = gewayService;
        ComponentUtil.gewayCodeService = gewayCodeService;
        ComponentUtil.platformGewayCodeService = platformGewayCodeService;
        ComponentUtil.platformGewayCodeLinkService = platformGewayCodeLinkService;
        ComponentUtil.gewayChangeService = gewayChangeService;
        ComponentUtil.gewayBalanceDeductService = gewayBalanceDeductService;
        ComponentUtil.gewayProfitService = gewayProfitService;
        ComponentUtil.agentService = agentService;
        ComponentUtil.agentBankService = agentBankService;
        ComponentUtil.agentWithdrawService = agentWithdrawService;
        ComponentUtil.agentChangeService = agentChangeService;
        ComponentUtil.agentBalanceDeductService = agentBalanceDeductService;
        ComponentUtil.agentProfitService = agentProfitService;
        ComponentUtil.agentProfitDistributionService = agentProfitDistributionService;
        ComponentUtil.replenishService = replenishService;
        ComponentUtil.sendTemplateService = sendTemplateService;
        ComponentUtil.sendFieldService = sendFieldService;
        ComponentUtil.returnTemplateService = returnTemplateService;
        ComponentUtil.returnFieldService = returnFieldService;
        ComponentUtil.notifyTemplateService = notifyTemplateService;
        ComponentUtil.notifyFieldService = notifyFieldService;


        runThread = new RunThread();
        runThread.start();






    }

    /**
     * @author df
     * @Description: TODO(模拟请求)
     * <p>1.随机获取当日金额的任务</p>
     * <p>2.获取代码信息</p>
     * @create 20:21 2019/1/29
     **/
    class RunThread extends Thread{
        @Override
        public void run() {
            log.info("启动啦............");
        }
    }




}
