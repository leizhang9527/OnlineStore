package com.log;


import com.util.JDBCUtil;
import com.util.StringUtils;

import java.sql.*;
import java.util.Date;
import java.util.UUID;

/**
 * 用于会员行为记录及智能推送
 *
 * @author zk
 *
 */

public class LogUtil {

	//businessType：业务类型（0其它 1新增 2修改 3删除）
	//操作状态（0正常 1异常）
	public static void logInsert(String operId, String title, Integer businessType, String method,
							String requestMethod, String operName, String operUrl, String operIp,
							String operParam, String jsonResult, Integer status, String errorMsg,
							Date operTime, Date startTime, Date endTime) {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "select * from t_log t where t.OPER_ID='"+operId+"'";
			conn  = JDBCUtil.getConnection();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				sql = "update t_log t set t.END_TIME = NOW() where t.OPER_ID='"+operId+"'";
				ps = conn.prepareStatement(sql);
			}else {
				operId= StringUtils.uuid();
				sql = "insert into t_log (OPER_ID,TITLE,BUSINESS_TYPE,METHOD,REQUEST_METHOD," +
						"OPER_NAME,OPER_URL,OPER_IP,OPER_PARAM,JSON_RESULT," +
						"STATUS,ERROR_MSG,OPER_TIME,END_TIME,START_TIME ) " +
						"values( ?,?,?,?,?,?,?,?,?,?,?,?,NOW(),NOW(),NOW())";
				ps = conn.prepareStatement(sql);
				ps.setString(1, operId);
				ps.setString(2, title);
				ps.setInt(3, businessType);
				ps.setString(4, method);
				ps.setString(5, requestMethod);
				ps.setString(6, operName);
				ps.setString(7, operUrl);
				ps.setString(8, operIp);
				ps.setString(9, operParam);
				ps.setString(10, jsonResult);
				ps.setInt(11, status);
				ps.setString(12, errorMsg);
			}
			ps.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			try {
				// 事变： 回滚事务
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResourse(conn,ps,rs);
		}
	}

	public static void main(String[] args) {
		try {
			LogUtil.logInsert(StringUtils.uuid(),"dd",1,"post","test","用户1","test.action"
					,"127.0.0.1","id","success",1,"500",new Date(),new Date(),new Date());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
