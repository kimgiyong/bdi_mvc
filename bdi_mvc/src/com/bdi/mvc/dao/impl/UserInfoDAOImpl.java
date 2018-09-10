package com.bdi.mvc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bdi.mvc.common.DBConnection;
import com.bdi.mvc.dao.UserInfoDAO;
import com.bdi.mvc.vo.UserInfo;

public class UserInfoDAOImpl implements UserInfoDAO {

	@Override
	public List<UserInfo> userInfoList() {
		Connection con = DBConnection.getCon();
		List<UserInfo> list = new ArrayList<UserInfo>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from user_info";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				UserInfo ui = new UserInfo(
						rs.getInt("uiNo"),
						rs.getString("uiName"),
						rs.getString("uiId"),
						rs.getString("uiPwd"),
						rs.getString("uiDesc"),
						rs.getInt("uiAge"),
						rs.getInt("diNo")
						);
				list.add(ui);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(ps!=null) {
					ps.close();
				}
			}catch(SQLException e) {
				
			}
			DBConnection.close();
		}
		return list;
	}

	@Override
	public UserInfo userInfoView(int ui) {
		Connection con = DBConnection.getCon();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from user_info where uiNo = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, ui);
			rs = ps.executeQuery();
			if(rs.next()) {
				UserInfo u = new UserInfo(
						rs.getInt("uiNo"),
						rs.getString("uiName"),
						rs.getString("uiId"),
						rs.getString("uiPwd"),
						rs.getString("uiDesc"),
						rs.getInt("uiAge"),
						rs.getInt("diNo")
						);
				return u;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(ps!=null) {
					ps.close();
				}
			}catch(SQLException e) {
				
			}
			DBConnection.close();
		}
		return null;
	}

	@Override
	public int userInfoInsert(UserInfo ui) {
		Connection con = DBConnection.getCon();
		PreparedStatement ps = null;
		String sql = "insert into user_info(uiName,uiId,uiPwd,uiDesc,uiAge,diNo) values(?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, ui.getUiName());
			ps.setString(2, ui.getUiId());
			ps.setString(3, ui.getUiPwd());
			ps.setString(4, ui.getUiDesc());
			ps.setInt(5, ui.getUiAge());
			ps.setInt(6, ui.getDiNo());
			int cnt = ps.executeUpdate();
			return cnt;
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null) {
					ps.close();
				}
			}catch(SQLException e) {
				
			}
			DBConnection.close();
		}
		return 0;
	}

	@Override
	public int userInfoUpdate(UserInfo ui) {
		Connection con = DBConnection.getCon();
		PreparedStatement ps = null;
		String sql = "update user_info set uiName = ?,uiId = ?,uiPwd = ?,uiDesc = ?,uiAge = ?,diNo = ? where uiNo = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, ui.getUiName());
			ps.setString(2, ui.getUiId());
			ps.setString(3, ui.getUiPwd());
			ps.setString(4, ui.getUiDesc());
			ps.setInt(5, ui.getUiAge());
			ps.setInt(6, ui.getDiNo());
			ps.setInt(7, ui.getUiNo());
			int cnt = ps.executeUpdate();
			return cnt;
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null) {
					ps.close();
				}
			}catch(SQLException e) {
				
			}
			DBConnection.close();
		}
		return 0;
	}

	@Override
	public int userInfoDelete(int ui) {
		Connection con = DBConnection.getCon();
		PreparedStatement ps = null;
		String sql = "delete from user_info where uiNo = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, ui);
			int cnt = ps.executeUpdate();
			return cnt;
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null) {
					ps.close();
				}
			}catch(SQLException e) {
				
			}
			DBConnection.close();
		}
		return 0;
	}

}
