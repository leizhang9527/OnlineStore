package com.util;

import com.model.SessionInfo;
import com.model.TAdmin;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpSession;

/**
 * 用于前台页面判断是否有权限的工具类
 */
public class SecurityUtil {
    private HttpSession session;

    public SecurityUtil(HttpSession session) {
        this.session = session;
    }

    /**
     * 判断当前用户是否可以访问某资源
     *
     * @param url 资源地址
     * @return
     */
    public boolean havePermission(String url) {
        SessionInfo sessionInfo = (SessionInfo) session.getAttribute(ConfigUtil.getSessionInfoName());
        /*List<Hxresource> resources = new ArrayList<Hxresource>();
        for (Hxrole role : sessionInfo.getUser().getHxroles()) {
            resources.addAll(role.getHxresources());
        }
        for (Hxorganization organization : sessionInfo.getUser().getHxorganizations()) {
            resources.addAll(organization.getHxresources());
        }
        resources = new ArrayList<Hxresource>(new HashSet<Hxresource>(resources));// 去重(这里包含了当前用户可访问的所有资源)
        for (Hxresource resource : resources) {
            if (StringUtils.equals(resource.getUrl(), url)) {// 如果有相同的，则代表当前用户可以访问这个资源
                return true;
            }
        }*/
        return false;
    }

	/**
	 * 获取当前SessionInfo对象
	 * @return
	 */
    public static SessionInfo getSessionInfo() {
        return (SessionInfo) ServletUtils.getSession().getAttribute(ConfigUtil.getSessionInfoName());
    }

	/**
	 * 获取当前User对象
	 * @return
	 */
    public static TAdmin getUser() {
        SessionInfo sessionInfo = getSessionInfo();
        TAdmin user = null;
        try {
            user = sessionInfo.getUser();
        } catch (Exception e) {
            user = null;
        }
        return user;

    }
}
