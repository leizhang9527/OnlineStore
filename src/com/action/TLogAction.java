package com.action;

import com.dao.TLogDAO;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author: Decadence
 * @Email: leizhang9527@163.com
 * @Date: 2020/3/22 19:22
 * @Version 1.0
 */
public class TLogAction extends ActionSupport {


    public String getAllLogList() {
        Map request=(Map) ServletActionContext.getContext().get("request");
        String sql="from TLog order by operId";
        List logList= logDAO.getHibernateTemplate().find(sql);
        request.put("logList", logList);
        return ActionSupport.SUCCESS;
    }


    private TLogDAO logDAO;

    public TLogDAO getLogDAO() {
        return logDAO;
    }

    public void setLogDAO(TLogDAO logDAO) {
        this.logDAO = logDAO;
    }
}
