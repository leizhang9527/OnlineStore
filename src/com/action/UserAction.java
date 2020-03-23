package com.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.hutool.crypto.digest.HMac;
import cn.hutool.crypto.digest.HmacAlgorithm;
import com.dao.TLogDAO;
import com.log.LogUtil;
import com.util.AesUtil;
import com.util.IpUtil;
import com.util.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.dao.TUserDAO;
import com.model.TUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.util.Cart;

import javax.servlet.http.HttpServletRequest;

public class UserAction extends ActionSupport
{
    private int userId;
	private String userName;
	private String userPw;
	private String userhmacmd5;
	private String userRealname;
	private String userAddress;
	private String userSex;
	private String userTel;
	private String userEmail;
	private String userQq;
	
	private String newUserPw;
   
	
	
	
	private String message;
	private String path;
	
	private TUserDAO userDAO;

	private TLogDAO logDAO;
	
	
	public String userReg() {
		TUser user=new TUser();
		user.setUserName(userName);
		user.setUserPw(userPw);
		user.setUserhmacmd5(AesUtil.generateKey(userPw));
		user.setUserAddress(userAddress);
		user.setUserTel(userTel);
		user.setUserRealname(userRealname);
		user.setUserEmail(userEmail);
		user.setUserSex(userSex);
		user.setUserQq(userQq);
		user.setUserDel("no");
		userDAO.save(user);
		Map session= ServletActionContext.getContext().getSession();
		session.put("user", user);
		try {
			LogUtil.logInsert(StringUtils.uuid(),userName+"注册",1,"UserAction.userReg","post",userName,
					"UserAction.userReg", IpUtil.getIpAddrByServletActionContext(),"","successAdd",0,
					"",new Date(),new Date(),new Date());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "successAdd";
	}
	public String userEdit()
	{
		TUser user=userDAO.findById(userId);
		user.setUserName(userName);
		user.setUserPw(userPw);
		user.setUserhmacmd5(AesUtil.generateKey(userPw));
		user.setUserAddress(userAddress);
		user.setUserTel(userTel);
		user.setUserRealname(userRealname);
		user.setUserEmail(userEmail);
		user.setUserSex(userSex);
		user.setUserQq(userQq);
		user.setUserDel("no");
		userDAO.attachDirty(user);
		Map session= ServletActionContext.getContext().getSession();
		session.put("user", user);
		try {
			LogUtil.logInsert(StringUtils.uuid(),userName+"修改信息",1,"UserAction.userEdit","post",userName,
					"UserAction.userEdit", IpUtil.getIpAddrByServletActionContext(),"","successAdd",0,
					"",new Date(),new Date(),new Date());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "successAdd";
	}
	
	
	public String userLogin()
	{
		String sql="from TUser where userName=? and userhmacmd5=?";
		Object[] con={userName,AesUtil.generateKey(userPw)};
		List userList=userDAO.getHibernateTemplate().find(sql,con);
		if(userList.size()==0) {
			this.setMessage("用户名或密码错误");
			this.setPath("qiantai/default.jsp");
			try {
				LogUtil.logInsert(StringUtils.uuid(),userName+"登录失败",1,"UserAction.userLogin","post",userName,
						"UserAction.userLogin", IpUtil.getIpAddrByServletActionContext(),"","failed",0,
						"",new Date(),new Date(),new Date());
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			 Map session= ServletActionContext.getContext().getSession();
			 TUser user=(TUser)userList.get(0);
			 session.put("user", user);
			 
			 Cart cart=new Cart();
			 session.put("cart", cart);
			 
			 this.setMessage("成功登录");
			try {
				LogUtil.logInsert(StringUtils.uuid(),userName+"登录成功",1,"UserAction.userLogin","post",userName,
						"UserAction.userLogin", IpUtil.getIpAddrByServletActionContext(),"","succeed",0,
						"",new Date(),new Date(),new Date());
			} catch (Exception e) {
				e.printStackTrace();
			}
			 this.setPath("qiantai/default.jsp");
		}
		return "succeed";
	}
	
	
	public String userLogout() {
		Map session= ServletActionContext.getContext().getSession();
		TUser user=(TUser)session.get("user");
		try {
			LogUtil.logInsert(StringUtils.uuid(),user.getUserName()+"注销",1,"UserAction.userLogout","post",user.getUserName(),
					"UserAction.userLogout", IpUtil.getIpAddrByServletActionContext(),"","succeed",0,
					"",new Date(),new Date(),new Date());
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.remove("user");
		return ActionSupport.SUCCESS;
	}
	
	
	
	
	
	
	public String userDel() {
		Map session= ServletActionContext.getContext().getSession();
		TUser user1=(TUser)session.get("user");
		TUser user=userDAO.findById(userId);
		user.setUserDel("yes");
		userDAO.attachDirty(user);
		this.setMessage("删除成功");
		try {
			LogUtil.logInsert(StringUtils.uuid(),user1.getUserName()+"删除用户"+user.getUserName()+"成功",1,"UserAction.userLogout","post",user1.getUserName(),
					"UserAction.userLogout", IpUtil.getIpAddrByServletActionContext(),"","succeed",0,
					"",new Date(),new Date(),new Date());
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.setPath("userMana.action");
		return "succeed";
	}
	
	
	public String userXinxi()
	{
		TUser user=userDAO.findById(userId);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("user", user);
		return ActionSupport.SUCCESS;
	}
	
	
	public String userMana() {
		List userList=userDAO.findAll();
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("userList", userList);
		return ActionSupport.SUCCESS;
	}
	
	
	
	public String getUserAddress()
	{
		return userAddress;
	}

	public void setUserAddress(String userAddress)
	{
		this.userAddress = userAddress;
	}

	public String getUserEmail()
	{
		return userEmail;
	}

	public void setUserEmail(String userEmail)
	{
		this.userEmail = userEmail;
	}

	public String getUserQq()
	{
		return userQq;
	}

	public void setUserQq(String userQq)
	{
		this.userQq = userQq;
	}

	public String getUserRealname()
	{
		return userRealname;
	}

	public void setUserRealname(String userRealname)
	{
		this.userRealname = userRealname;
	}

	public String getUserSex()
	{
		return userSex;
	}

	public void setUserSex(String userSex)
	{
		this.userSex = userSex;
	}

	public String getUserTel()
	{
		return userTel;
	}

	public void setUserTel(String userTel)
	{
		this.userTel = userTel;
	}

	public int getUserId()
	{
		return userId;
	}


	public void setUserId(int userId)
	{
		this.userId = userId;
	}


	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public TUserDAO getUserDAO()
	{
		return userDAO;
	}


	public String getMessage()
	{
		return message;
	}


	public String getNewUserPw()
	{
		return newUserPw;
	}

	public void setNewUserPw(String newUserPw)
	{
		this.newUserPw = newUserPw;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}


	public String getPath()
	{
		return path;
	}


	public void setPath(String path)
	{
		this.path = path;
	}


	public void setUserDAO(TUserDAO userDAO)
	{
		this.userDAO = userDAO;
	}


	public String getUserPw()
	{
		return userPw;
	}

	public void setUserPw(String userPw)
	{
		this.userPw = userPw;
	}

	
}
