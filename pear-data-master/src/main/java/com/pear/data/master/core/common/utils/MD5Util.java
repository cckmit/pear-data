package com.pear.data.master.core.common.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * md5加密util
 *
 * @Title: MD5Util
 * @Description:
 * @Author: qianyikai from HangZhouZhengqu， E-mail: 469640411@qq.com
 * @Date: Created in 2019/2/15 20:17
 * @Version 1.0
 * @Company HangZhouZhengqu Co., Ltd.
 */
public class MD5Util {

    private static Logger log = LoggerFactory.getLogger(MD5Util.class);

    /**
     * 默认的密码字符串组合，用来将字节转换成 16 进制表示的字符,apache校验下载的文件的正确性用的就是默认的这个组合
     */
    protected static char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    protected static MessageDigest messagedigest = null;

    static {
        try {
            messagedigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException nsaex) {
            System.err.println(MD5Util.class.getName() + "初始化失败，MessageDigest不支持MD5Util。");
            nsaex.printStackTrace();
        }
    }

    /**
     * 生成字符串的md5校验值
     *
     * @param s
     * @return
     */
    public static String getMD5String(String s) {
        return getMD5String(s.getBytes());
    }

    /**
     * 判断字符串的md5校验码是否与一个已知的md5码相匹配
     *
     * @param password  要校验的字符串
     * @param md5PwdStr 已知的md5校验码
     * @return
     */
    public static boolean checkPassword(String password, String md5PwdStr) {
        String s = getMD5String(password);
        return s.equals(md5PwdStr);
    }

    /**
     * 生成文件的md5校验值
     *
     * @param file
     * @return
     * @throws IOException
     */
    public static String getFileMD5String(File file) throws IOException {
        InputStream fis;
        fis = new FileInputStream(file);
        byte[] buffer = new byte[1024];
        int numRead = 0;
        while ((numRead = fis.read(buffer)) > 0) {
            messagedigest.update(buffer, 0, numRead);
        }
        fis.close();
        return bufferToHex(messagedigest.digest());
    }

    /**
     * JDK1.4中不支持以MappedByteBuffer类型为参数update方法，并且网上有讨论要慎用MappedByteBuffer，
     * 原因是当使用 FileChannel.map 方法时，MappedByteBuffer 已经在系统内占用了一个句柄， 而使用
     * FileChannel.close 方法是无法释放这个句柄的，且FileChannel有没有提供类似 unmap 的方法，
     * 因此会出现无法删除文件的情况。
     * <p>
     * 不推荐使用
     *
     * @param file
     * @return
     * @throws IOException
     */
    public static String getFileMD5String_old(File file) throws IOException {
        FileInputStream in = new FileInputStream(file);
        FileChannel ch = in.getChannel();
        MappedByteBuffer byteBuffer = ch.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
        messagedigest.update(byteBuffer);
        in.close();
        return bufferToHex(messagedigest.digest());
    }

    public static String getMD5String(byte[] bytes) {
        messagedigest.update(bytes);
        return bufferToHex(messagedigest.digest());
    }

    private static String bufferToHex(byte bytes[]) {
        return bufferToHex(bytes, 0, bytes.length);
    }

    private static String bufferToHex(byte bytes[], int m, int n) {
        StringBuffer stringbuffer = new StringBuffer(2 * n);
        int k = m + n;
        for (int l = m; l < k; l++) {
            appendHexPair(bytes[l], stringbuffer);
        }
        return stringbuffer.toString();
    }

    private static void appendHexPair(byte bt, StringBuffer stringbuffer) {
        char c0 = hexDigits[(bt & 0xf0) >> 4];// 取字节中高 4 位的数字转换, >>>
        // 为逻辑右移，将符号位一起右移,此处未发现两种符号有何不同
        char c1 = hexDigits[bt & 0xf];// 取字节中低 4 位的数字转换
        stringbuffer.append(c0);
        stringbuffer.append(c1);
    }



    /**
     * 加密
     *
     * @param plain 明文
     * @return 32位小写密文
     * @author qianyikai from HangZhouZhengqu， E-mail: 469640411@qq.com
     * @date Created in 2019/2/15 20:18
     */
    public static String encryption(String plain) {
        String re_md5 = new String();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plain.getBytes());
            byte b[] = md.digest();

            int i;

            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }

            re_md5 = buf.toString();

        } catch (NoSuchAlgorithmException e) {
//            logger.error("MD5Util加密失败：", e);
        }
        return re_md5;
    }

    public static  void  main(String[] args){
//            System.out.println(MD5Utils.("crp941918"));


        String channel = "101";
        String trade_type = "wxt";// YS101,xfl1,xfl2,xfl3,wxt
        String total_amount = "50.00";
        String out_trade_no = "2021080901";
        String noredirect = "1";
        String notify_url = "http://www.qidian.com";
        String secretKey = "secret_key_1";



        String checkSign = "";
        checkSign = "channel=" + channel + "&" + "trade_type=" + trade_type + "&" + "total_amount=" + total_amount
                + "&" + "out_trade_no=" + out_trade_no + "&" + "noredirect=" + noredirect
                + "&" + "notify_url=" + notify_url + "&" + "key=" + secretKey;
        checkSign = encryption(checkSign);
        log.info("checkSign:" + checkSign);


        String status_channel = "101";
        String status_out_trade_no = "2021080901011";// 202108090102
        String status_secretKey = "secret_key_1";


        String status_checkSign = "";
        status_checkSign = "channel=" + status_channel + "&" + "out_trade_no=" + status_out_trade_no + "&" + "key=" + status_secretKey;
        status_checkSign = MD5Util.encryption(status_checkSign);
        log.info("status_checkSign:" + status_checkSign);

    }

//    public static void main(String[] args) throws IOException {
//        long begin = System.currentTimeMillis();
//
//        File file = new File("D:\\app-debug.apk");
//        if (!file.exists()) {
//            System.out.println("不存在");
//        }
//        String md5 = getFileMD5String(file);
//
////      String md5 = getMD5String("a");
//
//        long end = System.currentTimeMillis();
//        System.out.println("md5:" + md5 + " time:" + ((end - begin) / 1000) + "s");
//        System.out.println(file.getPath());
//    }



}
