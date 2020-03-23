package com.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.aspectj.lang.annotation.Log;
import com.aspectj.lang.enums.BusinessType;
import com.util.AesUtil;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;

import com.dao.TAdminDAO;
import com.dao.TUserDAO;
import com.model.TAdmin;
import com.model.TUser;

public class loginService
{
	private TAdminDAO adminDAO;
	private TUserDAO userDAO;
	public TAdminDAO getAdminDAO()
	{
		return adminDAO;
	}
	public void setAdminDAO(TAdminDAO adminDAO)
	{
		this.adminDAO = adminDAO;
	}
	public TUserDAO getUserDAO()
	{
		return userDAO;
	}
	public void setUserDAO(TUserDAO userDAO)
	{
		this.userDAO = userDAO;
	}


	public String login(String userName,String userPw,int userType) {
		System.out.println("userType"+userType);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String result="no";
		
		if(userType==0)//系统管理员登陆
		{
			String sql="from TAdmin where userName=? and userhmacmd5=?";
			Object[] con={userName, AesUtil.generateKey(userPw)};
			List adminList=adminDAO.getHibernateTemplate().find(sql,con);
			if(adminList.size()==0) {
				 result="no";
			} else {
				 WebContext ctx = WebContextFactory.get(); 
				 HttpSession session=ctx.getSession(); 
				 TAdmin admin=(TAdmin)adminList.get(0);
				 session.setAttribute("userType", 0);
	             session.setAttribute("admin", admin);
	             result="yes";
			}
		}
		if(userType==1)//老师登陆
		{
			
		}
		if(userType==2)//学生登陆
		{
			
		}
		return result;
	}

    public String adminPwEdit(String userPwNew) {
    	try {
			Thread.sleep(100);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebContext ctx = WebContextFactory.get(); 
		HttpSession session=ctx.getSession(); 
		 
		TAdmin admin=(TAdmin)session.getAttribute("admin");
		admin.setUserPw(userPwNew);
		admin.setUserhmacmd5(AesUtil.generateKey(userPwNew));
		adminDAO.getHibernateTemplate().update(admin);
		session.setAttribute("admin", admin);
		
		return "yes";
    }
	
    public String jiance(String userName) {
    	try {
			Thread.sleep(100);
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql="from TUser where userName='"+userName+"'";
		List list=userDAO.getHibernateTemplate().find(sql);
		if(list.size()>0) {
			return "no";
		}
		else {
			return "yes";
		}
    }
    
    
}
