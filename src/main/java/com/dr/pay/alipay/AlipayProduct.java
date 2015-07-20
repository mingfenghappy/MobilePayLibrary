package com.dr.pay.alipay;import com.dr.pay.common.Product;import java.text.SimpleDateFormat;import java.util.Date;import java.util.Locale;import java.util.Random;/** * Created by kalen on 15/4/26. */public abstract class AlipayProduct extends Product {    public abstract String getAsynServer();    public String getPayRedirectURL() {        return "m.alipay.com";    }    /**     * // 设置未付款交易的超时时间     * // 默认30分钟，一旦超时，该笔交易就会自动被关闭。     * // 取值范围：1m～15d。     * // m-分钟，h-小时，d-天，1c-当天（无论交易何时创建，都在0点关闭）。     * 该参数数值不接受小数点，如1.5h，可转换为90m。     */    public abstract String getPayOverTime();    /**     * get the out_trade_no for an order. 获取外部订单号     */    public String getOutTradeNo() {        SimpleDateFormat format = new SimpleDateFormat("MMddHHmmss",                Locale.getDefault());        Date date = new Date();        String key = format.format(date);        Random r = new Random();        key = key + r.nextInt();        key = key.substring(0, 15);        return key;    }}