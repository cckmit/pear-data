package com.pear.data.master.core.common.utils.constant;

/**
 * @author df
 * @Description:异常状态码
 * @create 2018-07-27 11:13
 **/
public class ErrorCode {

    /**
     * 常量异常
     */
    public final class ERROR_CONSTANT {
        /**
         * 没有被捕捉到的异常
         * 默认系统异常状态码=255
         */
        public static final String DEFAULT_EXCEPTION_ERROR_CODE = "255";

        /**
         * 没有被捕捉到的异常
         * 默认系统异常错误信息=SYS_ERROR
         */
        public static final String DEFAULT_EXCEPTION_ERROR_MESSAGE = "ERROR";

        /**
         * 被捕捉到的异常，并且捕捉的异常错误码为空，则默认异常状态码
         * 默认捕捉的异常状态码=256
         */
        public static final String DEFAULT_SERVICE_EXCEPTION_ERROR_CODE = "256";

        /**
         * 被捕捉到的异常，但是错误信息为空，则默认异常信息提醒
         * 默认捕捉的异常信息提醒=错误
         */
        public static final String DEFAULT_SERVICE_EXCEPTION_ERROR_MESSAGE = "错误";

    }


    /**
     * 异常-枚举类
     */
    public enum ENUM_ERROR {


        /***********************************************
         * IOR打头表示代收订单的错误
         **********************************************/
        IOR00001("IOR00001", "代收订单数据同步时,根据通道码ID查询通道码信息的数据为空!", "代收订单数据同步时,根据通道码ID查询通道码信息的数据为空!"),
        IOR00002("IOR00002", "代收订单数据同步时,根据通道码ID查询同步模板的数据为空!", "代收订单数据同步时,根据通道码ID查询同步模板的数据为空!"),
        IOR00003("IOR00003", "代收订单数据同步时,根据同步模板ID查询同步字段的数据为空!", "代收订单数据同步时,根据同步模板ID查询同步字段的数据为空!"),
        IOR00004("IOR00004", "代收订单数据同步时,同步模板check状态字段值数据为空!", "代收订单数据同步时,同步模板check状态字段值数据为空!"),
        IOR00005("IOR00005", "代收订单数据同步时,上游同步所有数据为空!", "代收订单数据同步时,上游同步所有数据为空!"),
        IOR00006("IOR00006", "代收订单数据同步时,我方订单号数据为空!", "代收订单数据同步时,我方订单号数据为空!"),
        IOR00007("IOR00007", "代收订单数据同步时,上游订单号数据为空!", "代收订单数据同步时,上游订单号数据为空!"),
        IOR00008("IOR00008", "代收订单数据同步时,根据我方订单号查询订单数据为空!", "代收订单数据同步时,根据我方订单号查询订单数据为空!"),
        IOR00009("IOR00009", "代收订单数据同步时,拉单金额与同步的金额不一致!", "代收订单数据同步时,拉单金额与同步的金额不一致!"),
        IOR00010("IOR00010", "代收订单数据同步时,上游同步数据已存在数据库,属于重复同步!", "代收订单数据同步时,上游同步数据已存在数据库,属于重复同步!"),













        ;

        /**
         * 错误码
         */
        private String eCode;
        /**
         * 给客户端看的错误信息
         */
        private String eDesc;
        /**
         * 插入数据库的错误信息
         */
        private String dbDesc;




        private ENUM_ERROR(String eCode, String eDesc,String dbDesc) {
            this.eCode = eCode;
            this.eDesc = eDesc;
            this.dbDesc  = dbDesc;
        }

        public String geteCode() {
            return eCode;
        }

        public void seteCode(String eCode) {
            this.eCode = eCode;
        }

        public String geteDesc() {
            return eDesc;
        }

        public void seteDesc(String eDesc) {
            this.eDesc = eDesc;
        }

        public String getDbDesc() {
            return dbDesc;
        }

        public void setDbDesc(String dbDesc) {
            this.dbDesc = dbDesc;
        }
    }
}
