package com.weapon.joker.lib.net.bean;

/**
 * <pre>
 *     author : xiaweizi
 *     class  : com.weapon.joker.lib.net.bean.PushNewsBean
 *     e-mail : 1012126908@qq.com
 *     time   : 2017/10/17
 *     desc   : 推送消息 bean
 * </pre>
 */

public class PushNewsBean {
    /**
     * 推送类型
     */
    public int type;
    /**
     * 推送标题
     */
    public String title;
    /**
     * 推送内容
     */
    public String content;
    /**
     * 推送 action
     */
    public String action;
    /**
     * 推送跳转的链接 url
     */
    public String url;
}
